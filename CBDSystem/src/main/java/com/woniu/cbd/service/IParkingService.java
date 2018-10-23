package com.woniu.cbd.service;

import java.util.Date;
import java.util.List;

import com.woniu.cbd.bean.ParkingBean;

public interface IParkingService {
	//用于包租婆申请发布新的车位
    public boolean AddParking(List<ParkingBean> park);
   
    
    //用于抢租客查看所有的个人车位信息，无论是否被租赁
    public List<ParkingBean> ShowAll();
    
    
    //用于抢租客通过时间查询自己需要的车位信息
    public List<ParkingBean> SelectPark(Date date);
    
    
    //用于抢租客通过车位号模糊查询自己需要的车位信息
    public List<ParkingBean> SelectParkByNum(String num);
    //用于抢租客通过价格查询自己需要的车位信息
    public List<ParkingBean> SelectPark(int price);
    //用于抢租客查看指定的车位信息
    public ParkingBean SelectParkOne(int id);
    /**
	 * 通过ID查询单个车位信息
	 * @param id
	 * @return
	 */
	public ParkingBean findParkingById(int id);
   
    /**
	 * 删除某车位信息(不再在系统中管理该车位)
	 * 一般为合约失效或者包租婆放弃续租
	 * @param bean
	 * @return
	 */
	public boolean parkingDelete(int id);
	
	/**
	 * 查询申请状态的车位
	 * @param bean
	 * @return
	 */
	public List<ParkingBean> parkingSelect();
	
	/**
	 * 车位通过申请
	 * @param id
	 * @return
	 */
	public boolean passApply(int id);
	
	/**
	 * 车位没有通过申请
	 * @param id
	 * @return
	 */
	public boolean passApplyFail(int id);


}
