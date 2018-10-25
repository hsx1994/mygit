package com.woniu.cbd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.BargainBean;
import com.woniu.cbd.bean.OtherParkingBean;
import com.woniu.cbd.dao.IOtherParkingDao;
import com.woniu.cbd.service.IOtherParkingService;

@Service
public class OtherParkingServiceImpl implements IOtherParkingService {
	
	@Autowired
	private IOtherParkingDao dao;
	/**
	 * 添加车位
	 * @param bean
	 * @param address
	 * @param parkingNumber
	 * @param imgPath
	 * @param price
	 * @param startNumber
	 * @param endNumber
	 * @return
	 */
	public boolean addOtherParking(BargainBean bean,String[] address,
			String[] parkingNumber,String[] imgPath,String price[],String startNumber,String endNumber) {
		List<OtherParkingBean> list =new ArrayList<OtherParkingBean>();
		if (parkingNumber != null && parkingNumber.length != 0) {
			for (int i = 0; i < address.length; i++) {
				OtherParkingBean parkingBean = new OtherParkingBean();
				parkingBean.setBargain(bean);
				parkingBean.setAddress(address[i]);
				parkingBean.setParkingNum(parkingNumber[i]);
				parkingBean.setStartTime(bean.getStartTime());
				parkingBean.setEndTime(bean.getEndTime());
				parkingBean.setImg(imgPath[i]);
				parkingBean.setPrice(Double.parseDouble(price[i]));
				list.add(parkingBean);
			}
		}else {
			int start = Integer.parseInt(startNumber);
			int end = Integer.parseInt(endNumber);
			for (int i = start; i <= end; i++) {
				OtherParkingBean parkingBean = new OtherParkingBean();
				parkingBean.setBargain(bean);
				parkingBean.setAddress(address[0]);
				parkingBean.setParkingNum(String.valueOf(i));
				parkingBean.setStartTime(bean.getStartTime());
				parkingBean.setEndTime(bean.getEndTime());
				parkingBean.setImg(imgPath[0]);
				parkingBean.setPrice(Double.parseDouble(price[0]));
				list.add(parkingBean);
			}
		}
		int row = dao.otherParkingAdd(list);
		if(row > 0){
			return true;
		}
		return false;
	}
	
	@Override
	public boolean otherParkingAdd(List<OtherParkingBean> list) {
		int row = dao.otherParkingAdd(list);
		if(row > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean otherParkingDelete(Integer[] id) {
		int row = dao.otherParkingDelete(id);
		if(row > 0){
			return true;
		}
		return false;
	}

	@Override
	public OtherParkingBean otherParkingSelect(OtherParkingBean bean) {
		OtherParkingBean parking = dao.otherParkingSelect(bean);
		return parking;
	}

	@Override
	public List<OtherParkingBean> allOtherParkingSelect() {
		List<OtherParkingBean> list = dao.allOtherParkingSelect();
		return list;
	}
	//企业查看自己的所有车位
	@Override
	public List<OtherParkingBean> showCompanyParkingAll(int id) {
		List<OtherParkingBean> bean=dao.showCompanyParkingAll(id);
		return bean;
	}
    //企业查看单个车位
	@Override
	public OtherParkingBean showCompanyParkingById(int id) {
		OtherParkingBean bean=dao.showCompanyParkingById(id);
		return bean;
	}
	/**
	 * 查看车位的所有区域信息
	 */
	@Override
	public List<String> findAddressByGroup() {
		return dao.findAddressByGroup();
	}
	/**
	 * 查看某区域车位的所有编号
	 */
	@Override
	public List<String> findParkingNumberByAddress(String address) {
		return dao.findParkingNumberByAddress(address);
	}

	@Override
	public List<OtherParkingBean> showCompanyAll() {
		
		return dao.findCompanyAll();
	}

}
