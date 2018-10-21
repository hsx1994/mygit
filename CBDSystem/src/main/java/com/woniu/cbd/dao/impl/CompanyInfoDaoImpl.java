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


	/* (non-Javadoc)
	 * @see com.woniu.cbd.dao.ICompanyInfoDao#findIdByLid(int)
	 */
	@Override
	public int findIdByLid(int lid) {
		SqlSession session = fa.openSession();
		int id = session.selectOne("companyInfoMapper.findIdByLid", lid);
		session.close();
		return id;
	}
	
}
