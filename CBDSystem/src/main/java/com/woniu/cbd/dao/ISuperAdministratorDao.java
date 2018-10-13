package com.woniu.cbd.dao;

import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.bean.SuperAdministratorBean;

/**
 * 接口名：ISuperAdministratorDao 作用：定义超级管理员的增、删、改、查
 * 
 * @author dell
 *
 */
public interface ISuperAdministratorDao {

	/**
	 * 方法名：findAll 作用：通过用户名和密码查询超级管理员信息
	 * 
	 * @return SuperAdministratorBean
	 */
	public SuperAdministratorBean findAll(LoginBean lb);

}