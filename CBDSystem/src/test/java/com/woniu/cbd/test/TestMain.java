package com.woniu.cbd.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniu.cbd.dao.IOtherParkingDao;



public class TestMain {

	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IOtherParkingDao dao = (IOtherParkingDao) context.getBean("otherParkingDaoImpl");
		List<String> list = dao.findAddressByGroup();
		for (String string : list) {
			System.out.println(string);
		}
	}
}


