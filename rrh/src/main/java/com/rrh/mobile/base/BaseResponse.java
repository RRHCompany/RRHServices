package com.rrh.mobile.base;

import com.rrh.mobile.ErrorMsgConstant;


/**
 * 返回json数据
 */
public class BaseResponse {
	private String resultCode;
	private String errorMsg;
	private String time;
	private Object body;
	
	public BaseResponse(){
	}
	public BaseResponse(String resultCode){
		this.resultCode = resultCode;
	}
	public BaseResponse(String resultCode, Object body){
		this.resultCode = resultCode;
		this.body = body;
	}
	public BaseResponse(String resultCode, Object body,String errorMsg) {
		this.resultCode = resultCode;
		this.body = body;
		this.errorMsg=errorMsg;
//		if(resultCode != null){
//			this.errorMsg = ErrorMsgConstant.ERROR_MAP.get(resultCode);
//		}
	}

	public String getResultCode() {
		return resultCode;
	}
	public void setResultCode(String resultCode) {
		this.resultCode = resultCode;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Object getBody() {
		return body;
	}
	public void setBody(Object body) {
		this.body = body;
	}
}
