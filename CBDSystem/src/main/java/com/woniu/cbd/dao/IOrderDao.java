package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.OrderBean;

public interface IOrderDao {

	public List<OrderBean> findByParkingId(int parkingId);

	public boolean addOrder(OrderBean order);

}
