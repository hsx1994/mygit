package com.woniu.cbd.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.OtherParkingBean;
import com.woniu.cbd.dao.ICompanyBargainDao;
import com.woniu.cbd.dao.IOtherParkingDao;
import com.woniu.cbd.service.ICompanyBargainService;
import com.woniu.cbd.service.ICompanyOrderService;
import com.woniu.cbd.service.IOtherParkingService;
import java.util.List;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.util.ByteSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniu.cbd.bean.AdministratorBean;
import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.dao.impl.LoginDaoImpl;
import com.woniu.cbd.service.impl.AdministratorServiceImpl;
import com.woniu.cbd.service.impl.LoginServiceImpl;

public class TestMain {
	
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IOtherParkingDao dao = (IOtherParkingDao) context.getBean("otherParkingDaoImpl");
	}

	@Test
	public void check() {
		System.out.println("在LoginRealm中，即将查询数据库：");
		LoginServiceImpl loginService = (LoginServiceImpl) new LoginServiceImpl();
		LoginBean loginUser = loginService.getLoginUserByName("admin");
		System.out.println("在LoginRealm中，数据库查询完毕：loginUser=" + loginUser);
	}

	/**
	 * 功能：测试展示普通管理员所有信息功能
	 */
	@Test
	public void test1() {
		LoginBean loginUser = null;
		// 指定配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		// 获取 接口bean
		LoginServiceImpl loginService = (LoginServiceImpl) context.getBean("loginServiceImpl");
		System.out.println("在LoginRealm中，即将查询数据库：");
		loginUser = loginService.getLoginUserByName("admin");	
		System.out.println("在LoginRealm中，数据库查询完毕：loginUser=" + loginUser);
	}
	
	
	/**
	 * 功能：测试展示普通管理员所有信息功能
	 */
	@Test
	public void tes2t() {
		List<AdministratorBean> list = null;
		//
		// 指定配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		// 获取 接口bean
		AdministratorServiceImpl dao = (AdministratorServiceImpl) context.getBean("administratorServiceImpl");
		
		list = dao.showAdministrator();
		System.out.println(list.size() + "kbkjndf");

	}

}
