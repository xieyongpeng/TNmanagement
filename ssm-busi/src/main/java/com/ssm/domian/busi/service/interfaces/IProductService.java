package com.ssm.domian.busi.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ssm.domian.datacenter.bean.Product;

@Service
public interface IProductService {
	
	public List<Product> findAll(int page, int size) throws Exception;
	
	public Product findById(String id) throws Exception;
	
	public void save(Product product);
	
	public void delete(String id);
	
	public void update(Product product);
}
