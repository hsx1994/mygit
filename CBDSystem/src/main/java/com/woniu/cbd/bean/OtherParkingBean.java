package com.woniu.cbd.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
/**
 * 第三方提供的车位的信息
 * @author hsx 
 *
 */
public class OtherParkingBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//第三方提供的车位ID
	private int id;
	//第三方提供的车位地址
	private String address;
	//第三方提供的车位车位号
	private String parkingNum;
	//第三方提供的车位图片
	private String img;
	//第三方提供的车位价格
	private double price;
	//第三方提供的车位开始时间
	private Date startTime;
	//第三方提供的车位结束时间
	private Date endTime;
	//关联的第三方合约信息
	@JsonIgnore
	private BargainBean bargain;
	//第三方车位出租产生的企业订单
	@JsonIgnore
	private List<CompanyOrderBean> order;
	
	public List<CompanyOrderBean> getOrder() {
		return order;
	}
	public void setOrder(List<CompanyOrderBean> order) {
		this.order = order;
	}
	public BargainBean getBargain() {
		return bargain;
	}
	public void setBargain(BargainBean bargain) {
		this.bargain = bargain;
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
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
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
	
}
