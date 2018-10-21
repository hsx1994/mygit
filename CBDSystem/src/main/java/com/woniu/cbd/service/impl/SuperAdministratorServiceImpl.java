package com.woniu.cbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;

import com.woniu.cbd.dao.ISuperAdministratorDao;
import com.woniu.cbd.service.ISuperAdministratorService;

@Service
public class SuperAdministratorServiceImpl implements ISuperAdministratorService{

	@Autowired
	private ISuperAdministratorDao dao;
	
	/*
	 * 根据登录用户表lid查超级管理员id
	 */
	@Override
	public int findIdByLid(int lid) {
		
		return dao.findIdByLid(lid);
	}

}
