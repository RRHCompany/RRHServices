package com.rrh.common.mybatis.bean;


/**
 * 好友搜索
 * @author jason
 * @data 2015-12-8
 */
public class FriendSerachBean{
	
	private Integer userId;
	
	private String userName;
	
	private String nickName;
	
	private Integer gender;
	
	private String smallImg;
	
	private String bigImg;
	
	private String cityText;
	
	private String signature;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getGender() {
		return gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	public String getSmallImg() {
		return smallImg;
	}

	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}

	public String getBigImg() {
		return bigImg;
	}

	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getCityText() {
		return cityText;
	}

	public void setCityText(String cityText) {
		this.cityText = cityText;
	}
}
