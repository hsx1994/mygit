package com.woniu.cbd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.dao.IParkingDao;

@Repository
public class ParkingDaoImpl implements IParkingDao {
	
	@Autowired
	private SqlSessionFactory fa;

	/**
	 * 通过车位的id查找车位的信息
	 */
	@Override
	public ParkingBean findParkingById(int parkingId) {
		SqlSession session = fa.openSession(true);
		ParkingBean parking = session.selectOne("parkingMapper.findParkingById", parkingId);
		session.close();
		return parking;
		
	}
	
	@Override
	public int parkingDelete(int id) {
		SqlSession session = fa.openSession();
		int row = session.update("parkingMapper.parkingDelete", id);
		
		session.commit();
		session.close();
		return row;
	}

	@Override
	public List<ParkingBean> parkingSelect() {
		SqlSession session = fa.openSession();
		List<ParkingBean> list = session.selectList("parkingMapper.applyParkingSelect");
		
		session.close();
		return list;
	}

	@Override
	public int passApply(int id) {
		SqlSession session = fa.openSession();
		int row = session.update("parkingMapper.passApply",id);
		
		session.commit();
		session.close();
		return row;
	}

	@Override
	public int passApplyFail(int id) {
		SqlSession session = fa.openSession();
		int row = session.update("parkingMapper.passApplyFail",id);
		
		session.commit();
		session.close();
		return row;
	}
}
