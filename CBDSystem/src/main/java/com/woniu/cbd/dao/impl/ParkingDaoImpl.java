package com.woniu.cbd.dao.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.dao.IParkingDao;

@Repository
public class ParkingDaoImpl implements IParkingDao {
	// spring容器注入一个工厂对象
	@Autowired
	private SqlSessionFactory fa;

	// 包租婆批量添加个人车位
	@Override
	public int addParking(List<ParkingBean> park) {
		SqlSession session = fa.openSession(true);
		int num = session.insert("parkingMapper.addParking", park);
		
		session.close();
		return num;
	}

	// 包租婆查看上架记录
	@Override
	public List<ParkingBean> showMe(int id) {
		SqlSession session = fa.openSession(true);
		List<ParkingBean> bean = session.selectList("parkingMapper.showme", id);

		session.close();
		return bean;
	}

	// 抢租客查看所有的车位，无论是否被租赁
	@Override
	public List<ParkingBean> showAll() {
		SqlSession session = fa.openSession(true);
		List<ParkingBean> bean = session.selectList("parkingMapper.showall");
		
		session.close();
		return bean;
	}

	// 抢租客根据上架时间查询
			@Override
			public List<ParkingBean> selectParking(String startTime,String endTime) {
				SqlSession session = fa.openSession(true);
				Map<String, String> map = new HashMap<String, String>();
				map.put("startTime", startTime);
				map.put("endTime", endTime);
				List<ParkingBean> bean = session.selectList("parkingMapper.showdate", map);
				
				session.close();
				return bean;
			}

			// 抢租客根据价格查询
			@Override
			public List<ParkingBean> selectParking(int price1 ,int price2) {
				Map<String, Integer> map = new HashMap<String, Integer>();
				map.put("price1", price1);
				map.put("price2", price2);
				SqlSession session = fa.openSession(true);
				List<ParkingBean> bean = session.selectList("parkingMapper.showprice", map);
				
				session.close();
				return bean;
			}

	// 抢租客查询指定车位的信息
	@Override
	public ParkingBean selectParkingOne(int id) {
		SqlSession session = fa.openSession(true);
		ParkingBean bean = session.selectOne("parkingMapper.showone", id);
		
		session.close();
		return bean;
	}

	// 抢租客根据车位号来模糊查询
	@Override
	public List<ParkingBean> selectParkingByNum(String num) {
		SqlSession session = fa.openSession(true);
		List<ParkingBean> bean = session.selectList("parkingMapper.findbynum", num);

		session.close();
		return bean;
	}

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
		SqlSession session = fa.openSession(true);
		int row = session.update("parkingMapper.parkingDelete", id);

		session.close();
		return row;
	}

	@Override
	public List<ParkingBean> parkingSelect() {
		SqlSession session = fa.openSession(true);
		List<ParkingBean> list = session.selectList("parkingMapper.applyParkingSelect");

		session.close();
		return list;
	}

	@Override
	public int passApply(int id) {
		SqlSession session = fa.openSession(true);
		int row = session.update("parkingMapper.passApply", id);

		session.close();
		return row;
	}

	@Override
	public int passApplyFail(int id) {
		SqlSession session = fa.openSession(true);
		int row = session.update("parkingMapper.passApplyFail", id);

		session.close();
		return row;
	}

	@Override
	public ParkingBean selectParkingByOrderID(int id) {
		SqlSession session = fa.openSession(true);
		ParkingBean bean = session.selectOne("parkingMapper.selectParkingByOrderID", id);
		
		session.close();
		return bean;
	}
}
