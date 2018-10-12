package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.CompanyBargainBean;

/**
 * 企业合约持久层业务
 * @author hsx
 *
 */
public interface ICompanyBargainDao {
	
	/**
	 * 添加企业合约，跟企业用户签订合约
	 * @param bean
	 * @return
	 */
	public int companyBargainAdd(CompanyBargainBean bean);
	
	/**
	 * 删除企业合约，一般用于毁约情况
	 * @param id
	 * @return
	 */
	public int companyBargainDelete(int id);
	
	/**
	 * 更新企业合约，一般用于更新合约的状态
	 * @param bean
	 * @return
	 */
	public int companyBargainUpdate(CompanyBargainBean bean);
	
	/**
	 * 查询某个企业合约的信息
	 * @param bean
	 * @return
	 */
	public CompanyBargainBean companyBargainSelect(CompanyBargainBean bean);
	
	/**
	 * 查询所有的企业合约信息
	 * @return
	 */
	public List<CompanyBargainBean> allCompanyBargainSelect();
}
