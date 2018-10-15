package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.CompanyOrderBean;

public interface ICompanyOrderDao {
	
	public boolean addCompanyOrder(List<CompanyOrderBean> companyOrders);
	
	public boolean changeState(CompanyOrderBean order);

	public List<CompanyOrderBean> selectCompanyOrder(int id);
}
