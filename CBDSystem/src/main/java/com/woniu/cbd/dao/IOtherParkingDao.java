package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.OtherParkingBean;

/**
 * 第三方车位持久层业务
 * @author hsx
 *
 */
public interface IOtherParkingDao {
	
	/**
	 * 第三方车位批量添加
	 * @param list
	 * @return
	 */
	public int otherParkingAdd(List<OtherParkingBean> list);
	
	/**
	 * 批量删除第三方车位
	 * @param id
	 * @return
	 */
	public int otherParkingDelete(int[] id);
	
	/**
	 * 修改第三方车位信息
	 * @param bean
	 * @return
	 */
	public int otherParkingUpdate(OtherParkingBean bean);
	
	/**
	 * 查询第三方车位信息
	 * @param bean
	 * @return
	 */
	public OtherParkingBean otherParkingSelect(OtherParkingBean bean);
}
