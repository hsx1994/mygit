package com.woniu.cbd.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.dao.IOtherParkingDao;
import com.woniu.cbd.service.IOrderService;


public class TestMain {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IOrderService dao = (IOrderService) context.getBean("orderServiceImpl");
		List<OrderBean> list = dao.findOrderByState(1, 1);
		for (OrderBean orderBean : list) {
			System.out.println(orderBean.getId());
		}
	}
}
