package com.woniu.cbd.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 后台管理员的信息
 * 
 * @author hsx
 *
 */
public class AdministratorBean implements Serializable {
	@Override
	public String toString() {
		return "AdministratorBean [id=" + id + ", login=" + login
				+ ", jobNumber=" + jobNumber + ", realName=" + realName
				+ ", tel=" + tel +  "]";
	}

	private static final long serialVersionUID = 1L;
	// 后台管理员ID
	private int id;
	//登录信息(用户名密码信息)
	private LoginBean login;
	// 后台管理员工号
	private String jobNumber;
	// 后台管理员真实姓名
	private String realName;
	// 后台管理员电话
	private String tel;
	// 后台管理员权限
	private List<PermissionBean> limit;
	
	
	public LoginBean getLogin() {
		return login;
	}

	public void setLogin(LoginBean login) {
		this.login = login;
	}

	public void setLimit(List<PermissionBean> limit) {
		this.limit = limit;
	}
	public List<PermissionBean> getLimit() {
		return limit;
	}

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
}
