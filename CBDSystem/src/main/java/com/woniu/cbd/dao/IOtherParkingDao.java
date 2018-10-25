package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.OtherParkingBean;

/**
 * 第三方车位持久层业务
 * 
 * @author hsx
 *
 */
public interface IOtherParkingDao {

	/**
	 * 第三方车位批量添加
	 * 
	 * @param list
	 * @return
	 */
	public int otherParkingAdd(List<OtherParkingBean> list);

	/**
	 * 批量删除第三方车位
	 * 
	 * @param id
	 * @return
	 */
	public int otherParkingDelete(Integer[] id);

	/**
	 * 查询某个第三方车位信息
	 * 
	 * @param bean
	 * @return
	 */
	public OtherParkingBean otherParkingSelect(OtherParkingBean bean);

	/**
	 * 查询所有第三方车位信息
	 * 
	 * @return
	 */
	public List<OtherParkingBean> allOtherParkingSelect();

	// 前台查看企业的所有车位
	public List<CompanyBargainBean> showCompanyParkingAll(int id);

	// 企业查看单个车位信息
	public OtherParkingBean showCompanyParkingById(int c_id);
	/**
	 * 通过车位编号查找车位id
	 * @param parkingNumber
	 * @return
	 */
	public List<OtherParkingBean> findByParkingNumber(String[] parkingNumber);
	/**
	 * 查询车位所有的区域信息
	 * @return
	 */
	public List<String> findAddressByGroup();
	
	/**
	 * 查询某区域所有车位的编号
	 * @return
	 */
	public List<String> findParkingNumberByAddress(String address);
}
