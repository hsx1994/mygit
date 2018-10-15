package com.woniu.cbd.bean;

import java.io.Serializable;
import java.util.Date;

import java.util.List;
/**
 * 个人出租车位信息
 * @author hsx
 *
 */
public class ParkingBean implements Serializable {
	private static final long serialVersionUID = 1L;
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
	//个人出租车位状态(0:申请,1:审核通过,2:审核未通过)
	private int state;
	//个人出租车位产权证号
	private String certificate;
	//个人出租车位产权证图片
	private String certImg;
	//个人出租车位申请时间
	private Date applyTime;
	//个人车位订单集合
	private List<OrderBean> orders;
	//个人车位对应的包租婆信息
	private UserBean user;
	
	
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	public List<OrderBean> getOrders() {
		return orders;
	}
	public void setOrders(List<OrderBean> orders) {
		this.orders = orders;
	}
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
	@Override
	public String toString() {
		return "ParkingBean [id=" + id + ", address=" + address
				+ ", parkingNum=" + parkingNum + ", img=" + img + ", price="
				+ price + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", state=" + state + ", certificate=" + certificate
				+ ", certImg=" + certImg + ", applyTime=" + applyTime + "]";
	}
	
}
