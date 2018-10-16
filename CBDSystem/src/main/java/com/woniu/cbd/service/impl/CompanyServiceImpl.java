package com.woniu.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.OtherParkingBean;
import com.woniu.cbd.dao.ICompanyDao;
import com.woniu.cbd.service.ICompanyService;
@Service
public class CompanyServiceImpl implements ICompanyService {
	@Autowired
	private ICompanyDao dao;
	
	
	@Override
	public List<OtherParkingBean> ShowCompanyPark(int id) {
		// TODO Auto-generated method stub
		List<OtherParkingBean> bean=dao.ShowComPanyParkAll(id);
		return bean;
	}

	@Override
	public OtherParkingBean ShowCompanyParkById(int c_id) {
		// TODO Auto-generated method stub
		OtherParkingBean bean=dao.ShowComPanyPark(c_id);
		return bean;
	}


	@Override
	public List<CompanyBargainBean> CompanyContract(String name) {
		// TODO Auto-generated method stub
		List<CompanyBargainBean> bean=dao.CompanyContract(name);
		return bean;
	}

}
