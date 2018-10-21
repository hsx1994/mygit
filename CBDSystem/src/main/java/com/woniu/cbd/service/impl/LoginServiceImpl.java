package com.woniu.cbd.service.impl;

import java.util.Set;

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
	@Override
	public String addAdmin(LoginBean login) {
		String result = "失败";
		LoginBean bean = loginDao.findByLoginName(login);
		if(bean != null){
			result = "用户名已存在";
		} else {
			int id = loginDao.addAdmin(login);
			if(id > 0){
				result = "成功";
			}
		}
		return result;
	}

	@Override
	public String selectPwd(Integer id) {
		String re = loginDao.selecrPwd(id);
		return re;
	}

	@Override
	public boolean updatePwd(LoginBean bean) {
		int re = loginDao.updatePwd(bean);
		if(re > 0){
			return true;
		}
		return false;
	}

}
