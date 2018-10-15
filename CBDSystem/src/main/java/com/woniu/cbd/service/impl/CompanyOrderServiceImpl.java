package com.woniu.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.CompanyOrderBean;
import com.woniu.cbd.dao.ICompanyOrderDao;
import com.woniu.cbd.service.ICompanyOrderService;
@Service
public class CompanyOrderServiceImpl implements ICompanyOrderService{
	@Autowired
	private ICompanyOrderDao dao;
	//批量添加公司订单方法
	@Override
	public boolean addCompanyOrder(List<CompanyOrderBean> companyOrders) {
		boolean b = dao.addCompanyOrder(companyOrders);
		return b;
	}
	//企业查看企业租赁记录
	@Override
	public List<CompanyOrderBean> selectCompanyOrder(int id) {
		// TODO Auto-generated method stub
		List<CompanyOrderBean> bean=dao.selectCompanyOrder(id);
		return bean;
	}

}
