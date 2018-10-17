package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public ModelAndView companyBargainSelect(CompanyBargainBean bean,Integer page) {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page,10,true);
		List<CompanyBargainBean> bargain = service.companyBargainSelect(bean);
		PageInfo<CompanyBargainBean> pageInfo = new PageInfo<CompanyBargainBean>(bargain);
		
		mav.addObject("companBargain", pageInfo);
		mav.setViewName("");

		return mav;
	}

	@RequestMapping("/allCompanyBargainSelect.do")
	public ModelAndView allCompanyBargainSelect(Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page,10,true);
		List<CompanyBargainBean> bargain = service.allCompanyBargainSelect();
		PageInfo<CompanyBargainBean> pageInfo = new PageInfo<CompanyBargainBean>(bargain);
		
		mav.addObject("allCompanyBargain", pageInfo);
		mav.setViewName("");

		return mav;
	}

	@RequestMapping("/findUseingCompanyBargain.do")
	public ModelAndView findUseingCompanyBargain(Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page,10,true);
		List<CompanyBargainBean> bargain = service.companyBargainSelectByState(0);
		PageInfo<CompanyBargainBean> pageInfo = new PageInfo<CompanyBargainBean>(bargain);
		
		mav.addObject("useingCompanyBargain", pageInfo);
		mav.setViewName("");

		return mav;
	}

	@RequestMapping("/findUnseingCompanyBargain.do")
	public ModelAndView findUnseingCompanyBargain(Integer page) {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page,10,true);
		List<CompanyBargainBean> bargain = service.companyBargainSelectByState(1);
		PageInfo<CompanyBargainBean> pageInfo = new PageInfo<CompanyBargainBean>(bargain);
		
		mav.addObject("unuseingCompanyBargain", pageInfo);
		mav.setViewName("");

		return mav;
	}
	
}
