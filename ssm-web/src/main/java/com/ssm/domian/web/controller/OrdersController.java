package com.ssm.domian.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ssm.domian.busi.service.interfaces.IOrdersService;
import com.ssm.domian.datacenter.bean.Orders;

@Controller
@RequestMapping("/orders")
public class OrdersController {
	
	@Autowired
    private IOrdersService ordersService;
	
	@RequestMapping("/findAll")
	public ModelAndView findAll(@RequestParam(name="page",defaultValue="1") Integer page,
			@RequestParam(name = "size", required = true, defaultValue = "5") Integer size) throws Exception{
		ModelAndView modelAndView = new ModelAndView();
		List<Orders> ordersList = ordersService.findAll(page, size);
		PageInfo<Orders> pageInfo = new PageInfo<Orders>(ordersList);
		modelAndView.setViewName("orders-page-list");
		modelAndView.addObject("pageInfo",pageInfo);
		return modelAndView;
	}
	
	@RequestMapping("/findById")
    public ModelAndView findById(@RequestParam(name = "id", required = true) String ordersId) throws Exception {
        ModelAndView mv = new ModelAndView();
        Orders orders = ordersService.findById(ordersId);
        mv.addObject("orders",orders);
        mv.setViewName("orders-show");
        return mv;
    }
	
}
