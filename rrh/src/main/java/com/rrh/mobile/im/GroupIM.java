package com.rrh.mobile.im;

import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rrh.mobile.im.models.GroupInfo;
import com.rrh.mobile.im.models.SdkHttpResult;
import com.rrh.mobile.im.util.HttpUtil;

/**
 * 群组
 * @author jason
 * @data 2015-12-3
 */
public class GroupIM {

	// 创建群
	public static SdkHttpResult createGroup(List<String> userIds, String groupId, String groupName) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.GROUP_CREATE);
		StringBuilder sb = new StringBuilder();
		sb.append("groupId=").append(URLEncoder.encode(groupId, IM.UTF8));
		sb.append("&groupName=").append(URLEncoder.encode(groupName == null ? "" : groupName, IM.UTF8));
		if (userIds != null) {
			for (String id : userIds) {
				sb.append("&userId=").append(URLEncoder.encode(id, IM.UTF8));
			}
		}
		HttpUtil.setBodyParameter(sb, conn);
		return HttpUtil.returnResult(conn);
	}

	// 加入群
	public static SdkHttpResult joinGroup(String userId, String groupId, String groupName)throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.GROUP_JOIN);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("userId", userId);
		paramsMap.put("groupId", groupId);
		paramsMap.put("groupName", groupName == null ? "" : groupName);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}

	// 批量加入群
	public static SdkHttpResult joinGroupBatch(List<String> userIds, String groupId, String groupName) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.GROUP_BATCH_JOIN);
		StringBuilder sb = new StringBuilder();
		sb.append("groupId=").append(URLEncoder.encode(groupId, IM.UTF8));
		sb.append("&groupName=").append(URLEncoder.encode(groupName == null ? "" : groupName, IM.UTF8));
		if (userIds != null) {
			for (String id : userIds) {
				sb.append("&userId=").append(URLEncoder.encode(id, IM.UTF8));
			}
		}
		HttpUtil.setBodyParameter(sb, conn);
		return HttpUtil.returnResult(conn);
	}

	// 退出群
	public static SdkHttpResult quitGroup(String userId, String groupId) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.GROUP_QUIT);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("userId", userId);
		paramsMap.put("groupId", groupId);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}

	// 批量退出群
	public static SdkHttpResult quitGroupBatch(List<String> userIds, String groupId)throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.GROUP_BATCH_QUIT);
		StringBuilder sb = new StringBuilder();
		sb.append("groupId=").append(URLEncoder.encode(groupId, IM.UTF8));
		if (userIds != null) {
			for (String id : userIds) {
				sb.append("&userId=").append(URLEncoder.encode(id, IM.UTF8));
			}
		}
		HttpUtil.setBodyParameter(sb, conn);
		return HttpUtil.returnResult(conn);
	}

	// 解散群
	public static SdkHttpResult dismissGroup(String userId, String groupId) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.GROUP_DISMISS);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("userId", userId);
		paramsMap.put("groupId", groupId);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}

	// 同步用户群信息
	public static SdkHttpResult syncGroup(String userId, List<GroupInfo> groups)throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.GROUP_SYNC);
		StringBuilder sb = new StringBuilder();
		sb.append("userId=").append(URLEncoder.encode(userId, IM.UTF8));
		if (groups != null) {
			for (GroupInfo info : groups) {
				if (info != null) {
					sb.append(String.format("&group[%s]=", URLEncoder.encode(info.getId(), IM.UTF8))).append(URLEncoder.encode(info.getName(), IM.UTF8));
				}
			}
		}
		HttpUtil.setBodyParameter(sb, conn);
		return HttpUtil.returnResult(conn);
	}

	// 刷新群信息
	public static SdkHttpResult refreshGroupInfo(String groupId, String groupName) throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.GROUP_REFRESH_INFO);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("groupId", groupId);
		paramsMap.put("groupName", groupName == null ? "" : groupName);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}

	// 刷新群信息
	public static SdkHttpResult refreshGroupInfo(GroupInfo group)throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.GROUP_REFRESH_INFO);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("groupId", group.getId());
		paramsMap.put("groupName", group.getName() == null ? "" : group.getName());
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}
	
	// 获取群内成员
	public static SdkHttpResult queryGroupUserList(String groupId)throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.GROUP_QUERY_USER_LIST);
		Map<String, String> paramsMap=new HashMap<String, String>();
		paramsMap.put("groupId", groupId);
		HttpUtil.setBodyParameter(paramsMap, conn);
		return HttpUtil.returnResult(conn);
	}
}
