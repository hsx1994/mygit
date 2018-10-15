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
		//如果订单开始时间大于等于结束时间,订单不成立
		if (order.getStartTime().compareTo(order.getEndTime())>=0) {
			return b;
		}
		//如果订单时间段不在车位可租时间段内,订单不成立
		ParkingBean parking = parkingDao.findParkingById(order.getParking().getId());
		if ((order.getStartTime().compareTo(parking.getStartTime())<0)||(order.getEndTime().compareTo(parking.getEndTime())>0)) {
			return b;
		}
		List<OrderBean> orderList = orderDao.findByParkingId(order.getParking().getId());
		
		if (orderList.size() != 0) {
			b = true;
			for (OrderBean orderBean : orderList) {
				//如果订单开始时间在其他订单时间段内,订单不成立
				if (order.getStartTime().compareTo(orderBean.getStartTime())>0 && order.getStartTime().compareTo(orderBean.getEndTime())<0) {
					b = false;
					break;
				}
				//如果订单结束时间在其他订单时间段内,订单不成立
				if (order.getEndTime().compareTo(orderBean.getStartTime())>0 && order.getEndTime().compareTo(orderBean.getEndTime())<0) {
					b = false;
					break;
				}
				//如果订单的时间端内包含了其他订单,订单不成立
				if (order.getStartTime().compareTo(orderBean.getStartTime())<=0 && order.getEndTime().compareTo(orderBean.getEndTime())>=0) {
					b = false;
					break;
				}
			}
			//判断完后标志位依然为true,表示该订单正确,可以生成
			if (b) {
				b = orderDao.addOrder(order);
			}
		}else {
			b = orderDao.addOrder(order);
		}
		return b;
	}

}
