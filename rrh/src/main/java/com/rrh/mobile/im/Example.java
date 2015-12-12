package com.rrh.mobile.im;

import java.util.ArrayList;
import java.util.List;

import com.rrh.mobile.im.models.ChatroomInfo;
import com.rrh.mobile.im.models.GroupInfo;
import com.rrh.mobile.im.models.ImageMessage;
import com.rrh.mobile.im.models.SdkHttpResult;
import com.rrh.mobile.im.models.TextMessage;
import com.rrh.mobile.im.models.VoiceMessage;

public class Example {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub

		SdkHttpResult result = null;

//		result = TokenIM.getToken("1", "jason","http://guangdong.sinaimg.cn/2014/1202/U10867P693DT20141202080012.jpg");
		System.out.println("gettoken=" + result);
		
//		List<String> toIds = new ArrayList<String>();
//		toIds.add("id1");
//		toIds.add("id2");
//		toIds.add("id3");
//		result = MessageIM.publishMessage("fromUserId", toIds,new TxtMessage("txtMessagehaha"));
//		System.out.println("publishMessage=" + result);
//		result = MessageIM.publishMessage("fromUserId", toIds,new VoiceMessage("txtMessagehaha", 100L));
//		System.out.println("publishMessage=" + result);
//		result = MessageIM.publishMessage("fromUserId", toIds,new ImgMessage("txtMessagehaha", "http://aa.com/a.png"));
//		System.out.println("publishMessage=" + result);
//
//		result = MessageIM.publishMessage("fromUserId", toIds,new TxtMessage("txtMessagehaha"), "pushContent", "pushData");
//		System.out.println("publishMessageAddpush=" + result);
//
//		result = MessageIM.publishSystemMessage("fromUserId",toIds, new TxtMessage("txtMessagehaha"), "pushContent","pushData");
//		System.out.println("publishSystemMessage=" + result);
//
//		result = MessageIM.publishSystemMessage("fromUserId",toIds, new TxtMessage("txtMessagehaha"), "pushContent","pushData");
//		System.out.println("publishSystemMessage=" + result);
//
//		List<ChatroomInfo> chats = new ArrayList<ChatroomInfo>();
//		chats.add(new ChatroomInfo("idtest", "name"));
//		chats.add(new ChatroomInfo("id%s+-{}{#[]", "name12312"));
//		result = ChatroomIM.createChatroom(chats);
//		System.out.println("createchatroom=" + result);
//		List<String> chatIds = new ArrayList<String>();
//		chatIds.add("id");
//		chatIds.add("id%+-:{}{#[]");
//		result = MessageIM.queryChatroom(chatIds);
//		System.out.println("queryChatroom=" + result);
//
//		result = MessageIM.publishChatroomMessage("fromUserId", chatIds, new TxtMessage("txtMessagehaha"));
//		System.out.println("publishChatroomMessage=" + result);
//
//		result = ChatroomIM.destroyChatroom(chatIds);
//		System.out.println("destroyChatroom=" + result);
//		List<GroupInfo> groups = new ArrayList<GroupInfo>();
//		groups.add(new GroupInfo("id1", "name1"));
//		groups.add(new GroupInfo("id2", "name2"));
//		groups.add(new GroupInfo("id3", "name3"));
//		result = GroupIM.syncGroup("userId1", groups);
//		System.out.println("syncGroup=" + result);
//		result = GroupIM.joinGroup("userId2", "id1","name1");
//		System.out.println("joinGroup=" + result);
//		List<String> list = new ArrayList<String>();
//		list.add("userId3");
//		list.add("userId1");
//		list.add("userId3");
//		list.add("userId2");
//		list.add("userId3");
//		list.add("userId3");
//		result = GroupIM.joinGroupBatch(list, "id1","name1");
//		System.out.println("joinGroupBatch=" + result);
//
//		result = MessageIM.publishGroupMessage("userId1",chatIds, new TxtMessage("txtMessagehaha"), "pushContent","pushData");
//		System.out.println("publishGroupMessage=" + result);
//
//		result = GroupIM.quitGroup("userId1", "id1");
//		System.out.println("quitGroup=" + result);
//		result = GroupIM.quitGroupBatch(list, "id1");
//		System.out.println("quitGroupBatch=" + result);
//		result = GroupIM.dismissGroup("userIddismiss","id1");
//		result = MessageIM.getMessageHistoryUrl("2014112811");
//		System.out.println("getMessageHistoryUrl=" + result);
//
//		result = UserIM.blockUser("2", 10);
//		System.out.println("blockUser=" + result);
//
//		result = UserIM.blockUser("id2", 10);
//		System.out.println("blockUser=" + result);
//
//		result = UserIM.blockUser("id3", 10);
//		System.out.println("blockUser=" + result);
//
//		result = UserIM.queryBlockUsers();
//		System.out.println("queryBlockUsers=" + result);
//
//		result = UserIM.unblockUser("id1");
//		System.out.println("unblockUser=" + result);
//
//		result = UserIM.queryBlockUsers();
//		System.out.println("queryBlockUsers=" + result);
//
//		result = UserIM.unblockUser("id2");
//		System.out.println("unblockUser=" + result);
//
//		result = UserIM.unblockUser("id3");
//		System.out.println("unblockUser=" + result);
//
//		result = UserIM.queryBlockUsers();
//		System.out.println("queryBlockUsers=" + result);
//
//		result = UserIM.checkOnline("143");
//		System.out.println("checkOnline=" + result);
//		
//		List<String> toBlackIds = new ArrayList<String>();
//		toBlackIds.add("22");
//		toBlackIds.add("12");
//
//		result = UserIM.blackUser("3706", toBlackIds);
//		System.out.println("blackUser=" + result);
//		
//		result = UserIM.QueryblackUser("3706");
//		System.out.println("QueryblackUser=" + result);
//		
//		result = UserIM.unblackUser("3706", toBlackIds);
//		System.out.println("unblackUser=" + result);
//		
//		result = UserIM.QueryblackUser("3706");
//		System.out.println("QueryblackUser=" + result);	
//
//		result = MessageIM.deleteMessageHistory("2014122811");
//		System.out.println("deleteMessageHistory=" + result);
//		
//		result = GroupIM.refreshGroupInfo("id1", "name4");
//		System.out.println("refreshGroupInfo=" + result);

	}
}
