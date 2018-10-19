package com.woniu.cbd.dao;

import com.woniu.cbd.bean.LoginBean;

public interface ILoginDao {
	
	/**
	 * 添加普通管理员登录信息
	 * @param login
	 * @return
	 */
	public int addAdmin(LoginBean login);
	
	/**
	 * 检测用户名是否存在
	 */
	public LoginBean findByLoginName(LoginBean login);
}
