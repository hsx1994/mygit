package com.woniu.cbd.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
/**
 * 个人用户租赁订单信息
 * @author hsx
 *
 */
public class OrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//订单ID
	private int id;
	//个人用户租赁开始时间
	private Date startTime;
	//个人用户租赁结束时间
	private Date endTime;
	//订单车位信息
	private ParkingBean parking;
	//订单对应的投诉集合
	private List<ComplainBean> complain;
	//个人用户信息
	private UserBean user;
	//个人用户租赁状态(0:未付款,1:已付款，在租,2:已取消)
	private int state;
	//订单总金额
	private double pay;

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	public ParkingBean getParking() {
		return parking;
	}
	public void setParking(ParkingBean parking) {
		this.parking = parking;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public List<ComplainBean> getComplain() {
		return complain;
	}
	public void setComplain(List<ComplainBean> complain) {
		this.complain = complain;
	}
	public double getPay() {
		return pay;
	}
	public void setPay(double pay) {
		this.pay = pay;
	}
}

