package com.woniu.cbd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.CompanyOrderBean;
import com.woniu.cbd.dao.ICompanyOrderDao;
@Repository
public class CompanyOrderDaoImpl implements ICompanyOrderDao {
	
	@Autowired
	public SqlSessionFactory fa;
	//批量插入企业订单
	@Override
	public boolean addCompanyOrder(List<CompanyOrderBean> companyOrders) {
		SqlSession session = fa.openSession(true);
		int result = session.insert("companyOrderMapper.addCompanyOrder", companyOrders);
		if (result==0) {
			return false;
		}else {
			return true;
		}
	}

}
