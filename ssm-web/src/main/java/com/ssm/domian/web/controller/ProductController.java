package com.ssm.domian.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ssm.domian.busi.service.interfaces.IProductService;
import com.ssm.domian.datacenter.bean.Product;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired
	private IProductService productService;

	@RequestMapping("/findAll")
	public ModelAndView prodFindAll(@RequestParam(name="page",defaultValue="1") Integer page,
			@RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception {
		List<Product> list = productService.findAll(page,size);
		PageInfo<Product> pageInfo = new PageInfo<Product>(list);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("pageInfo", pageInfo);
		modelAndView.setViewName("product-list1");
		return modelAndView;
	}
	
	@RequestMapping("/save")
	public String saveProd(Product product){
		productService.save(product);
		return "redirect:findAll";
	}
}
