package com.ssm.domian.datacenter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ssm.domian.datacenter.bean.Role;

public interface IRoleDao {

	//根据用户id查询出所有对应的角色
	@Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
	@Results(id="findRoleByUserId",
		value={
			@Result(id=true, property = "id", column = "id"),
			@Result(property = "roleName", column = "roleName"),
            @Result(property = "roleDesc", column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,
            	many = @Many(select = "com.ssm.domian.datacenter.dao.IPermissionDao.findPermissionByRoleId"))
	})
	public List<Role> findRoleByUserId(String userId) throws Exception;
	
	@Select("select * from role")
    List<Role> findAll() throws Exception;

    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role);
    
    @Select("select * from role where id=#{roleId}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.ssm.domian.datacenter.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findById(String roleId);
}
