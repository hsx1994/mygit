package com.woniu.cbd.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.shiro.session.Session;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.bean.SuperAdministratorBean;
import com.woniu.cbd.dao.ISuperAdministratorDao;
import com.woniu.cbd.util.MybatisUtil;

/**
 * 类名：SuperAdministratorDaoImpl 作用：实现超级管理员的增、删、改、查
 * 描述：对ISuperAdministratorDao接口的实现
 */

public class SuperAdministratorDaoImpl implements ISuperAdministratorDao {

	@Override
	public SuperAdministratorBean findAll(LoginBean lb) {
		SuperAdministratorBean bean = null;
		SqlSession session = null;
		try {
			// 获取session对象
			session = MybatisUtil.getSession();
			// 通过映射文件映射获取dao层的实现类
			bean = session.selectOne("SuperAdministratorBeanMapper.findAll", lb);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return bean;

	}
}
