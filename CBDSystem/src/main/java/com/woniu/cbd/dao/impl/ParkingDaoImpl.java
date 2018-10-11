package com.woniu.cbd.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.dao.IParkingDao;
@Repository
public class ParkingDaoImpl implements IParkingDao {
	@Autowired
	private SqlSessionFactory factory;
	
	
	public void setFactory(SqlSessionFactory factory) {
		this.factory = factory;
	}

	/**
	 * 通过车位的id查找车位的信息
	 */
	@Override
	public ParkingBean findParkingById(int parkingId) {
		SqlSession session = factory.openSession(true);
		ParkingBean parking = session.selectOne("parkingMapper.findParkingById", parkingId);
		session.close();
		return parking;
		
	}

}
