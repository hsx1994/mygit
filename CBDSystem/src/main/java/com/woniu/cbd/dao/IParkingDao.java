package com.woniu.cbd.dao;

import java.util.Date;
import java.util.List;

import com.woniu.cbd.bean.ParkingBean;

public interface IParkingDao {
	// 批量添加
	public int addParking(List<ParkingBean> park);

	// 查看自己的申请记录
	public List<ParkingBean> showAll();

	// 日期查询
	public List<ParkingBean> selectParking(Date date);

	// 价格查询
	public List<ParkingBean> selectParking(int price);

	// 查询单个车位
	public ParkingBean selectParkingOne(int id);

	// 车位号模糊查询
	public List<ParkingBean> selectParkingByNum(String num);

	// 包租婆查看申请记录
	List<ParkingBean> showMe(int id);

	/**
	 * 通过车位id查找车位的全部信息
	 * 
	 * @param parkingId
	 * @return
	 */
	public ParkingBean findParkingById(int parkingId);

	/**
	 * 删除某车位信息(不再在系统中管理该车位) 一般为合约失效或者包租婆放弃续租
	 * 
	 * @param bean
	 * @return
	 */
	public int parkingDelete(int id);

	/**
	 * 查询申请状态的车位
	 * 
	 * @param bean
	 * @return
	 */
	public List<ParkingBean> parkingSelect();

	/**
	 * 车位通过申请
	 * 
	 * @param id
	 * @return
	 */
	public int passApply(int id);

	/**
	 * 车位没有通过申请
	 * 
	 * @param id
	 * @return
	 */
	public int passApplyFail(int id);

	// 订单id查询车位信息
	public ParkingBean selectParkingByOrderID(int id);

}
