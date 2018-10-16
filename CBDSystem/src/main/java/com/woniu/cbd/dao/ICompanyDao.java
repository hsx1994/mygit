package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.OtherParkingBean;

public interface ICompanyDao {
    //查看企业的所有车位
	public List<OtherParkingBean> ShowComPanyParkAll(int id);
    //企业查看单个车位信息
	public OtherParkingBean ShowComPanyPark(int c_id);
    //前台企业查询企业合同
	public List<CompanyBargainBean> CompanyContract(String name);

}
