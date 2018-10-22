package com.woniu.cbd.bean;

import java.io.Serializable;

import java.util.List;

/**
 * 企业用户信息
 * @author hsx
 *
 */
public class CompanyInfoBean implements Serializable {
	private static final long serialVersionUID = 1L;
	//企业ID
	private int id;
	//企业用户loginbean对象
	private LoginBean comLogin;
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
	//企业用户的订单信息
	private List<CompanyOrderBean> comOrder;
	//企业用户的合约信息
	private List<CompanyBargainBean> comBargain;
	
	
	public List<CompanyOrderBean> getComOrder() {
		return comOrder;
	}
	public void setComOrder(List<CompanyOrderBean> comOrder) {
		this.comOrder = comOrder;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public List<CompanyBargainBean> getComBargain() {
		return comBargain;
	}
	public void setComBargain(List<CompanyBargainBean> comBargain) {
		this.comBargain = comBargain;
	}
	public LoginBean getComLogin() {
		return comLogin;
	}
	public void setComLogin(LoginBean comLogin) {
		this.comLogin = comLogin;
	}
	
	
}
