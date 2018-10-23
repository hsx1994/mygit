package com.woniu.cbd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.PermissionBean;
import com.woniu.cbd.bean.RolePermissionBean;
import com.woniu.cbd.dao.IRolePermissionDao;

@Repository
public class RolePermissionDaoImpl implements IRolePermissionDao {
	@Autowired
	private SqlSessionFactory fa;
	/**
	 * 添加管理员时，给管理员添加权限
	 */
	@Override
	public int addLimites(List<RolePermissionBean> limit) {
		SqlSession session = fa.openSession(true);
		int row = session.insert("rolePermissionMapper.addPermission",limit);
		
		session.close();
		return row;
	}
	@Override
	public PermissionBean findById(int i) {
		SqlSession session = fa.openSession(true);
		PermissionBean bean = session.selectOne("rolePermissionMapper.findById",i);
		
		session.close();
		return bean;
	}
	@Override
	public int deletePerByAdminId(Integer id) {
		SqlSession session = fa.openSession(true);
		int row = session.update("rolePermissionMapper.deletePerByAdminId",id);
		
		return row;
	}
}

