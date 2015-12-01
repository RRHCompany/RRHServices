package com.rrh.service.mobile.user;

import com.rrh.base.BaseResponse;
import com.rrh.base.IBaseService;

public interface IVerifyService<T> extends IBaseService<T> {
	/**
	 * 生成验证码
	 * @param mobile
	 * @param type 1 为注册校验   2 为忘记密码校验
	 * @return
	 */
	public BaseResponse createVerifyCode(String mobile, String type);
	/**
	 * 校验验证码
	 * @param mobile
	 * @param type 1 为注册校验   2 为忘记密码校验
	 * @param code
	 * @return
	 */
	public BaseResponse verifyCode(String mobile,String type,String code);
	/**
	 * 校验验证码 内部方法调用
	 * @param mobile
	 * @param type 1 为注册校验   2 为忘记密码校验
	 * @param code
	 * @return
	 */
	public int verifyCode_(String mobile,String type,String code);
}
