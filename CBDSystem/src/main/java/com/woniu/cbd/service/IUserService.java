package com.woniu.cbd.service;


import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.LoginBean;

import com.woniu.cbd.bean.UserBean;

public interface IUserService {
	

	
	
	/**向数据库中添加一条用户信息	
	 ** @param user	 
	 ** @return int	 
	 **/
	public int addUser(LoginBean bean);
	
	/**向数据库中添加一条用户信息	
	 ** @param user	 
	 ** @return int	 
	 **/
	public boolean addUserInfor(UserBean bean);
		/**
		 * 修改数据库中个人信息
		 * @param user
		 * @return
		 */

	//用于查包租婆或抢租客表的id
	public int findIdByLid(int lid);

	//修改个人信息
	public boolean updateUser(UserBean bean);
	/***
	 * 修改数据库中企业信息
	 * @param company
	 * @return
	 */

	public boolean updateCompany(CompanyInfoBean company);
	
	//查看个人信息
	public UserBean findUserInfo(int id);
	//查看企业信息
	public CompanyInfoBean findCompanyInfo(int id);
}
