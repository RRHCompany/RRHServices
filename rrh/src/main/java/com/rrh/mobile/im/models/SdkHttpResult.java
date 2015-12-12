package com.rrh.mobile.im.models;

import com.alibaba.fastjson.JSON;

//对server sdk返回的封装
public class SdkHttpResult {

	private int httpCode;
	private String httpResult;

	public SdkHttpResult(int httpCode, String httpResult) {
		this.httpCode = httpCode;
		this.httpResult = httpResult;
	}

	public int getHttpCode() {
		return httpCode;
	}

	public String getHttpResult() {
		return httpResult;
	}

	@Override
	public String toString() {
		return String.format("{\"httpCode\":\"%s\",\"httpResult\":%s}", httpCode,httpResult);
	}
	
	public Object getBean(Class<?> clazz){
		return JSON.parseObject(httpResult, clazz);
	}
}
