package com.woniu.cbd.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.woniu.cbd.bean.AdministratorBean;
import com.woniu.cbd.dao.IAdministratorDao;
import com.woniu.cbd.service.IAdministratorService;

/**
 * 描述：IAdministratorService接口的实现类 ，对接口功能的实现
 * 
 * @author wt
 *
 */
@Service
public class AdministratorServiceImpl implements IAdministratorService {

	// 注入IAdministrator接口
	@Autowired
	private IAdministratorDao idao;

	@Override
	public String administratorRegister(AdministratorBean ab) {
		String result = "添加失败";
		// 调用方法获取dao层添加是否成功的结果
		boolean boo = idao.administratorAdd(ab);
		if(boo==true){
			result = "添加成功";
		}
		return result;
	}

	@Override
	public String administratorDelet(int id) {
		String result = "删除失败";
		// 调用方法获取dao层删除是否成功的结果
		boolean boo = idao.administratorDelete(id);
		if(boo==true){
			result = "删除成功";
		}
		return result;
	}

	@Override
	public String administratorLimitChange(AdministratorBean ab) {
		String result = "修改失败";
		// 调用方法获取dao层修改是否成功的结果
		boolean boo = idao.administratorUpdate(ab);
		if(boo==true){
			result = "修改 成功";
		}
		return result;
	}

	@Override
	public List<AdministratorBean> showAdministrator() {
		// 存储查询结果集合
		List<AdministratorBean> list = null;
		// 调用方法获取dao层查询到的数据
		list = idao.administratorSelectAll();
		return list;
	}

}
