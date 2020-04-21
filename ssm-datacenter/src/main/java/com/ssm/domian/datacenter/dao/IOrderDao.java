package com.ssm.domian.datacenter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import com.ssm.domian.datacenter.bean.Members;
import com.ssm.domian.datacenter.bean.Orders;
import com.ssm.domian.datacenter.bean.Product;

public interface IOrderDao {
	
	@Select("select * from orders")
	@Results(id="ordersList",
			value={
			@Result(id=true,property="id",column="id"),
			@Result(property="orderNum",column="orderNum"),
			@Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property="product",column="productId",javaType=Product.class
            	,one=@One(select="com.ssm.domian.datacenter.dao.IProductDao.findById"))
	})
	public List<Orders> findAll() throws Exception;
	
	
	@Select("select * from orders where id=#{ordersId}")
	@Results(id="ordersInfo",
			value={
			@Result(id=true,property="id",column="id"),
			@Result(property="orderNum",column="orderNum"),
			@Result(property = "orderTime",column = "orderTime"),
            @Result(property = "orderStatus",column = "orderStatus"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "peopleCount",column = "peopleCount"),
            @Result(property = "payType",column = "payType"),
            @Result(property = "orderDesc",column = "orderDesc"),
            @Result(property="product",column="productId",javaType=Product.class
            	,one=@One(select="com.ssm.domian.datacenter.dao.IProductDao.findById")),
            @Result(property="member",column="memberId",javaType=Members.class
            	,one=@One(select="com.ssm.domian.datacenter.dao.IMembersDao.findById")),
            @Result(property="travellers",column="id",javaType=java.util.List.class
            	,many=@Many(select="com.ssm.domian.datacenter.dao.ITravellerDao.findByOrdersId"))
	})
	public Orders findById(String ordersId) throws Exception;
}
