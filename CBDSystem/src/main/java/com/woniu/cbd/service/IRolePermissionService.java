package com.woniu.cbd.service;

import java.util.List;

import com.woniu.cbd.bean.PermissionBean;
import com.woniu.cbd.bean.RolePermissionBean;

public interface IRolePermissionService {

	public boolean addLimites(List<RolePermissionBean> list);

	public PermissionBean findById(int i);

	public boolean deletePerByAdminId(Integer id);
}
