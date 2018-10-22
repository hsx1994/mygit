package com.woniu.cbd.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.dao.IParkingDao;
import com.woniu.cbd.service.IParkingService;
@Service
public class ParkingServicelmpl implements IParkingService {
	@Autowired
    private IParkingDao dao;
    
	
	//包租婆批量添加功能
	@Override
	public boolean addParking(List<ParkingBean> park) {
		// TODO Auto-generated method stub
		int num=dao.addParking(park);
		if(num>0){
			return true;
			
		}else{
		return false;
		}
		
	}
	
	// 查看包租婆的发布记录
		@Override
		public List<ParkingBean> showMe(int id) {
			List<ParkingBean> bean = dao.showMe(id);
			return bean;
		}
	
    //抢租客查看所有上架车位功能
	@Override
	public List<ParkingBean> showAll() {
		// TODO Auto-generated method stub
		List<ParkingBean> bean = dao.showAll();
		return bean;
	}
    //根据日期上架
	@Override
	public List<ParkingBean> selectParking(Date date) {
		// TODO Auto-generated method stub
		List<ParkingBean> bean=dao.selectParking(date);
		return bean;
	}

    //根据价格查询
	@Override
	public List<ParkingBean> selectParking(int price) {
		// TODO Auto-generated method stub
		List<ParkingBean> bean=dao.selectParking(price);
		return bean;
	}
    //查询单个车位
	@Override
	public ParkingBean selectParkingOne(int id) {
		// TODO Auto-generated method stub
		ParkingBean bean=dao.selectParkingOne(id);
		return bean;
	}
	
  
    //车位号模糊查询	
	@Override
	public List<ParkingBean> selectParkingByNum(String num) {
		// TODO Auto-generated method stub
		List<ParkingBean> bean=dao.selectParkingByNum(num);
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
    //根据订单id查询车位信息
	@Override
	public ParkingBean selectParkingByOrderID(int id) {
		// TODO Auto-generated method stub
		ParkingBean bean=dao.selectParkingByOrderID(id);
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
}
