package com.woniu.cbd.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.RegisterBean;
import com.woniu.cbd.dao.IUserDao;
import com.woniu.cbd.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
    
	//查看包租婆的发布记录
	@Override
	public List<ParkingBean> ShowMe(int id) {
		List<ParkingBean> bean = dao.ShowMe(id);
		return bean;
	}

	// 查看包租婆的被租赁记录
	@Override
	public List<ParkingBean> SelectLog(int id) {
		List<ParkingBean> bean=dao.SelectLog(id);
		return bean;
	}

	// 查看抢租客的租赁记录
	@Override
	public List<OrderBean> ShowLog(int id) {
		List<OrderBean> bean=dao.ShowLog(id);
		return bean;
	}

	// 抢租客针对记录添加投诉信息
	@Override
	public boolean AddComplaint(ComplainBean bean) {
		int num=dao.AddComplaint(bean);
		if(num>0){
			return true;
			}
		return false;
	}
	
	/**
	 * 注册个人信息
	 */
	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, rollbackFor = TransactionException.class)
	public int addUser(RegisterBean user) {
		int row = dao.addUser(user);
		
			return row;
		
//	
//		int row=0;
//		int result = 0;
//		if(user.getName() == null || user.getPass()==null){
//			result = 0;
//		}else{
//			result = 1;
//			System.out.println("result+"+result);
//			
//		}
//		System.out.println("result"+result);
//		int resultinfor=0;
//		if(user.getAddress() == null || user.getEmail()==null ||user.getIdcard()==null||user.getJob()==null||user.getRealName()==null){
//			resultinfor = 0;
//		}else{
//			resultinfor = 1;
//			System.out.println("resultinfor+"+resultinfor);
//		}
//		System.out.println("resultinfor"+resultinfor);
//		if(result!=0&&resultinfor!=0){
//			row=1;
//		}
//		return row;
	}

	/**
	 * 修改信息
	 */
	@Override
	public int updateUser(RegisterBean user) {
		int row=0;
		int result = dao.updateUser(user);
		System.out.println(result);
		
		if(result>0){
			row=1;
		}
		return row;
	}

	@Override
	public int updateCompany(CompanyInfoBean company) {
		int row=0;
		int result = dao.updateCompany(company);
		System.out.println(result);
		
		if(result>0){
			row=1;
		}
		return row;
	}
}
