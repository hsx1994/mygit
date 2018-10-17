package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.BargainBean;
import com.woniu.cbd.service.IBargainService;

@Controller
public class BargainController {
	@Autowired
	private IBargainService service;

	@RequestMapping("/bargainAdd.do")
	public @ResponseBody String bargainAdd(BargainBean bean) {
		String result = "添加失败";
		boolean re = service.bargainAdd(bean);
		if (re) {
			result = "添加成功";
		}
		return result;
	}

	@RequestMapping("/bargainDelete.do")
	public @ResponseBody String bargainDelete(Integer id) {
		String result = "删除失败";
		boolean re = service.bargainDelete(id);
		if (re) {
			result = "删除成功";
		}
		return result;
	}

	@RequestMapping("/bargainUpdate.do")
	public @ResponseBody String bargainUpdate(BargainBean bean) {
		String result = "更改失败";
		boolean re = service.bargainUpdate(bean);
		if (re) {
			result = "更改成功";
		}
		return result;
	}

	@RequestMapping("/bargainSelect.do")
	public ModelAndView bargainSelect(BargainBean bean,Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page,10,true);
		List<BargainBean> bargain = service.bargainSelect(bean);
		PageInfo<BargainBean> pageInfo = new PageInfo<BargainBean>(bargain);
		
		mav.addObject("bargain", pageInfo);
		mav.setViewName("");

		return mav;
	}

	@RequestMapping("/allBargainSelect.do")
	public ModelAndView allBargainSelect(Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page,10,true);
		List<BargainBean> bargain = service.allBargainSelect();
		PageInfo<BargainBean> pageInfo = new PageInfo<BargainBean>(bargain);
		
		mav.addObject("allBargain", pageInfo);
		mav.setViewName("");

		return mav;
	}

	@RequestMapping("/findUnseingBargain.do")
	public ModelAndView findUseingBargain(Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page,10,true);
		List<BargainBean> bargain = service.bargainSelectByState(0);
		PageInfo<BargainBean> pageInfo = new PageInfo<BargainBean>(bargain);
		
		mav.addObject("useingBargain", pageInfo);
		mav.setViewName("");

		return mav;
	}

	@RequestMapping("/findUnseingBargain.do")
	public ModelAndView findUnseingBargain(Integer page) {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page,10,true);
		List<BargainBean> bargain = service.bargainSelectByState(1);
		PageInfo<BargainBean> pageInfo = new PageInfo<BargainBean>(bargain);
		
		mav.addObject("unuseingBargain", pageInfo);
		mav.setViewName("");

		return mav;
	}
}
