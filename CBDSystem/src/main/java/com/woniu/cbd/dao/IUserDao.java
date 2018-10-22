package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;

public interface IUserDao {
    
    
	
	// 通过登录表的id查包租婆或抢租客表的id
	int findIdByLid(int lid);
}
