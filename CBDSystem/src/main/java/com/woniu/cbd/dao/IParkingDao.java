package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.ParkingBean;

/**
 * 个人用户车位信息的持久层业务
 * @author hsx
 *
 */
public interface IParkingDao {
	
	/**
	 * 删除某车位信息(不再在系统中管理该车位)
	 * 一般为合约失效或者包租婆放弃续租
	 * @param bean
	 * @return
	 */
	public int parkingDelete(int id);
	
	/**
	 * 查询申请状态的车位
	 * @param bean
	 * @return
	 */
	public List<ParkingBean> parkingSelect();
	
	/**
	 * 车位通过申请
	 * @param id
	 * @return
	 */
	public int passApply(int id);
	
	/**
	 * 车位没有通过申请
	 * @param id
	 * @return
	 */
	public int passApplyFail(int id);
	
	
}
