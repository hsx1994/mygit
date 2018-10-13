package com.woniu.cbd.bean;

/**
 * 描述：用于各种用户登录
 * 
 * @author wt
 *
 */
public class LoginBean {
	// 登录表id
	private int id;
	// 登录名
	private String name;
	// 登录密码
	private String password;
	// 登录角色
	private int role;
	// 软删除
	private short delete;
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
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public short getDelete() {
		return delete;
	}
	public void setDelete(short delete) {
		this.delete = delete;
	}
}
