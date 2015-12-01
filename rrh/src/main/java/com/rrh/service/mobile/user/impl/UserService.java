package com.rrh.service.mobile.user.impl;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.rrh.base.BaseRequest;
import com.rrh.base.BaseResponse;
import com.rrh.base.BaseService;
import com.rrh.bean.req.UserLoginOtherRequest;
import com.rrh.bean.req.UserPerfectInfoRequest;
import com.rrh.bean.req.UserRegisterRequest;
import com.rrh.bean.res.UserImgResponse;
import com.rrh.bean.res.UserRegisterResponse;
import com.rrh.bean.res.UserResponse;
import com.rrh.common.CommonUtils;
import com.rrh.common.ErrorMsgConstant;
import com.rrh.common.MD5Util;
import com.rrh.common.SourceManager;
import com.rrh.common.SystemConstant;
import com.rrh.common.TokenUtils;
import com.rrh.mapper.user.TbMobileSessionMapper;
import com.rrh.mapper.user.TbUsersMapper;
import com.rrh.model.user.TbMobileSession;
import com.rrh.model.user.TbUsers;
import com.rrh.model.user.TbVerify;
import com.rrh.service.mobile.user.IUserService;
import com.rrh.service.mobile.user.IVerifyService;

@Service
public class UserService extends BaseService<TbUsers> implements IUserService<TbUsers> {

	@Autowired
	private TbUsersMapper tbUsersMapper;
	@Autowired
	private TbMobileSessionMapper tbMobileSessionMapper;
	@Autowired
	private IVerifyService<TbVerify> verifyService;
	@Autowired
	private SourceManager sourceManager;

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
		if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
			return new BaseResponse(ErrorMsgConstant.PUBLIC_PARAM_ERROR_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}else if(!CommonUtils.isMobileNO(mobile)){
			return new BaseResponse(ErrorMsgConstant.USER_PHONE_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
		try {
			TbUsers tbUsers = tbUsersMapper.selectUserByPhone(mobile);
			if(tbUsers == null){
				return new BaseResponse(ErrorMsgConstant.USER_NOTEXISTS_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
			}else{
				String userPwd = tbUsers.getPassword();
				//userPwd = userPwd.concat(mobile);
				//密码与电话号码 进行MD５一次
				//userPwd = MD5Util.GetMD5Code(userPwd);				
				if(!userPwd.equals(password)){
					return new BaseResponse(ErrorMsgConstant.USER_PASSWORD_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
				}
				String token = TokenUtils.getTokenByUserId(tbUsers.getUserId());
				//返回用户信息
				UserResponse response = new UserResponse(tbUsers.getUserId(), tbUsers.getUserName(), mobile, tbUsers.getTrueName(), tbUsers.getNickName(), 
						tbUsers.getMoney(), tbUsers.getGender(),tbUsers.getBirthday(), tbUsers.getSmallImg(), tbUsers.getBigImg(), tbUsers.getRegTime(), 
						tbUsers.getLastTime(), tbUsers.getIsCertification(), tbUsers.getProvince(), tbUsers.getCity(), tbUsers.getArea(), tbUsers.getIdCard(),
						tbUsers.getIdCardImage(), tbUsers.getBusinessName(), tbUsers.getBusinessDesc(),tbUsers.getBusinessTraffic(), tbUsers.getBusinessAddress(), 
						tbUsers.getBusinessDomain(), tbUsers.getBusinessWeixin(), tbUsers.getDetails(), tbUsers.getSignature(), tbUsers.getEmail(),token,
						tbUsers.getGoodAt(),tbUsers.getPlace(),tbUsers.getFood(),tbUsers.getStature(),tbUsers.getWeight(),tbUsers.getEmotion(),tbUsers.getSports()
						);
				return new BaseResponse(ErrorMsgConstant.PUBLIC_SUCC_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME, response);
			}
		} catch (Exception e) {
			log.error("", e);
			return new BaseResponse(ErrorMsgConstant.PUBLIC_SYSTEM_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
	}

	/**
	 * 校验用户名是否已使用
	 * @param userName
	 * @return
	 */
	public BaseResponse verifyUserByUserName(String userName){
		if(StringUtils.isEmpty(userName)){
			return new BaseResponse(ErrorMsgConstant.PUBLIC_PARAM_ERROR_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
		try {			
			int userId = tbUsersMapper.selectUserIdByUserName(CommonUtils.encordSQL(userName, 0));
			//用户名已注册
			if(userId > 0){
				return new BaseResponse(ErrorMsgConstant.USER_NAME_REPEAT_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
			}else{
				return new BaseResponse(ErrorMsgConstant.PUBLIC_SUCC_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
			}			
		} catch (Exception e) {
			log.error("", e);
			return new BaseResponse(ErrorMsgConstant.PUBLIC_SYSTEM_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
	} 
	//用户注册
	public BaseResponse userRegister(UserRegisterRequest bean,BaseRequest baseRequest){
		if(StringUtils.isEmpty(bean.getMobile()) || StringUtils.isEmpty(bean.getUserName())
				|| StringUtils.isEmpty(bean.getPassword()) || StringUtils.isEmpty(bean.getVerifyCode())){
			return new BaseResponse(ErrorMsgConstant.PUBLIC_PARAM_ERROR_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}else if(!CommonUtils.isMobileNO(bean.getMobile())){
			return new BaseResponse(ErrorMsgConstant.USER_PHONE_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
		try {
			//校验验证码
			int verifyCode_return = verifyService.verifyCode_(bean.getMobile(), SystemConstant.VERIFYCODE_TYPE_REGISTER, bean.getVerifyCode());
			if(verifyCode_return != 1){
				if(verifyCode_return == -4){
					return new BaseResponse(ErrorMsgConstant.SMS_CODE_TIMEOUT_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);
				}else{
					return new BaseResponse(ErrorMsgConstant.SMS_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);
				}
			}
			String userName = CommonUtils.encordSQL(bean.getUserName(),0);
			//查询用户名是否存在
			int userId = tbUsersMapper.selectUserIdByUserName(userName);
			//用户名已注册
			if(userId > 0){
				return new BaseResponse(ErrorMsgConstant.USER_NAME_REPEAT_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
			}
			System.out.println("password:"+MD5Util.GetMD5Code(bean.getPassword()+bean.getMobile()));
			TbUsers user = new TbUsers();
			user.setUserName(userName);
			user.setPassword(bean.getPassword());
			user.setMobile(bean.getMobile());
			user.setAppChannel(baseRequest.getAppChannel());
			user.setAppDeviceInfo(baseRequest.getAppDeviceInfo());
			user.setAppSystem(baseRequest.getAppSystem());
						
			int id = tbUsersMapper.insert(user);
			String token = TokenUtils.getTokenByUserId(id);
			
			//设备信息保存
			TbMobileSession mobileSession = new TbMobileSession();
			mobileSession.setAppChannel(baseRequest.getAppChannel());
			mobileSession.setAppDeviceInfo(baseRequest.getAppDeviceInfo());
			mobileSession.setAppSystem(baseRequest.getAppSystem());
			mobileSession.setLoginToken(token);
			mobileSession.setUserId(userId);
			tbMobileSessionMapper.insert(mobileSession);			
			
			UserRegisterResponse response = new UserRegisterResponse(id, token);
			return new BaseResponse(ErrorMsgConstant.PUBLIC_SUCC_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME,response);
		} catch (Exception e) {
			log.error("", e);
			return new BaseResponse(ErrorMsgConstant.PUBLIC_SYSTEM_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
	}
	//查询我的信息
	public BaseResponse getUserInfo(String userId){
		if(StringUtils.isEmpty(userId)){
			return new BaseResponse(ErrorMsgConstant.PUBLIC_PARAM_ERROR_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
		try{
			TbUsers tbUsers = tbUsersMapper.selectByPrimaryKey(CommonUtils.StringIntoInteger(userId));
			if(tbUsers != null){
				UserResponse response = new UserResponse(tbUsers.getUserId(), tbUsers.getUserName(), tbUsers.getMobile(), tbUsers.getTrueName(), tbUsers.getNickName(), 
						tbUsers.getMoney(), tbUsers.getGender(),tbUsers.getBirthday(), tbUsers.getSmallImg(), tbUsers.getBigImg(), tbUsers.getRegTime(), 
						tbUsers.getLastTime(), tbUsers.getIsCertification(), tbUsers.getProvince(), tbUsers.getCity(), tbUsers.getArea(), tbUsers.getIdCard(),
						tbUsers.getIdCardImage(), tbUsers.getBusinessName(), tbUsers.getBusinessDesc(),tbUsers.getBusinessTraffic(), tbUsers.getBusinessAddress(), 
						tbUsers.getBusinessDomain(), tbUsers.getBusinessWeixin(), tbUsers.getDetails(), tbUsers.getSignature(), tbUsers.getEmail(),"",
						tbUsers.getGoodAt(),tbUsers.getPlace(),tbUsers.getFood(),tbUsers.getStature(),tbUsers.getWeight(),tbUsers.getEmotion(),tbUsers.getSports()
						);
				return new BaseResponse(ErrorMsgConstant.PUBLIC_SUCC_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME, response);			
			}else
				return new BaseResponse(ErrorMsgConstant.PUBLIC_FAIL_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);			
		}catch(Exception e){
			log.error("", e);
			return new BaseResponse(ErrorMsgConstant.PUBLIC_SYSTEM_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
	}
	//修改个人信息
	public BaseResponse perfectInfo(UserPerfectInfoRequest bean){
		if(bean.getUserId() == null){
			return new BaseResponse(ErrorMsgConstant.PUBLIC_PARAM_ERROR_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
		try{
			TbUsers user = new TbUsers(bean.getUserId(), bean.getTrueName(), bean.getNickName(), bean.getGender(), bean.getBirthday(), bean.getProvince(), 
					bean.getCity(), bean.getArea(), bean.getIdCard(), bean.getIdCardImage(), bean.getBusinessName(), bean.getBusinessDesc(), bean.getBusinessTraffic(),
					bean.getBusinessAddress(), bean.getBusinessDomain(), bean.getBusinessWeixin(), bean.getDetails(), bean.getSignature(), bean.getEmail(), bean.getGoodAt(), 
					bean.getPlace(), bean.getFood(), bean.getStature(), bean.getWeight(), bean.getEmotion(), bean.getSports());
			tbUsersMapper.updateByModelSelective(user);
			return new BaseResponse(ErrorMsgConstant.PUBLIC_SUCC_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME); 
		}catch(Exception e){
			log.error("", e);
			return new BaseResponse(ErrorMsgConstant.PUBLIC_SYSTEM_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}		
	}
	//忘记密码
	public BaseResponse recoverPwd(String mobile,String password,String verifyCode){
		if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password) || StringUtils.isEmpty(verifyCode)){
			return new BaseResponse(ErrorMsgConstant.PUBLIC_PARAM_ERROR_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}else if(!CommonUtils.isMobileNO(mobile)){
			return new BaseResponse(ErrorMsgConstant.USER_PHONE_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
		
		try{
			//校验验证码
			int verifyCode_return = verifyService.verifyCode_(mobile, SystemConstant.VERIFYCODE_TYPE_FORGETPWD, verifyCode);
			if(verifyCode_return != 1){
				if(verifyCode_return == -4){
					return new BaseResponse(ErrorMsgConstant.SMS_CODE_TIMEOUT_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);
				}else{
					return new BaseResponse(ErrorMsgConstant.SMS_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);
				}
			}
			//更新密码
			TbUsers existsUser = tbUsersMapper.selectUserByPhone(mobile);
			if(existsUser == null){
				return new BaseResponse(ErrorMsgConstant.USER_NOTEXISTS_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);
			}
			TbUsers user = new TbUsers();
			user.setPassword(password);
			user.setUserId(existsUser.getUserId());
			tbUsersMapper.updateByModelSelective(user);
			return new BaseResponse(ErrorMsgConstant.PUBLIC_SUCC_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME); 
		}catch(Exception e){
			log.error("", e);
			return new BaseResponse(ErrorMsgConstant.PUBLIC_SYSTEM_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
	}
	//修改密码
	public BaseResponse modifyPwd(String userId,String password,String newPassword){
		if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(password) || StringUtils.isEmpty(newPassword)){
			return new BaseResponse(ErrorMsgConstant.PUBLIC_PARAM_ERROR_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
		try{
			TbUsers user = selectById(Integer.valueOf(userId));
			if(user != null){
				String pwd = user.getPassword();			
				if(pwd.equals(password)){
					TbUsers updateModel = new TbUsers();
					updateModel.setPassword(newPassword);
					updateModel.setUserId(CommonUtils.StringIntoInteger(userId));
					tbUsersMapper.updateByModelSelective(updateModel);
					return new BaseResponse(ErrorMsgConstant.PUBLIC_SUCC_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME); 
				}else{
					return new BaseResponse(ErrorMsgConstant.USER_PASSWORD_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
				}				
			}else
				return new BaseResponse(ErrorMsgConstant.USER_NOTEXISTS_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME);
		}catch(Exception e){
			log.error("", e);
			return new BaseResponse(ErrorMsgConstant.PUBLIC_SYSTEM_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
	}
	//第三方登录
	public BaseResponse loginOther(UserLoginOtherRequest bean){
		if(StringUtils.isEmpty(bean.getOpenId()) || StringUtils.isEmpty(bean.getType())){
			return new BaseResponse(ErrorMsgConstant.PUBLIC_PARAM_ERROR_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
		
		try{
			TbUsers model = new TbUsers();
			if("1".equals(bean.getType())){
				model.setOpenIdQq(SystemConstant.USER_LOGINOTHER_QQ);
			}else if("2".equals(bean.getType())){
				model.setOpenIdWeixin(SystemConstant.USER_LOGINOTHER_WEIXIN);
			}else if("3".equals(bean.getType())){
				model.setOpenIdSina(SystemConstant.USER_LOGINOTHER_SINA);
			}
			TbUsers tbUsers = tbUsersMapper.selectUserByOpenId(model);
			if(tbUsers != null){
				UserResponse response = new UserResponse(tbUsers.getUserId(), tbUsers.getUserName(), tbUsers.getMobile(), tbUsers.getTrueName(), tbUsers.getNickName(), 
						tbUsers.getMoney(), tbUsers.getGender(),tbUsers.getBirthday(), tbUsers.getSmallImg(), tbUsers.getBigImg(), tbUsers.getRegTime(), 
						tbUsers.getLastTime(), tbUsers.getIsCertification(), tbUsers.getProvince(), tbUsers.getCity(), tbUsers.getArea(), tbUsers.getIdCard(),
						tbUsers.getIdCardImage(), tbUsers.getBusinessName(), tbUsers.getBusinessDesc(),tbUsers.getBusinessTraffic(), tbUsers.getBusinessAddress(), 
						tbUsers.getBusinessDomain(), tbUsers.getBusinessWeixin(), tbUsers.getDetails(), tbUsers.getSignature(), tbUsers.getEmail(),"",
						tbUsers.getGoodAt(),tbUsers.getPlace(),tbUsers.getFood(),tbUsers.getStature(),tbUsers.getWeight(),tbUsers.getEmotion(),tbUsers.getSports()
						);
				return new BaseResponse(ErrorMsgConstant.PUBLIC_SUCC_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME, response);
			}else{
				//插入新的记录
				model.setSmallImg(bean.getSmallImg());
				model.setBigImg(bean.getSmallImg());
				model.setNickName(bean.getNickName());
				int id = tbUsersMapper.insert(model);
				UserResponse response = new UserResponse();
				response.setUserId(id);
				return new BaseResponse(ErrorMsgConstant.PUBLIC_SUCC_ERRORCODE, SystemConstant.DEFAULT_REQUEST_TIME, response);
				
				
			}				
			
		}catch(Exception e){
			log.error("", e);
			return new BaseResponse(ErrorMsgConstant.PUBLIC_SYSTEM_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
	}
	//上传用户头像
	public BaseResponse uploadUserImg(MultipartFile file, String photoSuffix, String userId){
		if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(photoSuffix) || file == null){
			return new BaseResponse(ErrorMsgConstant.PUBLIC_PARAM_ERROR_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
		try{
			//查询用户信息
			TbUsers user = selectById(Integer.valueOf(userId));
			File targetFile = new File(sourceManager.getUserPicFolderPath(true) + UUID.randomUUID().toString().replace("-", "") + "." + photoSuffix );
			if(!targetFile.exists())
				targetFile.mkdirs();
			if(!StringUtils.isEmpty(user.getSmallImg())) //删除旧图片
				new File( sourceManager.getUserPicFolderPath(true) + user.getSmallImg() ).delete();
			user.setSmallImg(targetFile.getName());
			user.setBigImg(targetFile.getName());
			update(user);
			//保存	
	        file.transferTo(targetFile);
	       	        
	        UserImgResponse resp = new UserImgResponse();
	        resp.setSmallImg(sourceManager.getUserPicFolderPath(false) + targetFile.getName());
			return new BaseResponse(ErrorMsgConstant.PUBLIC_SUCC_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME,resp);
		}catch(Exception e){
			log.error("", e);
			return new BaseResponse(ErrorMsgConstant.PUBLIC_SYSTEM_ERRORCODE,SystemConstant.DEFAULT_REQUEST_TIME);
		}
	}
}
