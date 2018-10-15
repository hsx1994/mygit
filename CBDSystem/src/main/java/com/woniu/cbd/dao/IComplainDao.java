package com.woniu.cbd.dao;

import org.apache.ibatis.annotations.Param;
import com.woniu.cbd.bean.ComplainBean;

public interface IComplainDao {
	/**
	 * 管理员处理订单的业务
	 * @param state 订单处理状态
	 * @param id 投诉id
	 */
	public void updateComplainState(@Param("state") int state,@Param("id")int id);
	
	
	/**
	 * 管理员查看所有待处理投诉的业务
	 * @return 
	 */
	public ComplainBean findAllComplain();
}
