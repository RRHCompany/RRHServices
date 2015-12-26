package com.rrh.mobile.bean.res;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rrh.common.mybatis.bean.GroupUserBean;
import com.rrh.mobile.base.BaseResponse;

/**
 * 普通群详请
 * 
 * @author jason
 * @data 2015-12-15
 */
public class GroupDetailRespoint extends BaseResponse{
	
	private Integer groupId;

	private String groupName;

	private String smallImg;

	private String bigImg;

	private Integer type;

	private Integer businessId;

	private Integer userId;

	private Boolean isPublic;

	private String bgImage;

	private Date createTime;

	private Integer parentId;

	private String qrcode;

	private Date lastTime;
	
	private String businessAddress;//企业地址
	
	private String businessTel;//企业电话
	
	private String businessName;//企业名称
	
	private List<GroupUserBean> groupUserList=new ArrayList<GroupUserBean>();//群成员

	public Integer getGroupId() {
		return groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
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

	public Integer getBusinessId() {
		return businessId;
	}

	public void setBusinessId(Integer businessId) {
		this.businessId = businessId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public String getBgImage() {
		return bgImage;
	}

	public void setBgImage(String bgImage) {
		this.bgImage = bgImage;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public Date getLastTime() {
		return lastTime;
	}

	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}

	public List<GroupUserBean> getGroupUserList() {
		return groupUserList;
	}

	public void setGroupUserList(List<GroupUserBean> groupUserList) {
		this.groupUserList = groupUserList;
	}

	public String getBusinessAddress() {
		return businessAddress;
	}

	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}

	public String getBusinessTel() {
		return businessTel;
	}

	public void setBusinessTel(String businessTel) {
		this.businessTel = businessTel;
	}

	public String getBusinessName() {
		return businessName;
	}

	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
}
