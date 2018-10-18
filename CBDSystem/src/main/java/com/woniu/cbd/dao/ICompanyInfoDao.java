package com.woniu.cbd.dao;

import com.woniu.cbd.bean.CompanyInfoBean;

public interface ICompanyInfoDao {

	CompanyInfoBean findByCompanyName(String comName);
   
}
