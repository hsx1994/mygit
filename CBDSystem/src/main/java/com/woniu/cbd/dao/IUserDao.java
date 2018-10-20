package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;

public interface IUserDao {
    //包租婆查看申请记录
	List<ParkingBean> ShowMe(int id);
    //包租婆查看被租赁记录
	List<ParkingBean> SelectLog(int id);
    //抢租客查看租赁记录
	List<OrderBean> ShowLog(int id);
   
}
