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
	private IParkingService service;
	
	@RequestMapping("/15")
	public @ResponseBody String parkingDelete(Integer id){
		String result = "删除失败";
		boolean re = service.parkingDelete(id);
		if(re){
			result = "删除成功";
		}
		
		return result;
	}
	
	@RequestMapping("/16")
	public ModelAndView parkingSelect(){
		ModelAndView mav = new ModelAndView();
		List<ParkingBean> list = service.parkingSelect();
		mav.addObject("allParking",list);
		mav.setViewName("");
		
		return mav;
	}
	
	@RequestMapping("/17")
	public @ResponseBody String passApply(Integer id){
		String result = "通过失败";
		boolean re = service.passApply(id);
		if(re){
			result = "通过成功";
		}
		
		return result;
	}

	@RequestMapping("/18")
	public @ResponseBody String passApplyFail(Integer id){
		String result = "失败";
		boolean re = service.passApplyFail(id);
		if(re){
			result = "成功";
		}
		
		return result;
	}
}
