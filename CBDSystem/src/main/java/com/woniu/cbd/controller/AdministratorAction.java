package com.woniu.cbd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.woniu.cbd.bean.AdministratorBean;
import com.woniu.cbd.service.impl.AdministratorServiceImpl;

/**
 * 描述 ：处理普通管理员所有前后端交互功能
 * 
 * @author wt
 *
 */
@RequestMapping("/Administrator")
@Controller
public class AdministratorAction {
	// 自动注入业务层的实现类
	@Autowired
	private AdministratorServiceImpl service;

	/**
	 * 描述:完成添加业务
	 * 
	 * @param model
	 * @param name
	 * @param password
	 * @return
	 */
	// 接受页面传参（普通管理员的基本信息）
	@RequestMapping("/register.do")
	public String register(Model model, @RequestParam("name") String name,
			@RequestParam("pass") String password) {
		// 向页面传参数
		model.addAttribute("name", name);
		return "/jsp/register.jsp";
	}

	/**
	 * 描述：实现账号删除功能
	 * 
	 * @param model
	 * @param id
	 *            要删除的管理员的id
	 * @return
	 */
	@RequestMapping("/delete.do")
	public String delete(Model model, @RequestParam("id") int id) {
		// 接收后台处理完删除后的结果
		String str = service.administratorDelet(id);
		// 向页面传参
		model.addAttribute("result", str);
		return "/jsp/register.jsp";
	}

	/**
	 * 作用：修改权限
	 * @param model
	 * @param ab 前端传来的对象包含id、limit字段
	 * @return  修改结果
	 */
	@RequestMapping("/change.do")
	public String change(Model model, AdministratorBean ab) {
																					
		// 接收后台处理完修改后的结果

		String str = service.administratorLimitChange(ab);
		// 向页面传参
		model.addAttribute("changeresult", str);
		return "/jsp/register.jsp";
	}

	
	@RequestMapping("/findAll.do")
	public String show(Model model) {
		// 存储查询结果
		List<AdministratorBean> list = null;
		// 接收后台处理完删除后的结果
		list = service.showAdministrator();
		// 向页面传参
		model.addAttribute("ablist", list);
		return "/jsp/register.jsp";
	}

}
