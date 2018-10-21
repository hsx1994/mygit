package com.woniu.cbd.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniu.cbd.service.IBargainService;
import com.woniu.cbd.service.impl.BargainServiceImpl;

public class TestMain {
	@Test
	public void test(){
	ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	IBargainService service = context.getBean("bargainServiceImpl",BargainServiceImpl.class);
	boolean re = service.bargainDelete(1);
	System.out.println(re);
	}
}
