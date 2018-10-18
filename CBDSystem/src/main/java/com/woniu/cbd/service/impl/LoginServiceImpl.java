package com.woniu.cbd.service.impl;

import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.dao.ILoginDao;
import com.woniu.cbd.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService{

	@Autowired
	private ILoginDao loginDao;
	
	/**
	 * 根据登录用户名获取登录用户信息
	 */
	@Override
	public LoginBean getLoginUserByName(String name) { 
		return loginDao.getLoginUserByName(name);
	}

	/**
	 * 根据登录用户名获取登录用户权限
	 */
	@Override
	public Set<String> getPermissions(String userName) {
		return loginDao.getPermissions(userName);
	}

}
