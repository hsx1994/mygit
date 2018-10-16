package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.cbd.bean.OtherParkingBean;
import com.woniu.cbd.service.IOtherParkingService;

@Controller
public class OtherParkingController {

	@Autowired
	private IOtherParkingService service;

	@RequestMapping("/11")
	public @ResponseBody String otherParkingAdd(List<OtherParkingBean> list) {
		String result = "添加失败";
		boolean re = service.otherParkingAdd(list);
		if (re) {
			result = "添加成功";
		}

		return result;
	}

	@RequestMapping("/12")
	public @ResponseBody String otherParkingDelete(Integer[] id) {
		String result = "删除失败";
		boolean re = service.otherParkingDelete(id);
		if (re) {
			result = "删除成功";
		}
		return result;
	}

	@RequestMapping("/13")
	public ModelAndView otherParkingSelect(OtherParkingBean bean) {
		ModelAndView mav = new ModelAndView();
		OtherParkingBean parking = service.otherParkingSelect(bean);
		mav.addObject("otherParking", parking);
		mav.setViewName("");

		return mav;
	}

	@RequestMapping("/14")
	public ModelAndView allOtherParkingSelect() {
		ModelAndView mav = new ModelAndView();
		List<OtherParkingBean> parking = service.allOtherParkingSelect();
		mav.addObject("allOtherParking", parking);
		mav.setViewName("");

		return mav;
	}

	// 企业查看自己的所有车位
	@RequestMapping("/9.do")
	public ModelAndView showComPanyParkingAll(Integer id) {
		ModelAndView mav = new ModelAndView();
		List<OtherParkingBean> parking = service.showCompanyParkingAll(id);
		mav.addObject("companyParking", parking);
		mav.setViewName("");

		return mav;
	}

	// 企业查看自己的单个车位
	@RequestMapping("/999")
	public ModelAndView showCompanyParkingById(Integer id) {
		ModelAndView mav = new ModelAndView();
		OtherParkingBean bean = service.showCompanyParkingById(id);
		mav.addObject("companyPark", bean);
		mav.setViewName("");
		return mav;
	}
}
