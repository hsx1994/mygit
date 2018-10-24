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
		SqlSession session = fa.openSession(true);
		int id = session.insert("bargainMapper.bargainAdd", bean);
		
		session.close();
		return id;
	}

	@Override
	public int bargainDelete(int id) {
		SqlSession session = fa.openSession(true);
		int row = session.update("bargainMapper.bargainDelete",id);
		
		session.close();
		return row;
	}

	@Override
	public int bargainUpdate(BargainBean bean) {
		SqlSession session = fa.openSession(true);
		int row = session.update("bargainMapper.bargainUpdate",bean);
		
		session.close();
		return row;
	}

	@Override
	public List<BargainBean> bargainSelect(BargainBean bean) {
		SqlSession session = fa.openSession(true);
		List<BargainBean> bargain = session.selectList("bargainMapper.selectBargainByCompanyName", bean);
		
		session.close();
		return bargain;
	}

	@Override
	public List<BargainBean> allBargainSelect() {
		SqlSession session = fa.openSession(true);
		List<BargainBean> bargain = session.selectList("bargainMapper.bargainSelect");
		
		session.close();
		return bargain;
	}

	@Override
	public List<BargainBean> bargainSelectByState(int state) {
		SqlSession session = fa.openSession(true);
		List<BargainBean> bargain = session.selectList("bargainMapper.fingBargainByState",state);
		
		session.close();
		return bargain;
	}
	
	@Override
	public List<BargainBean> queryUseingBargain(String condition) {
		SqlSession session = fa.openSession(true);
		List<BargainBean> list = session.selectList("bargainMapper.queryUseingBargain",condition);
		session.close();
		return list;
	}

	@Override
	public List<BargainBean> queryHistoryBargain(String condition) {
		
		SqlSession session = fa.openSession(true);
		List<BargainBean> list = session.selectList("bargainMapper.queryHistoryBargain",condition);
		
		session.close();
		return list;
	}

	@Override
	public BargainBean findBargainById(int id) {
		SqlSession session = fa.openSession(true);
		BargainBean bean = session.selectOne("bargainMapper.findById",id);
		return bean;
	}

}
