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
import com.rrh.mobile.bean.req.BusinessCreateTeamRequest;
import com.rrh.mobile.service.business.IBusinessService;
import com.rrh.mobile.service.group.IGroupService;
import com.rrh.model.business.TbBusiness;
import com.rrh.model.group.TbGroup;

@Controller
@RequestMapping(ConstantsMobile.MOBOLE_V_1_0_PRE+"group")
public class groupController extends BaseController{
	
	@Autowired
	private IBusinessService<TbBusiness> businessService;
	
	@Autowired
	private IGroupService<TbGroup> groupService;
	
	//创建团队
	@RequestMapping("createTeam")
	@ResponseBody
	public BaseResponse createTeam(BusinessCreateTeamRequest groupTeam, HttpSession session){
		return businessService.createTeam(groupTeam);
	}
	
	//查询团队详情
	@RequestMapping("getTeamInfo")
	@ResponseBody
	public BaseResponse getTeamInfo(@RequestParam int userId, HttpSession session){
		return businessService.getTeamInfo(userId);
	}
	
	//创建普通群
	@RequestMapping("createGroup")
	@ResponseBody
	public BaseResponse createGroup(@RequestParam int userId,@RequestParam String groupMenbers){
		return groupService.createGroup(userId, groupMenbers);
	}
	//查询普通群列表
	@RequestMapping("findGroupList")
	@ResponseBody
	public BaseResponse findGroupList(@RequestParam int userId, HttpSession session){
		return groupService.findGroupList(userId);
	}
	
	//查询认证群和副群列表
	@RequestMapping("findGroupAuthList")
	@ResponseBody
	public BaseResponse findGroupAuthList(@RequestParam int userId, HttpSession session){
		return groupService.findGroupAuthList(userId);
	}
	
	//查询群详情
	@RequestMapping("getGroupDetail")
	@ResponseBody
	public BaseResponse getGroupDetail(@RequestParam int groupId, HttpSession session){
		return groupService.getGroupDetail(groupId);
	}
}