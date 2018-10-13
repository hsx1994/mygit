package com.woniu.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.dao.ICompanyBargainDao;
import com.woniu.cbd.service.ICompanyBargainService;

@Service
public class CompanyBargainServiceImpl implements ICompanyBargainService {
	
	@Autowired
	private ICompanyBargainDao dao;

	@Override
	public boolean companyBargainAdd(CompanyBargainBean bean) {
		int row = dao.companyBargainAdd(bean);
		if(row > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean companyBargainDelete(int id) {
		int row = dao.companyBargainDelete(id);
		if(row > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean companyBargainUpdate(CompanyBargainBean bean) {
		int row = dao.companyBargainUpdate(bean);
		if(row > 0){
			return true;
		}
		return false;
	}

	@Override
	public List<CompanyBargainBean> companyBargainSelect(CompanyBargainBean bean) {
		List<CompanyBargainBean> bargain = dao.companyBargainSelect(bean);
		return bargain;
	}

	@Override
	public List<CompanyBargainBean> allCompanyBargainSelect() {
		List<CompanyBargainBean> list = dao.allCompanyBargainSelect();
		return list;
	}

}
