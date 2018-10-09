package com.woniu.cbd.bean;

import java.util.Date;

public class ParkingBean {
	private int id;
	private String address;
	private String parkingNum;
	private String img;
	private int price;
	private Date startTime;
	private Date endTime;
	private int state;
	private String certificate;
	private String certImg;
	private Date applyTime;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getParkingNum() {
		return parkingNum;
	}
	public void setParkingNum(String parkingNum) {
		this.parkingNum = parkingNum;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
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
	public String getCertificate() {
		return certificate;
	}
	public void setCertificate(String certificate) {
		this.certificate = certificate;
	}
	public String getCertImg() {
		return certImg;
	}
	public void setCertImg(String certImg) {
		this.certImg = certImg;
	}
	public Date getApplyTime() {
		return applyTime;
	}
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
}
