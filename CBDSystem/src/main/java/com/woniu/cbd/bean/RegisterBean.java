package com.woniu.cbd.bean;

import java.io.Serializable;


public class RegisterBean implements Serializable{
	private static final long serialVersionUID = 1L;
	//普通用户ID
	private int id;
	//用户角色ID
	private int role;
	//普通用户用户名
	private String name;
	//普通用户密码
	private String pass;
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
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
	@Override
	public String toString() {
		return "RegisterBean [id=" + id + ", role=" + role + ", name=" + name
				+ ", pass=" + pass + ", realName=" + realName + ", address="
				+ address + ", tel=" + tel + ", idcard=" + idcard + ", job="
				+ job + ", email=" + email + ", orderCount=" + orderCount
				+ ", complaintCount=" + complaintCount + "]";
	}
	
}
