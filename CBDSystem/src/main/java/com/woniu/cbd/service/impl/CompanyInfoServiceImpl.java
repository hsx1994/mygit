package com.woniu.cbd.service.impl;

import java.util.List;








import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.dao.ICompanyInfoDao;
import com.woniu.cbd.dao.ILoginDao;
import com.woniu.cbd.service.ICompanyInfoService;

@Service
public class CompanyInfoServiceImpl implements ICompanyInfoService {
	@Autowired
	private ICompanyInfoDao dao;
	@Autowired
	private ILoginDao loginDao;
	@Override
	public CompanyInfoBean findByCompanyName(String comName) {
		CompanyInfoBean bean = dao.findByCompanyName(comName);
		
		return bean;
	}
	

	@Override
	public List<CompanyInfoBean> showAllCompany() {
		
		List<CompanyInfoBean> list = dao.findAllCompany();
		
		return list;
	}

	@Override
	public List<CompanyInfoBean> queryCompany(String condition) {
		
		List<CompanyInfoBean> list = dao.fuzzyQuery(condition);
		
		return list;
	}

	@Transactional(isolation=Isolation.DEFAULT,propagation=Propagation.REQUIRED)
	@Override
	public String addCompanyInfo(CompanyInfoBean bean,LoginBean login) {
		String result ="添加失败";
		//数据格式验证
		if(bean.getAddress().equals("")||bean.getComName().equals("")
				||bean.getContact().equals("")||bean.getEmail().equals("")
				||bean.getTel().equals("")){
			
			result="数据不能为空";
			return result;
		}
		//添加企业登录信息
		int re = loginDao.addCompanyUser(login);
		if(re>0){
			bean.setComLogin(login);
			//添加企业信息
			int row = dao.addCompany(bean);
			if(row>0){
				result="添加成功";
			}
		}
		
		return result;
	}
		
		
	/**
	 * 根据登录表lid查企业id
	 * @param lid
	 * @return
	 */
	@Override
	public int findIdByLid(int lid) {
		
		return dao.findIdByLid(lid);

	}
	

}
