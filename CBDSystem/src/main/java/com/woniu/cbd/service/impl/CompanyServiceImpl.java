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
	public List<OtherParkingBean> ShowCompanyPark() {
		// TODO Auto-generated method stub
		List<OtherParkingBean> bean=dao.ShowComPanyParkAll();
		return bean;
	}

	@Override
	public List<OtherParkingBean> ShowCompanyPark(int c_id) {
		// TODO Auto-generated method stub
		List<OtherParkingBean> bean=dao.ShowComPanyPark(c_id);
		return bean;
	}

	@Override
	public boolean CompanyLease(List<OtherParkingBean> other) {
		// TODO Auto-generated method stub
		int num=dao.CompanyLease(other);
		if(num>0){
			return true;
		}else{
		return false;
		}
	}

	@Override
	public List<CompanyBargainBean> CompanyContract(String name) {
		// TODO Auto-generated method stub
		List<CompanyBargainBean> bean=dao.CompanyContract(name);
		return bean;
	}

}