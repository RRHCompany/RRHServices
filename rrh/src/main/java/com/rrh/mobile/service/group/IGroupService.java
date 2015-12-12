package com.rrh.mobile.service.group;

import com.rrh.base.IBaseService;
import com.rrh.mobile.base.BaseResponse;

public interface IGroupService<T> extends IBaseService<T> {

	//创建普通群
	public BaseResponse createGroup(int userId,String groupMenbers);
	//查询我的普通群列表
	public BaseResponse findGroupList(int userId);
	//查询认证群和副群列表
	public BaseResponse findGroupAuthList(int userId);
	
}
