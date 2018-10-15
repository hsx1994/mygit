package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.OtherParkingBean;

public interface ICompanyDao {
    //查看企业的所有车位
	public List<OtherParkingBean> ShowComPanyParkAll();
    //企业查看自己的租赁记录
	public List<OtherParkingBean> ShowComPanyPark(int c_id);
    //企业批量租赁车位
	public int CompanyLease(List<OtherParkingBean> other);
    //前台企业查询企业合同
	public List<CompanyBargainBean> CompanyContract(String name);

}
