package com.woniu.cbd.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.AdministratorBean;
import com.woniu.cbd.bean.RolePermissionBean;
import com.woniu.cbd.service.IAdministratorService;
import com.woniu.cbd.service.ILoginService;
import com.woniu.cbd.service.IRolePermissionService;
import com.woniu.cbd.util.RegularExpression;

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
	@Autowired
	private IRolePermissionService irs;
	
	/**
	 * 添加普通管理员
	 */
	@RequestMapping("/addAdmin.do")
	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	public @ResponseBody String registerAdmin(String[] limits,AdministratorBean admin) {
		String result = null;
		if(limits.length < 1 || limits == null){
			return "权限不能为空";
		}
		if(admin.getJobNumber().length()<1 || admin.getJobNumber() == null){
			return "工号不能为空";
		}
		if(admin.getTel().length()<1 || admin.getTel() == null){
			return "电话不能为空";
		}
		if(admin.getRealName().length()<1 || admin.getRealName() == null){
			return "姓名不能为空";
		}
		if(!RegularExpression.testTel(admin.getTel())){
			return "电话格式不合格";
		}
		List<RolePermissionBean> list = new ArrayList<RolePermissionBean>();
		
		//向登录表中添加普通管理员的相关信息
		String re = ils.addAdmin(admin.getLogin());
		
		if(!re.equals("成功")){
			result = re;
			return result;
		}
		
		result = service.addAdmin(admin);
		if(result.equals("添加失败")){
			return result;
		}
		
		for (String s : limits) {
			int i = Integer.parseInt(s);
			RolePermissionBean bean = new RolePermissionBean();
			bean.setPerId(i);
			bean.setLoginId(admin.getId());
			list.add(bean);
		}
		//将权限封装为array,添加权限
		boolean res = irs.addLimites(list);
		if(!res){
			result = "权限添加失败";
			return result;
		}
		return result;
	}
	/**
	 * 修改管理员权限
	 * @param limits
	 * @param id
	 * @return
	 */
	@RequestMapping("updatePer.do")
	public @ResponseBody String updatePer(String[] limits,Integer id){
		String result = "修改失败";
		if(limits.length == 0 || id == 0){
			return result;
		}
		boolean re = irs.deletePerByAdminId(id);
		if(!re){
			return result;
		}
		List<RolePermissionBean> list = new ArrayList<RolePermissionBean>();
		for (String s : limits) {
			int i = Integer.parseInt(s);
			RolePermissionBean bean = new RolePermissionBean();
			bean.setPerId(i);
			bean.setLoginId(id);
			list.add(bean);
		}
		boolean res = irs.addLimites(list);
		if(!res){
			result = "权限修改失败";
		} else {
			result = "修改成功";
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
		
		if(id == 0){
			return "删除失败";
		}
		String str = service.administratorDelet(id);
		// 向页面传参
		return str;
	}

	/**
	 * 作用：修改电话号
	 * @return  修改结果
	 */
	@ResponseBody
	@RequestMapping("/updateAdminTel.do")
	public String change(AdministratorBean bean){
		String str = "修改失败";
		if(bean.getTel().trim().length()<1){
			return "电话号不能为空";
		}
		if(!RegularExpression.testTel(bean.getTel())){
			return "电话格式不合格";
		}
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
