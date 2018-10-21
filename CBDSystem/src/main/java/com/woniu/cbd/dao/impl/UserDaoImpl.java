package com.woniu.cbd.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
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

	



}
