package com.woniu.cbd.service;

import java.util.List;

import com.woniu.cbd.bean.ComplainBean;

/**
 * 用于普通管理员处理投诉信息的业务（查看待处理投诉，处理投诉信息）
 * @author Administrator
 *
 */
public interface IComplainService {
	/**
	 * 显示待处理的投诉信息
	 */
	public  List<ComplainBean> showComplain();
	
	/**
	 * 用于受理用户的投诉信息，state：1生效，2，无效
	 * @param state
	 * @param id
	 * @return
	 */
	public String acceptComplain(int state,int id);
}
