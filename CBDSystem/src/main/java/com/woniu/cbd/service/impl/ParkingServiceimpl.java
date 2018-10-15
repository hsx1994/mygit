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
    
	
	//包租婆批量添加功能
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
	
    //抢租客查看所有上架车位功能
	@Override
	public List<ParkingBean> ShowAll() {
		// TODO Auto-generated method stub
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
}
