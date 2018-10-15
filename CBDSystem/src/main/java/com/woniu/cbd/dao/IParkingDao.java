package com.woniu.cbd.dao;

import java.util.Date;
import java.util.List;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;

public interface IParkingDao {
    //批量添加
	int AddPark(List<ParkingBean> park);
    //查看自己的申请记录
	List<ParkingBean> ShowAll();
    //日期查询
	List<ParkingBean> SelectPark(Date date);
    //价格查询
	List<ParkingBean> SelectPark(int price);
    //查询单个车位
	ParkingBean SelectParkOne(int id);
    //车位号模糊查询
	List<ParkingBean> SelectParkByNum(String num);
	/**
	 * 通过车位id查找车位的全部信息
	 * @param parkingId
	 * @return
	 */
	public ParkingBean findParkingById(int parkingId);

}
