package com.rrh.mobile.bean.req;


public class ExtLoginRequest {

	private String extendUserId;
	private Short type;
	public String getExtendUserId() {
		return extendUserId;
	}
	public void setExtendUserId(String extendUserId) {
		this.extendUserId = extendUserId;
	}
	public Short getType() {
		return type;
	}
	public void setType(Short type) {
		this.type = type;
	}
}
