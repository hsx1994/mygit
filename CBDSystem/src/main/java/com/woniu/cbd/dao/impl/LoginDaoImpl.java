package com.woniu.cbd.dao.impl;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.bean.PermissionBean;
import com.woniu.cbd.dao.ILoginDao;
@Repository
public class LoginDaoImpl implements ILoginDao {
	@Autowired
	private SqlSessionFactory fa;
	//添加普通管理员登录信息
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
		
		session.close();
		return bean;
	}
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
		Set<String> permissions=new HashSet<String>();
		SqlSession session = fa.openSession(true);
		List<PermissionBean> list = session.selectList("loginMapper.findPermissionsByname",name);
		for (PermissionBean P : list) {
			permissions.add(P.getName());
		}
		return permissions;
		
	}
	/**
	 * 添加企业用户
	 */
	@Override
	public int addCompanyUser(LoginBean login) {
		
		SqlSession session = fa.openSession(true);
		int id = session.insert("loginMapper.addCompanyUser",login);
		session.close();
		return id;
		
	}
	/**
	 * 通过ID查密码
	 */
	@Override
	public String selecrPwd(Integer id) {
		SqlSession session = fa.openSession(true);
		String re = session.selectOne("loginMapper.selecrPwd",id);
		return re;
	}
	@Override
	public int updatePwd(LoginBean bean) {
		SqlSession session = fa.openSession(true);
		int re = session.update("loginMapper.updatePwd",bean);
		return re;
	}
}
