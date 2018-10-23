package com.woniu.cbd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.dao.IComplainDao;

@Repository
public class ComplainDaoImpl implements IComplainDao {
	
	@Autowired
	private SqlSessionFactory fa;
	
	@Override
	public void updateComplainState(int state, int id) {
		
		SqlSession session = fa.openSession();
		IComplainDao dao = session.getMapper(IComplainDao.class);
		dao.updateComplainState(state, id);
		session.commit();
		session.close();
	}

	@Override
	public List<ComplainBean> findAllComplain() {
		
		SqlSession session = fa.openSession();
		List<ComplainBean> list = session.selectList("com.woniu.cbd.dao.IComplainDao.findAllComplain");
		session.close();
		
		return list;
	}

	@Override
	public List<ComplainBean> findComplainByPage(int page) {
		
		SqlSession session = fa.openSession();
		IComplainDao dao = session.getMapper(IComplainDao.class);
		List<ComplainBean> list = dao.findComplainByPage(page);
		session.close();
		return list;
	}


	@Override
	public ComplainBean findComplainById(int id) {
		SqlSession session = fa.openSession();
		IComplainDao dao = session.getMapper(IComplainDao.class);
		ComplainBean bean = dao.findComplainById(id);
		session.close();
		return bean;
	}

}
