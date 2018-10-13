package com.woniu.cbd.bean;

import java.io.Serializable;

/**
 * 企业用户信息
 * @author hsx
 *
 */
public class CompanyInfoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//企业用户ID
	private int id;
	//企业用户用户名
	private String name;
	//企业用户密码
	private String pass;
	//企业名称
	private String comName;
	//企业地址(楼层)
	private String address;
	//企业用户联系人
	private String contact;
	//企业用户电话
	private String tel;
	//企业用户邮箱
	private String email;
	
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
	public String getComName() {
		return comName;
	}
	public void setComName(String comName) {
		this.comName = comName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}
