package com.woniu.cbd.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.bean.SuperAdministratorBean;
import com.woniu.cbd.dao.ISuperAdministratorDao;


/**
 * 类名：SuperAdministratorDaoImpl 作用：实现超级管理员的增、删、改、查
 * 描述：对ISuperAdministratorDao接口的实现
 */
@Repository
public class SuperAdministratorDaoImpl implements ISuperAdministratorDao {
	
	@Autowired
	private SqlSessionFactory fa;
	
	@Override
	public SuperAdministratorBean findAll(LoginBean lb) {
		
		SqlSession session = fa.openSession(true);
		
		// 通过映射文件映射获取dao层的实现类
		SuperAdministratorBean bean = session.selectOne("SuperAdministratorBeanMapper.findAll", lb);
	
		session.close();
		return bean;

	}
}
