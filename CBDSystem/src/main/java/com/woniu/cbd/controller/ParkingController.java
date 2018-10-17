package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.ModelAndView;

import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.service.IParkingService;

@Controller
public class ParkingController {
	@Autowired
	private IParkingService park;

	// 包租婆批量添加车位信息
	@RequestMapping("/application.do")
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
	@RequestMapping("/showall.do")
	public ModelAndView ShowAll() {
		ModelAndView mav = new ModelAndView();
		List<ParkingBean> bean = park.ShowAll();
		
		if (bean != null) {
//			System.out.println("查询到车位");
			mav.addObject("all", bean);
			mav.setViewName("063/ShowParkingSpace.jsp");
//			System.out.println("id="+bean.size());
		} else {
//			System.out.println("满足条件的为空");
			mav.addObject("查询为空");
			mav.setViewName("");

		}
		return mav;

	}

	// 抢租客查看单个上架车位
	@RequestMapping("/showOne.do")
	public ModelAndView ShowOne(Integer id) {
		ModelAndView mav = new ModelAndView();
		System.out.println("id="+id);
		ParkingBean bean = park.SelectParkOne(id);
		if (bean != null) {
			System.out.println("查询到车位");
			mav.addObject("one", bean);
			mav.setViewName("063/Details.jsp");

		} else {
			System.out.println("满足条件的为空");
			mav.addObject("空");
			mav.setViewName("");

		}
		return mav;

	}

	// 抢租客车位号模糊查询上架车位
	@RequestMapping("/findbynum.do")
	public ModelAndView SelectParkByNum(String num) {
		ModelAndView mav = new ModelAndView();
		List<ParkingBean> bean = park.SelectParkByNum(num);
		if (bean != null) {
			System.out.println("查询到车位");
			mav.addObject("num", bean);
			mav.setViewName("");

		} else {
			System.out.println("满足条件的为空");
			mav.addObject("空");
			mav.setViewName("");

		}
		return mav;

	}

	// 抢租客根据价格查询上架车位
	@RequestMapping("/findbyprice.do")
	public ModelAndView SelectPark(Integer price) {
		ModelAndView mav = new ModelAndView();
		List<ParkingBean> bean = park.SelectPark(price);
		if (bean != null) {
			System.out.println("查询到车位");
			mav.addObject("price", bean);
			mav.setViewName("");
		} else {
			System.out.println("满足条件的为空");
			mav.addObject("空");
			mav.setViewName("");
		}
		return mav;

	}

	@RequestMapping("/15.do")
	public @ResponseBody String parkingDelete(Integer id) {
		String result = "删除失败";
		boolean re = park.parkingDelete(id);
		if (re) {
			result = "删除成功";
		}

		return result;
	}

	@RequestMapping("/16.do")
	public ModelAndView parkingSelect() {
		ModelAndView mav = new ModelAndView();
		List<ParkingBean> list = park.parkingSelect();
		mav.addObject("allParking", list);
		mav.setViewName("");
		return mav;
	}

	@RequestMapping("/17.do")
	public @ResponseBody String passApply(Integer id) {
		String result = "通过失败";
		boolean re = park.passApply(id);
		if (re) {
			result = "通过成功";
		}

		return result;
	}

	@RequestMapping("/18")
	public @ResponseBody String passApplyFail(Integer id) {
		String result = "失败";
		boolean re = park.passApplyFail(id);
		if (re) {
			result = "成功";
		}

		return result;
	}
}
