package com.woniu.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.dao.IUserDao;
import com.woniu.cbd.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	private IUserDao dao;
    
	//查看包租婆的发布记录
	@Override
	public List<ParkingBean> ShowMe(int id) {
		// TODO Auto-generated method stub
		List<ParkingBean> bean = dao.ShowMe(id);
		return bean;
	}

	// 查看包租婆的被租赁记录
	@Override
	public List<ParkingBean> SelectLog(int id) {
		// TODO Auto-generated method stub
		List<ParkingBean> bean=dao.SelectLog(id);
		return bean;
	}

	// 查看抢租客的租赁记录
	@Override
	public List<OrderBean> ShowLog(int id) {
		// TODO Auto-generated method stub
		List<OrderBean> bean=dao.ShowLog(id);
		return bean;
	}

	// 抢租客针对记录添加投诉信息
	@Override
	public boolean AddComplaint(ComplainBean bean) {
		// TODO Auto-generated method stub
		int num=dao.AddComplaint(bean);
		if(num>0){
			return true;
			}else{
				 
		    return false;
		    }
	}

}
