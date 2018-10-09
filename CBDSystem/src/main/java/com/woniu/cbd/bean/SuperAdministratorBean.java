package com.woniu.cbd.bean;
/**
 * 超级管理员的信息
 * @author hsx
 *
 */
public class SuperAdministratorBean {
	//超级管理员ID
	private int id;
	//超级管理员账号
	private String name;
	//超级管理员密码
	private String pass;
	//超级管理员工号
	private String jobNumber;
	//超级管理员真实姓名
	private String realName;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getJobNumber() {
		return jobNumber;
	}
	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
}
