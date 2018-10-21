package com.woniu.cbd.service.impl;

import java.util.List;


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
	

	@Override
	public List<CompanyInfoBean> showAllCompany() {
		
		List<CompanyInfoBean> list = dao.findAllCompany();
		
		return list;
	}

	@Override
	public List<CompanyInfoBean> queryCompany(String condition) {
		
		List<CompanyInfoBean> list = dao.fuzzyQuery(condition);
		
		return list;
	}

	/**
	 * 根据登录表lid查企业id
	 * @param lid
	 * @return
	 */
	@Override
	public int findIdByLid(int lid) {
		
		return dao.findIdByLid(lid);
	}
	

}
