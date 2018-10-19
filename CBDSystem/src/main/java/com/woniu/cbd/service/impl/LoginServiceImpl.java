package com.woniu.cbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.dao.ILoginDao;
import com.woniu.cbd.service.ILoginService;

@Service
public class LoginServiceImpl implements ILoginService {
	@Autowired
	private ILoginDao dao;
	@Override
	public String addAdmin(LoginBean login) {
		String result = "失败";
		LoginBean bean = dao.findByLoginName(login);
		if(bean != null){
			result = "用户名已存在";
		} else {
			int id = dao.addAdmin(login);
			if(id > 0){
				result = "成功";
			}
		}
		return result;
	}

}
