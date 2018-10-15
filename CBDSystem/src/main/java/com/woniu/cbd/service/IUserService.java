package com.woniu.cbd.service;


import java.util.List;

import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;

public interface IUserService {
	// 用于包租婆查看自己申请发布的车位
	public List<ParkingBean> ShowMe(int id);

	// 用于包租婆查看自己被租赁的记录
	public List<ParkingBean> SelectLog(int id);

	// 用于抢租客查看自己的租赁记录
	public List<OrderBean> ShowLog(int id);

	// 用于抢租客针对订单的投诉信息
	public boolean AddComplaint(ComplainBean bean);

}
