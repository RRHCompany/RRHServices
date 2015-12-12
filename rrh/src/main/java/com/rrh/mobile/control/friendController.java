package com.rrh.mobile.control;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rrh.base.BaseController;
import com.rrh.mobile.ConstantsMobile;
import com.rrh.mobile.base.BaseResponse;
import com.rrh.mobile.service.group.IFriendService;
import com.rrh.model.group.TbFriend;

@Controller
@RequestMapping(ConstantsMobile.MOBOLE_V_1_0_PRE+"friend")
public class friendController extends BaseController{
	
	@Autowired
	private IFriendService<TbFriend> friendService;
	
	//获取新的好友列表
	@RequestMapping("findNewFriendList")
	@ResponseBody
	public BaseResponse findNewFriendList(@RequestParam int userId, HttpSession session){
		return friendService.findNewFriendList(userId);
	}
	//获取我的好友列表
	@RequestMapping("findFriendList")
	@ResponseBody
	public BaseResponse findFriendList(@RequestParam int userId, HttpSession session){
		return friendService.findFriendList(userId);
	}
	//搜索新的好友
	@RequestMapping("serachFriend")
	@ResponseBody
	public BaseResponse serachFriend(@RequestParam int userId,@RequestParam String keywork, HttpSession session){
		return friendService.serachFriend(userId,keywork);
	}
	//请求添加好友 notes:备注  extra:发送文本
	@RequestMapping("requestAddFriend")
	@ResponseBody
	public BaseResponse requestAddFriend(@RequestParam int userId,@RequestParam int friendId,@RequestParam String notes,@RequestParam String extra, HttpSession session){
		return friendService.requestAddFriend(userId,friendId,notes,extra);
	}
	//添加好友
	@RequestMapping("addFriend")
	@ResponseBody
	public BaseResponse addFriend(@RequestParam int userId,@RequestParam int friendId,HttpSession session){
		return friendService.addFriend(userId,friendId);
	}
	//获取好友信息
	@RequestMapping("getFriendDetail")
	@ResponseBody
	public BaseResponse getFriendDetail(@RequestParam int userId,@RequestParam int friendId, HttpSession session){
		return friendService.getFriendDetail(userId,friendId);
	}
	//获取好友item
	@RequestMapping("getFriendItem")
	@ResponseBody
	public BaseResponse getFriendItem(@RequestParam int userId,@RequestParam int friendId, HttpSession session){
		return friendService.getFriendItem(userId,friendId);
	}
}