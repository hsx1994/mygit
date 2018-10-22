package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.RolePermissionBean;

public interface IRolePermissionDao {
	
	/**
	 * 添加普通管理员权限
	 * @param id 	   登录表id
	 * 
	 * @return		   插入结果
	 */
	public boolean addAdministratorLimit(List<RolePermissionBean> bean);
	/**
	 * 修改管理员权限
	 * @param id 登陆表id
	 * @return
	 */
	public boolean updateAdministratorLimit(RolePermissionBean bean);
	
	
}
