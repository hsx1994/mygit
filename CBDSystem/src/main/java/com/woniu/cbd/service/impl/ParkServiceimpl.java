package com.woniu.cbd.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.dao.IParkDao;
import com.woniu.cbd.service.IParkService;
@Service
public class ParkServiceimpl implements IParkService {
	@Autowired
    private IParkDao dao;
    
	
	//包租婆功能
	@Override
	public boolean AddPark(List<ParkingBean> park) {
		// TODO Auto-generated method stub
		int num=dao.AddPark(park);
		if(num>0){
			return true;
			
		}else{
		return false;
		}
		
	}
	
    //抢租客功能
	@Override
	public List<ParkingBean> ShowAll() {
		// TODO Auto-generated method stub
		List<ParkingBean> bean = dao.ShowAll();
		return bean;
	}

	@Override
	public List<ParkingBean> SelectPark(Date date) {
		// TODO Auto-generated method stub
		List<ParkingBean> bean=dao.SelectPark(date);
		return bean;
	}

	@Override
	public List<ParkingBean> SelectPark(String num) {
		// TODO Auto-generated method stub
		List<ParkingBean> bean=dao.SelectPark(num);
		return bean;
	}

	@Override
	public List<ParkingBean> SelectPark(int price) {
		// TODO Auto-generated method stub
		List<ParkingBean> bean=dao.SelectPark(price);
		return bean;
	}

	@Override
	public ParkingBean SelectParkOne(int id) {
		// TODO Auto-generated method stub
		ParkingBean bean=dao.SelectParkOne(id);
		return bean;
	}
	
    //抢租客的租赁
	@Override
	public boolean Lease(OrderBean bean) {
		// TODO Auto-generated method stub
		int num=dao.Lease(bean);
		if(num>0){
			return true;
		}else{
		return false;
		}
	}
	
	@Override
	public List<ParkingBean> SelectParkByNum(String num) {
		// TODO Auto-generated method stub
		List<ParkingBean> bean=dao.SelectParkByNum(num);
		return bean;
	}
}
