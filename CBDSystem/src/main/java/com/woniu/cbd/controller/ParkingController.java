package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.service.IParkingService;

@Controller
public class ParkingController {
	@Autowired
	private IParkingService park;

	// 包租婆批量添加车位信息
	@RequestMapping("application.do")
	public @ResponseBody String ApplicationParking(List<ParkingBean> parking) {
		boolean num = park.AddParking(parking);
		String result = "失败";
		if (num) {
			System.out.println("包租婆添加车位成功");
			result = "成功";

		}
		return result;

	}

	// 抢租客查看所有上架车位
	@RequestMapping("showall.do")
	public ModelAndView ShowAll(Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page,10,true);
		List<ParkingBean> bean = park.ShowAll();
		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);
		
		mav.addObject("pageinfo",pageInfo);
		mav.addObject("list",bean);
		mav.setViewName("");
		
		return mav;

	}

	// 抢租客查看单个上架车位
	@RequestMapping("showOne.do")
	public ModelAndView ShowOne(Integer id) {
		ModelAndView mav = new ModelAndView();
		ParkingBean bean = park.SelectParkOne(id);
		
		mav.addObject("one",bean);
		mav.setViewName("");

		return mav;

	}

	// 抢租客车位号模糊查询上架车位
	@RequestMapping("findbynum.do")
	public ModelAndView SelectParkByNum(String num,Integer page) {
		ModelAndView mav = new ModelAndView();
		List<ParkingBean> bean = park.SelectParkByNum(num);
		if (bean != null) {
			mav.addObject("num",bean);
			mav.setViewName("");
		} else {
			mav.addObject("空");
			mav.setViewName("");
		}
		return mav;

	}

	// 抢租客根据价格查询上架车位
	@RequestMapping("findbyprice.do")
	public ModelAndView SelectPark(Integer price,Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page,10,true);
		List<ParkingBean> bean = park.SelectPark(price);
		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);
		
		if (bean != null) {
			mav.addObject("price",pageInfo);
			mav.addObject("list",bean);
		} else {
			mav.addObject("空");
		}
		mav.setViewName("");
		return mav;

	}

	@RequestMapping("parkingDelete.do")
	public @ResponseBody String parkingDelete(Integer id) {
		String result = "删除失败";
		boolean re = park.parkingDelete(id);
		if (re) {
			result = "删除成功";
		}

		return result;
	}

	@RequestMapping("parkingSelect.do")
	public ModelAndView parkingSelect(Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page,10,true);
		List<ParkingBean> list = park.parkingSelect();
		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(list);
		
		mav.addObject("pageinfo", pageInfo);
		mav.addObject("list",list);
		mav.setViewName("views/landlord_carpart_apply.jsp");

		return mav;
	}

	@RequestMapping("passApply.do")
	public @ResponseBody String passApply(Integer id) {
		String result = "通过失败";
		boolean re = park.passApply(id);
		if (re) {
			result = "通过成功";
		}

		return result;
	}

	@RequestMapping("passApplyFail.do")
	public @ResponseBody String passApplyFail(Integer id) {
		String result = "失败";
		boolean re = park.passApplyFail(id);
		if (re) {
			result = "成功";
		}

		return result;
	}
}
