package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.service.IUserService;

@Controller
public class UserController {
	@Autowired
	private IUserService user;
	
	// 包租婆查看自己的申请记录
	@RequestMapping("/showme.do")
	public String ShowMe(int id) {
		List<ParkingBean> bean = user.ShowMe(id);
		if(bean !=null){
			System.out.println("查询成功");
			return "";
		}else{
			System.out.println("查询为空");
			return "";
		}
		

	}

	// 包租婆查看自己的被租赁记录
	@RequestMapping("/selectlog.do")
	public String SelectLog(int id) {
		List<ParkingBean> bean = user.SelectLog(id);
		return null;

	}
	//抢租客查看租赁记录
	@RequestMapping("/showlog.do")
	public String ShowLog(int id){
		List<OrderBean>bean=user.ShowLog(id);
		return null;
		
	}
}
