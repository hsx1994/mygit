package com.woniu.cbd.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.UserBean;
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
		if (session.insert("orderMapper.addOrder", order) == 0) {
			session.close();
			return false;
		} else {
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
		if (session.insert("orderMapper.updateOrder", order) == 0) {
			session.close();
			return false;
		} else {
			session.close();
			return true;
		}
	}

	/**
	 * 通过订单id查找订单
	 */
	@Override
	public OrderBean findByOrderId(int orderId) {
		OrderBean order = null;
		SqlSession session = fa.openSession(true);
		order = session.selectOne("orderMapper.findByOrderId", orderId);
		
		session.close();
		return order;
	}

	// 抢租客查看租赁记录
	@Override
	public List<OrderBean> showLog(int id) {
		SqlSession session = fa.openSession(true);
		List<OrderBean> bean = session.selectList("orderMapper.showlog", id);

		session.close();
		return bean;
	}

	// 包租婆查看被租赁记录
	@Override
	public List<ParkingBean> selectLog(int id) {
		SqlSession session = fa.openSession(true);
		List<ParkingBean> bean = session.selectList("parkingMapper.showmelog", id);

		session.close();
		return bean;
	}

	@Override
	public List<OrderBean> findOrderByState(int id, int state) {
		UserBean bean = new UserBean();
		bean.setId(id);
		OrderBean bean2 = new OrderBean();
		bean2.setUser(bean);
		bean2.setState(state);
		SqlSession session = fa.openSession(true);
		List<OrderBean> list = session.selectList("orderMapper.findOrderByState", bean2);

		session.close();
		return list;
	}
}
