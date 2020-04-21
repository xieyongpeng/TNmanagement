package com.ssm.domian.busi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.ssm.domian.busi.service.interfaces.IRoleService;
import com.ssm.domian.datacenter.bean.Role;
import com.ssm.domian.datacenter.dao.IRoleDao;

@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
@Service
public class RoleServiceImpl implements IRoleService{

	@Autowired
	private IRoleDao iRoleDao;
	
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Role> findAll(int page, int size) throws Exception {
		PageHelper.startPage(page, size);
		return iRoleDao.findAll();
	}

	@Override
	public void save(Role role) throws Exception {
		iRoleDao.save(role);
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Role findById(String roleId) throws Exception {
		return iRoleDao.findById(roleId);
	}

}
