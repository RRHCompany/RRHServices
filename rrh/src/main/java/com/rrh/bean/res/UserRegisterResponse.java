package com.rrh.bean.res;

import com.rrh.base.BaseResponse;

public class UserRegisterResponse extends BaseResponse{
	private Integer userId;	   
	private String token;
	public UserRegisterResponse() {
		super();
	}
	public UserRegisterResponse(Integer userId, String token) {
		super();
		this.userId = userId;
		this.token = token;
	}
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	 
	 	
}
