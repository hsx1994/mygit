package com.woniu.cbd.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aliyuncs.exceptions.ClientException;
import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.service.ILoginService;
import com.woniu.cbd.service.IUserService;
import com.woniu.cbd.util.Md5pwdUtil;
import com.woniu.cbd.util.PhoneCodeUtil;
import com.woniu.cbd.util.RegularExpression;

@Controller
public class UserController {
	@Autowired
	private IUserService user;
	@Autowired
	private ILoginService ls;
	// 手机发送验证码
	@RequestMapping("/phone.do")
	public void phoneCode(HttpServletRequest request, String number) throws ClientException {
		HttpSession session = request.getSession();
		// 发送验证码
		String code = PhoneCodeUtil.Number(number);
		// 将session放到session中
		session.setAttribute("code", code);

	}

	// 注册测试
	@RequestMapping("regist.do")
	public @ResponseBody String Regist(HttpServletRequest request, UserBean bean, String code) {
		HttpSession session = request.getSession();
		
		// 获取session给中的验证码
		String num = (String) session.getAttribute("code");
		// 验证验证码
		if (!code.equals(num)) {
			return "验证码错误";
		}
		if(bean.getLogin().getName().trim().length() < 1 || bean.getLogin().getPassword().trim().length() < 1){
			return "输入不能为空";
		}
		// 密码加密
		/*String pass = Md5pwdUtil.md5(bean.getLogin().getPassword(), bean.getLogin().getName());*/
		LoginBean login = bean.getLogin();
		login.setPassword(bean.getLogin().getPassword());
		int id = user.addUser(login);
		if (id == 0) {
			return "用户名或密码注册失败";
		}
		boolean re = user.addUserInfor(bean);
		if (re) {
			return "注册成功";
		}
		return "注册失败";
	}

	/***
	 * 修改个人信息是否成功
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("up.do")
	public @ResponseBody String updateUser(UserBean bean) {
		System.out.println(bean.getId()+":"+bean.getTel()+":"+bean.getEmail()+":"+bean.getJob()+":"+bean.getAddress());
		if(bean.getTel() == null || bean.getEmail() == null || bean.getJob() == null || bean.getAddress() == null ){
			return "输入不能为空";
		}
		if(bean.getTel().trim().length() < 1 ||bean.getEmail().trim().length() < 1 ||
				bean.getJob().trim().length() < 1 ||
				bean.getAddress().trim().length() < 1){
			return "输入不能为空字符";
		}
		if(!RegularExpression.testEmail(bean.getEmail())){
			return "邮箱格式不正确";
		}
		if(!RegularExpression.testTel(bean.getTel())){
			return "电话格式不正确";
		}
		
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
		UserBean bean = user.findById(id);
		return bean;
	}

	/***
	 * 修改企业信息是否成功
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping("companyUpdate.do")
	public @ResponseBody String updateCompany(CompanyInfoBean company) {
		if(company.getComLogin().getPassword() == null || company.getEmail() == null ||
				company.getTel() == null || company.getContact() == null){
				return "输入不能为空";
			}
		if(company.getComLogin().getPassword().trim().length() < 1 || company.getEmail().trim().length() < 1 ||
			company.getTel().trim().length() < 1 || company.getContact().trim().length() < 1){
			return "输入不能为空";
		}
		if(!RegularExpression.testTel(company.getTel())){
			return "电话格式不正确";
		}
		if(!RegularExpression.testEmail(company.getEmail())){
			return "邮箱格式不正确";
		}
		String newPwd = Md5pwdUtil.md5(company.getComLogin().getPassword(), company.getComLogin().getName());
		LoginBean login = company.getComLogin();
		login.setPassword(newPwd);
		boolean check = ls.updatePwd(login);
		if(!check){
			return "密码修改失败";
		}
		boolean row = user.updateCompany(company);
		String result = "修改失败";
		if (row) {
			result = "修改成功";
		}
		return result;
	}
}
