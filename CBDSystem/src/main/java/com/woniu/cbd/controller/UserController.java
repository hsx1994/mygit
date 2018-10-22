package com.woniu.cbd.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aliyuncs.exceptions.ClientException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.service.IUserService;
import com.woniu.cbd.util.MD5_Encoding;
import com.woniu.cbd.util.PhoneCodeUtil;

@Controller
public class UserController {
	@Autowired

	private IUserService user;


	// 手机发送验证码
	@RequestMapping("/phone.do")
	public void phoneCode(HttpServletRequest request, String number) throws ClientException {
		HttpSession session = request.getSession();
		// 发送验证码
		 String code = PhoneCodeUtil.Number(number); 
		// 将session放到session中
		session.setAttribute("code", code);
	}

	// 注册
	@RequestMapping("/regist.do")
	public @ResponseBody String regist(Model model,HttpServletRequest request, String name, String password, UserBean user,
			String code, String role) {
		//数据回显
		model.addAttribute("user",user);
		HttpSession session = request.getSession();
		// 密码加密
		String pass = MD5_Encoding.lowerMD5(password);

		// 获取session给中的验证码
		String num = (String) session.getAttribute("code");
		// 验证验证码
		LoginBean login = new LoginBean();
		login.setName(name);
		//把加密后的用户密码赋给Login实体类
		login.setPassword(pass);
		login.setRole(role);
		if (code.equals(num)) {

			return "注册成功";
		}
		return "验证码错误";

	}
}
