package com.woniu.cbd.service;

import com.woniu.cbd.bean.LoginBean;

public interface ILoginService {
	
	/**
	 * 普通管理员添加登录信息
	 * @param login
	 * @return
	 */
	public String addAdmin(LoginBean login);
}
