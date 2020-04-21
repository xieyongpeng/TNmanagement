package com.ssm.domian.busi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.ssm.domian.busi.service.interfaces.IPermissionService;
import com.ssm.domian.datacenter.bean.Permission;
import com.ssm.domian.datacenter.dao.IPermissionDao;

@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
@Service
public class PermissionServiceImpl implements IPermissionService{

	@Autowired
	IPermissionDao iPermissionDao;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Override
	public List<Permission> findAll(int page, int size) throws Exception {
		PageHelper.startPage(page,size);
		return iPermissionDao.findAll();
	}

	@Override
	public void save(Permission permission) throws Exception {
		iPermissionDao.save(permission);
	}

	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Override
	public Permission findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return iPermissionDao.findById(id);
	}

	@Override
	public void deleteById(String id) throws Exception {
		iPermissionDao.deleteById(id);
	}

}
