package com.ssm.domian.busi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.ssm.domian.busi.service.interfaces.IProductService;
import com.ssm.domian.datacenter.bean.Product;
import com.ssm.domian.datacenter.dao.IProductDao;

@Transactional(readOnly=false,propagation=Propagation.REQUIRED)
@Service
public class ProductServiceImpl implements IProductService{

	@Autowired
    private IProductDao productDao;
	
	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public List<Product> findAll(int page, int size) throws Exception {
		PageHelper.startPage(page, size);
		return productDao.findAll();
	}

	@Override
	@Transactional(readOnly=true,propagation=Propagation.SUPPORTS)
	public Product findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return productDao.findById(id);
	}

	@Override
	public void save(Product product) {
		productDao.save(product);
	}

	@Override
	public void delete(String id) {
		productDao.delete(id);
	}

	@Override
	public void update(Product product) {
		productDao.update(product);
	}

}
