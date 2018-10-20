package com.woniu.cbd.service;

import java.util.Set;

import com.woniu.cbd.bean.LoginBean;

public interface ILoginService {
	
	/**
	 * 普通管理员添加登录信息
	 * @param login
	 * @return
	 */
	public String addAdmin(LoginBean login);

	/**
	 * 通过登录用户名查询用户
	 * 
	 * @param LoginName
	 * @return
	 */
	public LoginBean getLoginUserByName(String name);


	/**
	 * 通过用户名查询权限信息
	 * 
	 * @param userName
	 * @return
	 */
	public Set<String> getPermissions(String name);
	
	/**
	 * 通过ID查真实密码
	 * @param id
	 * @return
	 */
	public String selectPwd(Integer id);
	
	/**
	 * 修改管理员密码
	 * @param bean
	 * @return
	 */
	public boolean updatePwd(LoginBean bean);

}
