package com.woniu.cbd.service;

import java.util.List;

import com.woniu.cbd.bean.AdministratorBean;

/**
 * 功能：处理超级管理员对普通管理员的注册、删除、权限修改、普通管理员展示的业务
 * 
 * @author wt
 *
 */
public interface IAdministratorService {

	/**
	 * 功能：添加功能
	 * 
	 * @return 返回添加信息是否成功结果
	 */
	public String administratorRegister(AdministratorBean ab);

	/**
	 * 功能：从数据库删除一个普通管理员账户的所有信息
	 * 
	 * @return 删除结果
	 */
	public String administratorDelet(int id);

	/**
	 * 
	 * 功能：超级管理员 修改普通管理员的权限
	 * 
	 * @return
	 */
	public String administratorLimitChange(AdministratorBean ab);

	/**
	 * 作用：展示所有管理员信息
	 * 
	 * @return 所有管理員的信息
	 */
	public List<AdministratorBean> showAdministrator();

}