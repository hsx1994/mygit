package com.woniu.cbd.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.service.IUserService;
import com.woniu.cbd.util.Md5pwdUtil;

@Controller
public class UserController {
	@Autowired
	private IUserService user;

	// 手机发送验证码测试
	@RequestMapping("/phone.do")
	public ModelAndView Num(HttpServletRequest request, String number) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		// 发送验证码
		// String code=PhoneCodeUtil.Number(number);
		// 将session放到session中
		session.setAttribute("code", "123123");
		System.out.println(number);
		mav.setViewName("");
		return mav;

	}

	// 注册测试
	@RequestMapping("/regist.do")
	public @ResponseBody String Regist(HttpServletRequest request, String role,
			String name, String password, UserBean bean, String code) {
		HttpSession session = request.getSession();
		// 密码加密
		String pass = Md5pwdUtil.md5(password, name);
		// 获取session给中的验证码
		String num = (String) session.getAttribute("code");
		LoginBean beans = new LoginBean();
		beans.setName(name);
		beans.setPassword(pass);
		beans.setRole(role);

		// 验证验证码
		 if (code.equals(num)) {
			user.addUser(beans);
			user.addUserInfor(bean);
			return "注册成功";
		} else {
			return "注册失败";
		}
	}

	/***
	 * 修改个人信息是否成功
	 * @param user
	 * @return
	 */
	@RequestMapping("up.do")
	public @ResponseBody String updateUser(@Validated UserBean bean){
		boolean row = user.updateUser(bean);
		String result = "修改失败";
		if (row) {
			result = "修改成功";
		}
		return result;
	}

	//查看个人信息
	@RequestMapping("look.do")
	public @ResponseBody UserBean findUserInfo(Integer id) {
		UserBean bean = user.findUserInfo(id);
		return bean;
	}

	/***
	 * 修改企业信息是否成功
	 * @param user
	 * @return
	 */		
	public String updateCompany(@Validated CompanyInfoBean company) {
		boolean row = user.updateCompany(company);
		if (row) {
			return "/three.jsp";
		} else {
			return "/ModificationPersonal.jsp";

		}
	}
	

}
