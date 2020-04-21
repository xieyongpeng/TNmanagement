package com.ssm.domian.busi.service.interfaces;

import java.util.List;

import com.ssm.domian.datacenter.bean.SysLog;

public interface ISysLogService {
	
	public void save(SysLog sysLog) throws Exception;

    List<SysLog> findAll(int page, int size) throws Exception;
}
