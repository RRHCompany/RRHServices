package com.rrh.model.group;

import java.util.Date;

/**
 * 好友
 * @author jason
 * @data 2015-12-7
 */
public class TbFriend {
	
    private Integer id;
	
    private Integer friendId;

    private Integer userId;

    private String relaty;
    
    private Integer status;

    private Date addTime;
    
    private String notes;//备注
    
    private String extra;//附加消息
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getFriendId() {
		return friendId;
	}

	public void setFriendId(Integer friendId) {
		this.friendId = friendId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getRelaty() {
		return relaty;
	}

	public void setRelaty(String relaty) {
		this.relaty = relaty;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
}