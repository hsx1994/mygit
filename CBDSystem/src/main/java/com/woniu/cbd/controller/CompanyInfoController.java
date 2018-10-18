package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.service.ICompanyInfoService;

/**
 * 企业信息（用户后台管理员查询企业相关信息）
 * @author Administrator
 *
 */
@Controller
public class CompanyInfoController {
	
	private ICompanyInfoService service;
	/**
	 * 查询所有企业信息
	 * @return
	 */
	@RequestMapping("showAllCompany.do")
	public ModelAndView showAllCompany(Integer page){
		
		System.out.println(page);
		ModelAndView mv = new ModelAndView();
		//设置分页处理 (第page页，每页显示10个，必须写在sql语句之前，不然分页不能生效，true可以省略)
		PageHelper.startPage(page,10,true);
		List<CompanyInfoBean> list = service.showAllCompany();
		//取分页信息,需要填入你查询出的集合
		PageInfo<CompanyInfoBean> pageInfo = new PageInfo<CompanyInfoBean>(list);
		mv.addObject("pageinfo",pageInfo);
		System.out.println(pageInfo);
		/*mv.setViewName("views.complain_info.html");*/
		return mv;
		
		
	}
	/**
	 * 按条件搜索企业信息
	 * @param condition
	 * @return
	 */
	@RequestMapping("queryCompany.do")
	public ModelAndView queryCompanyByCondition(Integer page,String condition){
		
		System.out.println(condition);
		
		ModelAndView mv = new ModelAndView();
		//设置分页处理 (第page页，每页显示10个，必须写在sql语句之前，不然分页不能生效，true可以省略)
		PageHelper.startPage(page,10,true);
		List<CompanyInfoBean> list = service.showAllCompany();
		//取分页信息,需要填入你查询出的集合
		PageInfo<CompanyInfoBean> pageInfo = new PageInfo<CompanyInfoBean>(list);
		mv.addObject("pageinfo",pageInfo);
		System.out.println(pageInfo);
		/*mv.setViewName("views.complain_info.html");*/
		return mv;
		
		
	}
}
