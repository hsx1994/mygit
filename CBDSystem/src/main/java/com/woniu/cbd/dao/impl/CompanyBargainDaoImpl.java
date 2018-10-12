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
		SqlSession session = fa.openSession();
		int id = session.insert("companyBargainMapper.companyBargainAdd", bean);
		
		session.commit();
		session.close();
		return id;
	}

	@Override
	public int companyBargainDelete(int id) {
		SqlSession session = fa.openSession();
		int row = session.insert("companyBargainMapper.companyBargainDelete", id);
		
		session.commit();
		session.close();
		return row;
	}

	@Override
	public int companyBargainUpdate(CompanyBargainBean bean) {
		SqlSession session = fa.openSession();
		int row = session.insert("companyBargainMapper.companyBargainUpdate", bean);
		
		session.commit();
		session.close();
		return row;
	}

	@Override
	public CompanyBargainBean companyBargainSelect(CompanyBargainBean bean) {
		SqlSession session = fa.openSession();
		CompanyBargainBean bargain = session.selectOne("companyBargainMapper.companyBargainSelect",bean);
		
		session.close();
		return bargain;
	}

	@Override
	public List<CompanyBargainBean> allCompanyBargainSelect() {
		SqlSession session = fa.openSession();
		List<CompanyBargainBean> list = session.selectList("companyBargainMapper.allCompanyBargainMapper");
		
		session.close();
		return list;
	}

}
