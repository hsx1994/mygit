package com.woniu.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.BargainBean;
import com.woniu.cbd.dao.IBargainDao;
import com.woniu.cbd.service.IBargainService;

@Service
public class BargainServiceImpl implements IBargainService {
	
	@Autowired
	private IBargainDao dao;
	
	@Override
	public boolean bargainAdd(BargainBean bean) {
		int row = dao.bargainAdd(bean);
		if(row > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean bargainDelete(int id) {
		int row = dao.bargainDelete(id);
		if(row > 0){
			return true;
		}
		return false;
	}

	@Override
	public boolean bargainUpdate(BargainBean bean) {
		int row = dao.bargainUpdate(bean);
		if(row > 0){
			return true;
		}
		return false;
	}

	@Override
	public List<BargainBean> bargainSelect(BargainBean bean) {
		List<BargainBean> bargain = dao.bargainSelect(bean);
		return bargain;
	}

	

	@Override
	public List<BargainBean> allBargainSelect() {
		List<BargainBean> list = dao.allBargainSelect();
		return list;
	}

	@Override
	public List<BargainBean> bargainSelectByState(int state) {
		List<BargainBean> list = dao.bargainSelectByState(state);
		return list;
	}
	
	@Override
	public List<BargainBean> queryUseingBargainByCondition(String condition) {
		List<BargainBean> list = dao.queryUseingBargain(condition);
		return list;
	}

	@Override
	public List<BargainBean> queryHistoryBargainByCondition(String condition) {
		List<BargainBean> list = dao.queryHistoryBargain(condition);
		return list;
	}

	@Override
	public BargainBean showDetailsBargain(int id) {
		
		BargainBean bean = dao.findBargainById(id);
		
		return bean;
	}

}
