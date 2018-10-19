package com.woniu.cbd.dao;

import java.util.Set;

import com.woniu.cbd.bean.LoginBean;

public interface ILoginDao {

	public LoginBean getLoginUserByName(String name);

	public Set<String> getPermissions(String userName);

}
