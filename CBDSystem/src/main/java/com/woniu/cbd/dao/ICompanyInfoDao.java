package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.CompanyInfoBean;

public interface ICompanyInfoDao {
   /**
    * 显示所有企业信息
    * @param id
    * @return
    */
   public List<CompanyInfoBean> findAllCompany();
	/**
	 * 根据条件模糊查询企业的业务
	 * 
	 * @param condition
	 * @return
	 */
	public List<CompanyInfoBean> fuzzyQuery(String condition);
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

	/**
	 * @param lid
	 * @return
	 */
	public int findIdByLid(int lid);
	/**
	 * 根据ID查询企业信息
	 * @param id
	 * @return
	 */
	public CompanyInfoBean findById(Integer id);

}
