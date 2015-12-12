package com.rrh.mobile.service.business;

import com.rrh.base.IBaseService;
import com.rrh.mobile.base.BaseResponse;
import com.rrh.mobile.bean.req.BusinessCreateTeamRequest;

public interface IBusinessService<T> extends IBaseService<T> {
	
	/** 创建团队*/
	public BaseResponse createTeam(BusinessCreateTeamRequest groupTeam);
	
	/** 获取团队信息*/
	public BaseResponse getTeamInfo(int userId);
	
}
