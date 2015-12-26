package com.rrh.mobile.service.group.impl;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrh.base.BaseService;
import com.rrh.common.Constants;
import com.rrh.common.SourceManager;
import com.rrh.common.mybatis.bean.GroupListBean;
import com.rrh.common.mybatis.bean.GroupUserBean;
import com.rrh.mapper.business.TbBusinessMapper;
import com.rrh.mapper.group.TbGroupMapper;
import com.rrh.mapper.group.TbGroupUserMapper;
import com.rrh.mapper.user.TbUsersMapper;
import com.rrh.mobile.ResultMobile;
import com.rrh.mobile.base.BaseResponse;
import com.rrh.mobile.bean.res.GroupDetailRespoint;
import com.rrh.mobile.im.GroupIM;
import com.rrh.mobile.service.group.IGroupService;
import com.rrh.model.business.TbBusiness;
import com.rrh.model.group.TbGroup;
import com.rrh.model.group.TbGroupUser;
import com.rrh.model.user.TbUsers;

@Service
public class GroupService extends BaseService<TbGroup> implements IGroupService<TbGroup> {

	@Autowired
	private TbGroupMapper tbGroupMapper;
	
	@Autowired
	private TbGroupUserMapper tbGroupUserMapper;
	
	@Autowired
	private TbUsersMapper tbUsersMapper;
	@Autowired
	private TbBusinessMapper tbBusinessMapper;
	@Override
	public void initMapper() {
		this.baseMapper = tbGroupMapper;
	}
	
	//创建普通群
	@Override
	public BaseResponse createGroup(int userId,String groupMenbers) {
		if(groupMenbers==null||groupMenbers.equals("")){
			return ResultMobile.resultFall("请选择群成员");
		}
		try {
			String[] friendIDs=groupMenbers.split(",");
			if(friendIDs==null||friendIDs.length==0){
				return ResultMobile.resultFall("请选择群成员");
			}
			TbUsers users=tbUsersMapper.selectByPrimaryKey(userId);
			if(users==null){
				return ResultMobile.resultErroUserNo();
			}
			List<String> friendIDList=new ArrayList<String>();
			for(String friendId:friendIDs ){
				friendIDList.add(friendId);
			}
			friendIDList.add(users.getUserId()+"");
			Date time=new Date();
			TbGroup group=new TbGroup();
			group.setName(users.getNickName());
			group.setBigImg(users.getBigImg());
			group.setSmallImg(users.getSmallImg());
			group.setCreateTime(time);
			group.setUserId(users.getUserId());
			group.setType(Constants.GROUP_TYPE_0);
			int groupRow=tbGroupMapper.insert(group);
			if(groupRow<=0){
				return ResultMobile.resultFall("群创建失败");
			}
			for(String friendId:friendIDList ){
				TbGroupUser groupUser=new TbGroupUser();
				groupUser.setGroupId(group.getGroupId());
				groupUser.setUserId(Integer.parseInt(friendId));
				groupUser.setStatus(Constants.GROUP_USER_STATUS_1);
				groupUser.setAddTime(time);
				tbGroupUserMapper.insert(groupUser);
			}
			//提交到融云
			GroupIM.createGroup(friendIDList, group.getGroupId()+"", group.getName());
			return ResultMobile.resultSuccess(group);
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
	@Autowired
	private SourceManager sourceManager;
	//查询群详请
	@Override
	public BaseResponse getGroupDetail(int groupId) {
		try {
			TbGroup group=tbGroupMapper.selectByPrimaryKey(groupId);
			if(group==null){
				return ResultMobile.resultFall("群不存在");
			}
			//群成员
			List<GroupUserBean> groupUserList=tbGroupUserMapper.findByGroupID(groupId);
			GroupDetailRespoint respoint=new GroupDetailRespoint();
			respoint.setGroupId(group.getGroupId());
			respoint.setGroupName(group.getName());
			respoint.setSmallImg(group.getSmallImg());
			respoint.setBigImg(group.getBigImg());
			respoint.setType(group.getType());
			respoint.setBusinessId(group.getBusinessId());
			respoint.setUserId(group.getUserId());
			respoint.setIsPublic(group.getIsPublic());
			respoint.setBgImage(group.getBgImage());
			respoint.setCreateTime(group.getCreateTime());
			respoint.setParentId(group.getParentId());
			respoint.setQrcode(group.getQrcode());
			respoint.setLastTime(group.getLastTime());
			respoint.setGroupUserList(groupUserList);
			//企业信息
			if(group.getType()!=Constants.GROUP_TYPE_0){
				//认证群
				TbBusiness business=tbBusinessMapper.selectByPrimaryKey(group.getBusinessId());
				if(business!=null){
					respoint.setBusinessName(business.getName());
					respoint.setBusinessTel(business.getTel());
					respoint.setBusinessAddress(business.getAddress());
				}
			}
			System.out.println(new File(sourceManager.getUserPicHeadPath(false)).getAbsolutePath());
			return ResultMobile.resultSuccess(respoint);
		} catch (Exception e) {
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
}
