package com.woniu.cbd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.OtherParkingBean;
import com.woniu.cbd.dao.IOtherParkingDao;

@Repository
public class OtherParkingDaoImpl implements IOtherParkingDao {
	
	@Autowired
	private SqlSessionFactory fa;

	@Override
	public int otherParkingAdd(List<OtherParkingBean> list) {
		SqlSession session = fa.openSession(true);
		int row = session.insert("otherParkingMapper.otherParkingAdd", list);
		
		session.close();
		return row;
	}

	@Override
	public int otherParkingDelete(Integer[] id) {
		SqlSession session = fa.openSession(true);
		int row = session.insert("otherParkingMapper.otherParkingDelete", id);
		
		session.close();
		return row;
	}

	@Override
	public OtherParkingBean otherParkingSelect(OtherParkingBean bean) {
		SqlSession session = fa.openSession(true);
		OtherParkingBean parking = session.selectOne("otherParkingMapper.otherParkingSelect", bean);
		
		session.close();
		return parking;
	}

	@Override
	public List<OtherParkingBean> allOtherParkingSelect() {
		SqlSession session = fa.openSession(true);
		List<OtherParkingBean> list = session.selectList("otherParkingMapper.allOtherParkingSelect");
		
		session.close();
		return list;
	}
	
	    // 查看企业的所有车位,使用了查询合约的懒加载
		@Override
		public List<OtherParkingBean> showCompanyParkingAll(int id) {
			SqlSession session = fa.openSession(true);
			List<OtherParkingBean> bean = session.selectList("companyBargainMapper.findCompanyBargainById", id);
			session.close();
			return bean;
		}

		// 企业查看单个车位信息
		@Override
		public OtherParkingBean showCompanyParkingById(int id) {
			SqlSession session = fa.openSession(true);
			OtherParkingBean bean = session.selectOne("otherParkingMapper.findParkingById", id);
			session.close();
			return bean;
		}
		//通过车位编号查找车位详细信息
		@Override
		public List<OtherParkingBean> findByParkingNumber(String[] parkingNumber) {
			SqlSession session = fa.openSession(true);
			List<OtherParkingBean> list = session.selectList("otherParkingMapper.findByParkingNumber", parkingNumber);
			session.close();
			return list;
		}
	
}
