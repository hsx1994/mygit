package com.woniu.cbd.bean;

import java.util.Date;

public class CompanyBargainBean {
	private int id;
	private String number;
	private String img;
	private Date startTime;
	private Date endTime;
	private String parkingDes;
	private int state;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
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
	public String getParkingDes() {
		return parkingDes;
	}
	public void setParkingDes(String parkingDes) {
		this.parkingDes = parkingDes;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
}
