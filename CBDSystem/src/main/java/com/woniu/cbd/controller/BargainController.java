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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.BargainBean;
import com.woniu.cbd.service.IBargainService;
import com.woniu.cbd.service.IOtherParkingService;

@Controller
public class BargainController {
	@Autowired
	private IBargainService service;
	@Autowired
	private IOtherParkingService otherParkingService;
	/**
	 * 添加第三方合约
	 * @param bean
	 * @return
	 */
	@RequestMapping("bargainAdd.do")
	public @ResponseBody String bargainAdd(BargainBean bean,String[] address,
			String[] parkingNumber,String startNumber,String endNumber,double[] price,MultipartFile[] img) {
		String result = "添加失败";
		boolean re = service.bargainAdd(bean);
		if (re) {
			result = "添加成功";
			String[] imgPath = null;
			otherParkingService.addOtherParking(bean, address, parkingNumber, imgPath, price, startNumber, endNumber);
		}
		return result;
	}

	@RequestMapping("bargainDelete.do")
	public @ResponseBody String bargainDelete(Integer id) {
		String result = "删除失败";
		boolean re = service.bargainDelete(id);
		if (re) {
			result = "删除成功";
		}
		return result;
	}
	
	@RequestMapping("bargainUpdate.do")
	public @ResponseBody String bargainUpdate(BargainBean bean) {
		String result = "更改失败";
		boolean re = service.bargainUpdate(bean);
		if (re) {
			result = "更改成功";
		}
		return result;
	}
	/**
	 * 查看第三方合约
	 * @param bean
	 * @param page
	 * @return
	 */
	@RequestMapping("bargainSelect.do")
	public ModelAndView bargainSelect(BargainBean bean,Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page,10,true);
		List<BargainBean> bargain = service.bargainSelect(bean);
		PageInfo<BargainBean> pageInfo = new PageInfo<BargainBean>(bargain);
		
		if(bargain != null){
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list",bargain);
		} else {
			mav.addObject("bargain","尚未签订合约");
		}
		mav.setViewName("views/out_contract_info.jsp");

		return mav;
	}
	/**
	 * 查看所有第三方合约
	 * @param page
	 * @return
	 */
	@RequestMapping("allBargainSelect.do")
	public ModelAndView allBargainSelect(Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page,10,true);
		List<BargainBean> bargain = service.allBargainSelect();
		PageInfo<BargainBean> pageInfo = new PageInfo<BargainBean>(bargain);
		
		if(bargain != null){
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list",bargain);
		} else {
			mav.addObject("allBargain","尚未签订合约");
		}
		mav.setViewName("");

		return mav;
	}
	/**
	 * 查询在用的合约
	 * @param page
	 * @return
	 */
	@RequestMapping("findUseingBargain.do")
	public ModelAndView findUseingBargain(Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page,10,true);
		List<BargainBean> list = service.bargainSelectByState(0);
		PageInfo<BargainBean> pageInfo = new PageInfo<BargainBean>(list);
		
		if(list != null){
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list",list);
		} else {
			mav.addObject("pageinfo","尚未签订合约");
		}
		mav.setViewName("views/out_contract_info.jsp");

		return mav;
	}
	/**
	 * 查看已废弃的合约
	 * @param page
	 * @return
	 */
	@RequestMapping("findUnuseingBargain.do")
	public ModelAndView findUnseingBargain(Integer page) {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page,10,true);
		List<BargainBean> bargain = service.bargainSelectByState(1);
		PageInfo<BargainBean> pageInfo = new PageInfo<BargainBean>(bargain);
		
		if(bargain != null){
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list",bargain);
		} else {
			mav.addObject("unuseingBargain","没有废弃的合约");
		}
		mav.setViewName("views/out_history_contract.jsp");

		return mav;
	}
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(true);  //是否需要严格转化
		
		//使用springmvc封装好的类进行格式转换
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
}
