package com.rrh.model.group;

import java.util.Date;

public class TbGroupUser {
   
    private Integer groupUserId;

    private Integer userId;
  
    private Integer groupId;

    private Integer status;

    private Date addTime;

    private String jobTitle;

    private Integer depId;

    private String tel;

    private Boolean isTelShow;

    private Boolean isFreeMode;//消息免打扰

    private Integer setTop;

	public Integer getGroupUserId() {
		return groupUserId;
	}

	public void setGroupUserId(Integer groupUserId) {
		this.groupUserId = groupUserId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
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

	public String getJobTitle() {
		return jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}

	public Integer getDepId() {
		return depId;
	}

	public void setDepId(Integer depId) {
		this.depId = depId;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Boolean getIsTelShow() {
		return isTelShow;
	}

	public void setIsTelShow(Boolean isTelShow) {
		this.isTelShow = isTelShow;
	}

	public Boolean getIsFreeMode() {
		return isFreeMode;
	}

	public void setIsFreeMode(Boolean isFreeMode) {
		this.isFreeMode = isFreeMode;
	}

	public Integer getSetTop() {
		return setTop;
	}

	public void setSetTop(Integer setTop) {
		this.setTop = setTop;
	}

   
}