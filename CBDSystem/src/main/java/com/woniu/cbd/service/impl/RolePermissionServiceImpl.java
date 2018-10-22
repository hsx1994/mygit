package com.woniu.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.RolePermissionBean;
import com.woniu.cbd.dao.IRolePermissionDao;
import com.woniu.cbd.service.IRolePermissionService;
/**
 * 权限管理的业务层实现类
 * @author wt
 *
 */
@Service
public class RolePermissionServiceImpl implements IRolePermissionService {
	@Autowired
	private IRolePermissionDao dao;
	
	//普通管理员权限添加业务
	@Override
	public String addAdministratorLimit(List<RolePermissionBean> bean) {
		//权限是否插入成功
		boolean result = dao.addAdministratorLimit(bean);
		if(result==true){
			return "添加成功";
		}
		return "添加失败";
	}

}
