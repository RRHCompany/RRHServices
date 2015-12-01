package com.rrh.base;

import com.rrh.common.ErrorMsgConstant;


public class BaseResponse {
	private String resultCode;
	private String errorMsg;
	private String time;
	private Object body = "";
	public BaseResponse(){}
	
	
	/**
	 * 
	 * @param resultCode
	 * @param errorMsg
	 * @param time
	 */
	public BaseResponse(String resultCode, String time) {
		this.resultCode = resultCode;
		this.time = time;
		if(resultCode != null){
			this.errorMsg = ErrorMsgConstant.ERROR_MAP.get(resultCode);
		}
	}

	public BaseResponse(String resultCode, String time, Object body) {
		super();
		this.resultCode = resultCode;
		this.time = time;
		this.body = body;
		if(resultCode != null){
			this.errorMsg = ErrorMsgConstant.ERROR_MAP.get(resultCode);
		}
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
