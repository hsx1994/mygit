package com.woniu.cbd.dao.impl;

import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.dao.ILoginDao;
import com.woniu.cbd.service.impl.LoginServiceImpl;

@Repository
public class LoginDaoImpl implements ILoginDao{

	// spring容器注入一个工厂对象
	@Autowired
	private SqlSessionFactory fa;
	
	
	/* *
	 * 根据登录用户名查找登录用户
	 */
	@Override
	public LoginBean getLoginUserByName(String name) {
		SqlSession session = fa.openSession(true);
		LoginBean bean = session.selectOne("loginMapper.findLoginUserByname",name);
		session.close();
		return bean;
	}

	/* *
	 * 根据登录用户名查找登录用户权限
	 */
	@Override
	public Set<String> getPermissions(String name) {
		SqlSession session = fa.openSession(true);
		LoginBean bean = session.selectOne("loginMapper.findPermissionsByname",name);
		session.close();
		return null;
	}
}
