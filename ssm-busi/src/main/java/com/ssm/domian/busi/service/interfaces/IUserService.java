package com.ssm.domian.busi.service.interfaces;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.ssm.domian.datacenter.bean.Role;
import com.ssm.domian.datacenter.bean.UserInfo;

public interface IUserService extends UserDetailsService{
	
	List<UserInfo> findAll(int page, int size) throws Exception;

    void save(UserInfo userInfo) throws Exception;
    
    UserInfo findById(String id) throws Exception;
    
    List<Role> findOtherRoles(String userId) throws Exception;

    void addRoleToUser(String userId, String[] roleIds);
}
