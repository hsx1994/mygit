package com.woniu.cbd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.service.ILoginService;
import com.woniu.cbd.util.Md5pwdUtil;

@Controller
public class LoginController {
	@Autowired
	private ILoginService service;
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
		
		return "redirect:showall.do?page=1";
	}

	@ResponseBody
	@RequestMapping("changePwd.do")
	public String changePwd(Integer id,String password,String newpwd,String checkpwd,HttpServletRequest req){
		String str = "更改失败";
		if(!newpwd.equals(checkpwd)){
			str = "两次新密码输入不一致，请重新输入";
			return str;
		}
		LoginBean user = (LoginBean) req.getSession().getAttribute("login");
		String realPwd = service.selectPwd(id);
		if(!Md5pwdUtil.md5(password, user.getName()).equals(realPwd)){
			str = "旧密码不正确";
			return str;
		}
		LoginBean bean = new LoginBean();
		bean.setId(id);
		bean.setPassword(Md5pwdUtil.md5(newpwd, user.getName()));
		boolean re = service.updatePwd(bean);
		if(re){
			str="更改成功";
		}
		return str;
	}
}
