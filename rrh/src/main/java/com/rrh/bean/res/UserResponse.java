package com.rrh.bean.res;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.rrh.base.BaseResponse;

public class UserResponse extends BaseResponse{
	 private Integer userId;	   
	 private String userName;
	 private String mobile;
	 private String trueName;
	 private String nickName;
	 private BigDecimal money;
	 private Integer gender;
	 private Date birthday;
	 private String smallImg;
	 private String bigImg;
	 private Date regTime;
	 private Date lastTime;
	 private Boolean isCertification;
	 private Integer province;
	 private Integer city;
	 private Integer area;
	 private String idCard;
	 private String idCardImage;
	 private String businessName;
	 private String businessDesc;
	 private String businessTraffic;
	 private String businessAddress;
	 private String businessDomain;
	 private String businessWeixin;
	 private String details;
	 private String signature;
	 private String email;
	 private String token;
	 private String goodAt;
	 private String place;
	 private String food;
	 private String stature;
	 private String weight;
	 private String emotion;
	 private String sports;

	    
		public UserResponse() {
			super();
		}
		public UserResponse(Integer userId, String userName, String mobile,
				String trueName, String nickName, BigDecimal money,
				Integer gender, Date birthday, String smallImg, String bigImg,
				Date regTime, Date lastTime, Boolean isCertification,
				Integer province, Integer city, Integer area, String idCard,
				String idCardImage, String businessName, String businessDesc,
				String businessTraffic, String businessAddress,
				String businessDomain, String businessWeixin, String details,
				String signature, String email,String token,String goodAt,String place,
				String food,String stature,String weight,String emotion,String sports) {
			super();
			this.userId = userId;
			this.userName = userName;
			this.mobile = mobile;
			this.trueName = trueName;
			this.nickName = nickName;
			this.money = money;
			this.gender = gender;
			this.birthday = birthday;
			this.smallImg = smallImg;
			this.bigImg = bigImg;
			this.regTime = regTime;
			this.lastTime = lastTime;
			this.isCertification = isCertification;
			this.province = province;
			this.city = city;
			this.area = area;
			this.idCard = idCard;
			this.idCardImage = idCardImage;
			this.businessName = businessName;
			this.businessDesc = businessDesc;
			this.businessTraffic = businessTraffic;
			this.businessAddress = businessAddress;
			this.businessDomain = businessDomain;
			this.businessWeixin = businessWeixin;
			this.details = details;
			this.signature = signature;
			this.email = email;
			this.token = token;
			this.goodAt = goodAt;
			this.place = place;
			this.food = food;
			this.stature = stature;
			this.weight = weight;
			this.emotion = emotion;
			this.sports = sports;
		}
		public String getToken() {
			return token;
		}
		public void setToken(String token) {
			this.token = token;
		}
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
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
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
		public BigDecimal getMoney() {
			return money;
		}
		public void setMoney(BigDecimal money) {
			this.money = money;
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
		@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss.SSS",timezone = "GMT+8")    
		public Date getRegTime() {
			return regTime;
		}

		public void setRegTime(Date regTime) {
			this.regTime = regTime;
		}
		public Date getLastTime() {
			return lastTime;
		}
		public void setLastTime(Date lastTime) {
			this.lastTime = lastTime;
		}
		public Boolean getIsCertification() {
			return isCertification;
		}
		public void setIsCertification(Boolean isCertification) {
			this.isCertification = isCertification;
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
	    
	
}
