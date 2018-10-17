package com.woniu.cbd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.RegisterBean;
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
		SqlSession session = fa.openSession(true);
		int num = session.insert("complaintMapper.addcomplaint", bean);
		
		session.close();
		return num;
	}

	@Override
	public int addUser(RegisterBean user) {
		SqlSession session = fa.openSession(true);
		int row = session.insert("complaintMapper.addcomplaint", user);
		
		session.close();
		return row;
	}

	@Override
	public int addUserInfor(RegisterBean user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(RegisterBean user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCompany(CompanyInfoBean company) {
		// TODO Auto-generated method stub
		return 0;
	}

}
