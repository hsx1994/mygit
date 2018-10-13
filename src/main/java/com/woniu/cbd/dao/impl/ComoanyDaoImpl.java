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
public class ComoanyDaoImpl implements ICompanyDao {
	// spring容器注入一个工厂对象
	@Autowired
	private SqlSessionFactory fa;

	// 查看企业的所有车位
	@Override
	public List<OtherParkingBean> ShowComPanyParkAll() {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		List<OtherParkingBean> bean = session.selectList("otherparkingMapper.showcompanyall");
		session.close();
		return bean;
	}

	// 企业查看租赁记录
	@Override
	public List<OtherParkingBean> ShowComPanyPark(int c_id) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		List<OtherParkingBean> bean = session.selectList("otherparkingMapper.showcompanypark", c_id);
		session.close();
		return bean;
	}

	// 企业批量租赁车位
	@Override
	public int CompanyLease(List<OtherParkingBean> other) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		int num = session.insert("companyorderMapper.companylease", other);
		session.close();
		return num;
	}

	// 查看企业合约
	@Override
	public List<CompanyBargainBean> CompanyContract(int cid) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		List<CompanyBargainBean> bean = session.selectOne("companybargainMapper.companycontract", cid);
		session.close();
		return bean;
	}

}
