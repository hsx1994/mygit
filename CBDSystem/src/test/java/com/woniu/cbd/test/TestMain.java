package com.woniu.cbd.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.dao.IOtherParkingDao;
import com.woniu.cbd.service.IOrderService;
import com.woniu.cbd.service.IUserService;
import com.woniu.cbd.service.impl.LoginServiceImpl;


public class TestMain {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		IUserService userService = (IUserService) context.getBean("userServiceImpl");
//		UserBean user = userService.findUserInfo(1);
//		user.setOrderCount(user.getOrderCount()+1);
//		userService.updateUser(user);
		
		LoginServiceImpl loginService = ( LoginServiceImpl) context.getBean("loginServiceImpl");
		System.out.println(loginService.getLoginUserByName("zhangsan"));
	}
}
