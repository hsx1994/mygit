package com.woniu.cbd.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.CompanyOrderBean;
import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.controller.ComplainController;
import com.woniu.cbd.dao.ICompanyDao;
import com.woniu.cbd.dao.ICompanyOrderDao;
import com.woniu.cbd.dao.IComplainDao;
import com.woniu.cbd.dao.IParkingDao;
import com.woniu.cbd.dao.IUserDao;
import com.woniu.cbd.dao.impl.CompanyDaoImpl;
import com.woniu.cbd.dao.impl.ComplainDaoImpl;

public class TestMain {
	
	/**
	 * 后台分页插件，分页测试
	 */
	@Test
	public void pageTest(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IComplainDao dao= context.getBean(ComplainDaoImpl.class);
		//设置分页处理 (第1页，每页显示3个，必须写在sql语句之前，不然分页不能生效，true可以省略)
		PageHelper.startPage(1,3,true);
		
		List<ComplainBean> list = dao.findAllComplain();
		for (ComplainBean complainBean : list) {
			System.out.println(complainBean.getContent());
		}
		//取分页信息,需要填入你查询出的集合
		PageInfo<ComplainBean> pageInfo = new PageInfo<ComplainBean>(list);
		//pageInfo.getList()：得到分页查询出来的对象集合
		List<ComplainBean> li = pageInfo.getList();
		//遍历得到每个对象
		for (ComplainBean complainBean : li) {
			System.out.println(complainBean);
		}
		//查看pageInfo信息
		System.out.println(pageInfo);
	}

}


