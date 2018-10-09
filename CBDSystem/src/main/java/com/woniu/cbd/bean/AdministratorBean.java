package com.woniu.cbd.bean;

import java.util.List;

public class AdministratorBean {
	private int id;
	private String name;
	private String pass;
	private String jobNumber;
	private String realName;
	private String tel;
	private List<String> limit;
	
	
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public List<String> getLimit() {
		return limit;
	}
	public void setLimit(List<String> limit) {
		this.limit = limit;
	}
	
}
