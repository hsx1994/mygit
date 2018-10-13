package com.woniu.cbd.bean;

import java.io.Serializable;
import java.util.Date;
/**
 * 企业合约内容信息
 * @author hsx
 *
 */
public class CompanyBargainBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//企业合约ID
	private int id;
	//企业合约中的企业名称
	private String name;
	//企业合约编号
	private String number;
	//企业合约复印件
	private String img;
	//企业合约开始时间
	private Date startTime;
	//企业合约结束时间
	private Date endTime;
	//企业合约租赁车位描述(车位号)
	private String parkingDes;
	//企业合约状态(0:正在用,1:续约,2:毁约)
	private int state;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
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
