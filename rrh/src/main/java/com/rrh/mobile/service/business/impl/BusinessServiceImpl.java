package com.rrh.mobile.service.business.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.rrh.base.BaseService;
import com.rrh.mapper.business.TbBusinessMapper;
import com.rrh.mobile.ResultMobile;
import com.rrh.mobile.base.BaseResponse;
import com.rrh.mobile.bean.req.BusinessCreateTeamRequest;
import com.rrh.mobile.service.business.IBusinessService;
import com.rrh.model.business.TbBusiness;

@Service
public class BusinessServiceImpl extends BaseService<TbBusiness> implements IBusinessService<TbBusiness> {

	@Autowired
	private TbBusinessMapper tbBusinessMapper;
	
	@Override
	public void initMapper() {
		this.baseMapper = tbBusinessMapper;
	}

	/** 创建团队*/
	@Override
	public BaseResponse createTeam(BusinessCreateTeamRequest groupTeam) {
		if(StringUtils.isEmpty(groupTeam.getName())){
			return ResultMobile.resultErroParam();
		}
		if(StringUtils.isEmpty(groupTeam.getTeamName())){
			return ResultMobile.resultErroParam();
		}
		if(StringUtils.isEmpty(groupTeam.getTaxesCode())){
			return ResultMobile.resultErroParam();
		}
		if(StringUtils.isEmpty(groupTeam.getTel())){
			return ResultMobile.resultErroParam();
		}
		if(StringUtils.isEmpty(groupTeam.getDomain())){
			return ResultMobile.resultErroParam();
		}
		if(StringUtils.isEmpty(groupTeam.getCorporateMobile())){
			return ResultMobile.resultErroParam();
		}
		if(StringUtils.isEmpty(groupTeam.getAddress())){
			return ResultMobile.resultErroParam();
		}
		try {
			groupTeam.setLastTime(new Date());
			int result=tbBusinessMapper.insertCreateTeam(groupTeam);
			if(result<=0){
				return ResultMobile.resultFall("comment.option.fall");
			}
			return ResultMobile.resultSuccess(null);
		} catch (Exception e) {
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
	/** 获取团队信息*/
	@Override
	public BaseResponse getTeamInfo(int userId) {
		try {
			TbBusiness business=tbBusinessMapper.getByUserID(userId);
			return ResultMobile.resultSuccess(business);
		} catch (Exception e) {
			log.error("", e);
			return ResultMobile.resultErroSystem();
		}
	}
}
