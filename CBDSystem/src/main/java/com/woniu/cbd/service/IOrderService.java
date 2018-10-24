package com.woniu.cbd.service;

import java.util.List;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;

public interface IOrderService {

	public boolean privateOrder(OrderBean order);

	public boolean companyOrder();

	public OrderBean findOrderById(int id);

	public boolean changeOrderState(OrderBean order);

	// 用于抢租客查看自己的租赁记录
	public List<OrderBean> showLog(int id);

	// 用于包租婆查看自己被租赁的记录
	public List<ParkingBean> selectLog(int id);
	
	public List<OrderBean> findOrderByState(int id,int state);

}
