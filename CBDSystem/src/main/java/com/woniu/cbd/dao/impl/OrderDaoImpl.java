package com.woniu.cbd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.dao.IOrderDao;

public class OrderDaoImpl implements IOrderDao {
	@Autowired
	private SqlSessionFactory factory;
	/**
	 * 通过车位的id查找当前车位的所有订单
	 */
	@Override
	public List<OrderBean> findByParkingId(int parkingId) {
		List<OrderBean> list = new ArrayList<OrderBean>();
		
		SqlSession session = factory.openSession(true);
		
		list = session.selectList("orderMapper.findByParkingId", parkingId);
		
		session.close();
		return list;
	}
	@Override
	public boolean addOrder(OrderBean order) {
		SqlSession session = factory.openSession(true);
		if(session.insert("orderMapper.addOrder", order) == 0){
			session.close();
			return false;
		}else {
			session.close();
			return true;
		}
	}
}
