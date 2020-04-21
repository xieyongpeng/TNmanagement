package com.ssm.domian.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageInfo;
import com.ssm.domian.busi.service.interfaces.ISysLogService;
import com.ssm.domian.datacenter.bean.SysLog;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {

	@Autowired
	private ISysLogService sysLogService;

	@RequestMapping("/findAll")
	public ModelAndView findAll(
			@RequestParam(name = "page", defaultValue = "1") Integer page,
			@RequestParam(name = "size", required = true, defaultValue = "10") Integer size)
			throws Exception {
		ModelAndView mv = new ModelAndView();
		List<SysLog> sysLogList = sysLogService.findAll(page, size);
		PageInfo<SysLog> pageInfo = new PageInfo<SysLog>(sysLogList);
		mv.addObject("pageInfo", pageInfo);
		mv.setViewName("syslog-list");
		return mv;
	}
}
