package com.woniu.cbd.service;

import java.util.List;

import com.woniu.cbd.bean.BargainBean;

/**
 * 第三方签订的合约业务层服务
 * @author hsx
 *
 */
public interface IBargainService {
	
	/**
	 * 添加第三方合约，跟第三方企业签订合约
	 * @param bean
	 * @return
	 */
	public boolean bargainAdd(BargainBean bean);
	
	/**
	 * 删除第三方合约，一般用于毁约情况
	 * @param id
	 * @return
	 */
	public boolean bargainDelete(int id);
	
	/**
	 * 更新第三方合约，一般用于更新合约的状态
	 * @param bean
	 * @return
	 */
	public boolean bargainUpdate(BargainBean bean);
	
	/**
	 * 查询第三方合约的信息
	 * @param bean
	 * @return
	 */
	public List<BargainBean> bargainSelect(BargainBean bean);
	
	/**
	 * 通过合约状态查询所有该状态的合约信息
	 * @param state
	 * @return
	 */
	public List<BargainBean> bargainSelectByState(int state);
	
	/**
	 * 查询所有第三方合约的信息
	 * @return
	 */
	public List<BargainBean> allBargainSelect();
	/**
	 * 管理员搜索执行中第三方合约业务
	 * @param condition
	 * @return
	 */
	public  List<BargainBean> queryUseingBargainByCondition(String condition);
	/**
	 * 管理员搜索第三方历史合约业务
	 * @param condition
	 * @return
	 */
	public  List<BargainBean> queryHistoryBargainByCondition(String condition);
	/**
	 * 显示第三方合约详情的业务
	 * @param id
	 * @return
	 */
	public BargainBean showDetailsBargain(int id);
}
