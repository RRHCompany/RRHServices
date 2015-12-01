package com.rrh.base;

public class BaseRequest {
	protected String appSystem;//系统类型 Ios Android 
	protected String appDeviceInfo;// 设备信息 imei udid
	protected String appChannel;//渠道
	protected String token; //
	protected Integer baseId;
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public Integer getBaseId() {
		return baseId;
	}
	public void setBaseId(Integer baseId) {
		this.baseId = baseId;
	}
	public String getAppSystem() {
		return appSystem;
	}
	public void setAppSystem(String appSystem) {
		this.appSystem = appSystem;
	}
	public String getAppDeviceInfo() {
		return appDeviceInfo;
	}
	public void setAppDeviceInfo(String appDeviceInfo) {
		this.appDeviceInfo = appDeviceInfo;
	}
	public String getAppChannel() {
		return appChannel;
	}
	public void setAppChannel(String appChannel) {
		this.appChannel = appChannel;
	}
}
