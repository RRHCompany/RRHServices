package com.rrh.mobile.service.group;

import com.rrh.base.IBaseService;
import com.rrh.mobile.base.BaseResponse;

public interface IFriendService<T> extends IBaseService<T> {

	//获取新的好友列表
	public BaseResponse findNewFriendList(int userId);
	//获取好友列表
	public BaseResponse findFriendList(int userId);
	//搜索新的好友
	public BaseResponse serachFriend(int userId,String keywork);
	//请求添加好友
	public BaseResponse requestAddFriend(int userId, int friendId,String notes,String extra);
	//添加好友
	public BaseResponse addFriend(int userId, int friendId);
	//查询好友详细资料
	public BaseResponse getFriendDetail(int userId,int friendId);
	//查询好友item
	public BaseResponse getFriendItem(int userId,int friendId);
	
}
