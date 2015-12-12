package com.rrh.mobile.im;

import java.net.HttpURLConnection;
import java.net.URLEncoder;
import java.util.List;

import com.rrh.mobile.im.models.ChatroomInfo;
import com.rrh.mobile.im.models.SdkHttpResult;
import com.rrh.mobile.im.util.HttpUtil;

/**
 * 聊天室
 * @author jason
 * @data 2015-12-3
 */
public class ChatroomIM {
	// 创建聊天室
	public static SdkHttpResult createChatroom(List<ChatroomInfo> chatrooms)throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.CHATROOM_CREATE);
		StringBuilder sb = new StringBuilder();
		sb.append("1=1");
		if (chatrooms != null) {
			for (ChatroomInfo info : chatrooms) {
				if (info != null) {
					sb.append(String.format("&chatroom[%s]=", URLEncoder.encode(info.getId(), IM.UTF8))).append(URLEncoder.encode(info.getName(), IM.UTF8));
				}
			}
		}
		HttpUtil.setBodyParameter(sb, conn);
		return HttpUtil.returnResult(conn);
	}

	// 销毁聊天室
	public static SdkHttpResult destroyChatroom(List<String> chatroomIds)throws Exception {
		HttpURLConnection conn = HttpUtil.CreatePostHttpConnection(IM.CHATROOM_DESTROY);
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
}
