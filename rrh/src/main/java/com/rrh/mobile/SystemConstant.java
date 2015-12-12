package com.rrh.mobile;



public class SystemConstant {

	public static final String BACK_ADMIN = "BACK_ADMIN";
	//不通过登录 过滤器的方法名，用逗号隔开
	public static final String LOGINFILTER_METHOD_FREE = "login.do,createVerifyCode.do,verifyCode.do,verifyUserByUserName.do,register.do,recoverPwd.do";
	
	//第三方登录 
	public static final String USER_LOGINOTHER_WEIXIN = "openIdWeixin";
	public static final String USER_LOGINOTHER_QQ = "openIdQq";
	public static final String USER_LOGINOTHER_SINA = "openIdSina";
}
