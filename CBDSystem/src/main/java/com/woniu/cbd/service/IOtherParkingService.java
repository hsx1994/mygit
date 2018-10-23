package com.woniu.cbd.service;

import java.util.List;

import com.woniu.cbd.bean.BargainBean;
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
	public boolean addOtherParking(BargainBean bean,String[] address,
			String[] parkingNumber,String[] imgPath,double price[],String startNumber,String endNumber); 
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
	public boolean otherParkingDelete(Integer[] id);
	
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
	
	// 用于企业查看可租赁的企业车位车位
	public List<OtherParkingBean> showCompanyParkingAll(int id);

	// 用于企业查看单个车位信息
	public OtherParkingBean showCompanyParkingById(int c_id);
	/**
	 * 查询车位的所有区域信息
	 * @return
	 */
	public List<String> findAddressByGroup();
	/**
	 * 查询某区域所有车位的编号
	 * @return
	 */
	public List<String> findParkingNumberByAddress(String address);
}
