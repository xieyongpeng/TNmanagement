package com.ssm.domian.busi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.ssm.domian.busi.service.interfaces.IOrdersService;
import com.ssm.domian.datacenter.bean.Orders;
import com.ssm.domian.datacenter.dao.IOrderDao;

@Service
@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
public class OrdersServiceImpl implements IOrdersService{

	@Autowired
	private IOrderDao iOrderDao;
	
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	@Override
	public List<Orders> findAll(int page, int size) throws Exception {
		//参数pageNum 是页码值   参数pageSize 代表是每页显示条数
		PageHelper.startPage(page, size);
		return iOrderDao.findAll();
	}

	@Override
    public Orders findById(String ordersId) throws Exception{
        return iOrderDao.findById(ordersId);
    }

}
