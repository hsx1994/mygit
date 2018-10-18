package com.woniu.cbd.controller;


import java.util.List;










import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.RegisterBean;
import com.woniu.cbd.service.IUserService;

@Controller
public class RegisterAction {
	@Autowired
	private IUserService service;

	@RequestMapping("/personl.do")
	/***
	 * 注册是否成功
	 * @param user
	 * @return
	 */
	
	public @ResponseBody boolean addUser(String name) {
		System.out.println(name);
//		boolean row = service.addUser(user);
//		String result = "失败";
//		if (row) {
//			System.out.println("成功");
//			result = "成功";

		
		return true;
		

	}
	/***
	 * 修改个人信息是否成功
	 * @param user
	 * @return
	 */

	public boolean updateUser(@Validated RegisterBean user){
		boolean row = service.updateUser(user);
		String result = "失败";
		if (row) {
			System.out.println("成功");
			result = "成功";

		}
		return row;
	}
	
	/***
	 * 修改企业信息是否成功
	 * @param user
	 * @return
	 */
	public String updateCompany(@Validated CompanyInfoBean company){
		int row = service.updateCompany(company);
		if(row>0){
			return "/某页面";	
		}else{
			return "/ModificationPersonal.jsp";	
		}
	}

}
