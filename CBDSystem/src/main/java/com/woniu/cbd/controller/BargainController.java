package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.cbd.bean.BargainBean;
import com.woniu.cbd.service.IBargainService;

@Controller
public class BargainController {
	@Autowired
	private IBargainService service;
	
	@RequestMapping("/1")
	public @ResponseBody String bargainAdd(BargainBean bean){
		String result = "添加失败";
		boolean re = service.bargainAdd(bean);
		if(re){
			result = "添加成功";
		}
		return result;
	}
	
	@RequestMapping("/2")
	public @ResponseBody String bargainDelete(Integer id){
		String result = "删除失败";
		boolean re = service.bargainDelete(id);
		if(re){
			result = "删除成功";
		}
		return result;
	}
	
	@RequestMapping("/3")
	public @ResponseBody String bargainUpdate(BargainBean bean){
		String result = "更改失败";
		boolean re = service.bargainUpdate(bean);
		if(re){
			result = "更改成功";
		}
		return result;
	}
	
	@RequestMapping("/4")
	public ModelAndView bargainSelect(BargainBean bean){
		ModelAndView mav = new ModelAndView();
		List<BargainBean> bargain = service.bargainSelect(bean);
		mav.addObject("bargain", bargain);
		mav.setViewName("");
		
		return mav;
	}
	
	@RequestMapping("/5")
	public ModelAndView allBargainSelect(){
		ModelAndView mav = new ModelAndView();
		List<BargainBean> bargain = service.allBargainSelect();
		mav.addObject("allBargain", bargain);
		mav.setViewName("");
		
		return mav;
	}
	
	@RequestMapping("/99")
	public ModelAndView findUseingBargain(){
		ModelAndView mav = new ModelAndView();
		List<BargainBean> bargain = service.bargainSelectByState(0);
		mav.addObject("useingBargain", bargain);
		mav.setViewName("");
		
		return mav;
	}
	
	@RequestMapping("/99999")
	public ModelAndView findUnseingBargain(){
		ModelAndView mav = new ModelAndView();
		List<BargainBean> bargain = service.bargainSelectByState(1);
		mav.addObject("unuseingBargain", bargain);
		mav.setViewName("");
		
		return mav;
	}
}
