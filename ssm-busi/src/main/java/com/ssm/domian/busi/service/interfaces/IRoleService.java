package com.ssm.domian.busi.service.interfaces;

import java.util.List;

import com.ssm.domian.datacenter.bean.Role;

public interface IRoleService {
	public List<Role> findAll(int page, int size) throws Exception;

    void save(Role role) throws Exception;

    Role findById(String roleId) throws  Exception;
}
