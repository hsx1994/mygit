package com.woniu.cbd.dao;


import java.util.Set;

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
	/**
	 * 添加企业用户
	 * @param login
	 * @return
	 */
	public int addCompanyUser(LoginBean login);

	public LoginBean getLoginUserByName(String name);

	public Set<String> getPermissions(String userName);

}
