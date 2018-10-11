package com.woniu.cbd.dao;

import com.woniu.cbd.bean.BargainBean;

/**
 * 第三方签订的合约持久层业务
 * @author hsx
 *
 */
public interface IBargainDao {
	
	/**
	 * 添加第三方合约，跟第三方企业签订合约
	 * @param bean
	 * @return
	 */
	public int bargainAdd(BargainBean bean);
	
	/**
	 * 删除第三方合约，一般用于毁约情况
	 * @param id
	 * @return
	 */
	public int bargainDelete(int id);
	
	/**
	 * 更新第三方合约，一般用于更新合约的状态
	 * @param bean
	 * @return
	 */
	public int bargainUpdate(BargainBean bean);
	
	/**
	 * 查询第三方合约的信息
	 * @param bean
	 * @return
	 */
	public BargainBean bargainSelect(BargainBean bean);
}
