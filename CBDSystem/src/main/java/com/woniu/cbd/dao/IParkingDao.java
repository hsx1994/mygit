package com.woniu.cbd.dao;

import com.woniu.cbd.bean.ParkingBean;

/**
 * 个人用户车位信息的持久层业务
 * @author hsx
 *
 */
public interface IParkingDao {
	/**
	 * 添加车位信息
	 * @return
	 */
	public int parkingAdd(ParkingBean bean);
	
	/**
	 * 删除某车位信息(不再系统中管理该车位)
	 * 一般为合约失效或者包租婆放弃续租
	 * @param bean
	 * @return
	 */
	public int parkingDelete(int id);
	
	/**
	 * 更改车位的部分信息
	 * @param bean
	 * @return
	 */
	public int parkingUpdate(ParkingBean bean);
	
	/**
	 * 查询某车位的详细信息
	 * @param bean
	 * @return
	 */
	public ParkingBean parkingSelect(ParkingBean bean);
}
