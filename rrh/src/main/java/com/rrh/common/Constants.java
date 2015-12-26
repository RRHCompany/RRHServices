package com.rrh.common;


/**
 * 网站全局参数
 * @author jason
 * @data 2015-12-8
 */
public class Constants {
	
	//好友状态
	public static final int FRIEND_STATUS_1=1;//1 好友
	public static final int FRIEND_STATUS_2=2;//2 请求添加 
	public static final int FRIEND_STATUS_3=3;//3请求被添加 
	public static final int FRIEND_STATUS_4=4;//4 请求被拒绝
	public static final int FRIEND_STATUS_5=5;//5 我被对方删除
	//群组类型
	public static final int GROUP_TYPE_0=0;//0:普通群
	public static final int GROUP_TYPE_1=1;//1:认证群
	public static final int GROUP_TYPE_2=2;//2:认证副群
	
	
	public static final int GROUP_USER_STATUS_1=1;//1:正常
	public static final int GROUP_USER_STATUS_2=2;//2:用户申请加入
	public static final int GROUP_USER_STATUS_3=3;//3:群主邀请加入
	public static final int GROUP_USER_STATUS_4=4;//4：群主拒绝
	public static final int GROUP_USER_STATUS_5=5;//5：用户拒绝
	public static final int GROUP_USER_STATUS_6=6;//6：已退群
	public static final int GROUP_USER_STATUS_7=7;//7：群解散
	
	
	
	public static final String VERIFYCODE_TYPE_REGISTER = "1";//验证码类型 注册
	public static final String VERIFYCODE_TYPE_FORGETPWD = "2";//验证码类别 忘记密码
}
