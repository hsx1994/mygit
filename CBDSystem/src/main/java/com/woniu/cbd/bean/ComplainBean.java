package com.woniu.cbd.bean;

import java.io.Serializable;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(value = {"handler"})
public class ComplainBean implements Serializable{
	private static final long serialVersionUID = 1L;
	//个人用户投诉ID
	private int id;
	//个人用户投诉者
	private UserBean user;
	//个人用户投诉的订单
	private OrderBean order;
	//个人用户被投诉者
	private UserBean buser;
	//个人用户投诉内容
	private String content;
	//个人用户投诉状态(0:暂缓状态,1:投诉生效,2:投诉无效)
	private int state;
	//个人用户投诉时间
	private Date time;
	
	public UserBean getBuser() {
		return buser;
	}
	public void setBuser(UserBean buser) {
		this.buser = buser;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public UserBean getUser() {
		return user;
	}
	public void setUser(UserBean user) {
		this.user = user;
	}
	synchronized
	public OrderBean getOrder() {
		return order;
	}
	public void setOrder(OrderBean order) {
		this.order = order;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getState() {
		return state;
	}
	public void setState(int state) {
		this.state = state;
	}
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}

	
}
