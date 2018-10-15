package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.service.IParkService;
import com.woniu.cbd.service.IUserService;

@Controller
public class ParkController {
	@Autowired
	private IParkService park;

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

}
