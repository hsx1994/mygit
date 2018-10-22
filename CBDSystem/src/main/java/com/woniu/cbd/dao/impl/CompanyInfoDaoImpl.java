package com.woniu.cbd.dao.impl;

import java.util.List;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.dao.ICompanyInfoDao;

@Repository
public class CompanyInfoDaoImpl implements ICompanyInfoDao {
	// spring容器注入一个工厂对象
	@Autowired
	private SqlSessionFactory fa;

	@Override
	public List<CompanyInfoBean> fuzzyQuery(String condition) {
		
		SqlSession session = fa.openSession();
		List<CompanyInfoBean> list = session.selectList("companyInfoMapper.fuzzyQuery",condition);
		
		session.close();
		return list;
	}


	@Override
	public List<CompanyInfoBean> findAllCompany() {
		SqlSession session = fa.openSession();
		List<CompanyInfoBean> list = session.selectList("companyInfoMapper.findAllCompany");
		
		session.close();
		return list;
	}


	@Override
	public CompanyInfoBean findByCompanyName(String comName) {
		SqlSession session = fa.openSession();
		CompanyInfoBean bean = session.selectOne("companyInfoMapper.findByCompanyName",comName);
		return bean;
	}


	@Override
	public int addCompany(CompanyInfoBean bean) {
		SqlSession session = fa.openSession(true);
		
		int row = session.insert("companyInfoMapper.addCompany",bean);
		session.commit();
		session.close();
		
		return row;
		
	}
	
}
