package com.woniu.cbd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.OtherParkingBean;
import com.woniu.cbd.dao.ICompanyDao;

@Repository
public class CompanyDaoImpl implements ICompanyDao {
	// spring容器注入一个工厂对象
	@Autowired
	private SqlSessionFactory fa;

	// 查看企业的所有车位
	@Override
	public List<OtherParkingBean> ShowComPanyParkAll() {
		SqlSession session = fa.openSession(true);
		List<OtherParkingBean> bean = session.selectList("otherParkingMapper.showCompanyAllByCid");
		
		session.close();
		return bean;
	}

	// 企业查看单个车位信息
	@Override
	public OtherParkingBean ShowComPanyPark(int c_id) {
		SqlSession session = fa.openSession(true);
		OtherParkingBean bean = session.selectOne("otherParkingMapper.showCompanyParking", c_id);
		
		session.close();
		return bean;
	}


	// 前台查看企业合约
	@Override
	public List<CompanyBargainBean> CompanyContract(String name) {
		SqlSession session = fa.openSession(true);
		List<CompanyBargainBean> bean = session.selectOne("companyBargainMapper.companycontract", name);
		
		session.close();
		return bean;
	}

}
