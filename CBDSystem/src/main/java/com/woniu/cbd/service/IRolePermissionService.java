package com.woniu.cbd.service;

import java.util.List;

import com.woniu.cbd.bean.RolePermissionBean;

/**
 * 权限管理接口，处理各类权限问题
 * @author wt
 *
 */
public interface IRolePermissionService {
	/**
	 * 添加管理员时，进行的权限添加
	 * @param bean 包含权限id和登录表的id
	 * @return
	 */
	public String  addAdministratorLimit(List<RolePermissionBean> bean);

}
