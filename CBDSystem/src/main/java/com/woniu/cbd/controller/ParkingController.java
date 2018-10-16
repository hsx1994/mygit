package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.service.IParkingService;
import com.woniu.cbd.service.IUserService;

@Controller
public class ParkingController {
	@Autowired
	private IParkingService park;

	@Autowired
	private IUserService user;

	// 包租婆批量添加车位信息
	@RequestMapping("/application.do")
	public String ApplicationPark(List<ParkingBean> parking) {
		boolean num = park.AddPark(parking);
		if (num) {
			System.out.println("包租婆添加车位成功");
			return "xxx.jsp";

		} else {
			System.out.println("包租婆添加车位失败");
			return "xxx.jsp";

		}

	}

	// 包租婆查看自己的申请记录
	@RequestMapping("/showme.do")
	public String ShowMe(int id) {
		List<ParkingBean> bean = user.ShowMe(id);
		return null;

	}

	// 包租婆查看自己的被租赁记录
	@RequestMapping("/selectlog.do")
	public String SelectLog(int id) {
		List<ParkingBean> bean = user.SelectLog(id);
		return null;

	}
	

	@RequestMapping("/15")
	public @ResponseBody String parkingDelete(Integer id){
		String result = "删除失败";
		boolean re = park.parkingDelete(id);
		if(re){
			result = "删除成功";
		}
		
		return result;
	}
	
	@RequestMapping("/16.do")
	public ModelAndView parkingSelect(){	
		ModelAndView mav = new ModelAndView();
		List<ParkingBean> list = park.parkingSelect();
		mav.addObject("allParking",list);
		mav.setViewName("jsp/register.jsp");
		System.out.println(list.size());
		return mav;
	}
	
	@RequestMapping("/17")
	public @ResponseBody String passApply(Integer id){
		String result = "通过失败";
		boolean re = park.passApply(id);
		if(re){
			result = "通过成功";
		}
		
		return result;
	}

	@RequestMapping("/18")
	public @ResponseBody String passApplyFail(Integer id){
		String result = "失败";
		boolean re = park.passApplyFail(id);
		if(re){
			result = "成功";
		}
		
		return result;
	}
}
