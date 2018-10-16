package com.woniu.cbd.bean;

import java.io.Serializable;
import java.util.Date;

/**
 * 企业用户租赁记录
 * 
 * @author hsx
 *
 */
public class CompanyOrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	// 企业用户租赁记录ID
	private int id;
	// 企业用户租赁状态(0:未付款,1:已付款，在租,2:已取消)
	private int state;
	// 企业用户租赁开始时间
	private Date startTime;
	// 企业用户租赁结束时间
	private Date endTime;

	// 企业租车订单关联的车位信息
	private OtherParkingBean otherParking;
	// 企业租车订单关联的企业合约信息
	private CompanyBargainBean comBargain;
	// 企业订单关联的企业信息
	private CompanyInfoBean company;

	public CompanyBargainBean getComBargain() {
		return comBargain;
	}

	public void setComBargain(CompanyBargainBean comBargain) {
		this.comBargain = comBargain;
	}

	public CompanyInfoBean getCompany() {
		return company;
	}

	public void setCompany(CompanyInfoBean company) {
		this.company = company;
	}

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

	public OtherParkingBean getOtherParking() {
		return otherParking;
	}

	public void setOtherParking(OtherParkingBean otherParking) {
		this.otherParking = otherParking;
	}
}
