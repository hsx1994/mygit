package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.service.ICompanyInfoService;
/**
 * 企业信息（用户后台管理员查询、新增企业）
 * @author Administrator
 *
 */
@Controller
public class CompanyInfoController {
	
	@Autowired
	private ICompanyInfoService comService;
	/**
	 * 查询所有企业信息
	 * @return
	 */
	@RequestMapping("showAllCompany.do")
	public ModelAndView showAllCompany(Integer page){
		ModelAndView mv = new ModelAndView();
		
		//设置分页处理 (第page页，每页显示10个，必须写在sql语句之前，不然分页不能生效，true可以省略)
		PageHelper.startPage(page,10,true);
		List<CompanyInfoBean> list = comService.showAllCompany();
		//取分页信息,需要填入你查询出的集合
		PageInfo<CompanyInfoBean> pageInfo = new PageInfo<CompanyInfoBean>(list);
		
		if(list != null){
			mv.addObject("pageinfo",pageInfo);
			mv.addObject("list",list);
		}
		mv.setViewName("views/company_info.jsp");
		return mv;
		
		
	}
	/**
	 * 按条件搜索企业信息
	 * @param condition
	 * @return
	 */
	@RequestMapping("queryCompany.do")
	public ModelAndView queryCompanyByCondition(Integer page,String condition){
		ModelAndView mv = new ModelAndView();
		if(condition!=null){
			//设置分页处理 (第page页，每页显示10个，必须写在sql语句之前，不然分页不能生效，true可以省略)
			PageHelper.startPage(page,10,true);
			List<CompanyInfoBean> list = comService.queryCompany(condition);
			//取分页信息,需要填入你查询出的集合
			PageInfo<CompanyInfoBean> pageInfo = new PageInfo<CompanyInfoBean>(list);
			mv.addObject("condition", condition);
			mv.addObject("pageinfo",pageInfo);
			mv.addObject("list",list);
			mv.setViewName("views/company_info.jsp");
		}
		
		return mv;
	}
	/**
	 * 新增企业
	 * @param company
	 * @param loginBean
	 * @return
	 */
	@ResponseBody
	@RequestMapping("addCompany.do")
	public String addCompany(CompanyInfoBean company,LoginBean loginBean,String repwd){
		
		ModelAndView mv = new ModelAndView();
	
		String result = comService.addCompanyInfo(company,loginBean);
		mv.addObject("result", result);
		
		return result;
	}
	// 车位区域信息
	@RequestMapping("/showCompany.do")
	public @ResponseBody List<CompanyInfoBean> showParkingAddress() {
		List<CompanyInfoBean> list = comService.showAllCompany();
		return list;
	}
	@RequestMapping("/findCompany.do")
	public @ResponseBody CompanyInfoBean findById(Integer id){
		CompanyInfoBean bean = comService.findById(id);
		return bean;
	}
}
