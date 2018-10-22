package com.woniu.cbd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.RolePermissionBean;
import com.woniu.cbd.dao.IRolePermissionDao;

/**
 * 权限管理的实现类
 * 
 * @author wt
 *
 */
@Repository
public class RolePermissionDaoImpl implements IRolePermissionDao {
	@Autowired
	SqlSessionFactory fa;
	
	//添加普通管理员权限
	@Override
	public boolean addAdministratorLimit(List<RolePermissionBean> bean) {
		SqlSession session = fa.openSession(true);
		//返回结果，row：影响行数
		int row = session.insert("RolePermissionMapper.addAdministratorLimit",bean);
		if(row>0){
			//插入成功
			return true;
		}
		session.close();
		return false;
	}
	
	//修改普通管理员权限
	@Override
	public boolean updateAdministratorLimit(RolePermissionBean bean) {
		SqlSession session = fa.openSession(true);
		//返回结果，row：影响行数
		int row = session.update("RolePermissionMapper.updateAdministratorLimit",bean);
		if(row>0){
			//更新成功
			return true;
		}
		session.close();
		return false;
	}
	

}
