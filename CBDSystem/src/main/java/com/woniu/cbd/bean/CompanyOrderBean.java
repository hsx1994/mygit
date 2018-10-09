package com.woniu.cbd.bean;

import java.util.Date;
/**
 * 企业用户租赁记录
 * @author hsx
 *
 */
public class CompanyOrderBean {
	//企业用户租赁记录ID
	private int id;
	//企业用户租赁状态(0:未付款,1:已付款，在租,2:已取消)
	private int state;
	//企业用户租赁开始时间
	private Date startTime;
	//企业用户租赁结束时间
	private Date endTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
}
