package com.rrh.common.mybatis.bean;


/**
 * 好友
 * @author jason
 * @data 2015-12-8
 */
public class FriendItemBean{
	
	private int id;
	
	private int userId;
	
	private int friendId;//好友编号
	
	private String smallImg;
	
	private String bigImg;
	
	private String notes;//备注
	
	private String nickName;//昵称
	
	private String relaty;//关系
	
	private int status;//状态
	
	private String extra;//附加消息
	
	private int gender;//性别

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFriendId() {
		return friendId;
	}

	public void setFriendId(int friendId) {
		this.friendId = friendId;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public String getRelaty() {
		return relaty;
	}

	public void setRelaty(String relaty) {
		this.relaty = relaty;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
