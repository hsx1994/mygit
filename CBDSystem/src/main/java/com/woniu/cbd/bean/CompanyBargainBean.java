package com.woniu.cbd.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 企业合约内容信息
 * 
 * @author hsx
 *
 */
public class CompanyBargainBean implements Serializable {
	private static final long serialVersionUID = 1L;
	// 企业合约ID
	private int id;
	// 企业合约中的企业信息
	private CompanyInfoBean company;
	// 企业合约编号
	private String number;
	// 企业合约复印件
	private String img;
	// 企业联系人
	private String contact;
	// 联系人电话
	private String tel;
	// 企业合约开始时间
	private Date startTime;
	// 企业合约结束时间
	private Date endTime;
	// 企业合约状态(0:正在用,2:毁约)
	private int state;
	// 企业合约包含的订单集合
	private List<CompanyOrderBean> comOrder;

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

	public List<CompanyOrderBean> getComOrder() {
		return comOrder;
	}

	public void setComOrder(List<CompanyOrderBean> comOrder) {
		this.comOrder = comOrder;
	}

	public CompanyInfoBean getCompany() {
		return company;
	}

	public void setCompany(CompanyInfoBean company) {
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
}
