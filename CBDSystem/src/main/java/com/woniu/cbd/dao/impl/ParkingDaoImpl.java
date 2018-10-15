package com.woniu.cbd.dao.impl;

import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.dao.IParkingDao;
@Repository
public class ParkingDaoImpl implements IParkingDao {
	// spring容器注入一个工厂对象
	@Autowired
	private SqlSessionFactory fa;
    //包租婆批量添加个人车位
	@Override
	public int AddPark(List<ParkingBean> park) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		int num=session.insert("parkingMapper.addParking", park);
		session.close();
		return num;
	}
    //抢租客查看所有的车位，无论是否被租赁
	@Override
	public List<ParkingBean> ShowAll() {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		List<ParkingBean> bean=session.selectList("parkingMapper.showall");
		session.close();
		return bean;
	}
    //抢租客根据上架时间查询
	@Override
	public List<ParkingBean> SelectPark(Date date) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		List<ParkingBean> bean=session.selectList("parkingMapper.showdate",date);
		session.close();
		return bean;
	}
    //抢租客根据价格查询
	@Override
	public List<ParkingBean> SelectPark(int price) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		List<ParkingBean> bean=session.selectList("parkingMapper.showprice",price);
		session.close();
		return bean;
	}
    //抢租客查询指定车位的信息
	@Override
	public ParkingBean SelectParkOne(int id) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		ParkingBean bean=session.selectOne("parkingMapper.showone",id);
		session.close();
		return bean;
	}
    //抢租客根据车位号来模糊查询
	@Override
	public List<ParkingBean> SelectParkByNum(String num) {
		// TODO Auto-generated method stub
		SqlSession session = fa.openSession();
		List<ParkingBean> bean=session.selectList("parkingMapper.findbynum",num);
		return bean;
	}
	
	/**
	 * 通过车位的id查找车位的信息
	 */
	@Override
	public ParkingBean findParkingById(int parkingId) {
		SqlSession session = fa.openSession(true);
		ParkingBean parking = session.selectOne("parkingMapper.findParkingById", parkingId);
		session.close();
		return parking;
		
	}
	
	@Override
	public int parkingDelete(int id) {
		SqlSession session = fa.openSession();
		int row = session.update("parkingMapper.parkingDelete", id);
		
		session.commit();
		session.close();
		return row;
	}

	@Override
	public List<ParkingBean> parkingSelect() {
		SqlSession session = fa.openSession();
		List<ParkingBean> list = session.selectList("parkingMapper.applyParkingSelect");
		
		session.close();
		return list;
	}

	@Override
	public int passApply(int id) {
		SqlSession session = fa.openSession();
		int row = session.update("parkingMapper.passApply",id);
		
		session.commit();
		session.close();
		return row;
	}

	@Override
	public int passApplyFail(int id) {
		SqlSession session = fa.openSession();
		int row = session.update("parkingMapper.passApplyFail",id);
		
		session.commit();
		session.close();
		return row;
	}
}
