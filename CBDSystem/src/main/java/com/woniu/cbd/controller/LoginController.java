package com.woniu.cbd.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.service.ILoginService;
import com.woniu.cbd.util.Md5pwdUtil;

@Controller
public class LoginController {

	@Autowired
	private ILoginService service;

	/**
	 * 管理员登录
	 * 
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping("adminLogin.do")
	public String adminLogin(LoginBean user, String checkcode, String path,
			HttpServletRequest request) {
		// 获取真实验证码
		Session session = SecurityUtils.getSubject().getSession();
		Object realCode = session.getAttribute("randCheckCode");

		if (!checkcode.equalsIgnoreCase((String) realCode)) {
			session.setAttribute("errorMsg", "验证码错误");
			return "redirect:" + path;
		}

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
			session.setAttribute("loginPath", path);
			LoginBean lo = (LoginBean) session.getAttribute("login");
			if (lo.getRole().endsWith("管理员")) {
				return "redirect:/views/manage.jsp";
			} else {
				session.removeAttribute("login");
				session.setAttribute("user", user);
				session.setAttribute("errorMsg", "管理账户不存在");
				return "redirect:" + path;
			}

		} catch (Exception e) {
			session.setAttribute("user", user);
			session.setAttribute("errorMsg", "用户名或密码错误！");
			return "redirect:" + path;
		}

	}

	/*
	 * 普通用户登录
	 * 
	 * @param admin
	 * 
	 * @param request
	 * 
	 * @return
	 */
	@RequestMapping("login.do")
	public String login(LoginBean user, String checkcode, String path,
			HttpServletRequest request) {
		// 获取真实验证码
		Session session = SecurityUtils.getSubject().getSession();
		Object realCode = session.getAttribute("randCheckCode");
		if (!checkcode.equalsIgnoreCase((String) realCode)) {
			session.setAttribute("errorMsg", "验证码错误");
			return "redirect:" + path;
		}

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
			session.setAttribute("loginPath", path);
			LoginBean lo = (LoginBean) session.getAttribute("login");
			String role = lo.getRole();

			if (role.equals("抢租客")) {
				return "redirect:/index.jsp";

			} else if (role.equals("企业用户")) {
				return "redirect:/jsp/ConpanyShowParking.jsp";
			} else if (role.equals("包租婆")) {
				return "redirect:/jsp/one.jsp";
			} else {
				session.removeAttribute("login");
				session.setAttribute("user", user);
				session.setAttribute("errorMsg", "用户不存在！");
				return "redirect:" + path;

			}
		} catch (Exception e) {
			session.setAttribute("user", user);
			session.setAttribute("errorMsg", "用户名或密码错误！");
			return "redirect:" + path;
		}
	}

	/**
	 * 注销功能
	 * 
	 * @param session
	 * @return
	 */
	@ResponseBody
	@RequestMapping("logoutExit.do")
	public String logoutExit(HttpSession session) {
		String path = (String) session.getAttribute("loginPath");
		session.removeAttribute("login");
		session.removeAttribute("id");
		session.removeAttribute("user");
		session.removeAttribute("errorMsg");
		return  path;
	}

	@ResponseBody
	@RequestMapping("logoutExitAdmin.do")
	public String logoutExit(HttpServletRequest req) {
		HttpSession session = req.getSession();
		session.removeAttribute("login");
		session.removeAttribute("id");
		session.removeAttribute("user");
		session.removeAttribute("errorMsg");
		return "注销成功";
	}

	/**
	 * 验证用户名是否可用
	 * 
	 * @param name
	 * @return
	 */
	@RequestMapping("checkUserName.do")
	public @ResponseBody String checkUserName(String name) {
		String result = "用户名已存在";
		LoginBean bean = service.getLoginUserByName(name);
		if (bean == null) {
			result = "用户名可用";
		}
		return result;
	}

	/**
	 * 管理员修改密码
	 * 
	 * @param password
	 * @param newpwd
	 * @param checkpwd
	 * @param req
	 * @return
	 */
	@ResponseBody
	@RequestMapping("changePwd.do")
	public String changePwd(String password, String newpwd, String checkpwd,
			HttpServletRequest req) {

		String str = "更改失败";
		if (!newpwd.equals(checkpwd)) {
			str = "两次新密码输入不一致，请重新输入";
			return str;
		}
		LoginBean user = (LoginBean) req.getSession().getAttribute("login");
		String realPwd = service.selectPwd(user.getId());
		if (!Md5pwdUtil.md5(password, user.getName()).equals(realPwd)) {
			str = "旧密码不正确";
			return str;
		}
		user.setPassword(Md5pwdUtil.md5(newpwd, user.getName()));
		boolean re = service.updatePwd(user);
		if (re) {
			str = "更改成功";
		}
		return str;
	}

}
