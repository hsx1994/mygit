package com.woniu.cbd.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.CompanyOrderBean;
import com.woniu.cbd.bean.OtherParkingBean;
import com.woniu.cbd.dao.ICompanyOrderDao;
import com.woniu.cbd.dao.IOtherParkingDao;
import com.woniu.cbd.service.ICompanyOrderService;
@Service
public class CompanyOrderServiceImpl implements ICompanyOrderService{
	@Autowired
	private ICompanyOrderDao dao;
	@Autowired
	private IOtherParkingDao parkingDao;
	//批量添加公司订单方法
	@Override
	public boolean addCompanyOrder(List<CompanyOrderBean> companyOrders) {
		return false;
	}
	//企业查看企业租赁记录
	@Override
	public List<CompanyOrderBean> selectCompanyOrder(int id) {
		// TODO Auto-generated method stub
		List<CompanyOrderBean> bean=dao.selectCompanyOrder(id);
		return bean;
	}
	//批量添加企业租车订单
	@Override
	public boolean addCompanyOrder(CompanyBargainBean bean,
			String[] parkingNumber) {
		List<OtherParkingBean> list = parkingDao.findByParkingNumber(parkingNumber);
		if (list != null) {
			List<CompanyOrderBean> orders = new ArrayList<CompanyOrderBean>();
			for (OtherParkingBean parking : list) {
				CompanyOrderBean order = new CompanyOrderBean();
				order.setComBargain(bean);
				order.setStartTime(bean.getStartTime());
				order.setEndTime(bean.getEndTime());
				order.setOtherParking(parking);
				order.setCompany(bean.getCompany());
				orders.add(order);
			}
			int i = dao.addCompanyOrder(orders);
			if (i==0) {
				return false;
			}else {
				return true;
			}
		}
		return false;
	}

}
