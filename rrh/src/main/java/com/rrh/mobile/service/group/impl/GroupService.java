package com.rrh.mobile.service.group.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrh.base.BaseService;
import com.rrh.common.mybatis.bean.GroupListBean;
import com.rrh.mapper.group.TbGroupMapper;
import com.rrh.mobile.ResultMobile;
import com.rrh.mobile.base.BaseResponse;
import com.rrh.mobile.service.group.IGroupService;
import com.rrh.model.group.TbGroup;

@Service
public class GroupService extends BaseService<TbGroup> implements IGroupService<TbGroup> {

	@Autowired
	private TbGroupMapper tbGroupMapper;
	
	@Override
	public void initMapper() {
		this.baseMapper = tbGroupMapper;
	}
	
	//创建普通群
	@Override
	public BaseResponse createGroup(int userId,String groupMenbers) {
		try {
			List<GroupListBean> groupList=tbGroupMapper.findGroupList(userId);
			return ResultMobile.resultSuccess(groupList);
		} catch (Exception e) {
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
	//查询我的群列表
	@Override
	public BaseResponse findGroupList(int userId) {
		try {
			List<GroupListBean> groupList=tbGroupMapper.findGroupList(userId);
			return ResultMobile.resultSuccess(groupList);
		} catch (Exception e) {
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
	//查询认证群和副群列表
	@Override
	public BaseResponse findGroupAuthList(int userId){
		try {
			List<GroupListBean> groupList=tbGroupMapper.findGroupAuthList(userId);
			return ResultMobile.resultSuccess(groupList);
		} catch (Exception e) {
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
}
