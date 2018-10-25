package com.woniu.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.dao.IComplainDao;
import com.woniu.cbd.service.IComplainService;

@Service
public class ComplainServiceImpl implements IComplainService {
	@Autowired
	private IComplainDao dao;

	@Override
	public List<ComplainBean> showComplain() {

		List<ComplainBean> comlist = dao.findAllComplain();

		return comlist;

	}

	@Override
	public String acceptComplain(int state, int id) {
		String result = "受理成功";

		dao.updateComplainState(state, id);

		return result;
	}

	@Override
	public ComplainBean showComplainById(int id) {

		ComplainBean bean = dao.findComplainById(id);

		return bean;
	}

	// 抢租客针对记录添加投诉信息
	@Override
	public String addComplaint(ComplainBean bean) {
		int num = dao.addComplaint(bean);
		if (num > 0) {
			return "投诉成功";
		}
		return "投诉失败";
	}
	/**
	 * 通过ID查投诉信息
	 */
	@Override
	public ComplainBean findById(Integer id) {
		ComplainBean bean = dao.findById(id);
		return bean;
	}

}
