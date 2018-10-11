package com.woniu.cbd.service;

import java.util.List;

import com.woniu.cbd.bean.OtherParkingBean;

/**
 * 第三方车位业务层业务
 * @author hsx
 *
 */
public interface IOtherParkingService {
	/**
	 * 第三方车位批量添加
	 * @param list
	 * @return
	 */
	public boolean otherParkingAdd(List<OtherParkingBean> list);
	
	/**
	 * 批量删除第三方车位
	 * @param id
	 * @return
	 */
	public boolean otherParkingDelete(int[] id);
	
	/**
	 * 查询第三方车位信息
	 * @param bean
	 * @return
	 */
	public OtherParkingBean otherParkingSelect(OtherParkingBean bean);
	
	/**
	 * 查询所有第三方车位信息
	 * @param bean
	 * @return
	 */
	public List<OtherParkingBean> allOtherParkingSelect();
}
