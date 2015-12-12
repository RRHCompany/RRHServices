package com.rrh.common.mybatis.bean;


/**
 * 普通群列表
 * @author jason
 * @data 2015-12-8
 */
public class GroupListBean{
	
	private Integer groupId;
	
	private String name;
	
	private String smallImg;
	
	private String bigImg;
	
	private Integer type;

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}
}
