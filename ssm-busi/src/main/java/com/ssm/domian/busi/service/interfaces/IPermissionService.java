package com.ssm.domian.busi.service.interfaces;

import java.util.List;

import com.ssm.domian.datacenter.bean.Permission;

public interface IPermissionService {
	public List<Permission> findAll(int page, int size) throws Exception;

    void save(Permission permission) throws Exception;

    Permission findById(String id) throws Exception;

    void deleteById(String id) throws Exception;
}
