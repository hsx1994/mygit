package com.woniu.cbd.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.util.Md5pwdUtil;

@Controller
public class LoginController {

	/**
	 * 管理员登录
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping("adminLogin.do")
	public String adminLogin(LoginBean user, String checkcode,
			HttpServletRequest request) {

		// 加密密码Md5
		String realPassword = Md5pwdUtil
				.md5(user.getPassword(), user.getName());
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),
				realPassword);
		try {
			// 是否记住我功能,默认记住
			if (!subject.isRemembered()) {
				token.setRememberMe(true);
			}
			subject.login(token);
			return "redirect:/views/main.jsp";
		} catch (Exception e) {
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "views/login.jsp";
		}

	}
	
	
	
	/**
	 * 用户登录
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping("login.do")
	public String login(LoginBean user, String checkcode,
			HttpServletRequest request) {

		// 加密密码Md5
		String realPassword = Md5pwdUtil
				.md5(user.getPassword(), user.getName());
		Subject subject = SecurityUtils.getSubject();
		UsernamePasswordToken token = new UsernamePasswordToken(user.getName(),
				realPassword);
		try {
			// 是否记住我功能,默认记住
			if (!subject.isRemembered()) {
				token.setRememberMe(true);
			}
			subject.login(token);
			return "redirect:/index.jsp";
		} catch (Exception e) {
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "/views/user/login.jsp";
		}

	}
}
