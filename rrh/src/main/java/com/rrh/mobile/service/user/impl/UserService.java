package com.rrh.mobile.service.user.impl;

import java.io.File;
import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.rrh.base.BaseService;
import com.rrh.common.Constants;
import com.rrh.common.SourceManager;
import com.rrh.common.utils.CommonUtils;
import com.rrh.common.utils.RegexpUtil;
import com.rrh.mapper.user.TbMobileSessionMapper;
import com.rrh.mapper.user.TbUsersMapper;
import com.rrh.mobile.ConstantsMobile;
import com.rrh.mobile.ErrorMsgConstant;
import com.rrh.mobile.ResultMobile;
import com.rrh.mobile.SystemConstant;
import com.rrh.mobile.base.BaseResponse;
import com.rrh.mobile.bean.req.UserLoginOtherRequest;
import com.rrh.mobile.bean.req.UserPerfectInfoRequest;
import com.rrh.mobile.bean.req.UserRegisterRequest;
import com.rrh.mobile.bean.res.UserImgResponse;
import com.rrh.mobile.bean.res.UserRegisterResponse;
import com.rrh.mobile.bean.res.UserResponse;
import com.rrh.mobile.im.TokenIM;
import com.rrh.mobile.im.respoint.TokenRespoint;
import com.rrh.mobile.service.user.IUserService;
import com.rrh.mobile.service.user.IVerifyService;
import com.rrh.mobile.utils.TokenUtils;
import com.rrh.model.user.TbMobileSession;
import com.rrh.model.user.TbUsers;
import com.rrh.model.user.TbVerify;

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
	 * http://10.0.8.236:8080/rrh/v1.0/mobile/users/login?appChannel=android&appSystem=android&password=123456&appDeviceInfo=867064018359594&mobile=13538023252
	 */
	@Override
	public BaseResponse phoneLogin(String mobile, String password){
		if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password)){
			return ResultMobile.resultErroParam();
		}
		if(!RegexpUtil.isMobile(mobile)){
			return ResultMobile.resultFall("user.mobile.format.error");
		}
		try {
			TbUsers tbUsers = tbUsersMapper.getByMobile(mobile);
			if(tbUsers == null){
				return ResultMobile.resultFall("user.login.erroe");
			}
			String userPwd = tbUsers.getPassword();
			//userPwd = userPwd.concat(mobile);
			//密码与电话号码 进行MD５一次
			//userPwd = MD5Util.GetMD5Code(userPwd);				
			if(!userPwd.equals(password)){
				return ResultMobile.resultFall("user.login.erroe");
			}
			String token = TokenUtils.getTokenByUserId(tbUsers.getUserId());
			//返回用户信息
			UserResponse response = new UserResponse(tbUsers.getUserId(), tbUsers.getUserName(), mobile, tbUsers.getTrueName(), tbUsers.getNickName(), 
					tbUsers.getMoney(), tbUsers.getGender(),tbUsers.getBirthday(), tbUsers.getSmallImg(), tbUsers.getBigImg(), tbUsers.getRegTime(), 
					tbUsers.getLastTime(), tbUsers.getIsCertification(), tbUsers.getProvince(), tbUsers.getCity(), tbUsers.getArea(), tbUsers.getIdCard(),
					tbUsers.getIdCardImage(), tbUsers.getBusinessName(), tbUsers.getBusinessDesc(),tbUsers.getBusinessTraffic(), tbUsers.getBusinessAddress(), 
					tbUsers.getBusinessDomain(), tbUsers.getBusinessWeixin(),  tbUsers.getSignature(), tbUsers.getEmail(),token,
					tbUsers.getGoodAt(),tbUsers.getPlace(),tbUsers.getFood(),tbUsers.getStature(),tbUsers.getWeight(),tbUsers.getEmotion(),tbUsers.getSports()
					);
			TokenRespoint tokenRespoint=TokenIM.getToken(tbUsers.getUserId(), tbUsers.getUserName(), tbUsers.getSmallImg());
			response.setImToken(tokenRespoint.getToken());
			return ResultMobile.resultSuccess(response);
		} catch (Exception e) {
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}

	
	//用户手机号码注册
	@Override
	public BaseResponse phoneRegister(UserRegisterRequest bean){
		if(StringUtils.isEmpty(bean.getMobile()) || StringUtils.isEmpty(bean.getPassword()) || StringUtils.isEmpty(bean.getVerifyCode())){
			return ResultMobile.resultErroParam();
		}
		if(!RegexpUtil.isMobile(bean.getMobile())){
			return ResultMobile.resultFall("user.mobile.format.error");
		}
		try {
			//校验验证码
			int verifyCode_return = verifyService.verifyCode_(bean.getMobile(), Constants.VERIFYCODE_TYPE_REGISTER, bean.getVerifyCode());
			if(verifyCode_return != 1){
				if(verifyCode_return == -4){
					return ResultMobile.resultFall("sms.verify.timeout");
				}else{
					return ResultMobile.resultFall("sms.verify.error");
				}
			}
			String mobile = CommonUtils.encordSQL(bean.getMobile(),0);
			//查询用户名是否存在
			int userCount = tbUsersMapper.countByMobile(mobile);
			//手机已注册
			if(userCount > 0){
				return ResultMobile.resultFall("user.mobile.exists");
			}
			Date time=new Date();
			TbUsers user = new TbUsers();
			user.setPassword(bean.getPassword());
			user.setMobile(bean.getMobile());
			user.setAppChannel(bean.getAppChannel());
			user.setAppDeviceInfo(bean.getAppDeviceInfo());
			user.setAppSystem(bean.getAppSystem());
			user.setRegTime(time);
			user.setLastTime(time);
			user.setLoginCount(1);
			int userID = tbUsersMapper.insert(user);
			String token = TokenUtils.getTokenByUserId(userID);
			
			//设备信息保存
			TbMobileSession mobileSession = new TbMobileSession();
			mobileSession.setAppChannel(bean.getAppChannel());
			mobileSession.setAppDeviceInfo(bean.getAppDeviceInfo());
			mobileSession.setAppSystem(bean.getAppSystem());
			mobileSession.setLoginToken(token);
			mobileSession.setUserId(userID);
			tbMobileSessionMapper.insert(mobileSession);
			
			UserRegisterResponse response = new UserRegisterResponse(userID, token);
			return ResultMobile.resultSuccess(response);
		} catch (Exception e) {
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
	//完善注册信息
	@Override
	public BaseResponse registerPerfectInfo(int userId, String nickName,String smallImg,String bigImg , Date birthday, int gender) {
		if(StringUtils.isEmpty(nickName) || StringUtils.isEmpty(smallImg) || StringUtils.isEmpty(bigImg)|| StringUtils.isEmpty(birthday)){
			return ResultMobile.resultErroParam();
		}
		try{
			//查询用户信息
			int number=tbUsersMapper.registerPerfectInfo(userId, nickName, smallImg, bigImg, birthday, gender);
			if(number<=0){
				//失败
				return ResultMobile.resultFall("comment.option.fall");
			}
			String token = TokenUtils.getTokenByUserId(userId);
			UserRegisterResponse response = new UserRegisterResponse(userId, token);
			return ResultMobile.resultSuccess(response);
		}catch(Exception e){
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
	
	//查询我的信息
	@Override
	public BaseResponse getUserInfo(String userId){
		if(StringUtils.isEmpty(userId)){
			return ResultMobile.resultErroParam();
		}
		try{
			TbUsers tbUsers = tbUsersMapper.selectByPrimaryKey(CommonUtils.StringIntoInteger(userId));
			if(tbUsers == null){
				return ResultMobile.resultErroUserNo();
			}
			UserResponse response = new UserResponse(tbUsers.getUserId(), tbUsers.getUserName(), tbUsers.getMobile(), tbUsers.getTrueName(), tbUsers.getNickName(), 
					tbUsers.getMoney(), tbUsers.getGender(),tbUsers.getBirthday(), tbUsers.getSmallImg(), tbUsers.getBigImg(), tbUsers.getRegTime(), 
					tbUsers.getLastTime(), tbUsers.getIsCertification(), tbUsers.getProvince(), tbUsers.getCity(), tbUsers.getArea(), tbUsers.getIdCard(),
					tbUsers.getIdCardImage(), tbUsers.getBusinessName(), tbUsers.getBusinessDesc(),tbUsers.getBusinessTraffic(), tbUsers.getBusinessAddress(), 
					tbUsers.getBusinessDomain(), tbUsers.getBusinessWeixin(), tbUsers.getSignature(), tbUsers.getEmail(),"",
					tbUsers.getGoodAt(),tbUsers.getPlace(),tbUsers.getFood(),tbUsers.getStature(),tbUsers.getWeight(),tbUsers.getEmotion(),tbUsers.getSports()
					);
			return ResultMobile.resultSuccess(response);
		}catch(Exception e){
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
	//修改个人信息
	@Override
	public BaseResponse perfectInfo(UserPerfectInfoRequest bean){
		if(bean.getUserId() == null){
			return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_PARAM);
		}
		try{
			TbUsers user = new TbUsers(bean.getUserId(), bean.getTrueName(), bean.getNickName(), bean.getGender(), bean.getBirthday(), bean.getProvince(), 
					bean.getCity(), bean.getArea(), bean.getIdCard(), bean.getIdCardImage(), bean.getBusinessName(), bean.getBusinessDesc(), bean.getBusinessTraffic(),
					bean.getBusinessAddress(), bean.getBusinessDomain(), bean.getBusinessWeixin(), bean.getSignature(), bean.getEmail(), bean.getGoodAt(), 
					bean.getPlace(), bean.getFood(), bean.getStature(), bean.getWeight(), bean.getEmotion(), bean.getSports());
			tbUsersMapper.updateByModelSelective(user);
			return new BaseResponse(ConstantsMobile.RESULT_CODE_SUCCESS); 
		}catch(Exception e){
			log.error("", e);
			return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_SYSTEM);
		}		
	}
	//忘记密码
	@Override
	public BaseResponse recoverPwd(String mobile,String password,String verifyCode){
		if(StringUtils.isEmpty(mobile) || StringUtils.isEmpty(password) || StringUtils.isEmpty(verifyCode)){
			return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_PARAM);
		}else if(!RegexpUtil.isMobile(mobile)){
			return new BaseResponse(ErrorMsgConstant.USER_PHONE_ERRORCODE);
		}
		
		try{
			//校验验证码
			int verifyCode_return = verifyService.verifyCode_(mobile, Constants.VERIFYCODE_TYPE_FORGETPWD, verifyCode);
			if(verifyCode_return != 1){
				if(verifyCode_return == -4){
					return new BaseResponse(ErrorMsgConstant.SMS_CODE_TIMEOUT_ERRORCODE);
				}else{
					return new BaseResponse(ErrorMsgConstant.SMS_ERRORCODE);
				}
			}
			//更新密码
			TbUsers existsUser = tbUsersMapper.getByMobile(mobile);
			if(existsUser == null){
				return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_USER_NO);
			}
			TbUsers user = new TbUsers();
			user.setPassword(password);
			user.setUserId(existsUser.getUserId());
			tbUsersMapper.updateByModelSelective(user);
			return new BaseResponse(ConstantsMobile.RESULT_CODE_SUCCESS); 
		}catch(Exception e){
			log.error("", e);
			return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_SYSTEM);
		}
	}
	//修改密码
	@Override
	public BaseResponse modifyPwd(String userId,String password,String newPassword){
		if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(password) || StringUtils.isEmpty(newPassword)){
			return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_PARAM);
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
					return new BaseResponse(ConstantsMobile.RESULT_CODE_SUCCESS); 
				}else{
					return new BaseResponse(ErrorMsgConstant.USER_PASSWORD_ERRORCODE);
				}				
			}else
				return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_USER_NO);
		}catch(Exception e){
			log.error("", e);
			return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_SYSTEM);
		}
	}
	//第三方登录
	@Override
	public BaseResponse loginOther(UserLoginOtherRequest bean){
		if(StringUtils.isEmpty(bean.getOpenId()) || StringUtils.isEmpty(bean.getType())){
			return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_PARAM);
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
						tbUsers.getBusinessDomain(), tbUsers.getBusinessWeixin(),  tbUsers.getSignature(), tbUsers.getEmail(),"",
						tbUsers.getGoodAt(),tbUsers.getPlace(),tbUsers.getFood(),tbUsers.getStature(),tbUsers.getWeight(),tbUsers.getEmotion(),tbUsers.getSports()
						);
				return new BaseResponse(ConstantsMobile.RESULT_CODE_SUCCESS, response);
			}else{
				//插入新的记录
				model.setSmallImg(bean.getSmallImg());
				model.setBigImg(bean.getSmallImg());
				model.setNickName(bean.getNickName());
				int id = tbUsersMapper.insert(model);
				UserResponse response = new UserResponse();
				response.setUserId(id);
				return new BaseResponse(ConstantsMobile.RESULT_CODE_SUCCESS,  response);
				
				
			}				
			
		}catch(Exception e){
			log.error("", e);
			return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_SYSTEM);
		}
	}
	//上传用户头像
	@Override
	public BaseResponse uploadUserImg(MultipartFile file, String photoSuffix, String userId){
		if(StringUtils.isEmpty(userId) || StringUtils.isEmpty(photoSuffix) || file == null){
			return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_PARAM);
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
			return new BaseResponse(ConstantsMobile.RESULT_CODE_SUCCESS,resp);
		}catch(Exception e){
			log.error("", e);
			return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_SYSTEM);
		}
	}
	
}
