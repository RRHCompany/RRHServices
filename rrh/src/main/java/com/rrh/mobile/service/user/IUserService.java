package com.rrh.mobile.service.user;

import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import com.rrh.base.IBaseService;
import com.rrh.mobile.base.BaseResponse;
import com.rrh.mobile.bean.req.UserLoginOtherRequest;
import com.rrh.mobile.bean.req.UserPerfectInfoRequest;
import com.rrh.mobile.bean.req.UserRegisterRequest;

public interface IUserService<T> extends IBaseService<T> {

	/**
	 * 手机号码登录
	 * @param phone
	 * @param password
	 * @return
	 */
	public BaseResponse phoneLogin(String mobile, String password);
	
	/**
	 * 手机号码注册
	 * @param bean 用户bean
	 * @return
	 */
	public BaseResponse phoneRegister(UserRegisterRequest bean);
	/**
	 * 查询我的信息
	 * @param userId
	 * @return
	 */
	public BaseResponse getUserInfo(String userId);
	/**
	 * 修改个人信息提交接口
	 * @param bean
	 * @return
	 */
	public BaseResponse perfectInfo(UserPerfectInfoRequest bean);
	/**
	 * 忘记密码
	 * @param mobile 电话
	 * @param password 新密码
	 * @param verifyCode 验证码
	 * @return
	 */
	public BaseResponse recoverPwd(String mobile,String password,String verifyCode);
	/**
	 * 修改密码
	 * @param userId
	 * @param password 魇密码
	 * @param newPassword 新密码
	 * @return
	 */
	public BaseResponse modifyPwd(String userId,String password,String newPassword); 
	/**
	 * 第三方登录
	 * @param bean
	 * @return
	 */
	public BaseResponse loginOther(UserLoginOtherRequest bean);
	/**
	 * 上传用户头像
	 * @param file
	 * @param photoSuffix
	 * @param userId
	 * @return
	 */
	public BaseResponse uploadUserImg(int userId,MultipartFile picFile);
	//完善注册信息
	public BaseResponse registerPerfectInfo(int userId, String nickName,String smallImg,String bigImg , Date birthday, int gender);
}
