package com.woniu.cbd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.dao.ICompanyInfoDao;
import com.woniu.cbd.service.ICompanyInfoService;
@Service
public class CompanyInfoServiceImpl implements ICompanyInfoService {
	@Autowired
	private ICompanyInfoDao dao;
	@Override
	public CompanyInfoBean findByCompanyName(String comName) {
		CompanyInfoBean bean = dao.findByCompanyName(comName);
		
		return bean;
	}
	

}
