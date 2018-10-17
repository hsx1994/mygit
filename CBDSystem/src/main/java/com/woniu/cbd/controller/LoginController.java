package com.woniu.cbd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.cbd.bean.LoginBean;

@Controller
public class LoginController {
	@RequestMapping("/login.do")
	public @ResponseBody boolean login(LoginBean bean) {
		
		System.out.println(bean.getName()+"+"+bean.getPassword());
		return true;
	}
}
