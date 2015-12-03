package com.rrh.mobile.bean.req;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;


public class UserPerfectInfoRequest {
	 private Integer userId;
	 private String trueName;
	 private String nickName;
	 private Integer gender;
	 @DateTimeFormat(pattern="yyyy-MM-dd") 
	 private Date birthday; 
	 private Integer province;
	 private Integer city;
	 private Integer area;
	 private String businessName;
	 private String businessDesc;
	 private String businessTraffic;
	 private String businessAddress;
	 private String businessDomain;
	 private String businessWeixin;
	 private String details;
	 private String signature;
	 private String email;
	 private String goodAt;
	 private String place;
	 private String food;
	 private String stature;
	 private String weight;
	 private String emotion;
	 private String sports;
	 private String idCard;
	 private String idCardImage;
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getTrueName() {
		return trueName;
	}
	public void setTrueName(String trueName) {
		this.trueName = trueName;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Integer getProvince() {
		return province;
	}
	public void setProvince(Integer province) {
		this.province = province;
	}
	public Integer getCity() {
		return city;
	}
	public void setCity(Integer city) {
		this.city = city;
	}
	public Integer getArea() {
		return area;
	}
	public void setArea(Integer area) {
		this.area = area;
	}
	public String getBusinessName() {
		return businessName;
	}
	public void setBusinessName(String businessName) {
		this.businessName = businessName;
	}
	public String getBusinessDesc() {
		return businessDesc;
	}
	public void setBusinessDesc(String businessDesc) {
		this.businessDesc = businessDesc;
	}
	public String getBusinessTraffic() {
		return businessTraffic;
	}
	public void setBusinessTraffic(String businessTraffic) {
		this.businessTraffic = businessTraffic;
	}
	public String getBusinessAddress() {
		return businessAddress;
	}
	public void setBusinessAddress(String businessAddress) {
		this.businessAddress = businessAddress;
	}
	public String getBusinessDomain() {
		return businessDomain;
	}
	public void setBusinessDomain(String businessDomain) {
		this.businessDomain = businessDomain;
	}
	public String getBusinessWeixin() {
		return businessWeixin;
	}
	public void setBusinessWeixin(String businessWeixin) {
		this.businessWeixin = businessWeixin;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public String getSignature() {
		return signature;
	}
	public void setSignature(String signature) {
		this.signature = signature;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGoodAt() {
		return goodAt;
	}
	public void setGoodAt(String goodAt) {
		this.goodAt = goodAt;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getFood() {
		return food;
	}
	public void setFood(String food) {
		this.food = food;
	}
	public String getStature() {
		return stature;
	}
	public void setStature(String stature) {
		this.stature = stature;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getEmotion() {
		return emotion;
	}
	public void setEmotion(String emotion) {
		this.emotion = emotion;
	}
	public String getSports() {
		return sports;
	}
	public void setSports(String sports) {
		this.sports = sports;
	}
	public String getIdCard() {
		return idCard;
	}
	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}
	public String getIdCardImage() {
		return idCardImage;
	}
	public void setIdCardImage(String idCardImage) {
		this.idCardImage = idCardImage;
	}
		
}
