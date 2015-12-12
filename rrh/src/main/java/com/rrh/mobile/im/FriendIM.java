package com.rrh.mobile.im;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import com.rrh.mobile.im.models.ContactNtfMessage;
import com.rrh.mobile.im.models.SdkHttpResult;
import com.rrh.mobile.im.util.HttpUtil;

/**
 * 好友
 * @author jason
 * @data 2015-12-3
 */
public class FriendIM {
	
	// 发送添加好友请求消息
	public static SdkHttpResult requestFriendMessage(String fromUserId,String toUserIds,ContactNtfMessage msg, String pushContent,String pushData) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.MSG_SEND_SYSTEM_PUBLISH);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("fromUserId", fromUserId);
		paramsMap.put("toUserId", toUserIds);
		paramsMap.put("objectName",msg.getType());
		paramsMap.put("content",msg.toString());
		paramsMap.put("pushContent",pushContent == null ? "" : pushContent);
		paramsMap.put("pushData",pushData == null ? "" : pushData);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}
	
	// 发送添加好友消息
	public static SdkHttpResult addFriendMessage(String fromUserId,String toUserIds,ContactNtfMessage msg, String pushContent,String pushData) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.MSG_SEND_SYSTEM_PUBLISH);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("fromUserId", fromUserId);
		paramsMap.put("toUserId", toUserIds);
		paramsMap.put("objectName",msg.getType());
		paramsMap.put("content",msg.toString());
		paramsMap.put("pushContent",pushContent == null ? "" : pushContent);
		paramsMap.put("pushData",pushData == null ? "" : pushData);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}
}
