package com.woniu.cbd.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 第三方合约内容信息
 * @author hsx
 *
 */
public class BargainBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//第三方合约ID
	private int id;
	//第三方合约编号
	private String number;
	//第三方合约企业名称
	private String company;
	//第三方合约企业联系人
	private String contact;
	//第三方合约联系人电话
	private String tel;
	//第三方合约企业地址
	private String address;
	//第三方合约复印件
	private String img;
	//第三方合约开始时间
	private Date startTime;
	//第三方合约结束时间
	private Date endTime;
	//第三方合约涉及车位描述(车位号)
	private String parkingDes;
	//第三方合约状态(0:正在用,2:毁约)
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
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getContact() {
		return contact;
	}
	public void setContact(String contact) {
		this.contact = contact;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
