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
	public static SdkHttpResult requestFriendMessage(String toUserIds,String nickName) throws Exception {
		ContactNtfMessage cnm=new ContactNtfMessage("请求添加好友", IM.PUBLIC_MSG_NEW_FRIEND,toUserIds, nickName+" 请求添加你为好友");
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.MSG_SEND_SYSTEM_PUBLISH);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("fromUserId", IM.PUBLIC_MSG_NEW_FRIEND);
		paramsMap.put("toUserId", toUserIds);
		paramsMap.put("objectName",cnm.getType());
		paramsMap.put("content",cnm.toString());
		paramsMap.put("pushContent","请求添加好友pushContent");
		paramsMap.put("pushData","请求添加好友pushData");
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}
	
	// 发送添加好友成功消息
	public static SdkHttpResult addFriendMessage(String toUserIds,String nickName) throws Exception {
		ContactNtfMessage cnm=new ContactNtfMessage("好友添加成功", IM.PUBLIC_MSG_NEW_FRIEND,toUserIds, nickName+" 添加好友成功");
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.MSG_SEND_SYSTEM_PUBLISH);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("fromUserId", IM.PUBLIC_MSG_NEW_FRIEND);
		paramsMap.put("toUserId", toUserIds);
		paramsMap.put("objectName",cnm.getType());
		paramsMap.put("content",cnm.toString());
		paramsMap.put("pushContent","好友添加成功pushContent");
		paramsMap.put("pushData","好友添加成功pushData");
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}
}
