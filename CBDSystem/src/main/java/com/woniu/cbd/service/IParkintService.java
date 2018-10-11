package com.woniu.cbd.service;

import com.woniu.cbd.bean.ParkingBean;

/**
 * 个人用户车位信息的业务层业务
 * @author hsx
 *
 */
public interface IParkintService {
	/**
	 * 添加车位信息
	 * @return
	 */
	public boolean parkingAdd(ParkingBean bean);
	
	/**
	 * 删除某车位信息(不再系统中管理该车位)
	 * 一般为合约失效或者包租婆放弃续租
	 * @param bean
	 * @return
	 */
	public boolean parkingDelete(int id);
	
	/**
	 * 更改车位的部分信息
	 * @param bean
	 * @return
	 */
	public boolean parkingUpdate(ParkingBean bean);
	
	/**
	 * 查询某车位的详细信息
	 * @param bean
	 * @return
	 */
	public ParkingBean parkingSelect(ParkingBean bean);
}
