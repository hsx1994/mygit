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
import com.woniu.cbd.dao.IParkDao;
import com.woniu.cbd.dao.IUserDao;

public class TestMain {

	//查看所有的车位
	@Test
	public void test1(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IParkDao dao = (IParkDao) context.getBean("parkDaoImpl");
		List<ParkingBean> bean=dao.ShowAll();
	    System.out.println(bean);
		
	}
	//根据价格查询个人车位
	@Test
	public void test2(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IParkDao dao = (IParkDao) context.getBean("parkDaoImpl");
		List<ParkingBean> bean=dao.SelectPark(15);
	    System.out.println(bean);
		
	}
	//查询单个车位和车位号
	@Test
	public void test8(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IParkDao dao = (IParkDao) context.getBean("parkDaoImpl");
		List<ParkingBean> bean=dao.SelectParkByNum("952");
	    System.out.println(bean);
		
	}
	//根据车位id查询单个车位
		@Test
		public void test9(){
			@SuppressWarnings("resource")
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			IParkDao dao = (IParkDao) context.getBean("parkDaoImpl");
			ParkingBean bean=dao.SelectParkOne(1);
		    System.out.println(bean);
			
		}
	//查看包租婆的上架记录
	@Test
	public void test3(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao dao = (IUserDao) context.getBean("userDaoImpl");
		List<ParkingBean> bean=dao.ShowMe(2);
	    System.out.println(bean);
		
	}
	//包租婆批量添加，测试成功
	@Test
	public void test4(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IParkDao dao = (IParkDao) context.getBean("parkDaoImpl");
		ParkingBean p=new ParkingBean();
		UserBean user=new UserBean();
		user.setId(2);
		p.setUser(user);
		p.setAddress("包租婆批量添加测试1");
		ParkingBean pa=new ParkingBean();
		user.setId(2);
		pa.setUser(user);
		pa.setAddress("包租婆批量添加测试2");
		List<ParkingBean> bean=new ArrayList<ParkingBean>();
		bean.add(p);
		bean.add(pa);
		int bea=dao.AddPark(bean);
	    System.out.println(bea);
		
	}
	//包租婆查看自己被租赁的记录，测试除了抢租客名成功
	@Test
	public void test5(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao dao = (IUserDao) context.getBean("userDaoImpl");
		List<ParkingBean> bean=dao.SelectLog(2);
	    System.out.println(bean);
		
	}
	//抢租客查看自己的租赁记录，测试除了包租婆人名成功
	@Test
	public void test6(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao dao = (IUserDao) context.getBean("userDaoImpl");
		List<OrderBean> bean=dao.ShowLog(1);
	    System.out.println(bean);
		
	}
	//抢租客针对订单添加投诉信息，测试成功
	@Test
	public void test7(){
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IUserDao dao = (IUserDao) context.getBean("userDaoImpl");
		UserBean user=new UserBean();
		UserBean user1=new UserBean();
		OrderBean order=new OrderBean();
		ComplainBean bean=new ComplainBean();
		user.setId(1);
		user1.setId(2);
		order.setId(1);
		bean.setContent("添加个人订单评论测试3");
		bean.setBuser(user);
		bean.setUser(user1);
		bean.setOrder(order);
		int num=dao.AddComplaint(bean);
		System.out.println(num);
		
	    
		
	}
	//企业名查询企业合约.测试成功
		@Test
		public void test10(){
			@SuppressWarnings("resource")
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			ICompanyDao dao = (ICompanyDao) context.getBean("companyDaoImpl");
			List<CompanyBargainBean> bean=dao.CompanyContract("yiyi");
		    System.out.println(bean);
			
		}
}
