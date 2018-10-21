package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.AdministratorBean;
import com.woniu.cbd.service.IAdministratorService;
import com.woniu.cbd.service.ILoginService;

/**
 * 描述 ：处理普通管理员所有前后端交互功能
 * 
 * @author wt
 *
 */

@Controller
public class AdministratorAction {
	// 自动注入业务层的实现类
	@Autowired
	private IAdministratorService service;
	@Autowired
	private ILoginService ils;
	/**
	 * 添加普通管理员
	 * @param model
	 * @param name
	 * @param password
	 * @return
	 */
	@RequestMapping("/addAdmin.do")
	public @ResponseBody String register(@RequestBody AdministratorBean admin) {
		String result = null;
		if(admin.getJobNumber().length()<1){
			result="工号不能为空";
			return result;
		}
		if(admin.getTel().length()<1){
			result="电话不能为空";
			return result;
		}
		if(admin.getRealName().length()<1){
			result="姓名不能为空";
			return result;
		}
		String re = ils.addAdmin(admin.getLogin());
		
		if(re.equals("成功")){
			result = service.addAdmin(admin);
		} else {
			result = re;
		}
		return result;
	}

	/**
	 * 描述：实现账号删除功能
	 * 
	 * @param model
	 * @param id 要删除的管理员的id
	 * @return
	 */
	@RequestMapping("/deleteAdmin.do")
	public @ResponseBody String delete(@RequestParam("id") int id) {
		// 接收后台处理完删除后的结果
		String str = service.administratorDelet(id);
		// 向页面传参
		return str;
	}

	/**
	 * 作用：修改电话号码
	 * @param model
	 * @param ab 前端传来的对象包含id、limit字段
	 * @return  修改结果
	 */
	@ResponseBody
	@RequestMapping("/updateAdminTel.do")
	public String change(AdministratorBean bean){
		String str = "修改失败";
		str = service.updateAdminTel(bean);
		return str;
	}


	/**
	 * 查询所有管理员信息
	 * @param page
	 * @return
	 */
	@RequestMapping("findAll.do")
	public ModelAndView show(Integer page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(page,10,true);
		// 存储查询结果
		List<AdministratorBean> list = null;
		// 所有后台管理员信息集合
		list = service.showAdministrator();
		PageInfo<AdministratorBean> pageInfo = new PageInfo<AdministratorBean>(list);
		// 向页面传参
		mav.addObject("pageinfo",pageInfo);
		mav.addObject("list",list);
		mav.setViewName("views/all_admin_info.jsp");
		return mav;
	}
	
	/**
	 * 通过ID查询单个管理员信息
	 * @param id
	 * @return
	 */
	@RequestMapping("showOneAdmin.do")
	public ModelAndView showOneAdmin(Integer id){
		ModelAndView mav = new ModelAndView();
		AdministratorBean admin = service.showOneAdministrator(id);
		
		mav.addObject("admin",admin);
		mav.setViewName("views/update_admin.jsp");
		return mav;
	}
	/**
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("showAdminInfo.do")
	public ModelAndView showAdminInfo(String id){
		int uid = Integer.parseInt(id);
		ModelAndView mav = new ModelAndView();
		AdministratorBean admin = service.showAdministratorInfo(uid);
		
		mav.addObject("admin",admin);
		mav.setViewName("views/userinfo.jsp");
		return mav;
	}
}
