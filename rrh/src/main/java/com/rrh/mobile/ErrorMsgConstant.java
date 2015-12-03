package com.rrh.mobile;

import java.util.LinkedHashMap;
import java.util.Map;

public class ErrorMsgConstant {

	public static final String SMS_SEND_CODE_CHECKED_ERRORCODE = "0008";
	public static final String SMS_ERRORCODE = "0009";
	public static final String SMS_CODE_TIMEOUT_ERRORCODE = "0010";	
	public static final String SMS_CREATE_VERIFY_MOREREQUEST_ERRORCODE = "0017";
	
	public static final String USER_NOTEXISTS_ERRORCODE = "0006";
	public static final String USER_PHONE_HAD_RESGISTER_ERRORCODE = "0011";
	public static final String USER_NAME_REPEAT_ERRORCODE = "0012";	
	public static final String USER_PASSWORD_ERRORCODE = "0013";
	public static final String USER_EXTEND_ERRORCODE = "0014";
	public static final String USER_TOKEN_ERRORCODE = "0015";
	public static final String USER_PHONE_ERRORCODE = "0016";
	
	
	
	public static final String SMS_CREATE_VERIFY_MOREREQUEST_ERRORMSG = "请求太频繁，请5分钟后再获取！";
	public static final String SMS_CODE_TIMEOUT_ERRORMSG = "验证码已过期，请重新获取！";
	public static final String SMS_SEND_CODE_CHECKED_ERRORMSG = "发送短信验证码失败！";
	public static final String SMS_ERRORMSG = "短信验证码错误！";
		
	public static final String USER_NOTEXISTS_ERRORMSG = "用户不存在";
	public static final String USER_TOKEN_ERRORMSG = "TOKEN验证失败！";
	public static final String USER_PHONE_HAD_RESGISTER_ERRORMSG = "手机号已经被注册！";
	public static final String USER_USER_NAME_REPEAT_ERRORMSG = "用户名存在，请重新输入！";	
	public static final String USER_PASSWORD_ERRORMSG = "密码错误！";
	public static final String USER_EXTEND_ERRORMSG = "未注册的用户！";	
	public static final String USER_PHONE_ERRORMSG = "电话号码错误！";
	
	
	//ID 标签字段 
	public static Map<String, String> ERROR_MAP = new LinkedHashMap<String, String>();
	static{
//		ERROR_MAP.put(SMS_CODE_TIMEOUT_ERRORCODE,SMS_CODE_TIMEOUT_ERRORMSG);
//		ERROR_MAP.put(SMS_ERRORCODE,SMS_ERRORMSG);
//		ERROR_MAP.put(USER_PHONE_HAD_RESGISTER_ERRORCODE,USER_PHONE_HAD_RESGISTER_ERRORMSG);
//		ERROR_MAP.put(USER_NAME_REPEAT_ERRORCODE,USER_USER_NAME_REPEAT_ERRORMSG);
//		ERROR_MAP.put(USER_PASSWORD_ERRORCODE,USER_PASSWORD_ERRORMSG);
//		ERROR_MAP.put(USER_EXTEND_ERRORCODE,USER_EXTEND_ERRORMSG);
//		ERROR_MAP.put(USER_TOKEN_ERRORCODE,USER_TOKEN_ERRORMSG);
//		ERROR_MAP.put(SMS_SEND_CODE_CHECKED_ERRORCODE,SMS_SEND_CODE_CHECKED_ERRORMSG);
//		ERROR_MAP.put(USER_PHONE_ERRORCODE,USER_PHONE_ERRORMSG);
//		ERROR_MAP.put(SMS_CREATE_VERIFY_MOREREQUEST_ERRORCODE,SMS_CREATE_VERIFY_MOREREQUEST_ERRORMSG);
	}
	
}
