package com.woniu.cbd.dao;

import com.woniu.cbd.bean.CompanyInfoBean;

import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.bean.UserBean;

public interface IUserDao {

	/**
	 * 添加用户名密码
	 * 
	 * @param user
	 * @return
	 */
	public int addUser(LoginBean bean);

	/**
	 * 添加用户信息
	 * 
	 * @param user
	 * @return
	 */

	// 通过登录表的id查包租婆或抢租客表的id

	int findIdByLid(int lid);

	public int addUserInfor(UserBean bean);

	/**
	 * 修改个人用户信息
	 * 
	 * @param user
	 * @return
	 */

	public int updateUser(UserBean bean);

	/***
	 * 修改企业用户信息
	 * 
	 * @param company
	 * @return
	 */

	public int updateCompany(CompanyInfoBean company);
	
	//查看个人信息
	
	public UserBean findUserInfo(int id);
	//查看公司信息
	public CompanyInfoBean findCompanyInfo(int id);
}
