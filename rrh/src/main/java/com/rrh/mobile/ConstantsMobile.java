package com.rrh.mobile;


public class ConstantsMobile {
	
	public final static String MOBOLE_V_1_0_PRE="/v1.0/mobile/";//手机接口前缀
    
	public static final String RESULT_CODE_FAIL = "0"; //操作失败
	public static final String RESULT_CODE_SUCCESS = "1";//操作成功
	public final static String RESULT_CODE_ERROR_PARAM="0000";//请求参数为空或有误，请检查
	public final static String RESULT_CODE_ERROR_LACK_PARAM="0001";//缺少必要参数
	public final static String RESULT_CODE_ERROR_PUBLIC_PARAM="0002";//缺少公共参数
	public final static String RESULT_CODE_ERROR_SYSTEM="0003";//程序内部异常
	public final static String RESULT_CODE_ERROR_DATA="0004";//数据异常
	public final static String RESULT_CODE_ERROR_RECORD_YES="0005";//记录已经存在
	public final static String RESULT_CODE_ERROR_RECORD_NO="0006";//记录不存在
	public final static String RESULT_CODE_ERROR_USER_NO="0007";//用户不存在
	
}
