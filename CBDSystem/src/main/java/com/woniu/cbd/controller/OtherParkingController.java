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
import com.woniu.cbd.bean.OtherParkingBean;
import com.woniu.cbd.service.IOtherParkingService;

@Controller
public class OtherParkingController {

	@Autowired
	private IOtherParkingService service;

	@RequestMapping("/otherParkingAdd.do")
	public @ResponseBody String otherParkingAdd(List<OtherParkingBean> list) {
		String result = "添加失败";
		boolean re = service.otherParkingAdd(list);
		if (re) {
			result = "添加成功";
		}

		return result;
	}

	@RequestMapping("otherParkingDelete.do")
	public @ResponseBody String otherParkingDelete(Integer[] id) {
		String result = "删除失败";
		boolean re = service.otherParkingDelete(id);
		if (re) {
			result = "删除成功";
		}
		return result;
	}

	@RequestMapping("otherParkingSelect.do")
	public ModelAndView otherParkingSelect(OtherParkingBean bean) {
		ModelAndView mav = new ModelAndView();
		OtherParkingBean parking = service.otherParkingSelect(bean);
		mav.addObject("otherParking", parking);
		mav.setViewName("");

		return mav;
	}

	@RequestMapping("allOtherParkingSelect.do")
	public ModelAndView allOtherParkingSelect(Integer page) {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page, 10, true);
		List<OtherParkingBean> parking = service.allOtherParkingSelect();
		PageInfo<OtherParkingBean> pageInfo = new PageInfo<OtherParkingBean>(parking);

		mav.addObject("pageinfo", pageInfo);
		mav.addObject("list", parking);
		mav.setViewName("views/cbd_carport.jsp");

		return mav;
	}

	// 企业查看自己的所有车位
	@RequestMapping("showCompanyParkingAll.do")
	public ModelAndView showComPanyParkingAll(Integer id, Integer page) {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page, 8, true);
		List<OtherParkingBean> parking = service.showCompanyParkingAll(id);
		PageInfo<OtherParkingBean> pageInfo = new PageInfo<OtherParkingBean>(parking);
		mav.addObject("pageinfo", pageInfo);
		mav.addObject("list", parking);
		mav.setViewName("views/cbd_carport.jsp");

		return mav;
	}

	// 企业查看自己的单个车位
	@RequestMapping("showCompanyParkingById.do")
	public ModelAndView showCompanyParkingById(Integer id) {
		ModelAndView mav = new ModelAndView();
		OtherParkingBean bean = service.showCompanyParkingById(id);
		mav.addObject("companyPark", bean);
		mav.setViewName("");
		return mav;
	}
	
	// 车位区域信息
	@RequestMapping("/showAddress.do")
	public @ResponseBody List<String> showParkingAddress() {
		List<String> list = service.findAddressByGroup();
		return list;
	}

	/**
	 * 查找某区域车位的所有编号
	 * @return
	 */
	@RequestMapping("/showParkingNumber.do")
	public @ResponseBody List<String> showParkingNumber(String address) {
		List<String> list = service.findParkingNumberByAddress(address);
		return list;
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {

		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setLenient(false);  //是否需要严格转化
		
		//使用springmvc封装好的类进行格式转换
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
}
