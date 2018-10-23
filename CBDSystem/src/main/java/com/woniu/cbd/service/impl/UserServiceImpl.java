package com.woniu.cbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.CompanyInfoBean;

import com.woniu.cbd.bean.LoginBean;


import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.dao.IUserDao;
import com.woniu.cbd.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
	/**
	 * 注册个人信息
	 */
	@Override
	public int addUser(LoginBean bean) {
		int row = dao.addUser(bean);
		
		return row;	
	}
	@Override
	public boolean addUserInfor(UserBean bean) {
		int row = dao.addUserInfor(bean);
		if(row>0){
			return true;
		}
		return false;	
	}

	/**
	 * 修改信息
	 */
	@Override
	public boolean updateUser(UserBean user) {
		int row = dao.updateUser(user);
		if(row>0){
			return true;
		}
		return false;	
	}

	@Override
	public boolean updateCompany(CompanyInfoBean company) {
		int row = dao.updateCompany(company);
		if(row>0){
			return true;
		}
		return false;	
		
	}

	// 通过登录表的id查包租婆或抢租客表的id
	@Override
	public int findIdByLid(int lid) {
		return dao.findIdByLid(lid);
	}
	@Override
	public UserBean findUserInfo(int id) {
		
		UserBean bean = dao.findUserInfo(id);
		
		return bean;
	}
	@Override
	public CompanyInfoBean findCompanyInfo(int id) {

		CompanyInfoBean bean = dao.findCompanyInfo(id);
		
		return bean;
	}
	@Override
	public UserBean findById(int uid) {
		UserBean user = dao.findById(uid);
		return user;
	}
	@Override
	public boolean updaCount(UserBean u) {
		int row = dao.updateCounet(u);
		if(row > 0){
			return true;
		}
		return false;
	}
	
	

}
