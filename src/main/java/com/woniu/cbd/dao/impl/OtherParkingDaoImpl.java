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
		SqlSession session = fa.openSession();
		int row = session.insert("otherParkingMapper.otherParkingAdd", list);
		
		session.commit();
		session.close();
		return row;
	}

	@Override
	public int otherParkingDelete(Integer[] id) {
		SqlSession session = fa.openSession();
		int row = session.insert("otherParkingMapper.otherParkingDelete", id);
		
		session.commit();
		session.close();
		return row;
	}

	@Override
	public OtherParkingBean otherParkingSelect(OtherParkingBean bean) {
		SqlSession session = fa.openSession();
		OtherParkingBean parking = session.selectOne("otherParkingMapper.otherParkingSelect", bean);
		
		session.close();
		return parking;
	}

	@Override
	public List<OtherParkingBean> allOtherParkingSelect() {
		SqlSession session = fa.openSession();
		List<OtherParkingBean> list = session.selectList("otherParkingMapper.allOtherParkingSelect");
		
		session.close();
		return list;
	}
	
}
