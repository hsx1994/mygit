package com.woniu.cbd.test;



import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.dao.ICompanyInfoDao;
import com.woniu.cbd.dao.IComplainDao;
import com.woniu.cbd.dao.IOrderDao;
import com.woniu.cbd.dao.IOtherParkingDao;
import com.woniu.cbd.dao.impl.CompanyInfoDaoImpl;
import com.woniu.cbd.dao.impl.ComplainDaoImpl;
import com.woniu.cbd.service.ICompanyBargainService;
import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.OtherParkingBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.dao.ICompanyBargainDao;
import com.woniu.cbd.dao.IParkingDao;
import com.woniu.cbd.dao.IUserDao;
import com.woniu.cbd.service.impl.CompanyBargainServiceImpl;
public class TestMain {
	// 查看所有的车位
	@Test
	public void test1() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IParkingDao dao = (IParkingDao) context.getBean("parkingDaoImpl");
		List<ParkingBean> bean = dao.showAll();
		System.out.println(bean);

	}

	// 根据价格查询个人车位
	@Test
	public void test2() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IParkingDao dao = (IParkingDao) context.getBean("parkingDaoImpl");
		List<ParkingBean> bean = dao.selectParking(15);
		System.out.println(bean);

	}

	// 查询单个车位和车位号
	@Test
	public void test8() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IParkingDao dao = (IParkingDao) context.getBean("parkingDaoImpl");
		List<ParkingBean> bean = dao.selectParkingByNum("28");
		System.out.println(bean);

	}

	// 根据车位id查询单个车位
	@Test
	public void test9() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IParkingDao dao = (IParkingDao) context.getBean("parkingDaoImpl");
		ParkingBean bean = dao.selectParkingOne(6);
		System.out.println(bean);

	}

	// 查看包租婆的上架记录
	@Test
	public void test3() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IParkingDao dao = (IParkingDao) context.getBean("parkingDaoImpl");
		List<ParkingBean> bean = dao.showMe(2);
		System.out.println(bean);

	}

	// 包租婆批量添加，测试成功
	@Test
	public void test4() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IParkingDao dao = (IParkingDao) context.getBean("parkingDaoImpl");
		ParkingBean p = new ParkingBean();
		UserBean user = new UserBean();
		user.setId(2);
		p.setUser(user);
		p.setAddress("包租婆批量添加测试1");
		ParkingBean pa = new ParkingBean();
		user.setId(2);
		pa.setUser(user);
		pa.setAddress("包租婆批量添加测试2");
		List<ParkingBean> bean = new ArrayList<ParkingBean>();
		bean.add(p);
		bean.add(pa);
		int bea = dao.addParking(bean);
		System.out.println(bea);

	}

	// 包租婆查看自己被租赁的记录，测试成功
	@Test
	public void test5() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IOrderDao dao = (IOrderDao) context.getBean("orderDaoImpl");
		List<ParkingBean> bean = dao.selectLog(2);
		System.out.println(bean);

	}

	// 抢租客查看自己的租赁记录，测试成功
	@Test
	public void test6() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IOrderDao dao = (IOrderDao) context.getBean("orderDaoImpl");
		List<OrderBean> bean = dao.showLog(1);
		System.out.println(bean);

	}

	// 抢租客针对订单添加投诉信息，测试成功
	@Test
	public void test7() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IComplainDao dao = (IComplainDao) context.getBean("complainDaoImpl");
		UserBean user = new UserBean();
		UserBean user1 = new UserBean();
		OrderBean order = new OrderBean();
		ComplainBean bean = new ComplainBean();
		user.setId(1);
		user1.setId(2);
		order.setId(1);
		bean.setContent("添加个人订单投诉测试5");
		bean.setBuser(user);
		bean.setUser(user1);
		bean.setOrder(order);
		int num = dao.addComplaint(bean);
		System.out.println(num);

	}

	// 企业查询企业合约.测试成功
	@Test
	public void test10() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ICompanyBargainDao dao = (ICompanyBargainDao) context.getBean("companyBargainDaoImpl");
		List<CompanyBargainBean> bean = dao.companyBargainById(1);
		System.out.println(bean);

	}

	// 企业查询企业中的车位
	@Test
	public void test11() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IOtherParkingDao dao = (IOtherParkingDao) context.getBean("otherParkingDaoImpl");
		List<OtherParkingBean> bean = dao.showCompanyParkingAll(2);
		System.out.println(bean);

	}

	// 企业查询企业中单个的车位
	@Test
	public void test12() {
		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IOtherParkingDao dao = (IOtherParkingDao) context.getBean("otherParkingDaoImpl");
		OtherParkingBean bean = dao.showCompanyParkingById(1);
		System.out.println(bean);

	}
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

	@Test
	public void test(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ICompanyInfoDao dao = context.getBean(CompanyInfoDaoImpl.class);
		dao.fuzzyQuery("蜗牛");
		dao.findAllCompany();
	}
	@Test
	public void b(){
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IComplainDao dao = context.getBean(ComplainDaoImpl.class);
		System.out.println(dao.findComplainById(9));
	}

	@Test
	public void atest() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		IOtherParkingDao dao = (IOtherParkingDao) context.getBean("otherParkingDaoImpl");
	}

}

