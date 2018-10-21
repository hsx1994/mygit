package com.woniu.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.PermissionBean;
import com.woniu.cbd.bean.RolePermissionBean;
import com.woniu.cbd.dao.IRolePermissionDao;
import com.woniu.cbd.service.IRolePermissionService;

@Service
public class RolePermissionServiceImpl implements IRolePermissionService {
	@Autowired
	private IRolePermissionDao dao;
	/**
	 * 给后台管理员赋予权限
	 */
	@Override
	public boolean addLimites(List<RolePermissionBean> limit) {
		int row = dao.addLimites(limit);
		if(row > 0){
			return true;
		}
		return false;
	}
	/**
	 * 通过权限ID查权限信息
	 */
	@Override
	public PermissionBean findById(int i) {
		PermissionBean bean = dao.findById(i);
		return bean;
	}
	@Override
	public boolean deletePerByAdminId(Integer id) {
		int row = dao.deletePerByAdminId(id);
		if(row > 0){
			return true;
		}
		return false;
	}

}
