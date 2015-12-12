package com.rrh.mobile.im;

import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;

import com.rrh.mobile.im.models.SdkHttpResult;
import com.rrh.mobile.im.util.HttpUtil;

/**
 * 其他
 * @author jason
 * @data 2015-12-3
 */
public class OtherIM {
	
	public static SdkHttpResult groupUserGagAdd(String groupId, String userId,long minute) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.OTHER_GROUP_USER_GAG_ADD);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("groupId", groupId == null ? "" : groupId);
		paramsMap.put("userId", userId == null ? "" : userId);
		paramsMap.put("minute", String.valueOf(minute));
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}

	public static SdkHttpResult groupUserGagRollback(String groupId, String userId)throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.OTHER_GROUP_USER_GAG_ROLLBACK);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("groupId", groupId == null ? "" : groupId);
		paramsMap.put("userId", userId == null ? "" : userId);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}

	public static SdkHttpResult groupUserGagList(String groupId)throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.OTHER_GROUP_USER_GAG_LIST);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("groupId", groupId == null ? "" : groupId);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}

	public static SdkHttpResult wordFilterAdd(String word) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.OTHER_WORDFILTER_ADD);
		if (word == null || word.length() == 0) {
			throw new Exception("word is not null or empty.");
		}
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("word", word == null ? "" : word);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}

	public static SdkHttpResult wordFilterDelete(String word) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.OTHER_WORDFILTER_DELETE);
		if (word == null || word.length() == 0) {
			throw new Exception("word is not null or empty.");
		}
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("word", word == null ? "" : word);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}

	public static SdkHttpResult wordFilterList() throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.OTHER_WORDFILTER_LIST);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("1", "1");
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}
}
