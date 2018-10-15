package com.woniu.cbd.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.dao.ICompanyDao;
import com.woniu.cbd.dao.IUserDao;
import com.woniu.cbd.dao.impl.CompanyDaoImpl;
import com.woniu.cbd.dao.impl.ComplainDaoImpl;

public class TestMain {
	@Test
	public void test(){
		ComplainBean com = new ComplainDaoImpl().findAllComplain();
		System.out.println(com);
	}
}
