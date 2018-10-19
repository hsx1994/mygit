package com.woniu.cbd.service;

import com.woniu.cbd.bean.OrderBean;

public interface IOrderService {
	
	public boolean privateOrder(OrderBean order);
	
	public boolean companyOrder();
	
	public OrderBean findOrderById(int id);
	
	public boolean changeOrderState(OrderBean order);
}
