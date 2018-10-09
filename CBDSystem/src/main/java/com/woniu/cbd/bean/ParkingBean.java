package com.woniu.cbd.bean;

import java.util.Date;
/**
 * 个人出租车位信息
 * @author Administrator
 *
 */
public class ParkingBean {
	//个人出租车位ID
	private int id;
	//个人出租车位地址
	private String address;
	//个人出租车位车位号
	private String parkingNum;
	//个人出租车位图片
	private String img;
	//个人出租车位价格
	private int price;
	//个人出租车位开始时间
	private Date startTime;
	//个人出租车位结束时间
	private Date endTime;
	//个人出租车位状态(0:申请,1:审核通过,已待租,2:已租出,3:审核未通过)
	private int state;
	//个人出租车位产权证号
	private String certificate;
	//个人出租车位产权证图片
	private String certImg;
	//个人出租车位申请时间
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
