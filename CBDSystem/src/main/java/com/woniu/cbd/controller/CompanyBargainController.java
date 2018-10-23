package com.woniu.cbd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.service.ICompanyBargainService;
import com.woniu.cbd.service.ICompanyInfoService;
import com.woniu.cbd.service.ICompanyOrderService;

@Controller
public class CompanyBargainController {
	@Autowired
	private ICompanyBargainService service;
	@Autowired
	private ICompanyInfoService cis;
	@Autowired
	private ICompanyOrderService orderService;

	@RequestMapping("/companyBargainAdd.do")
	public @ResponseBody String companyBargainAdd(CompanyBargainBean bean,String[] parkingNumber,String[] address) {

		CompanyInfoBean company = cis.findByCompanyName(bean.getCompany().getComName());
		if(company == null){
			return "该企业用户不存在";
		}
		bean.setCompany(company);
		String result = "添加失败";
		boolean re = service.companyBargainAdd(bean);
		if (re) {
			result = "添加成功";
			orderService.addCompanyOrder(bean,parkingNumber);
		}
		return result;
	}

	@RequestMapping("companyBargainDelete.do")
	public @ResponseBody String companyBargainDelete(Integer id) {
		String result = "删除失败";
		boolean re = service.companyBargainDelete(id);
		if (re) {
			result = "删除成功";
		}
		return result;
	}

	@RequestMapping("companyBargainUpdate.do")
	public @ResponseBody String companyBargainUpdate(CompanyBargainBean bean) {
		String result = "更改失败";
		boolean re = service.companyBargainUpdate(bean);
		if (re) {
			result = "更改成功";
		}
		return result;
	}
    //企业查看合约
	@RequestMapping("companyBargainSelect.do")
	public ModelAndView companyBargainSelect(CompanyBargainBean bean) {
		bean.setId(1);
		System.out.println(bean);
		ModelAndView mav = new ModelAndView();
		int page = 1 ;
		PageHelper.startPage(page,10,true);
		List<CompanyBargainBean> bargain = service.companyBargainSelect(bean);
		System.out.println(bargain);
		PageInfo<CompanyBargainBean> pageInfo = new PageInfo<CompanyBargainBean>(bargain);
		System.out.println(pageInfo);
		if(bargain != null){
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list",bargain);
		} else {
			mav.addObject("companBargain","尚未签订合约");
		}
		mav.setViewName("views/tenant_contract_info.jsp");

		return mav;
	}

	@RequestMapping("allCompanyBargainSelect.do")
	public ModelAndView allCompanyBargainSelect() {
		ModelAndView mav = new ModelAndView();
		int page = 1;
		PageHelper.startPage(page,10,true);
		List<CompanyBargainBean> bargain = service.allCompanyBargainSelect();
		PageInfo<CompanyBargainBean> pageInfo = new PageInfo<CompanyBargainBean>(bargain);
		
		if(bargain != null){
			mav.addObject("allCompanyBargain", pageInfo);
			mav.addObject("list",bargain);
		} else {
			mav.addObject("allCompanyBargain","尚未签订合约");
		}
		mav.setViewName("views/tenant_history_contract.jsp");

		return mav;
	}

	@RequestMapping("findUseingCompanyBargain.do")
	public ModelAndView findUseingCompanyBargain(Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page,10,true);
		List<CompanyBargainBean> bargain = service.companyBargainSelectByState(0);
		PageInfo<CompanyBargainBean> pageInfo = new PageInfo<CompanyBargainBean>(bargain);
		
		if(bargain != null){
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list",bargain);
		} else {
			mav.addObject("useingCompanyBargain","尚未签订合约");
		}
		mav.setViewName("views/tenant_contract_info.jsp");
		return mav;
	}

	@RequestMapping("findUnseingCompanyBargain.do")
	public ModelAndView findUnseingCompanyBargain(Integer page) {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page,10,true);
		List<CompanyBargainBean> bargain = service.companyBargainSelectByState(1);
		PageInfo<CompanyBargainBean> pageInfo = new PageInfo<CompanyBargainBean>(bargain);
		
		if(bargain != null){
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list",bargain);
		} else {
			mav.addObject("unuseingCompanyBargain","没有已废弃合约");
		}
		mav.setViewName("views/tenant_history_contract.jsp");

		return mav;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setLenient(false);  //是否需要严格转化
		
		//使用springmvc封装好的类进行格式转换
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
		
	}
	
}
