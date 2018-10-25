package com.woniu.cbd.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.dao.IOrderDao;
import com.woniu.cbd.dao.IParkingDao;
import com.woniu.cbd.service.IOrderService;
import com.woniu.cbd.util.DateUtil;

@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private IOrderDao orderDao;
	@Autowired
	private IParkingDao parkingDao;

	/**
	 * 个人订单生成方法
	 */
	@Override
	public String privateOrder(OrderBean order) {
		boolean b = false;
		String result = "订单插入失败";
		ParkingBean parking = parkingDao.findParkingById(order.getParking().getId());

		// 如果订单开始结束时间时过去时间,订单不成立
		if (order.getStartTime().compareTo(new Date()) < 0 || order.getEndTime().compareTo(new Date()) <= 0) {
			return "订单开始结束时间是过去时间,订单不成立";
		}
		// 如果订单开始时间大于等于结束时间,订单不成立
		if (order.getStartTime().compareTo(order.getEndTime()) >= 0) {
			return "订单开始时间在结束时间之后,订单不成立";
		}
		// 如果订单时间段不在车位可租时间段内,订单不成立
		if ((order.getStartTime().compareTo(parking.getStartTime()) < 0)
				|| (order.getEndTime().compareTo(parking.getEndTime()) > 0)) {
			return "订单时间段不在车位可租时间段内,订单不成立";
		}
		List<OrderBean> orderList = orderDao.findByParkingId(order.getParking().getId());

		if (orderList.size() != 0) {
			b = true;
			for (OrderBean orderBean : orderList) {
				// 如果订单开始时间在其他订单时间段内,订单不成立
				if (order.getStartTime().compareTo(orderBean.getStartTime()) > 0
						&& order.getStartTime().compareTo(orderBean.getEndTime()) < 0) {
					b = false;
					result = "订单开始时间在其他订单时间段内,订单不成立";
					break;
				}
				// 如果订单结束时间在其他订单时间段内,订单不成立
				if (order.getEndTime().compareTo(orderBean.getStartTime()) > 0
						&& order.getEndTime().compareTo(orderBean.getEndTime()) < 0) {
					b = false;
					result = "订单结束时间在其他订单时间段内,订单不成立";
					break;
				}
				// 如果订单的时间端内包含了其他订单,订单不成立
				if (order.getStartTime().compareTo(orderBean.getStartTime()) <= 0
						&& order.getEndTime().compareTo(orderBean.getEndTime()) >= 0) {
					b = false;
					result = "订单的时间段内包含了其他订单,订单不成立";
					break;
				}
			}
			System.out.println(b);
			// 判断完后标志位依然为true,表示该订单正确,可以生成
			if (b) {
				order.setPay(DateUtil.timeMinus(order.getStartTime(), order.getEndTime()) * parking.getPrice());
				b = orderDao.addOrder(order);
				if(b){
					result = "订单插入成功";
				}
			}
		} else {
			order.setPay(DateUtil.timeMinus(order.getStartTime(), order.getEndTime()) * parking.getPrice());
			b = orderDao.addOrder(order);
			if(b){
				result = "订单插入成功";
			}
		}
		return result;
	}

	/**
	 * 通过订单id查找订单信息
	 */
	@Override
	public OrderBean findOrderById(int id) {
		return orderDao.findByOrderId(id);
	}

	/**
	 * 修改订单的状态信息
	 */
	@Override
	public boolean changeOrderState(OrderBean order) {
		return orderDao.changeState(order);
	}

	// 查看抢租客的租赁记录
	@Override
	public List<OrderBean> showLog(int id) {
		List<OrderBean> bean = orderDao.showLog(id);
		return bean;
	}

	// 查看包租婆的被租赁记录
	@Override
	public List<ParkingBean> selectLog(int id) {
		List<ParkingBean> bean = orderDao.selectLog(id);
		return bean;
	}

	@Override
	public List<OrderBean> findOrderByState(int id, int state) {
		List<OrderBean> bean = orderDao.findOrderByState(id, state);
		return bean;
	}

	@Override
	public boolean companyOrder() {
		return false;
	}

}
