package com.woniu.cbd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.CompanyOrderBean;
import com.woniu.cbd.service.ICompanyBargainService;
import com.woniu.cbd.service.ICompanyInfoService;
import com.woniu.cbd.service.ICompanyOrderService;
import com.woniu.cbd.util.FileUpUtil;
import com.woniu.cbd.util.RegularExpression;

@Controller
public class CompanyBargainController {
	@Autowired
	private ICompanyBargainService service;
	@Autowired
	private ICompanyInfoService cis;
	@Autowired
	private ICompanyOrderService orderService;

	@RequestMapping("/companyBargainAdd.do")
	public @ResponseBody String companyBargainAdd(HttpServletRequest request,CompanyBargainBean bean,String[] parkingNumber,String[] address,
			@RequestParam(value="barginCopy", required=true) MultipartFile[] barginCopy) {
		if(bean.getContact() == null || bean.getEndTime() == null || bean.getImg() == null ||
				bean.getNumber() == null || bean.getStartTime() == null || bean.getTel() == null ||
				parkingNumber == null || address == null){
			return "输入不能为空";
		}
		if(bean.getContact().trim().length() < 1 || bean.getImg().length() < 1 ||
				bean.getNumber().trim().length() < 1 || bean.getTel().trim().length() < 1 ||
				parkingNumber.length < 1 || address.length < 1){
			return "输入不能为空字符";
		}
		int row = bean.getStartTime().compareTo(bean.getEndTime());
		if(row >= 0){
			return "开始时间不能在结束时间之后";
		}
			
		CompanyInfoBean company = cis.findByCompanyName(bean.getCompany().getComName());
		if(company == null){
			return "该企业用户不存在";
		}
		if(!RegularExpression.testTel(bean.getTel())){
			return "联系人电话格式不合格";
		}
		bean.setCompany(company);
		bean.setImg(FileUpUtil.fileUpUtil(barginCopy, request, "/images/bargain").get(0));
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
	public ModelAndView companyBargainSelect(Integer id,Integer page) {
		
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(page,10,true);
		List<CompanyBargainBean> bargain = service.companyBargainSelect(id);
		PageInfo<CompanyBargainBean> pageInfo = new PageInfo<CompanyBargainBean>(bargain);
		if(bargain != null){
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list",bargain);
		} else {
			mav.addObject("companBargain","尚未签订合约");
		}
		mav.setViewName("jsp/LookThreeUser.jsp");
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
	
	/**
	 * 根据条件查询执行中合约
	 * @param page
	 * @param condition
	 * @return
	 */
	@RequestMapping("queryUseingBargain.do")
	public ModelAndView queryUseingBargainByCondition(Integer page,String condition){
		ModelAndView mv = new ModelAndView();
		if(condition!=null){
			PageHelper.startPage(page,10,true);
			List<CompanyBargainBean>  list = service.queryUseingBarginByCondition(condition);
			PageInfo<CompanyBargainBean> pageInfo = new PageInfo<CompanyBargainBean>(list);
			mv.addObject("condition", condition);
			mv.addObject("pageinfo",pageInfo);
			mv.addObject("list",list);
			mv.setViewName("views/tenant_contract_info.jsp");
		}
		
		return mv;
		
	}
	
	/**
	 * 根据条件查询历史合约
	 * @param page
	 * @param condition
	 * @return
	 */
	@RequestMapping("queryHistoryBargain.do")
	public ModelAndView queryHistoryBargainByCondition(Integer page,String condition){
		ModelAndView mv = new ModelAndView();
		if(condition!=null){
			PageHelper.startPage(page,10,true);
			List<CompanyBargainBean>  list = service.queryHistoryBargainByCondition(condition);
			PageInfo<CompanyBargainBean> pageInfo = new PageInfo<CompanyBargainBean>(list);
			mv.addObject("condition", condition);
			mv.addObject("pageinfo",pageInfo);
			mv.addObject("list",list);
			mv.setViewName("views/tenant_history_contract.jsp");
		}
		
		return mv;
		
	}
	/**
	 * 显示企业合约详情
	 * @param id
	 * @return
	 */
	@RequestMapping("showCompanyBargainDetails.do")
	public ModelAndView showCompanyBargainDetails(int id){
		
		ModelAndView mv = new ModelAndView();
		CompanyBargainBean bean = service.showCompanyBargainDetails(id);
		List<CompanyOrderBean>  list = bean.getComOrder();
		String num = "";
		for (int i = 0; i < list.size(); i++) {
			if(i==0){
				num=list.get(i).getOtherParking().getParkingNum();
				continue;
			}
			num+="、"+list.get(i).getOtherParking().getParkingNum();
		}
		mv.addObject("carNum", num);
		mv.addObject("comBargain",bean);
		mv.setViewName("views/tenant_contract_detail.jsp");
		return mv;
		
	}
	
	/**
	 * 企业（租户）续约详情
	 * @param id
	 * @return
	 */
	@RequestMapping("tenantContractEextension.do")
	public ModelAndView tenantContractEextension(int id){
		ModelAndView mv = new ModelAndView();
		CompanyBargainBean bean = service.showCompanyBargainDetails(id);
		List<CompanyOrderBean>  list = bean.getComOrder();
		String num = "";
		for (int i = 0; i < list.size(); i++) {
			if(i==0){
				num=list.get(i).getOtherParking().getParkingNum();
				continue;
			}
			num+="、"+list.get(i).getOtherParking().getParkingNum();
		}
		mv.addObject("carNum", num);
		mv.addObject("comBargain",bean);
		mv.setViewName("views/tenant_contract_extension.jsp");
		return mv;
		
	}
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setLenient(true);  //是否需要严格转化
		
		//使用springmvc封装好的类进行格式转换
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
		
	}
	
}
