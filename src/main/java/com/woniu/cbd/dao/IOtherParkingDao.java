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
	public int otherParkingDelete(Integer[] id);
	
	/**
	 * 查询某个第三方车位信息
	 * @param bean
	 * @return
	 */
	public OtherParkingBean otherParkingSelect(OtherParkingBean bean);
	
	/**
	 * 查询所有第三方车位信息
	 * @return
	 */
	public List<OtherParkingBean> allOtherParkingSelect();
}
