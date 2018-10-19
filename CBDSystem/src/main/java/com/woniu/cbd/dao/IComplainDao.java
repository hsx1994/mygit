package com.woniu.cbd.dao;

import java.util.List;

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
	public List<ComplainBean> findAllComplain();
	
	/**
	 * 根据页码显示待处理投诉的信息
	 * @return
	 */
	public List<ComplainBean> findComplainByPage(int page);
	
	/**
	 * 按id查询投诉详情
	 * @return
	 */
	public ComplainBean findComplainById(int id);
}
