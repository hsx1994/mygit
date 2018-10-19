package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.AdministratorBean;
import com.woniu.cbd.bean.LoginBean;

/**
 * 对于后台管理员的增删改查
 * 
 * @author wt
 *
 */
public interface IAdministratorDao {

	/**
	 * 作用：对后台管理员的删除
	 * 
	 * @param id
	 * @return 删除结果 true：删除成功 false：删除失败
	 */
	public boolean administratorDelete(int id);

	/**
	 * 作用：修改后台管理员信息，超级管理员只允许修改权限 后台管理员自己可修改密码和电话号码
	 * 
	 * @param ab
	 *            普通管理员的实体bean
	 * @return 修改结果 true：修改成功 false：修改失败
	 */
	public boolean administratorUpdate(AdministratorBean ab);

	/**
	 * 作用：查看后台单个管理员的各项信息
	 * 
	 * @param lb
	 *            登录表的一个实体对象
	 * @return 返回一个AdministratorBean对象
	 */
	public AdministratorBean administratorSelect(LoginBean lb);

	/**
	 * 作用：查看后台所有管理员的各项信息
	 * 
	 * @return 返回一个包含AdministratorBean的List集合
	 */
	public List<AdministratorBean> administratorSelectAll();
	
	/**
	 * 根据ID查询单个管理员信息
	 * @param id
	 * @return
	 */
	public AdministratorBean findOneAdministrator(Integer id);
	/**
	 * 添加管理员
	 * @param admin
	 * @return
	 */
	public int addAdmin(AdministratorBean admin);
}
