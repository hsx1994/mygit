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
	 * 通过企业名查询所有该企业合约的信息
	 * @param bean
	 * @return
	 */
	public List<CompanyBargainBean> companyBargainSelect(CompanyBargainBean bean);
	
	/**
	 * 通过合约状态查询所有该状态的合约
	 * @param state
	 * @return
	 */
	public List<CompanyBargainBean> companyBargainSelectByState(int state);
	
	/**
	 * 查询所有的企业合约信息
	 * @return
	 */
	public List<CompanyBargainBean> allCompanyBargainSelect();
}