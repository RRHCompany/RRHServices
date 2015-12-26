package com.rrh.mobile;

import java.util.HashMap;
import java.util.Map;

import com.rrh.common.utils.I18NUtils;
import com.rrh.mobile.base.BaseResponse;

public class ResultMobile {
	
	//操作成功
	public static BaseResponse resultSuccess(Object body){
		return new BaseResponse(ConstantsMobile.RESULT_CODE_SUCCESS,body,null);
	}
	//操作成功
	public static BaseResponse resultSuccess(String key,Object value){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put(key, value);
		return new BaseResponse(ConstantsMobile.RESULT_CODE_SUCCESS,map,null);
	}
	//操作失败
	public static BaseResponse resultFall(String errorMsg){
		String value=I18NUtils.getInstaner().getMessage(errorMsg);
		if(value==null||value.equals("")){
			value=errorMsg;
		}
		return new BaseResponse(ConstantsMobile.RESULT_CODE_FAIL,null,value);
	}
	//请求参数为空或有误，请检查
	public static BaseResponse resultErroParam(){
		return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_PARAM,null,"请求参数为空或有误，请检查");
	}
	//缺少必要参数
	public static BaseResponse resultErroLackParam(){
		return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_LACK_PARAM,null,"缺少必要参数");
	}
	//缺少公共参数
	public static BaseResponse resultErroPublicParam(){
		return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_PUBLIC_PARAM,null,"缺少公共参数");
	}
	//程序内部异常
	public static BaseResponse resultErroSystem(){
		return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_SYSTEM,null,"程序内部异常");
	}
	//数据异常
	public static BaseResponse resultErroData(){
		return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_DATA,null,"数据异常");
	}
	//记录已经存在
	public static BaseResponse resultErroRecodrYes(){
		return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_RECORD_YES,null,"记录已经存在");
	}
	//记录不存在
	public static BaseResponse resultErroRecodrNo(){
		return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_RECORD_NO,null,"记录不存在");
	}
	//用户不存在
	public static BaseResponse resultErroUserNo(){
		return new BaseResponse(ConstantsMobile.RESULT_CODE_ERROR_USER_NO,null,"用户不存在");
	}
}
