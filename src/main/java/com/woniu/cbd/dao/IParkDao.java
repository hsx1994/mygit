package com.woniu.cbd.dao;

import java.util.Date;
import java.util.List;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;

public interface IParkDao {

	int AddPark(List<ParkingBean> park);

	List<ParkingBean> ShowAll();

	List<ParkingBean> SelectPark(Date date);

	List<ParkingBean> SelectPark(String num);

	List<ParkingBean> SelectPark(int price);

	ParkingBean SelectParkOne(int id);

	int Lease(OrderBean bean);

	List<ParkingBean> SelectParkByNum(String num);

}
