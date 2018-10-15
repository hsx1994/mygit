package com.woniu.cbd.dao.impl;

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
	public ComplainBean findAllComplain() {
		
		SqlSession session = fa.openSession();
		/*IComplainDao dao = session.getMapper(IComplainDao.class);
		ComplainBean bean = dao.findAllComplain();*/
		
		ComplainBean bean = session.selectOne("complainMapper.findAllComplain");
		session.close();
		
		return bean;
	}

}
