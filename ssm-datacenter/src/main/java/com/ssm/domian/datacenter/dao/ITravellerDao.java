package com.ssm.domian.datacenter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.ssm.domian.datacenter.bean.Traveller;

public interface ITravellerDao {

	@Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
