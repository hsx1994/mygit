package com.woniu.cbd.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.util.Md5pwdUtil;

@Controller
public class LoginController {
	
	/**
	 * 用户登录
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("userLogin.do")
	public String login(LoginBean user, String checkcode,HttpServletRequest request){
		System.out.println("user=" + user + ":" + "checkcode" + checkcode);
		// 加密密码Md5
		String realPassword = Md5pwdUtil.md5(user.getPassword(), user.getName());
		
		return "redirect:/index.jsp";
	}
}
