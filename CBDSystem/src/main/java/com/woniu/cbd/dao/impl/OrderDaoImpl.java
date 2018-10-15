package com.woniu.cbd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.dao.IOrderDao;
@Repository
public class OrderDaoImpl implements IOrderDao {
	@Autowired
	private SqlSessionFactory fa;
	
	/**
	 * 通过车位的id查找当前车位的所有订单
	 */
	@Override
	public List<OrderBean> findByParkingId(int parkingId) {
		List<OrderBean> list = new ArrayList<OrderBean>();
		
		SqlSession session = fa.openSession(true);
		
		list = session.selectList("orderMapper.findByParkingId", parkingId);
		
		session.close();
		return list;
	}
	/**
	 * 添加订单
	 */
	@Override
	public boolean addOrder(OrderBean order) {
		SqlSession session = fa.openSession(true);
		if(session.insert("orderMapper.addOrder", order) == 0){
			session.close();
			return false;
		}else {
			session.close();
			return true;
		}
	}
	/**
	 * 修改订单状态
	 */
	@Override
	public boolean changeState(OrderBean order) {
		SqlSession session = fa.openSession(true);
		if(session.insert("orderMapper.updateOrder", order) == 0){
			session.close();
			return false;
		}else {
			session.close();
			return true;
		}
	}
	/**
	 * 通过订单id查找订单
	 */
	@Override
	public OrderBean findByOrderId(int parkingId) {
		OrderBean order = null;
		SqlSession session = fa.openSession(true);
		order = session.selectOne("orderMapper.findByOrderId", parkingId);
		return order;
	}
}
