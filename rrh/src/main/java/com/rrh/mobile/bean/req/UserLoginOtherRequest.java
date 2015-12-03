package com.rrh.mobile.bean.req;


public class UserLoginOtherRequest {
	private String openId;//key
	private String smallImg;//头像
	private String nickName; //昵称
	private String type; // QQ:1  微信：2：新浪微博：3
	public String getOpenId() {
		return openId;
	}
	public void setOpenId(String openId) {
		this.openId = openId;
	}
	public String getSmallImg() {
		return smallImg;
	}
	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
