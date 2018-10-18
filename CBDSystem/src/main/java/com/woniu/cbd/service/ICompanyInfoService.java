package com.woniu.cbd.service;

import java.util.List;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.OtherParkingBean;
import com.woniu.cbd.dao.ICompanyInfoDao;


public interface ICompanyInfoService {

	public CompanyInfoBean findByCompanyName(String comName);
		
		
}
