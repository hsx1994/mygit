package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;

public interface IOrderDao {

	public List<OrderBean> findByParkingId(int parkingId);

	public boolean addOrder(OrderBean order);

	public boolean changeState(OrderBean order);

	public OrderBean findByOrderId(int orderId);

	// 抢租客查看租赁记录
	List<OrderBean> showLog(int id);

	// 包租婆查看被租赁记录
	List<ParkingBean> selectLog(int id);

	public List<OrderBean> findOrderByState(int id, int state);
}
