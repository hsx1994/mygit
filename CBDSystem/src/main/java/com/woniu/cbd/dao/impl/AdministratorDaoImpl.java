package com.woniu.cbd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.AdministratorBean;
import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.dao.IAdministratorDao;

/**
 * 类名：AdministratorDaoImpl 作用：实现普通管理员的增、删、改、查 描述：对IAdministratorDao接口的实现
 */
@Repository
public class AdministratorDaoImpl implements IAdministratorDao {

	@Autowired
	private SqlSessionFactory fa;
	
	@Override
	public boolean administratorAdd(AdministratorBean ab) {
		// 存储返回结果
		boolean result = false;
		// 获取session
		SqlSession session = fa.openSession(true);
		// 执行sql插入操作，获取影响行数；
		int row = session.insert("AdministratorMapper.administratorAdd", ab);
		// 关闭session
		session.close();
		if (row > 0) {
			// 返回影响行数大于0，则插入成功
			result = true;
		}
		return result;
	}

	@Override
	public boolean administratorDelete(int id) {
		// 存储返回结果
		boolean result = false;
		// 获取session，自动提交开启
		SqlSession session = fa.openSession(true);
		// 执行sql删除语句，返回影响行数
		int row = session.update("AdministratorMapper.administratorDelete", id);
		// 根据返回影响行数判断书否删除成功
		if (row > 0) {
			// 大于0，删除成功
			result = true;
		}
		return result;
	}

	@Override
	public boolean administratorUpdate(AdministratorBean ab) {
		// 定义变量存储 更新是否成功
		boolean result = false;
		// 获取session
		SqlSession session = fa.openSession(true);
		// 执行sql,接受执行sql返回的影响 行数
		int row = session.delete("AdministratorMapper.administratorUpdate", ab);
		// 判断更新是否成功
		if (row > 0) {
			result = true;
		}
		return result;
	}

	@Override
	public AdministratorBean administratorSelect(LoginBean lb) {

		// 获取session
		SqlSession session = fa.openSession(true);
		// 执行sql，获取结果集
		AdministratorBean bean = session.selectOne("AdministratorMapper.administratorSelect", lb);
		return bean;
	}

	@Override
	public List<AdministratorBean> administratorSelectAll() {
	
		// 获取session
		SqlSession session = fa.openSession(true);
		// 执行sql，获取结果集
		List<AdministratorBean> list = session.selectList("AdministratorMapper.administratorSelectAll");
		return list;
	}

}