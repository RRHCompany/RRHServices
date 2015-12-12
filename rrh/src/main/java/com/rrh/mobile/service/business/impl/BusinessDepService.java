package com.rrh.mobile.service.business.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrh.base.BaseService;
import com.rrh.mapper.business.TbBusinessDepMapper;
import com.rrh.mobile.service.business.IBusinessDepService;
import com.rrh.model.business.TbBusinessDep;

@Service
public class BusinessDepService extends BaseService<TbBusinessDep> implements IBusinessDepService<TbBusinessDep> {

	@Autowired
	private TbBusinessDepMapper tbBusinessDepMapper;
	
	@Override
	public void initMapper() {
		this.baseMapper = tbBusinessDepMapper;
	}
	
}
