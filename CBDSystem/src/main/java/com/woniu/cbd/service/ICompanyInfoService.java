package com.woniu.cbd.service;

import java.util.List;

import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.LoginBean;


public interface ICompanyInfoService {

	/**
	 * 后台管理员查看所有企业用户
	 * @return
	 */
	public List<CompanyInfoBean> showAllCompany();
	/**
	 * 根据条件模糊查询企业
	 * @param condition
	 * @return
	 */
	public List<CompanyInfoBean> queryCompany(String condition);

	/**
	 * 根据企业名称查询企业
	 * @param comName
	 * @return
	 */
	public CompanyInfoBean findByCompanyName(String comName);
		
	/**
	 * 用于普通管理员新增企业的业务
	 * @param bean
	 * @return
	 */
	public String addCompanyInfo(CompanyInfoBean bean,LoginBean login);

}
