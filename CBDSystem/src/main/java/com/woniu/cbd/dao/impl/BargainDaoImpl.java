package com.woniu.cbd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.BargainBean;
import com.woniu.cbd.dao.IBargainDao;

@Repository
public class BargainDaoImpl implements IBargainDao {
	
	@Autowired
	private SqlSessionFactory fa;
	
	@Override
	public int bargainAdd(BargainBean bean) {
		SqlSession session = fa.openSession();
		int id = session.insert("bargainMapper.bargainAdd", bean);
		
		session.commit();
		session.close();
		return id;
	}

	@Override
	public int bargainDelete(int id) {
		SqlSession session = fa.openSession();
		int row = session.update("bargainMapper.bargainDelete",id);
		
		session.commit();
		session.close();
		return row;
	}

	@Override
	public int bargainUpdate(BargainBean bean) {
		SqlSession session = fa.openSession();
		int row = session.update("bargainMapper.bargainUpdate",bean);
		
		session.commit();
		session.close();
		
		return row;
	}

	@Override
	public BargainBean bargainSelect(BargainBean bean) {
		SqlSession session = fa.openSession();
		BargainBean bargain = session.selectOne("bargainMapper.selectBargainByCompanyName", bean);
		
		session.close();
		return bargain;
	}

	@Override
	public List<BargainBean> allBargainSelect() {
		SqlSession session = fa.openSession();
		List<BargainBean> bargain = session.selectOne("bargainMapper.bargainSelect");
		
		session.close();
		return bargain;
	}

}
