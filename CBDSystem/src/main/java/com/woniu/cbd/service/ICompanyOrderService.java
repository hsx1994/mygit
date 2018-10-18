package com.woniu.cbd.service;

import java.util.List;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.CompanyOrderBean;

public interface ICompanyOrderService {
	public boolean addCompanyOrder(List<CompanyOrderBean> companyOrders);
	//企业查看租赁记录
	public List<CompanyOrderBean> selectCompanyOrder(int id);
	//批量添加订单
	public boolean addCompanyOrder(CompanyBargainBean bean, String[] parkingNumber);
}
