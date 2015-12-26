package com.rrh.common.mybatis.bean;


/**
 * 群成员
 * @author jason
 * @data 2015-12-8
 */
public class GroupUserBean{
	
	private Integer groupUserId;
	
	private Integer userId;
	
	private String smallImg;
	
	private String bigImg;

	public Integer getGroupUserId() {
		return groupUserId;
	}

	public void setGroupUserId(Integer groupUserId) {
		this.groupUserId = groupUserId;
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

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
