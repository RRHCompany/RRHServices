package com.rrh.mobile.im.models;

import com.rrh.mobile.im.util.GsonUtil;

//文本消息
public class TextMessage extends BaseMessage {

	private String content;
	private String extra;

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}
	
	public TextMessage(String content) {
		this.type = "RC:TxtMsg";
		this.content = content;
	}

	public TextMessage(String content,String extra) {
		this(content);
		this.extra = extra;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return GsonUtil.toJson(this, TextMessage.class);
	}
}
