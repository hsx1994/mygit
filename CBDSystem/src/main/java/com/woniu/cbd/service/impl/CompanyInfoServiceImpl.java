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


	@Override
	public String addCompanyInfo(CompanyInfoBean bean) {
		String result ="添加失败";
		
		int row = dao.addCompany(bean);
		if(row>0){
			result="添加成功";
		}
		
		return result;
	}
	

}
