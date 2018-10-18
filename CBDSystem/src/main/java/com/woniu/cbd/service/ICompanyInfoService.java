package com.woniu.cbd.service;

import java.util.List;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.OtherParkingBean;
import com.woniu.cbd.dao.ICompanyInfoDao;


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
		
		

}
