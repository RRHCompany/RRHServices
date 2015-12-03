package com.rrh.mobile.bean.req;

import com.rrh.mobile.base.BaseRequest;


/**
 * 手机号码注册
 * @author jason
 * @data 2015-12-3
 */
public class UserRegisterRequest extends BaseRequest{

	private String mobile;//电话
	private String password;//密码
	private String verifyCode;//验证码
	private String accessToken;//短信令牌
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	
}
