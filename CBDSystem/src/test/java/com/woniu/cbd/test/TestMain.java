package com.woniu.cbd.test;

import java.util.Date;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.service.ICompanyBargainService;
import com.woniu.cbd.service.impl.CompanyBargainServiceImpl;

public class TestMain {
	
	/**
	 * 后台分页插件，分页测试
	 */
	@Test
	public void pageTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ICompanyBargainService service= context.getBean(CompanyBargainServiceImpl.class);
		CompanyBargainBean bean = new CompanyBargainBean();
		CompanyInfoBean company = new CompanyInfoBean();
		company.setId(1);
		bean.setTel("123456");
		bean.setStartTime(new Date());
		bean.setNumber("qqq111");
		bean.setEndTime(new Date());
		bean.setImg("复印件");
		bean.setContact("王小二");
		bean.setCompany(company);
		boolean re = service.companyBargainAdd(bean);
		System.out.println(re);
		
	}

}


