package com.woniu.cbd.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.dao.IParkingDao;
import com.woniu.cbd.service.IParkingService;
@Service
public class ParkingServiceimpl implements IParkingService {
	@Autowired
    private IParkingDao dao;
    
	
	//包租婆批量添加功能
	@Override
	public boolean AddParking(List<ParkingBean> park) {
		// TODO Auto-generated method stub
		int num=dao.AddParking(park);
		if(num>0){
			return true;
			
		}else{
		return false;
		}
		
	}
	
    //抢租客查看所有上架车位功能
	@Override
	public List<ParkingBean> ShowAll() {
		List<ParkingBean> bean = dao.ShowAll();
		return bean;
	}
    //根据日期上架
	@Override
	public List<ParkingBean> SelectPark(Date date) {
		// TODO Auto-generated method stub
		List<ParkingBean> bean=dao.SelectPark(date);
		return bean;
	}

    //根据价格查询
	@Override
	public List<ParkingBean> SelectPark(int price) {
		// TODO Auto-generated method stub
		List<ParkingBean> bean=dao.SelectPark(price);
		return bean;
	}
    //查询单个车位
	@Override
	public ParkingBean SelectParkOne(int id) {
		// TODO Auto-generated method stub
		ParkingBean bean=dao.SelectParkOne(id);
		return bean;
	}
	
  
    //车位号模糊查询	
	@Override
	public List<ParkingBean> SelectParkByNum(String num) {
		// TODO Auto-generated method stub
		List<ParkingBean> bean=dao.SelectParkByNum(num);
		return bean;
	}
	/**
	 * 通过ID查询单个车位信息
	 * @param id
	 * @return
	 */
	public ParkingBean findParkingById(int id){
		ParkingBean bean = dao.findParkingById(id);
		return bean;
	}
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
