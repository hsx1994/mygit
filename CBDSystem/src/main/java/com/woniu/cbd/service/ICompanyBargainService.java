package com.woniu.cbd.service;

import java.util.List;

import com.woniu.cbd.bean.CompanyBargainBean;

/**
 * 企业合约业务层业务
 * 
 * @author hsx
 * 
 */
public interface ICompanyBargainService {

	/**
	 * 添加企业合约，跟企业用户签订合约
	 * 
	 * @param bean
	 * @return
	 */
	public boolean companyBargainAdd(CompanyBargainBean bean);

	/**
	 * 删除企业合约，一般用于毁约情况
	 * 
	 * @param id
	 * @return
	 */
	public boolean companyBargainDelete(int id);

	/**
	 * 更新企业合约，一般用于更新合约的状态
	 * 
	 * @param bean
	 * @return
	 */
	public boolean companyBargainUpdate(CompanyBargainBean bean);

	/**
	 * 根据企业名称查询该企业所有合约的信息
	 * 
	 * @param bean
	 * @return
	 */
	public List<CompanyBargainBean> companyBargainSelect(CompanyBargainBean bean);

	/**
	 * 通过合约状态查询所有该状态的合约信息
	 * 
	 * @param state
	 * @return
	 */
	public List<CompanyBargainBean> companyBargainSelectByState(int state);

	/**
	 * 查询所有的企业合约信息
	 * 
	 * @return
	 */
	public List<CompanyBargainBean> allCompanyBargainSelect();

	// 前台用于企业查询企业合同
	public List<CompanyBargainBean> companyBargainById(int id);
	/**
	 * 按条件查询执行中的合约
	 * @param condition
	 * @return
	 */
	public List<CompanyBargainBean> queryUseingBarginByCondition(String condition);
	/**
	 * 按条件查询历史合约
	 * @param condition
	 * @return
	 */
	public List<CompanyBargainBean> queryHistoryBargainByCondition(String condition);
	/**
	 * 通过id查看企业合约详情
	 * @param id
	 * @return
	 */
	public CompanyBargainBean showCompanyBargainDetails(int id);
}
