package com.rrh.mobile.im;

import com.rrh.mobile.im.models.FormatType;

public class IM {

	public static final String IM_BASE_URL = "http://api.cn.ronghub.com";
	
	public static final String UTF8 = "UTF-8";
	
	public static final String APP_KEY="sfci50a7cb7ti";
	
	public static final String APP_SECRE="0r548LdYUTJol";
	
	public static final String PUBLIC_MSG_NEW_FRIEND="-100";//新的好友消息
	
	
	/**========================请求URL==============================*/
	//获取token
	public static final String GET_TOKEN=IM_BASE_URL+ "/user/getToken." + FormatType.json.toString();
	//检查用户在线状态
	public static final String USER_CHECK_ONLINE=IM_BASE_URL+ "/user/checkOnline." + FormatType.json.toString();
	//刷新用户信息
	public static final String USER_REFRESH=IM_BASE_URL+ "/user/refresh." + FormatType.json.toString();
	//封禁用户
	public static final String USER_BLOCK=IM_BASE_URL+ "/user/block." + FormatType.json.toString();
	//解禁用户
	public static final String USER_UN_BLOCK=IM_BASE_URL+ "/user/unblock." + FormatType.json.toString();
	//获取被封禁用户
	public static final String USER_QUERY_BLOCK_USERS=IM_BASE_URL+ "/user/block/query." + FormatType.json.toString();
	//添加用户到黑名单
	public static final String USER_ADD_BLACK_LIST=IM_BASE_URL+ "/user/blacklist/add." + FormatType.json.toString();
	//从黑名单移除用户
	public static final String USER_REMOVE_BLACK_LIST=IM_BASE_URL+ "/user/blacklist/remove." + FormatType.json.toString();
	//获取黑名单用户
	public static final String USER_QUERY_BLACK_LIST=IM_BASE_URL+ "/user/blacklist/query." + FormatType.json.toString();
	
	
	/**========================群组请求URL==============================*/
	//创建群
	public static final String GROUP_CREATE=IM_BASE_URL+ "/group/create." + FormatType.json.toString();
	//加入群
	public static final String GROUP_JOIN=IM_BASE_URL+ "/group/join." + FormatType.json.toString();
	//批量加入群
	public static final String GROUP_BATCH_JOIN=IM_BASE_URL+ "/group/join." + FormatType.json.toString();
	//退出群
	public static final String GROUP_QUIT=IM_BASE_URL+ "/group/quit." + FormatType.json.toString();
	//批量退出群
	public static final String GROUP_BATCH_QUIT=IM_BASE_URL+ "/group/quit." + FormatType.json.toString();
	//解散群
	public static final String GROUP_DISMISS=IM_BASE_URL+ "/group/dismiss." + FormatType.json.toString();
	//同步用户群信息
	public static final String GROUP_SYNC=IM_BASE_URL+ "/group/sync." + FormatType.json.toString();
	//刷新群信息
	public static final String GROUP_REFRESH_INFO=IM_BASE_URL+ "/group/refresh." + FormatType.json.toString();
	//获取群内成员
	public static final String GROUP_QUERY_USER_LIST=IM_BASE_URL+ "/group/user/query." + FormatType.json.toString();
	
	/**========================聊天室请求URL==============================*/
	//创建聊天室
	public static final String CHATROOM_CREATE=IM_BASE_URL+ "/chatroom/create." + FormatType.json.toString();
	//创建聊天室
	public static final String CHATROOM_DESTROY=IM_BASE_URL+ "/chatroom/destroy." + FormatType.json.toString();
	
	/**========================消息请求URL==============================*/
	//发送消息
	public static final String MSG_SEND_PRIVATE_PUBLISH=IM_BASE_URL+ "/message/private/publish." + FormatType.json.toString();
	//发送消息
	public static final String MSG_SEND_PUBLISH=IM_BASE_URL+ "/message/publish." + FormatType.json.toString();
	//发送系统消息
	public static final String MSG_SEND_SYSTEM_PUBLISH=IM_BASE_URL+ "/message/system/publish." + FormatType.json.toString();
	//发送群消息
	public static final String MSG_SEND_GROUP_PUBLISH=IM_BASE_URL+ "/message/group/publish." + FormatType.json.toString();
	//发送聊天室消息
	public static final String MSG_SEND_CHATROOM_PUBLISH=IM_BASE_URL+ "/message/chatroom/publish." + FormatType.json.toString();
	//发送广播室消息
	public static final String MSG_SEND_BROADCAST_PUBLISH=IM_BASE_URL+ "/message/broadcast." + FormatType.json.toString();
	//查询聊天室信息
	public static final String MSG_QUERY_CHATROOM_MSG=IM_BASE_URL+ "/chatroom/query." + FormatType.json.toString();
	//获取消息历史记录下载地址
	public static final String MSG_GET_HISTORY_URL=IM_BASE_URL+ "/message/history." + FormatType.json.toString();
	//获取消息历史记录
	public static final String MSG_QUERY_HISTORY_LIST=IM_BASE_URL+ "/message/history/delete." + FormatType.json.toString();
	
	
	/**========================其他未知请求URL==============================*/
	
	public static final String OTHER_GROUP_USER_GAG_ADD=IM_BASE_URL+ "/group/user/gag/add." + FormatType.json.toString();
	public static final String OTHER_GROUP_USER_GAG_ROLLBACK=IM_BASE_URL+ "/group/user/gag/rollback." + FormatType.json.toString();
	public static final String OTHER_GROUP_USER_GAG_LIST=IM_BASE_URL+ "/group/user/gag/list." + FormatType.json.toString();
	public static final String OTHER_WORDFILTER_ADD=IM_BASE_URL+ "/wordfilter/add." + FormatType.json.toString();
	public static final String OTHER_WORDFILTER_DELETE=IM_BASE_URL+ "/wordfilter/delete." + FormatType.json.toString();
	public static final String OTHER_WORDFILTER_LIST=IM_BASE_URL+ "/wordfilter/list." + FormatType.json.toString();
}
