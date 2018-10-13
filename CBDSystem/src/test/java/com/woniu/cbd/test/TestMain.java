package com.woniu.cbd.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.service.IOrderService;

public class TestMain {
	@Test
	public void findOrder() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IOrderService  service= (IOrderService) context.getBean("orderServiceImpl");
		OrderBean order = new OrderBean();
		order.setUserId(1);
		order.setParkingId(1);
		Date startTime = null;
		Date endTime = null;
		try {
			startTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-10-11 11:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			endTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse("2018-10-11 14:00:00");
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		order.setStartTime(startTime);
		order.setEndTime(endTime);
		System.out.println(service.privateOrder(order));
	}
}
