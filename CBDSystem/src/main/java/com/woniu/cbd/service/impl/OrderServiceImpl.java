package com.woniu.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.dao.IOrderDao;
import com.woniu.cbd.dao.IParkingDao;
import com.woniu.cbd.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private IParkingDao	parkingDao;
	/**
	 * 企业用户租赁订单生成方法
	 */
	@Override
	public boolean companyOrder() {
		// TODO Auto-generated method stub
		return false;
	}
	/**
	 * 个人订单生成方法
	 */
	@Override
	public boolean privateOrder(OrderBean order) {
		boolean b = false;
		ParkingBean parking = parkingDao.findParkingById(order.getParkingId());
		if ((order.getStartTime().compareTo(parking.getStartTime())<0)||(order.getEndTime().compareTo(parking.getEndTime())>0)) {
			return b;
		}
		List<OrderBean> orderList = orderDao.findByParkingId(order.getParkingId());
		
		if (orderList.size() != 0) {
			b = true;
			for (OrderBean orderBean : orderList) {
				if (order.getStartTime().compareTo(orderBean.getStartTime())>0 && order.getStartTime().compareTo(orderBean.getEndTime())<0) {
					b = false;
					break;
				}
				if (order.getEndTime().compareTo(orderBean.getStartTime())>0 && order.getEndTime().compareTo(orderBean.getEndTime())<0) {
					b = false;
					break;
				}
			}
		}else {
			b = orderDao.addOrder(order);
		}
		return b;
	}

}
