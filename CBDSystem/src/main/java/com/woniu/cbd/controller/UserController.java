package com.woniu.cbd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aliyuncs.exceptions.ClientException;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.service.IUserService;
import com.woniu.cbd.util.PhoneCodeUtil;

@Controller
public class UserController {
	@Autowired
	private IUserService user;

	// 包租婆查看自己的申请记录
	@RequestMapping("/showme.do")
	public ModelAndView ShowMe(Integer id) {
		ModelAndView mav = new ModelAndView();
		List<ParkingBean> bean = user.ShowMe(id);
		if (bean != null) {
			System.out.println("查询成功");
			mav.addObject("application", bean);
			mav.setViewName("");
		} else {
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
		mav.addObject("lease", bean);
		return mav;

	}

	// 抢租客查看租赁记录
	@RequestMapping("/showlog.do")
	public ModelAndView ShowLog(Integer id) {
		List<OrderBean> bean = user.ShowLog(id);
		ModelAndView mav = new ModelAndView();
		mav.addObject("Lease", bean);
		mav.setViewName("");
		return mav;

	}

	// 手机发送验证码测试
	@RequestMapping("/phone.do")
	public ModelAndView Num(HttpServletRequest request, String number) throws ClientException {
		ModelAndView mav = new ModelAndView();
		System.out.println(number);
		HttpSession session = request.getSession();
	    String code=PhoneCodeUtil.Number(number); 
	    System.out.println(code);
		session.setAttribute("code", code);
		mav.setViewName("views/hu/MyJsp.jsp");
		return mav;

	}

	// 注册验证码校验测试
	@RequestMapping("/number.do")
	@ResponseBody
	public String number(HttpServletRequest request, String num) {
		HttpSession session = request.getSession();
		String code = (String) session.getAttribute("code");
		System.out.println(code);
		System.out.println(num);
		if (num.equals(code)) {
			System.out.println("验证码验证成功");
			return "注册成功";
		} else {
			System.out.println("验证码验证失败");
			return "注册失败";
		}

	}
}
