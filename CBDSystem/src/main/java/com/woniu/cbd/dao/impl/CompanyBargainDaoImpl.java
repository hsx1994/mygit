package com.woniu.cbd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.dao.ICompanyBargainDao;

@Repository
public class CompanyBargainDaoImpl implements ICompanyBargainDao {
	
	@Autowired
	private SqlSessionFactory fa;

	@Override
	public int companyBargainAdd(CompanyBargainBean bean) {
		SqlSession session = fa.openSession(true);
		int id = session.insert("companyBargainMapper.companyBargainAdd", bean);
		
		session.close();
		return id;
	}

	@Override
	public int companyBargainDelete(int id) {
		SqlSession session = fa.openSession(true);
		int row = session.insert("companyBargainMapper.companyBargainDelete", id);
		
		session.close();
		return row;
	}

	@Override
	public int companyBargainUpdate(CompanyBargainBean bean) {
		SqlSession session = fa.openSession(true);
		int row = session.insert("companyBargainMapper.companyBargainUpdate", bean);
		
		session.close();
		return row;
	}
	
	@Override
	public List<CompanyBargainBean> companyBargainSelect(int id) {
		SqlSession session = fa.openSession(true);
		List<CompanyBargainBean> bargain = session.selectList("companyBargainMapper.companyBargainById",id);
		
		session.close();
		return bargain;
	}

	@Override
	public List<CompanyBargainBean> allCompanyBargainSelect() {
		SqlSession session = fa.openSession(true);
		List<CompanyBargainBean> list = session.selectList("companyBargainMapper.allCompanyBargainSelect");
		
		session.close();
		return list;
	}

	@Override
	public List<CompanyBargainBean> companyBargainSelectByState(int state) {
		SqlSession session = fa.openSession(true);
		List<CompanyBargainBean> list = session.selectList("companyBargainMapper.findCompanyBargainByState",state);
		
		session.close();
		return list;
	}
	// 前台查看企业合约
	@Override
	public List<CompanyBargainBean> companyBargainById(int id) {
		SqlSession session = fa.openSession(true);
		List<CompanyBargainBean> bean = session.selectList("companyBargainMapper.companyBargainById",id);
		
		session.close();
		return bean;
	}
	
	@Override
	public List<CompanyBargainBean> queryUseingBargainByCondition(
			String condition) {
		SqlSession session = fa.openSession(true);
		List<CompanyBargainBean> list= session.selectList("companyBargainMapper.fuzzyQueryBargainBeUseing",condition);
		
		session.close();
		return list;
	}

	@Override
	public List<CompanyBargainBean> queryHistoryBargainByCondition(
			String condition) {
		SqlSession session = fa.openSession(true);
		List<CompanyBargainBean> list= session.selectList("companyBargainMapper.queryHistoryBargain",condition);
		
		session.close();
		return list;
	}

	@Override
	public CompanyBargainBean findBargainById(int id) {
		SqlSession session = fa.openSession(true);
		CompanyBargainBean  bean = session.selectOne("companyBargainMapper.findBargainById",id);
		
		session.close();
		return bean;
	}

}
