package com.rrh.common;


public class SystemConstant {

	public static final String BACK_ADMIN = "BACK_ADMIN";
	//不通过登录 过滤器的方法名，用逗号隔开
	public static final String LOGINFILTER_METHOD_FREE = "login.do,createVerifyCode.do,verifyCode.do,verifyUserByUserName.do,register.do";
	
	public static final String DEFAULT_REQUEST_TIME= "0";//默认接口请求耗时
	
	public static final String VERIFYCODE_TYPE_REGISTER = "1";//验证码类型 注册
	public static final String VERIFYCODE_TYPE_FORGETPWD = "2";//验证码类别 忘记密码

}
