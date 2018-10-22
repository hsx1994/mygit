package com.woniu.cbd.service;


import java.util.List;





import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.UserBean;

public interface IUserService {
	

	
	
	/**向数据库中添加一条用户信息	
	 ** @param user	 
	 ** @return int	 
	 **/
	public boolean addUser(LoginBean bean);
	
	/**向数据库中添加一条用户信息	
	 ** @param user	 
	 ** @return int	 
	 **/
	public boolean addUserInfor(UserBean bean);
		/**
		 * 修改数据库中个人信息
		 * @param user
		 * @return
		 */

	//用于查包租婆或抢租客表的id
	public int findIdByLid(int lid);


	public boolean updateUser(UserBean bean);
	/***
	 * 修改数据库中企业信息
	 * @param company
	 * @return
	 */

	public int updateCompany(CompanyInfoBean company);
}
