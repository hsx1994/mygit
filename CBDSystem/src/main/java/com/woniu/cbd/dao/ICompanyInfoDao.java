package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.CompanyInfoBean;

public interface ICompanyInfoDao {
   /**
    * 根据条件模糊查询企业
    * @param condition
    * @return
    */
   public List<CompanyInfoBean> fuzzyQuery(String condition);
   /**
    * 显示所有企业信息
    * @param id
    * @return
    */
   public List<CompanyInfoBean> findAllCompany();

   
	/**
	 * 按企业名称查询企业信息
	 * @param comName
	 * @return
	 */
   public CompanyInfoBean findByCompanyName(String comName);
   /**
    * 新增企业信息
    * @param bean
    */
   public int addCompany(CompanyInfoBean bean);
   
}
