package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.service.IParkService;

@Controller
public class ApplicationParkAction {
	@Autowired
	private IParkService service;
	
	@RequestMapping("/application.do")
	public String ApplicationPark(List<ParkingBean> park){
		boolean i=service.AddPark(park);
		return null;
		
	}

}
