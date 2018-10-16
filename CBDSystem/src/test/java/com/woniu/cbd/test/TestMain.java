package com.woniu.cbd.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniu.cbd.bean.AdministratorBean;
import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.dao.ICompanyDao;
import com.woniu.cbd.dao.IUserDao;
import com.woniu.cbd.service.impl.AdministratorServiceImpl;

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
