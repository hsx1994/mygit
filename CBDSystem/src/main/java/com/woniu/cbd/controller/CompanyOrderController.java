package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.CompanyOrderBean;
import com.woniu.cbd.service.ICompanyOrderService;

@Controller
public class CompanyOrderController {

	@Autowired
	private ICompanyOrderService service;

	// 前台企业查看自己订单
	@RequestMapping("selectcompanyorder.do")
	public ModelAndView SelectCompanyOrder(Integer id,Integer page) {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page,10,true);
		List<CompanyOrderBean> order = service.selectCompanyOrder(id);
		PageInfo<CompanyOrderBean> pageInfo = new PageInfo<CompanyOrderBean>(order);
		
		mav.addObject("pageinfo",pageInfo);
		mav.addObject("list",order);
		mav.setViewName("");
		return mav;
	}

}
