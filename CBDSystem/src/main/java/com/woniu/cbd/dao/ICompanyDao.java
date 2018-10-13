package com.woniu.cbd.dao;

import java.util.List;

import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.OtherParkingBean;

public interface ICompanyDao {

	public List<OtherParkingBean> ShowComPanyParkAll();

	public List<OtherParkingBean> ShowComPanyPark(int c_id);

	public int CompanyLease(List<OtherParkingBean> other);

	public List<CompanyBargainBean> CompanyContract(int cid);

}
