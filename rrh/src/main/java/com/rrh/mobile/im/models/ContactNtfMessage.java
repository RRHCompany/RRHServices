package com.rrh.mobile.im.models;

import com.rrh.mobile.im.util.GsonUtil;

/**添加联系人消息
 * @author jason
 * @data 2015-12-7
 */
public class ContactNtfMessage extends BaseMessage {

	private String operation;
	private String sourceUserId;
	private String targetUserId;
	private String extra;
	private String message;

	public ContactNtfMessage(String operation, String sourceUserId,
			String targetUserId, String message) {
		this.type = "RC:ContactNtf";
		this.operation = operation;
		this.sourceUserId = sourceUserId;
		this.targetUserId = targetUserId;
		this.message = message;
	}

	public ContactNtfMessage(String operation, String sourceUserId,
			String targetUserId, String message, String extra) {
		this(operation, sourceUserId, targetUserId, message);
		this.extra = extra;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	public String getSourceUserId() {
		return sourceUserId;
	}

	public void setSourceUserId(String sourceUserId) {
		this.sourceUserId = sourceUserId;
	}

	public String getTargetUserId() {
		return targetUserId;
	}

	public void setTargetUserId(String targetUserId) {
		this.targetUserId = targetUserId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getExtra() {
		return extra;
	}

	public void setExtra(String extra) {
		this.extra = extra;
	}

	@Override
	public String toString() {
		return GsonUtil.toJson(this, ContactNtfMessage.class);
	}
}
