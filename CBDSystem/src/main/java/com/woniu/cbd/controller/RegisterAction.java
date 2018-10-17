package com.woniu.cbd.controller;


import java.util.List;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.RegisterBean;
import com.woniu.cbd.service.IUserService;

@Controller
public class RegisterAction {
	@Autowired
	private IUserService service;

	@RequestMapping("personl.do")
	/***
	 * 注册是否成功
	 * @param user
	 * @return
	 */
	
	public String addUser(Model model, @Validated RegisterBean user,BindingResult res) {
		System.out.println("user+"+user);
		
		System.out.println("service+"+service);
		boolean row = service.addUser(user);
		
		if(row = true){
			return "jsp/Success.jsp";	
		}else{
			model.addAttribute("user",user);
			System.out.println("model+"+model);
			if(res.hasErrors()){
				System.out.println("res+"+res);
				List<ObjectError> list = res.getAllErrors();
				
				model.addAttribute("allErrors",list);
			}
			return "jsp/PersonalRegister.jsp";	
		}

	}
	/***
	 * 修改个人信息是否成功
	 * @param user
	 * @return
	 */

	public String updateUser(@Validated RegisterBean user){
		int row = service.updateUser(user);
		if(row>0){
			return "/某页面";	
		}else{
			return "/ModificationPersonal.jsp";	
		}
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
