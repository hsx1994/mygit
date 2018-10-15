package com.woniu.cbd.service;

import java.util.Date;
import java.util.List;

import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;

public interface IParkingService {
	//用于包租婆申请发布新的车位
    public boolean AddPark(List<ParkingBean> park);
   
    
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
    
   
    


}
