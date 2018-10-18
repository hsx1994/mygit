package com.woniu.cbd.dao.impl;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.dao.ICompanyInfoDao;

@Repository
public class CompanyInfoDaoImpl implements ICompanyInfoDao {
	// spring容器注入一个工厂对象
	@Autowired
	private SqlSessionFactory fa;

}
