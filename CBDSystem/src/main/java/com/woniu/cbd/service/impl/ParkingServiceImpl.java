package com.woniu.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.dao.IParkingDao;
import com.woniu.cbd.service.IParkingService;

@Service
public class ParkingServiceImpl implements IParkingService {
	
	@Autowired
	private IParkingDao dao;

	@Override
	public boolean parkingDelete(int id) {
		int row = dao.parkingDelete(id);
		if(row > 0){
			return true;
		}
		return false;
	}

	@Override
	public List<ParkingBean> parkingSelect() {
		List<ParkingBean> list = dao.parkingSelect();
		return list;
	}

	@Override
	public boolean passApply(int id) {
		int row = dao.passApply(id);
		if(row > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean passApplyFail(int id) {
		int row = dao.passApplyFail(id);
		if(row > 0){
			return true;
		}
		return false;
	}
}
