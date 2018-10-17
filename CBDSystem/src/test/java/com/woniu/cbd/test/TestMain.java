package com.woniu.cbd.test;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




import com.woniu.cbd.bean.AdministratorBean;
import com.woniu.cbd.bean.BargainBean;
import com.woniu.cbd.service.IBargainService;
import com.woniu.cbd.service.IParkingService;
import com.woniu.cbd.service.impl.AdministratorServiceImpl;
import com.woniu.cbd.service.impl.BargainServiceImpl;


public class TestMain {

	/**
	 * 功能：测试展示普通管理员所有信息功能
	 */
	@Test
	public void test() {
		List<AdministratorBean> list = null;
		//
		// 指定配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// 获取 接口bean
		AdministratorServiceImpl dao = (AdministratorServiceImpl) context
				.getBean("administratorServiceImpl");
		list = dao.showAdministrator();
		System.out.println(list.size() + "kbkjndf");

	}



}
