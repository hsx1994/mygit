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

	// 通过登录表的id查包租婆或抢租客表的id
	@Override
	public int findIdByLid(int lid) {
		SqlSession session = fa.openSession();
		int id = session.selectOne("userMapper.findIdByLid", lid);
		session.close();
		return id;
	}
}
