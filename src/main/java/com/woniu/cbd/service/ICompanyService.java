package com.woniu.cbd.service;

import java.util.List;
import com.woniu.cbd.bean.CompanyBargainBean;
import com.woniu.cbd.bean.OtherParkingBean;

public interface ICompanyService {
		//用于企业查看可租赁的企业车位车位
		public List<OtherParkingBean> ShowCompanyPark();
		//用于企业查看自己的租赁记录
		public List<OtherParkingBean> ShowCompanyPark(int c_id);
		//用于企业批量租赁车位
		public boolean CompanyLease(List<OtherParkingBean> other);
		//用于企业查询企业合同
		public List<CompanyBargainBean> CompanyContract(int cid);
}
