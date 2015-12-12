package com.rrh.mobile.service.group.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.rrh.base.BaseService;
import com.rrh.common.Constants;
import com.rrh.common.mybatis.bean.FriendDetailBean;
import com.rrh.common.mybatis.bean.FriendItemBean;
import com.rrh.common.mybatis.bean.FriendListBean;
import com.rrh.common.mybatis.bean.FriendSerachBean;
import com.rrh.mapper.group.TbFriendMapper;
import com.rrh.mobile.ResultMobile;
import com.rrh.mobile.base.BaseResponse;
import com.rrh.mobile.im.FriendIM;
import com.rrh.mobile.im.models.ContactNtfMessage;
import com.rrh.mobile.service.group.IFriendService;
import com.rrh.model.group.TbFriend;

@Service
public class FriendService extends BaseService<TbFriend> implements IFriendService<TbFriend> {

	@Autowired
	private TbFriendMapper tbFriendMapper;
	
	@Override
	public void initMapper() {
		this.baseMapper = tbFriendMapper;
	}
	/** 获取新的好友列表*/
	@Override
	public BaseResponse findNewFriendList(int userId){
		try {
			List<FriendListBean> friendList=tbFriendMapper.findNewFriendList(userId);
			return ResultMobile.resultSuccess(friendList);
		} catch (Exception e) {
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
	/** 获取好友列表*/
	@Override
	public BaseResponse findFriendList(int userId){
		try {
			List<FriendListBean> friendList=tbFriendMapper.findFriendList(userId);
			return ResultMobile.resultSuccess(friendList);
		} catch (Exception e) {
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
	/**搜索新的好友*/
	@Override
	public BaseResponse serachFriend(int userId, String keywork) {
		if(StringUtils.isEmpty(keywork)){
			return ResultMobile.resultErroParam();
		}
		try {
			List<FriendSerachBean> friendList=tbFriendMapper.serachFriend(userId,keywork);
			return ResultMobile.resultSuccess(friendList);
		} catch (Exception e) {
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
	/**请求添加好友*/
	@Override
	public BaseResponse requestAddFriend(int userId, int friendId,String notes,String extra){
		try {
			Date addTime=new Date();
			//判断对方是否是我的好友
			TbFriend userFriend=tbFriendMapper.getByUserIDAndFriendID(userId,friendId);
			if(userFriend==null){
				//添加请求
				TbFriend friend=new TbFriend();
				friend.setUserId(userId);
				friend.setFriendId(friendId);
				friend.setAddTime(addTime);
				friend.setNotes(notes);
				friend.setExtra(extra);
				friend.setStatus(Constants.FRIEND_STATUS_2);
				tbFriendMapper.insert(friend);
			}else if(userFriend.getStatus()!=Constants.FRIEND_STATUS_1){
				//不是好友，修改请求
				userFriend.setAddTime(addTime);
				userFriend.setNotes(notes);
				userFriend.setExtra(extra);
				userFriend.setStatus(Constants.FRIEND_STATUS_2);
				tbFriendMapper.updateByPrimaryKey(userFriend);
			}
			//判断我是否是对方好友
			TbFriend friendUser=tbFriendMapper.getByUserIDAndFriendID(friendId,userId);
			if(friendUser==null){
				//添加请求
				TbFriend friend=new TbFriend();
				friend.setUserId(friendId);
				friend.setFriendId(userId);
				friend.setAddTime(addTime);
				friend.setExtra(extra);
				friend.setStatus(Constants.FRIEND_STATUS_3);
				tbFriendMapper.insert(friend);
			}else if(friendUser.getStatus()!=Constants.FRIEND_STATUS_1){
				//不是好友，修改请求
				friendUser.setAddTime(addTime);
				friendUser.setExtra(extra);
				friendUser.setStatus(Constants.FRIEND_STATUS_3);
				tbFriendMapper.updateByPrimaryKey(friendUser);
			}
			FriendIM.requestFriendMessage(userId+"", friendId+"", new ContactNtfMessage("哈1", userId+"",friendId+"", extra), "哈2", "哈3");
			return ResultMobile.resultSuccess(null);
		} catch (Exception e) {
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
	/**添加好友*/
	@Override
	public BaseResponse addFriend(int userId, int friendId) {
		try {
			tbFriendMapper.updateStatusByUserIDAndFriendID(userId, friendId, Constants.FRIEND_STATUS_1);
			tbFriendMapper.updateStatusByUserIDAndFriendID(friendId, userId, Constants.FRIEND_STATUS_1);
			FriendIM.addFriendMessage(userId+"", friendId+"", new ContactNtfMessage("哈1", userId+"",friendId+"", "哈4"), "哈2", "哈3");
			return ResultMobile.resultSuccess(null);
		} catch (Exception e) {
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
	/**查询好友资料*/
	@Override
	public BaseResponse getFriendDetail(int userId,int friendId){
		try {
			FriendDetailBean bean=tbFriendMapper.getFriendDetail(friendId);
			return ResultMobile.resultSuccess(bean);
		} catch (Exception e) {
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
	@Override
	public BaseResponse getFriendItem(int userId, int friendId) {
		try {
			FriendItemBean friendItemBean=tbFriendMapper.getFriendItemBean(userId, friendId);
			return ResultMobile.resultSuccess(friendItemBean);
		} catch (Exception e) {
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
}
