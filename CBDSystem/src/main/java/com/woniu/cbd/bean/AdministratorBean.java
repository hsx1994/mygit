package com.woniu.cbd.bean;

import java.io.Serializable;

/**
 * 后台管理员的信息
 * 
 * @author hsx
 *
 */
public class AdministratorBean implements Serializable {
	private static final long serialVersionUID = 1L;
	// 后台管理员ID
	private int id;
	// 登录表id
	private int lid;
	// 后台管理员工号
	private String jobNumber;
	// 后台管理员真实姓名
	private String realName;
	// 后台管理员电话
	private String tel;
	// 后台管理员权限
	private int limit;

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

}
