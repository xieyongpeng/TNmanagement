package com.ssm.domian.datacenter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.ssm.domian.datacenter.bean.Product;

public interface IProductDao {
	
	//根据id查询产品
    @Select("select * from product where id=#{id}")
    public Product findById(String id) throws Exception;
    
	@Select("select * from product")
	public List<Product> findAll() throws Exception;
	
	@Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
	public void save(Product product);
	
	@Delete("delete from product where id=#{id} ")
	public void delete(String id);
	
	@Update("update product set productNum=#{productNum},productName=#{productName},cityName=#{cityName},departureTime=#{departureTime},productPrice=#{productPrice},productDesc=#{productDesc},productStatus=#{productStatus}")
	public void update(Product product);
}