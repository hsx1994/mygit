package com.woniu.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.dao.IUserDao;
import com.woniu.cbd.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;

	// 查看包租婆的发布记录
	@Override
	public List<ParkingBean> ShowMe(int id) {
		List<ParkingBean> bean = dao.ShowMe(id);
		return bean;
	}

	// 查看包租婆的被租赁记录
	@Override
	public List<ParkingBean> SelectLog(int id) {
		List<ParkingBean> bean = dao.SelectLog(id);
		return bean;
	}

	// 查看抢租客的租赁记录
	@Override
	public List<OrderBean> ShowLog(int id) {
		List<OrderBean> bean = dao.ShowLog(id);
		return bean;
	}

	// 抢租客针对记录添加投诉信息
	@Override
	public boolean AddComplaint(ComplainBean bean) {
		int num = dao.AddComplaint(bean);
		if (num > 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * 注册个人信息
	 */
	@Override
	public boolean addUser(LoginBean bean) {
		int row = dao.addUser(bean);
		if(row>0){
			return true;
		}
		return false;	
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
	public int updateCompany(CompanyInfoBean company) {
		int row = dao.updateCompany(company);
		if(row>0){
			return 1;
		}
		return 0;	
		
	}



	// 通过登录表的id查包租婆或抢租客表的id
	@Override
	public int findIdByLid(int lid) {
		return dao.findIdByLid(lid);
	}
}
