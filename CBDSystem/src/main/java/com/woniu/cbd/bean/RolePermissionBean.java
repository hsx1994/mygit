package com.woniu.cbd.bean;

import java.io.Serializable;

public class RolePermissionBean implements Serializable{
	private int loginId;
	private int perId;

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginId) {
		this.loginId = loginId;
	}

	public int getPerId() {
		return perId;
	}

	public void setPerId(int perId) {
		this.perId = perId;
	}

}
