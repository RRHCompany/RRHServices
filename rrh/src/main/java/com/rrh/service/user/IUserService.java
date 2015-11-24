package com.rrh.service.user;

import com.rrh.base.BaseResponse;
import com.rrh.base.IBaseService;
import com.rrh.bean.req.UserRegisterRequest;

public interface IUserService<T> extends IBaseService<T> {

	/**
	 * 手机号码登录
	 * @param phone
	 * @param password
	 * @return
	 */
	public BaseResponse phoneLogin(String mobile, String password);
	/**
	 * 校验用户名是否已使用
	 * @param userName
	 * @return
	 */
	public BaseResponse verifyUserByUserName(String userName);
	/**
	 * 用户注册
	 * @param reqUser 用户bean
	 * @return
	 */
	public BaseResponse userRegister(UserRegisterRequest reqUser);
}
