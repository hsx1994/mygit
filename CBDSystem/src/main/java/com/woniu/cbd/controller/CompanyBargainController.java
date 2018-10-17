package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.service.ICompanyBargainService;

public class CompanyBargainController {
	@Autowired
	private ICompanyBargainService service;

	@RequestMapping("/6")
	public @ResponseBody String bargainAdd(CompanyBargainBean bean) {
		String result = "添加失败";
		boolean re = service.companyBargainAdd(bean);
		if (re) {
			result = "添加成功";
		}
		return result;
	}

	@RequestMapping("/7")
	public @ResponseBody String bargainDelete(Integer id) {
		String result = "删除失败";
		boolean re = service.companyBargainDelete(id);
		if (re) {
			result = "删除成功";
		}
		return result;
	}

	@RequestMapping("/8")
	public @ResponseBody String bargainUpdate(CompanyBargainBean bean) {
		String result = "更改失败";
		boolean re = service.companyBargainUpdate(bean);
		if (re) {
			result = "更改成功";
		}
		return result;
	}
    //企业查看合约
	@RequestMapping("/9")
	public ModelAndView bargainSelect(CompanyBargainBean bean) {
		ModelAndView mav = new ModelAndView();
		List<CompanyBargainBean> bargain = service.companyBargainSelect(bean);
		mav.addObject("companBargain", bargain);
		mav.setViewName("");

		return mav;
	}

	@RequestMapping("/10")
	public ModelAndView allBargainSelect() {
		ModelAndView mav = new ModelAndView();
		List<CompanyBargainBean> bargain = service.allCompanyBargainSelect();
		mav.addObject("allCompanyBargain", bargain);
		mav.setViewName("");

		return mav;
	}

	@RequestMapping("/999")
	public ModelAndView findUseingBargain() {
		ModelAndView mav = new ModelAndView();
		List<CompanyBargainBean> bargain = service.companyBargainSelectByState(0);
		mav.addObject("useingCompanyBargain", bargain);
		mav.setViewName("");

		return mav;
	}

	@RequestMapping("/9999")
	public ModelAndView findUnseingBargain() {
		ModelAndView mav = new ModelAndView();
		List<CompanyBargainBean> bargain = service.companyBargainSelectByState(1);
		mav.addObject("unuseingCompanyBargain", bargain);
		mav.setViewName("");

		return mav;
	}
	
}
