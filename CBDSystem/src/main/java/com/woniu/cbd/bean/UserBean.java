package com.woniu.cbd.bean;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * 普通用户信息表
 * @author hsx
 *
 */
public class UserBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//普通用户ID
	private int id;
	//登录信息(用户名密码信息)
	@JsonIgnore
	private LoginBean login;
	//普通用户账号真实姓名
	private String realName;
	//普通用户地址
	private String address;
	//普通用户电话
	private String tel;
	//普通用户身份证号
	private String idcard;
	//普通用户职业
	private String job;
	//普通用户邮箱
	private String email;
	//普通用户订单完成次数
	private int orderCount;
	//普通用户被投诉次数
	private int complaintCount;
	//包租婆所拥有的车位集合
	@JsonIgnore
	private List<ParkingBean> parking;
	
	
	public LoginBean getLogin() {
		return login;
	}
	public void setLogin(LoginBean login) {
		this.login = login;
	}
	public List<ParkingBean> getParking() {
		return parking;
	}
	public void setParking(List<ParkingBean> parking) {
		this.parking = parking;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getIdcard() {
		return idcard;
	}
	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public int getComplaintCount() {
		return complaintCount;
	}
	public void setComplaintCount(int complaintCount) {
		this.complaintCount = complaintCount;
	}
	
}
