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
			request.setAttribute("errorMsg", "验证码错误");
			return "redirect:"+path;
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
			return "redirect:/views/manage.jsp";
		} catch (Exception e) {
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return path;
		}

	}

	/**
	 * 用户登录
	 * 
	 * @param admin
	 * @param request
	 * @return
	 */
	@RequestMapping("login.do")
	public String login(LoginBean user, String checkcode, String path,
			HttpServletRequest request) {
		// 获取真实验证码
		Session session = SecurityUtils.getSubject().getSession();
		Object realCode = session.getAttribute("randCheckCode");
		if (!checkcode.equalsIgnoreCase((String) realCode)) {
			request.setAttribute("errorMsg", "验证码错误");
			return path;
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
			return "redirect:showall.do?page=1";
		} catch (Exception e) {
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return path;
		}
	}

	@ResponseBody
	@RequestMapping("changePwd.do")
	public String changePwd(Integer id, String password, String newpwd,
			String checkpwd, HttpServletRequest req) {
		String str = "更改失败";
		if (!newpwd.equals(checkpwd)) {
			str = "两次新密码输入不一致，请重新输入";
			return str;
		}
		LoginBean user = (LoginBean) req.getSession().getAttribute("login");
		String realPwd = service.selectPwd(id);
		if (!Md5pwdUtil.md5(password, user.getName()).equals(realPwd)) {
			str = "旧密码不正确";
			return str;
		}
		LoginBean bean = new LoginBean();
		bean.setId(id);
		bean.setPassword(Md5pwdUtil.md5(newpwd, user.getName()));
		boolean re = service.updatePwd(bean);
		if (re) {
			str = "更改成功";
		}
		return str;
	}
}
