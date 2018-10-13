package com.woniu.cbd.dao.test;

import org.junit.Test;

import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.bean.SuperAdministratorBean;
import com.woniu.cbd.dao.ISuperAdministratorDao;
import com.woniu.cbd.dao.impl.SuperAdministratorDaoImpl;

public class SuperAdministratorDaoTest {
	
	/**
	 *描述： 超級管理员登录查询测试（对通过账号和密码查询超级管理员信息）
	 */
	@Test
	public void test1() {
		LoginBean lb = new LoginBean();
		lb.setName("超级管理员");
		lb.setPassword("123456");
		ISuperAdministratorDao dao = new SuperAdministratorDaoImpl();
		SuperAdministratorBean bean = dao.findAll(lb);
		System.out.println(bean.getRealName());

	}

}
