package com.woniu.cbd.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.dao.IUserDao;

@Repository
public class UserDaoImpl implements IUserDao {

	// spring容器注入一个工厂对象
	@Autowired
	private SqlSessionFactory fa;

	@Override
	public int addUser(LoginBean bean) {
		SqlSession session = fa.openSession(true);
		int row = session.insert("userMapper.addUser", bean);

		session.close();
		return row;
	}
	//包租婆添加个人信息
	@Override
	public int addUserInfor(UserBean bean) {
		SqlSession session = fa.openSession(true);
		int row = session.insert("userMapper.addUserInfor", bean);

		session.close();
		return row;
	}
	
	//包租婆修改个人信息
	@Override
	public int updateUser(UserBean bean) {
		SqlSession session = fa.openSession(true);
		int row = session.insert("userMapper.updateUser", bean);

		session.close();
		return row;
	}
	//企业修改信息
	@Override
	public int updateCompany(CompanyInfoBean company) {
		SqlSession session = fa.openSession(true);
		int row = session.update("userMapper.updateCompany", company);
		
		session.close();
		return row;
	}

	// 通过登录表的id查包租婆或抢租客表的id
	@Override
	public int findIdByLid(int lid) {
		SqlSession session = fa.openSession();
		int id = session.selectOne("userMapper.findIdByLid", lid);
		session.close();
		return id;
	}
	
	//查看企业信息
	@Override
	public CompanyInfoBean findCompanyInfo(int id) {
		SqlSession session = fa.openSession(true);
		CompanyInfoBean bean = session.selectOne("userMapper.findCompanyInfo", id);

		session.close();
		return bean;
	}
	//查看个人信息
	@Override
	public UserBean findById(int uid) {
		SqlSession session = fa.openSession(true);
		UserBean user = session.selectOne("userMapper.findById",uid);
		
		session.close();
		return user;
	}
	@Override
	public int updateCounet(UserBean u) {
		SqlSession session = fa.openSession(true);
		int row = session.update("userMapper.updateCounet",u);
		
		session.close();
		return row;
	}
}
