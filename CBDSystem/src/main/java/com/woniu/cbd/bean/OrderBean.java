package com.woniu.cbd.bean;

import java.io.Serializable;
import java.util.Date;
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
	//订单车位ID
	private int parkingId;
	//个人用户ID
	private int userId;
	//个人用户租赁状态(0:未付款,1:已付款，在租,2:已取消)
	private int state;
	
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
	public int getParkingId() {
		return parkingId;
	}
	public void setParkingId(int parkingId) {
		this.parkingId = parkingId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "OrderBean [id=" + id + ", startTime=" + startTime
				+ ", endTime=" + endTime + ", parkingId=" + parkingId
				+ ", userId=" + userId + ", state=" + state + "]";
	}
	
}
