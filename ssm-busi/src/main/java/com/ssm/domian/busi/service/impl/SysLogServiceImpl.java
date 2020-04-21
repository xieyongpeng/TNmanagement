package com.ssm.domian.busi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.ssm.domian.busi.service.interfaces.ISysLogService;
import com.ssm.domian.datacenter.bean.SysLog;
import com.ssm.domian.datacenter.dao.ISysLogDao;

@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
@Service
public class SysLogServiceImpl implements ISysLogService{

	@Autowired
	private ISysLogDao iSysLogDao;
	
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public void save(SysLog sysLog) throws Exception {
		iSysLogDao.save(sysLog);		
	}

	@Override
	public List<SysLog> findAll(int page, int size) throws Exception {
		PageHelper.startPage(page,size);
		return iSysLogDao.findAll();
	}

}
