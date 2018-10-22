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

	

	

	// 通过登录表的id查包租婆或抢租客表的id
	@Override
	public int findIdByLid(int lid) {
		return dao.findIdByLid(lid);
	}

}
