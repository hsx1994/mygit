package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.CompanyInfoBean;

public interface ICompanyInfoDao {
   /**
    * 根据条件模糊查询企业的业务
    * @param condition
    * @return
    */
   public List<CompanyInfoBean> fuzzyQuery(String condition);
   /**
    * 显示所有企业信息业务
    * @param id
    * @return
    */
   public List<CompanyInfoBean> findAllCompany();

   
	/**
	 * 
	 * @param comName
	 * @return
	 */
   public CompanyInfoBean findByCompanyName(String comName);
   
}
