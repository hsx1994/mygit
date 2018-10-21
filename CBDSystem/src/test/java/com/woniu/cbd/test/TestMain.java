package com.woniu.cbd.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.RolePermissionBean;
import com.woniu.cbd.dao.ICompanyInfoDao;
import com.woniu.cbd.dao.IComplainDao;
import com.woniu.cbd.dao.IOtherParkingDao;
import com.woniu.cbd.dao.IRolePermissionDao;
import com.woniu.cbd.dao.impl.CompanyInfoDaoImpl;
import com.woniu.cbd.dao.impl.ComplainDaoImpl;
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
import com.woniu.cbd.service.impl.CompanyBargainServiceImpl;

public class TestMain {
	@Test
	public void test1(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IRolePermissionDao dao = (IRolePermissionDao)context.getBean(IRolePermissionDao.class);
		
		RolePermissionBean bean = new RolePermissionBean();
		bean.setLoginId(5);
		bean.setPerId(5);
		//添加权限
//		boolean boo =dao.addAdministratorLimit(bean);
		//更改权限
		boolean boo =dao.updateAdministratorLimit(bean);
	}

}
