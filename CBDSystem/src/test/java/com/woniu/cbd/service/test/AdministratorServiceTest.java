package com.woniu.cbd.service.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniu.cbd.bean.AdministratorBean;
import com.woniu.cbd.service.impl.AdministratorServiceImpl;

/**
 * 对administratorServiceImpl的service层各种功能进行测试
 * 
 * @author wt
 *
 */
public class AdministratorServiceTest {

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

	/**
	 * 功能：测试修改普通管理员权限功能
	 */
	@Test
	public void showAdministratorTest() {

		// 指定配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// 获取 接口bean
		AdministratorServiceImpl dao = (AdministratorServiceImpl) context
				.getBean("administratorServiceImpl");
		AdministratorBean bean = new AdministratorBean();
		bean.setLimit(6);
		bean.setId(26);
		String boo = dao.administratorLimitChange(bean);
		System.out.println(boo + "kbkjndf");

	}

	/**
	 * 功能：测试删除普通管理员账号功能
	 */
	@Test
	public void administratorDeletTest() {

		// 指定配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// 获取 接口bean
		AdministratorServiceImpl dao = (AdministratorServiceImpl) context
				.getBean("administratorServiceImpl");
		String boo = dao.administratorDelet(25);
		System.out.println(boo + "kbkjndf");

	}

	/**
	 * 功能：测试添加普通管理员详细信息账号功能
	 */
	@Test
	public void administratorRegisterTest() {

		// 指定配置文件
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		// 获取 接口bean
		AdministratorServiceImpl dao = (AdministratorServiceImpl) context
				.getBean("administratorServiceImpl");
		AdministratorBean ab = new AdministratorBean();
		ab.setLid(2);
		ab.setJobNumber("111111");
		ab.setName("小九");
		ab.setTel("1111111");
		String boo = dao.administratorRegister(ab);
		System.out.println(boo + "kbkjndf");

	}

}
