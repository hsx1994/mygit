package com.woniu.cbd.dao.test;

import java.util.List;

import org.junit.Test;

import com.woniu.cbd.bean.AdministratorBean;
import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.dao.IAdministratorDao;
import com.woniu.cbd.dao.impl.AdministratorDaoImpl;

/**
 * 描述：AdministratorDao的增、删、改、查的测试类
 * 
 * @author wt
 *
 */
public class AdministratorDaoTest {

	/**
	 * 功能：AdministratorDao对管理员表添加进行测试
	 * 
	 */
	@Test
	public void administratorAdd() {
		IAdministratorDao idao = new AdministratorDaoImpl();
		AdministratorBean ab = new AdministratorBean();
		ab.setLid(1);
		ab.setJobNumber("111111");
		ab.setName("小小");
		ab.setTel("1111111");
		boolean boo = idao.administratorAdd(ab);
		System.out.println(boo);
	}

	/**
	 * 作用：AdministratorDao对管理员表软删除进行测试
	 */
	@Test
	public void administratorDelete() {
		// 获取接口实现类
		IAdministratorDao idao = new AdministratorDaoImpl();
		// 调用接口方法，执行sql，返回测试结果
		boolean result = idao.administratorDelete(25);
		System.out.println(result);
	}

	/**
	 * 作用：AdministratorDao对管理员表权限修改进行测试
	 */
	@Test
	public void administratorUpdate() {

		AdministratorBean ab = new AdministratorBean();
		// 设置参数，权限
		ab.setLimit(5);
		ab.setId(25);
		// 获取接口实现类
		IAdministratorDao idao = new AdministratorDaoImpl();
		// 调用接口方法，执行sql，返回测试结果
		boolean result = idao.administratorUpdate(ab);
		System.out.println(result);
	}

	/**
	 * 作用：AdministratorDao对管理员表查询功能进行测试
	 */
	@Test
	public void administratorSelect() {
		LoginBean lb = new LoginBean();
		lb.setName("管理员");
		lb.setPassword("123456");
		IAdministratorDao dao = new AdministratorDaoImpl();
		AdministratorBean bean = dao.administratorSelect(lb);
		System.out.println(bean);

	}

	@Test
	public void administratorSelectAll() {
		AdministratorBean ab = new AdministratorBean();
		IAdministratorDao dao = new AdministratorDaoImpl();
		List<AdministratorBean> list = dao.administratorSelectAll();
		System.out.println(list.get(0).getRealName());

	}

}