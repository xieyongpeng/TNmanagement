package com.ssm.domian.busi.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.ssm.domian.busi.service.interfaces.IUserService;
import com.ssm.domian.datacenter.bean.Role;
import com.ssm.domian.datacenter.bean.UserInfo;
import com.ssm.domian.datacenter.dao.IUserDao;

@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
@Service("userService")
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao iUserDao;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		//User对象实现了UserDetails类
		User user = null;
		try {
			UserInfo userInfo = iUserDao.findByUsername(username);
			//enabled设置用户时候可用
			//accountNonExpired设置是否过期
			//credentialsNonExpired凭证是否过期
			//accountNonLocked账户是否被锁定
			user = new User(userInfo.getUsername(), userInfo.getPassword()
					, userInfo.getStatus() == 0 ? false : true, true, true, true, getAuthority(userInfo.getRoles()));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	//作用就是返回一个List集合，集合中装入的是角色描述
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for (Role role : roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	@Override
	public List<UserInfo> findAll(int page, int size) throws Exception {
    	PageHelper.startPage(page, size);
		return iUserDao.findAll();
	}

	@Override
	public void save(UserInfo userInfo) throws Exception {
		//对密码进行加密处理
		userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
		iUserDao.save(userInfo);
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public UserInfo findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return iUserDao.findById(id);
	}

	@Override
	@Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
	public List<Role> findOtherRoles(String userId) throws Exception {
		return iUserDao.findOtherRoles(userId);
	}

	@Override
	public void addRoleToUser(String userId, String[] roleIds) {
		for(String roleId : roleIds){
			iUserDao.addRoleToUser(userId, roleId);
		}
	}

}
