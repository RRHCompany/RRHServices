package com.rrh.mobile.im;

import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rrh.mobile.im.models.SdkHttpResult;
import com.rrh.mobile.im.util.HttpUtil;

/**
 * 用户
 * @author jason
 * @data 2015-12-3
 */
public class UserIM {

	// 检查用户在线状态
	public static SdkHttpResult checkOnline(String userId) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.USER_CHECK_ONLINE);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("userId", userId);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}

	// 刷新用户信息
	public static SdkHttpResult refreshUser(String userId, String userName,String portraitUri) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.USER_REFRESH);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("userId", userId);
		paramsMap.put("name", userName);
		paramsMap.put("portraitUri", portraitUri);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}

	// 封禁用户
	public static SdkHttpResult blockUser(String userId, int minute)throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.USER_BLOCK);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("userId", userId);
		paramsMap.put("minute", String.valueOf(minute));
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}

	// 解禁用户
	public static SdkHttpResult unblockUser(String userId) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.USER_UN_BLOCK);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("userId", userId);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}

	// 获取被封禁用户
	public static SdkHttpResult queryBlockUsers()throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.USER_QUERY_BLOCK_USERS);
		return HttpUtil.returnResult(conn);
	}

	// 添加用户到黑名单
	public static SdkHttpResult blackUser(String userId,List<String> blackUserIds) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.USER_ADD_BLACK_LIST);
		StringBuilder sb = new StringBuilder();
		sb.append("userId=").append(URLEncoder.encode(userId, IM.UTF8));
		if (blackUserIds != null) {
			for (String blackId : blackUserIds) {
				sb.append("&blackUserId=").append(URLEncoder.encode(blackId, IM.UTF8));
			}
		}
		HttpUtil.setBodyParameter(sb, conn);
		return HttpUtil.returnResult(conn);
	}

	// 从黑名单移除用户
	public static SdkHttpResult unblackUser(String userId,List<String> blackUserIds) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.USER_REMOVE_BLACK_LIST);
		StringBuilder sb = new StringBuilder();
		sb.append("userId=").append(URLEncoder.encode(userId, IM.UTF8));
		if (blackUserIds != null) {
			for (String blackId : blackUserIds) {
				sb.append("&blackUserId=").append(URLEncoder.encode(blackId, IM.UTF8));
			}
		}
		HttpUtil.setBodyParameter(sb, conn);
		return HttpUtil.returnResult(conn);
	}

	// 获取黑名单用户
	public static SdkHttpResult QueryblackUser(String userId) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.USER_QUERY_BLACK_LIST);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("userId", userId);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}
}
