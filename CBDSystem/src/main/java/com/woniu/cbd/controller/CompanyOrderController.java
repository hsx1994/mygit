package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.cbd.bean.CompanyOrderBean;
import com.woniu.cbd.service.ICompanyOrderService;

@Controller
public class CompanyOrderController {

	@Autowired
	private ICompanyOrderService service;

	// 前台企业查看自己订单
	@RequestMapping("/selectcompanyorder.do")
	public ModelAndView SelectCompanyOrder(int id) {
		ModelAndView mav = new ModelAndView();
		List<CompanyOrderBean> order = service.selectCompanyOrder(id);
		mav.addObject("order",order);
		mav.setViewName("");
		return mav;
	}

}
