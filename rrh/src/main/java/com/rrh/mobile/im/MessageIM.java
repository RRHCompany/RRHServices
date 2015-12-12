package com.rrh.mobile.im;

import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rrh.mobile.im.models.BaseMessage;
import com.rrh.mobile.im.models.SdkHttpResult;
import com.rrh.mobile.im.util.HttpUtil;

/**
 * 消息
 * @author jason
 * @data 2015-12-3
 */
public class MessageIM {

	// 发送消息
	public static SdkHttpResult publishMessage(String fromUserId,List<String> toUserIds, BaseMessage msg) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.MSG_SEND_PRIVATE_PUBLISH);
		StringBuilder sb = new StringBuilder();
		sb.append("fromUserId=").append(URLEncoder.encode(fromUserId, IM.UTF8));
		if (toUserIds != null) {
			for (int i = 0; i < toUserIds.size(); i++) {
				sb.append("&toUserId=").append(URLEncoder.encode(toUserIds.get(i), IM.UTF8));
			}
		}
		sb.append("&objectName=").append(URLEncoder.encode(msg.getType(), IM.UTF8));
		sb.append("&content=").append(URLEncoder.encode(msg.toString(), IM.UTF8));
		HttpUtil.setBodyParameter(sb, conn);
		return HttpUtil.returnResult(conn);
	}

	// 发送消息
	public static SdkHttpResult publishMessage(String fromUserId,List<String> toUserIds, BaseMessage msg, String pushContent,String pushData) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.MSG_SEND_PUBLISH);
		StringBuilder sb = new StringBuilder();
		sb.append("fromUserId=").append(URLEncoder.encode(fromUserId, IM.UTF8));
		if (toUserIds != null) {
			for (int i = 0; i < toUserIds.size(); i++) {
				sb.append("&toUserId=").append(URLEncoder.encode(toUserIds.get(i), IM.UTF8));
			}
		}
		sb.append("&objectName=").append(URLEncoder.encode(msg.getType(), IM.UTF8));
		sb.append("&content=").append(URLEncoder.encode(msg.toString(), IM.UTF8));
		if (pushContent != null) {
			sb.append("&pushContent=").append(URLEncoder.encode(pushContent == null ? "" : pushContent,IM.UTF8));
		}
		if (pushData != null) {
			sb.append("&pushData=").append(URLEncoder.encode(pushData == null ? "" : pushData, IM.UTF8));
		}
		HttpUtil.setBodyParameter(sb, conn);
		return HttpUtil.returnResult(conn);
	}

	// 发送系统消息
	public static SdkHttpResult publishSystemMessage(String fromUserId,List<String> toUserIds, BaseMessage msg, String pushContent,String pushData) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.MSG_SEND_SYSTEM_PUBLISH);
		StringBuilder sb = new StringBuilder();
		sb.append("fromUserId=").append(URLEncoder.encode(fromUserId, IM.UTF8));
		if (toUserIds != null) {
			for (int i = 0; i < toUserIds.size(); i++) {
				sb.append("&toUserId=").append(URLEncoder.encode(toUserIds.get(i), IM.UTF8));
			}
		}
		sb.append("&objectName=").append(URLEncoder.encode(msg.getType(), IM.UTF8));
		sb.append("&content=").append(URLEncoder.encode(msg.toString(), IM.UTF8));
		if (pushContent != null) {
			sb.append("&pushContent=").append(URLEncoder.encode(pushContent == null ? "" : pushContent,IM.UTF8));
		}
		if (pushData != null) {
			sb.append("&pushData=").append(URLEncoder.encode(pushData == null ? "" : pushData, IM.UTF8));
		}
		HttpUtil.setBodyParameter(sb, conn);
		return HttpUtil.returnResult(conn);
	}
	


	// 发送群消息
	public static SdkHttpResult publishGroupMessage(String fromUserId,List<String> toGroupIds, BaseMessage msg, String pushContent,String pushData) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.MSG_SEND_GROUP_PUBLISH);
		StringBuilder sb = new StringBuilder();
		sb.append("fromUserId=").append(URLEncoder.encode(fromUserId, IM.UTF8));
		if (toGroupIds != null) {
			for (int i = 0; i < toGroupIds.size(); i++) {
				sb.append("&toGroupId=").append(URLEncoder.encode(toGroupIds.get(i), IM.UTF8));
			}
		}
		sb.append("&objectName=").append(URLEncoder.encode(msg.getType(), IM.UTF8));
		sb.append("&content=").append(URLEncoder.encode(msg.toString(), IM.UTF8));
		if (pushContent != null) {
			sb.append("&pushContent=").append(URLEncoder.encode(pushContent == null ? "" : pushContent,IM.UTF8));
		}
		if (pushData != null) {
			sb.append("&pushData=").append(URLEncoder.encode(pushData == null ? "" : pushData, IM.UTF8));
		}
		HttpUtil.setBodyParameter(sb, conn);
		return HttpUtil.returnResult(conn);
	}

	// 发送聊天室消息
	public static SdkHttpResult publishChatroomMessage(String fromUserId,List<String> toChatroomIds, BaseMessage msg) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.MSG_SEND_CHATROOM_PUBLISH);
		StringBuilder sb = new StringBuilder();
		sb.append("fromUserId=").append(URLEncoder.encode(fromUserId, IM.UTF8));
		if (toChatroomIds != null) {
			for (int i = 0; i < toChatroomIds.size(); i++) {
				sb.append("&toChatroomId=").append(URLEncoder.encode(toChatroomIds.get(i), IM.UTF8));
			}
		}
		sb.append("&objectName=").append(URLEncoder.encode(msg.getType(), IM.UTF8));
		sb.append("&content=").append(URLEncoder.encode(msg.toString(), IM.UTF8));
		HttpUtil.setBodyParameter(sb, conn);
		return HttpUtil.returnResult(conn);
	}
	// 发送广播消息
	public static SdkHttpResult broadcastMessage(String fromUserId,BaseMessage msg, String pushContent, String pushData) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.MSG_SEND_BROADCAST_PUBLISH);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("fromUserId", fromUserId);
		paramsMap.put("objectName", msg.getType());
		paramsMap.put("content", msg.toString());
		paramsMap.put("pushContent", pushContent);
		paramsMap.put("pushData", pushData);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}

	// 查询聊天室信息
	public static SdkHttpResult queryChatroom(List<String> chatroomIds)throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.MSG_QUERY_CHATROOM_MSG);
		StringBuilder sb = new StringBuilder();
		sb.append("1=1");
		if (chatroomIds != null) {
			for (String id : chatroomIds) {
				sb.append("&chatroomId=").append(URLEncoder.encode(id, IM.UTF8));
			}
		}
		HttpUtil.setBodyParameter(sb, conn);
		return HttpUtil.returnResult(conn);
	}

	// 获取消息历史记录下载地址
	public static SdkHttpResult getMessageHistoryUrl(String date) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.MSG_GET_HISTORY_URL);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("date", date);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}

	// 删除消息历史记录
	public static SdkHttpResult deleteMessageHistory(String date) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.MSG_QUERY_HISTORY_LIST);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("date", date);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}
}
