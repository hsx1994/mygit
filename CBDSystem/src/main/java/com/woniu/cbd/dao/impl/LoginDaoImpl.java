package com.woniu.cbd.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.dao.ILoginDao;
@Repository
public class LoginDaoImpl implements ILoginDao {
	@Autowired
	private SqlSessionFactory fa;
	@Override
	public int addAdmin(LoginBean login) {
		SqlSession session = fa.openSession(true);
		int id = session.insert("loginMapper.addAdmin",login);
		
		session.close();
		return id;
	}
	@Override
	public LoginBean findByLoginName(LoginBean login) {
		SqlSession session = fa.openSession(true);
		LoginBean bean = session.selectOne("loginMapper.findByName",login);
		
		return bean;
	}

}
