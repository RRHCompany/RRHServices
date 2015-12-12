package com.rrh.mobile.im.models;

//消息基类，如实现自定义消息，可继承此类
public abstract class BaseMessage {

	protected String type;

	public String getType() {
		return type;
	}	
}
