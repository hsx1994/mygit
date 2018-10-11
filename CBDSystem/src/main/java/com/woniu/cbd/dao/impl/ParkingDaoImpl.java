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

	@Override
	public int parkingRenting(int id) {
		SqlSession session = fa.openSession();
		int row = session.update("parkingMapper.parkingRenting",id);
		
		session.commit();
		session.close();
		return row;
	}

}
