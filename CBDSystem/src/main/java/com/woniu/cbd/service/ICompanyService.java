package com.woniu.cbd.service;

import java.util.List;
import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.OtherParkingBean;

public interface ICompanyService {
		//用于企业查看可租赁的企业车位车位
		public List<OtherParkingBean> ShowCompanyPark(int id);
		//用于企业查看单个车位信息
		public OtherParkingBean ShowCompanyParkById(int c_id);
		//前台用于企业查询企业合同
		public List<CompanyBargainBean> CompanyContract(String name);
}
