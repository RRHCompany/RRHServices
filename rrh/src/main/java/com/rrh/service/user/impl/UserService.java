package com.rrh.service.user.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.rrh.base.BaseResponse;
import com.rrh.base.BaseService;
import com.rrh.bean.req.UserRegisterRequest;
import com.rrh.bean.res.UserResponse;
import com.rrh.common.Coder;
import com.rrh.common.CommonUtils;
import com.rrh.common.ErrorMsgConstant;
import com.rrh.common.MD5Util;
import com.rrh.common.SystemConstant;
import com.rrh.common.TokenUtils;
import com.rrh.jpush.IJpushWrapper;
import com.rrh.mapper.user.TbUsersMapper;
import com.rrh.model.user.TbUsers;
import com.rrh.model.user.TbVerify;
import com.rrh.service.user.IUserService;
import com.rrh.service.user.IVerifyService;

@Service
public class UserService extends BaseService<TbUsers> implements IUserService<TbUsers> {

	@Autowired
	private TbUsersMapper tbUsersMapper;
	@Autowired 
	private IJpushWrapper jpushWrapper;
	@Autowired
	private IVerifyService<TbVerify> verifyService;

	@Override
	public void initMapper() {
		this.baseMapper = tbUsersMapper;
	}
	
	
	/**
	 * 手机号码登录
	 * @param phone
	 * @param password
	 * @return
	 */
	public BaseResponse phoneLogin(String mobile, String password){
		jpushWrapper.pushByIds(null, null, null, null);
		if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
			return new BaseResponse(ErrorMsgConstant.PARAM_ERROR_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}else if(!CommonUtils.isMobileNO(mobile)){
			return new BaseResponse(ErrorMsgConstant.PHONE_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
		try {
			TbUsers reqModel = new TbUsers();
			reqModel.setMobile(mobile);
			List<TbUsers> list = SelectByModel(reqModel);
			if(list == null ||  list.size() == 0){
				return new BaseResponse(ErrorMsgConstant.USER_NOTEXISTS_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
			}else{
				TbUsers tbUsers = list.get(0);
				String userPwd = tbUsers.getPassword();
				userPwd = userPwd.concat(mobile);
				userPwd = MD5Util.GetMD5Code(Coder.decryptDES(userPwd));
				if(!userPwd.equals(password)){
					return new BaseResponse(ErrorMsgConstant.PASSWORD_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
				}
				String token = TokenUtils.getTokenByUserId(tbUsers.getUserId());
				//返回用户信息
				UserResponse response = new UserResponse(tbUsers.getUserId(), tbUsers.getUserName(), mobile, tbUsers.getTrueName(), tbUsers.getNickName(), 
						tbUsers.getMoney(), tbUsers.getGender(),tbUsers.getBirthday(), tbUsers.getSmallImg(), tbUsers.getBigImg(), tbUsers.getRegTime(), 
						tbUsers.getLastTime(), tbUsers.getIsCertification(), tbUsers.getProvince(), tbUsers.getCity(), tbUsers.getArea(), tbUsers.getIdCard(),
						tbUsers.getIdCardImage(), tbUsers.getBusinessName(), tbUsers.getBusinessDesc(),tbUsers.getBusinessTraffic(), tbUsers.getBusinessAddress(), 
						tbUsers.getBusinessDomain(), tbUsers.getBusinessWeixin(), tbUsers.getDetails(), tbUsers.getSignature(), tbUsers.getEmail(),token);
				return new BaseResponse(ErrorMsgConstant.SUCC_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME, response);
			}
		} catch (Exception e) {
			log.error("", e);
			return new BaseResponse(ErrorMsgConstant.SYSTEM_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
	}

	/**
	 * 校验用户名是否已使用
	 * @param userName
	 * @return
	 */
	public BaseResponse verifyUserByUserName(String userName){
		if(StringUtils.isEmpty(userName)){
			return new BaseResponse(ErrorMsgConstant.PARAM_ERROR_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
		try {			
			int userId = tbUsersMapper.selectUserIdByUserName(CommonUtils.encordSQL(userName, 0));
			//用户名已注册
			if(userId > 0){
				return new BaseResponse(ErrorMsgConstant.USER_NAME_REPEAT_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
			}else{
				return new BaseResponse(ErrorMsgConstant.SUCC_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
			}			
		} catch (Exception e) {
			log.error("", e);
			return new BaseResponse(ErrorMsgConstant.SYSTEM_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
	} 
	//用户注册
	public BaseResponse userRegister(UserRegisterRequest reqUser){
		if(StringUtils.isEmpty(reqUser.getMobile()) || StringUtils.isEmpty(reqUser.getUserName())
				|| StringUtils.isEmpty(reqUser.getPassword()) || StringUtils.isEmpty(reqUser.getVerifyCode())){
			return new BaseResponse(ErrorMsgConstant.PARAM_ERROR_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}else if(!CommonUtils.isMobileNO(reqUser.getMobile())){
			return new BaseResponse(ErrorMsgConstant.PHONE_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
		try {
			//校验验证码
			int verifyCode_return = verifyService.verifyCode_(reqUser.getMobile(), SystemConstant.VERIFYCODE_TYPE_REGISTER, reqUser.getVerifyCode());
			if(verifyCode_return != 1){
				if(verifyCode_return == -4){
					return new BaseResponse(ErrorMsgConstant.SMS_CODE_TIMEOUT_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);
				}else{
					return new BaseResponse(ErrorMsgConstant.SEND_CODE_CHECKED_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);
				}
			}
			String userName = CommonUtils.encordSQL(reqUser.getUserName(),0);
			//查询用户名是否存在
			int userId = tbUsersMapper.selectUserIdByUserName(userName);
			//用户名已注册
			if(userId > 0){
				return new BaseResponse(ErrorMsgConstant.USER_NAME_REPEAT_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
			}
			TbUsers user = new TbUsers();
			user.setUserName(userName);
			user.setPassword(reqUser.getPassword());
			user.setMobile(reqUser.getMobile());
			tbUsersMapper.insert(user);
			return new BaseResponse(ErrorMsgConstant.SUCC_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		} catch (Exception e) {
			log.error("", e);
			return new BaseResponse(ErrorMsgConstant.SYSTEM_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
	}
}
