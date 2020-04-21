package com.ssm.domian.busi.service.interfaces;

import java.util.List;

import com.ssm.domian.datacenter.bean.Orders;

public interface IOrdersService {
	
	List<Orders> findAll(int page,int size) throws Exception;
	
	Orders findById(String ordersId) throws Exception;
}
