package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.service.IUserService;

@Controller
public class UserController {
	@Autowired
	private IUserService user;
	
	// 包租婆查看自己的申请记录
	@RequestMapping("/showme.do")
	public ModelAndView ShowMe(Integer id) {
		ModelAndView mav = new ModelAndView();
		List<ParkingBean> bean = user.ShowMe(id);
		if(bean !=null){
			System.out.println("查询成功");
			mav.addObject("application",bean);
			mav.setViewName("");
		}else{
			System.out.println("查询为空");
			mav.addObject(" ");
			mav.setViewName("");
		}
		return mav;
		

	}

	// 包租婆查看自己的被租赁记录
	@RequestMapping("/selectlog.do")
	public ModelAndView SelectLog(Integer id) {
		List<ParkingBean> bean = user.SelectLog(id);
		ModelAndView mav = new ModelAndView();
		mav.setViewName("");
		mav.addObject("lease",bean);
		return mav;

	}
	//抢租客查看租赁记录
	@RequestMapping("/showlog.do")
	public ModelAndView ShowLog(Integer id){
		List<OrderBean>bean=user.ShowLog(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("Lease",bean);
		mav.setViewName("");
		return mav;
		
	}
	//手机验证码校验
}
