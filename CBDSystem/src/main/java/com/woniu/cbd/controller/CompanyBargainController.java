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

	@RequestMapping("/companyBargainAdd.do")
	public @ResponseBody String companyBargainAdd(CompanyBargainBean bean) {
		String result = "添加失败";
		boolean re = service.companyBargainAdd(bean);
		if (re) {
			result = "添加成功";
		}
		return result;
	}

	@RequestMapping("/companyBargainDelete.do")
	public @ResponseBody String companyBargainDelete(Integer id) {
		String result = "删除失败";
		boolean re = service.companyBargainDelete(id);
		if (re) {
			result = "删除成功";
		}
		return result;
	}

	@RequestMapping("/companyBargainUpdate.do")
	public @ResponseBody String companyBargainUpdate(CompanyBargainBean bean) {
		String result = "更改失败";
		boolean re = service.companyBargainUpdate(bean);
		if (re) {
			result = "更改成功";
		}
		return result;
	}
    //企业查看合约
	@RequestMapping("/companyBargainSelect.do")
	public ModelAndView companyBargainSelect(CompanyBargainBean bean) {
		ModelAndView mav = new ModelAndView();
		List<CompanyBargainBean> bargain = service.companyBargainSelect(bean);
		mav.addObject("companBargain", bargain);
		mav.setViewName("");

		return mav;
	}

	@RequestMapping("/allCompanyBargainSelect.do")
	public ModelAndView allCompanyBargainSelect() {
		ModelAndView mav = new ModelAndView();
		List<CompanyBargainBean> bargain = service.allCompanyBargainSelect();
		mav.addObject("allCompanyBargain", bargain);
		mav.setViewName("");

		return mav;
	}

	@RequestMapping("/findUseingCompanyBargain.do")
	public ModelAndView findUseingCompanyBargain() {
		ModelAndView mav = new ModelAndView();
		List<CompanyBargainBean> bargain = service.companyBargainSelectByState(0);
		mav.addObject("useingCompanyBargain", bargain);
		mav.setViewName("");

		return mav;
	}

	@RequestMapping("/findUnseingCompanyBargain.do")
	public ModelAndView findUnseingCompanyBargain() {
		ModelAndView mav = new ModelAndView();
		List<CompanyBargainBean> bargain = service.companyBargainSelectByState(1);
		mav.addObject("unuseingCompanyBargain", bargain);
		mav.setViewName("");

		return mav;
	}
	
}
