package com.woniu.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.OtherParkingBean;
import com.woniu.cbd.dao.IOtherParkingDao;
import com.woniu.cbd.service.IOtherParkingService;

@Service
public class OtherParkingServiceImpl implements IOtherParkingService {
	
	@Autowired
	private IOtherParkingDao dao;

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

}
