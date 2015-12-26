package com.rrh.model.user;

import java.math.BigDecimal;
import java.util.Date;

public class TbUsers {
    
    private int userId;

    private String userName;

    private String mobile;

    private String password;

    private String trueName;

    private String nickName;

    private BigDecimal money;

    private Integer gender;

    private Date birthday;

    private String smallImg;

    private String bigImg;

    private Date regTime;

    private Date lastTime;

    private Integer loginCount;

    private Boolean isCertification;

    private int province;

    private int city;

    private int area;

    private String idCard;

    private String idCardImage;

    private String businessName;

    private String businessDesc;

    private String businessTraffic;

    private String businessAddress;

    private String businessDomain;

    private String businessWeixin;

    private String signature;

    private String email;

    private String payPassword;

    private String contactsPassword;

    private Date lcd;

    private String appChannel;

    private String appDeviceInfo;
    
    private String appSystem;

    private String loginToken;

    private String goodAt;

    private String place;

    private String food;

    private String stature;

    private String weight;

    private String emotion;

    private String sports;

    private String openIdWeixin;

    private String openIdQq;

    private String openIdSina;

	public TbUsers() {}

	public TbUsers(int userId, String trueName, String nickName,
			int gender, Date birthday,
			int province, int city,
			int area, String idCard, String idCardImage,
			String businessName, String businessDesc, String businessTraffic,
			String businessAddress, String businessDomain,
			String businessWeixin,  String signature,
			String email, String goodAt, String place, String food,
			String stature, String weight, String emotion, String sports) {
		this.userId = userId;
		this.trueName = trueName;
		this.nickName = nickName;
		this.gender = gender;
		this.birthday = birthday;
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
		this.signature = signature;
		this.email = email;
		this.goodAt = goodAt;
		this.place = place;
		this.food = food;
		this.stature = stature;
		this.weight = weight;
		this.emotion = emotion;
		this.sports = sports;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public Integer getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Integer loginCount) {
		this.loginCount = loginCount;
	}

	public Boolean getIsCertification() {
		return isCertification;
	}

	public void setIsCertification(Boolean isCertification) {
		this.isCertification = isCertification;
	}

	public int getProvince() {
		return province;
	}

	public void setProvince(int province) {
		this.province = province;
	}

	public int getCity() {
		return city;
	}

	public void setCity(int city) {
		this.city = city;
	}

	public int getArea() {
		return area;
	}

	public void setArea(int area) {
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

	public String getPayPassword() {
		return payPassword;
	}

	public void setPayPassword(String payPassword) {
		this.payPassword = payPassword;
	}

	public String getContactsPassword() {
		return contactsPassword;
	}

	public void setContactsPassword(String contactsPassword) {
		this.contactsPassword = contactsPassword;
	}

	public Date getLcd() {
		return lcd;
	}

	public void setLcd(Date lcd) {
		this.lcd = lcd;
	}

	public String getAppChannel() {
		return appChannel;
	}

	public void setAppChannel(String appChannel) {
		this.appChannel = appChannel;
	}

	public String getAppDeviceInfo() {
		return appDeviceInfo;
	}

	public void setAppDeviceInfo(String appDeviceInfo) {
		this.appDeviceInfo = appDeviceInfo;
	}

	public String getAppSystem() {
		return appSystem;
	}

	public void setAppSystem(String appSystem) {
		this.appSystem = appSystem;
	}

	public String getLoginToken() {
		return loginToken;
	}

	public void setLoginToken(String loginToken) {
		this.loginToken = loginToken;
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

	public String getOpenIdWeixin() {
		return openIdWeixin;
	}

	public void setOpenIdWeixin(String openIdWeixin) {
		this.openIdWeixin = openIdWeixin;
	}

	public String getOpenIdQq() {
		return openIdQq;
	}

	public void setOpenIdQq(String openIdQq) {
		this.openIdQq = openIdQq;
	}

	public String getOpenIdSina() {
		return openIdSina;
	}

	public void setOpenIdSina(String openIdSina) {
		this.openIdSina = openIdSina;
	}
	
}