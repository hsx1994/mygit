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
	/**
	 * 批量插入企业订单
	 */
	@Override
	public int addCompanyOrder(List<CompanyOrderBean> companyOrders) {
		SqlSession session = fa.openSession(true);
		int result = session.insert("companyOrderMapper.addCompanyOrder", companyOrders);
		
		session.close();
		return result;
	}
	/**
	 * 修改企业订单的状态
	 */
	@Override
	public boolean changeState(CompanyOrderBean order) {
		SqlSession session = fa.openSession(true);
		if (session.update("companyOrderMapper.updateCompanyOrder", order)==0) {
			session.close();
			return false;
		}else {
			session.close();
			return true;
		}
	}
	//前台查看企业订单记录
	@Override
	public List<CompanyOrderBean> selectCompanyOrder(int id) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession(true);
		List<CompanyOrderBean> bean=session.selectList("companyOrderMapper.selectCompanyOrder", id);
		
		session.close();
		return bean;
	}

}
