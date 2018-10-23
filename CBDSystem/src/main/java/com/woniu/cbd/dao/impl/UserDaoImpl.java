package com.woniu.cbd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.dao.IUserDao;

@Repository
public class UserDaoImpl implements IUserDao {

	// spring容器注入一个工厂对象
	@Autowired
	private SqlSessionFactory fa;

	// 包租婆查看上架记录
	@Override
	public List<ParkingBean> ShowMe(int id) {
		SqlSession session = fa.openSession(true);
		List<ParkingBean> bean = session.selectList("parkingMapper.showme", id);
		
		session.close();
		return bean;
	}

	// 包租婆查看被租赁记录
	@Override
	public List<ParkingBean> SelectLog(int id) {
		SqlSession session = fa.openSession(true);
		List<ParkingBean> bean = session.selectList("parkingMapper.showmelog", id);
		
		session.close();
		return bean;
	}

	// 抢租客查看租赁记录
	@Override
	public List<OrderBean> ShowLog(int id) {
		SqlSession session = fa.openSession(true);
		List<OrderBean> bean = session.selectList("orderMapper.showlog", id);
		
		session.close();
		return bean;
	}

	// 抢租客添加投诉信息
	@Override
	public int AddComplaint(ComplainBean bean) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		int num = session.insert("com.woniu.cbd.dao.IComplainDao.addcomplaint", bean);

		session.close();
		return num;
	}

	@Override
	public int addUser(LoginBean bean) {
		SqlSession session = fa.openSession(true);
		int row = session.insert("userMapper.addUser", bean);
		
		session.close();
		return row;
	}
	//包租婆添加个人信息
	@Override
	public int addUserInfor(UserBean bean) {
		SqlSession session = fa.openSession(true);
		int row = session.insert("userMapper.addUserInfor", bean);
		
		session.close();
		return row;
	}
	
	//包租婆修改个人信息
	@Override
	public int updateUser(UserBean bean) {
		SqlSession session = fa.openSession(true);
		int row = session.insert("userMapper.updateUser", bean);
		
		session.close();
		return row;
	}
	//企业修改信息
	@Override
	public int updateCompany(CompanyInfoBean company) {
		SqlSession session = fa.openSession(true);
		int row = session.insert("userMapper.updateCompany", company);
		
		session.close();
		return row;
	}


	// 通过登录表的id查包租婆或抢租客表的id
	@Override
	public int findIdByLid(int lid) {
		SqlSession session = fa.openSession();
		int id = session.selectOne("userMapper.findIdByLid", lid);
		session.close();
		return id;
	}

	//查看个人信息
	@Override
	public UserBean findUserInfo(int id) {
		SqlSession session = fa.openSession(true);
		UserBean bean = session.selectOne("userMapper.findById", id);

		session.close();
		return bean;
	}
	//查看企业信息
	@Override
	public CompanyInfoBean findCompanyInfo(int id) {
		SqlSession session = fa.openSession(true);
		CompanyInfoBean bean = session.selectOne("userMapper.findCompanyInfo", id);

		session.close();
		return bean;
	}
}
