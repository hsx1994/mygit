package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.PermissionBean;
import com.woniu.cbd.bean.RolePermissionBean;

public interface IRolePermissionDao {

	public int addLimites(List<RolePermissionBean> limit);

	public PermissionBean findById(int i);

	public int deletePerByAdminId(Integer id);
}
