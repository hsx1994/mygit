package com.woniu.cbd.service;

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
	public BargainBean bargainSelect(BargainBean bean);
}
