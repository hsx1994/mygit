package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;

public interface IUserDao {

	List<ParkingBean> ShowMe(int id);

	List<ParkingBean> SelectLog(int id);

	List<OrderBean> ShowLog(int id);

	int AddComplaint(ComplainBean bean);

}
