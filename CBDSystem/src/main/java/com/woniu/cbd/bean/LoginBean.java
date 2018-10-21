package com.woniu.cbd.bean;

import java.io.Serializable;

/**
 * 描述：用于各种用户登录
 * 
 * @author wt
 *
 */
public class LoginBean implements Serializable{
	private static final long serialVersionUID = 1L;
	// 登录表id
	private int id;
	// 登录名
	private String name;
	// 登录密码
	private String password;
	// 登录角色
	private String role;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}
