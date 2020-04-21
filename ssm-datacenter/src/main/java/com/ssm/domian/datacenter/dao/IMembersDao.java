package com.ssm.domian.datacenter.dao;

import org.apache.ibatis.annotations.Select;

import com.ssm.domian.datacenter.bean.Members;

public interface IMembersDao {
	
	@Select("select * from members where id=#{id}")
    public Members findById(String id) throws Exception;
}
