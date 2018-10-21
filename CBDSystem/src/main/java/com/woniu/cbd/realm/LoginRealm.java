package com.woniu.cbd.realm;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.service.ILoginService;

public class LoginRealm extends AuthorizingRealm {

	@Autowired
	private ILoginService loginService;

	@Override
	public String getName() {
		return "LoginRealm";
	}

	/**
	 * 验证当前登录的用户,认证操作
	 */

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(
			AuthenticationToken token) throws AuthenticationException {
		String name = (String) token.getPrincipal();
		System.out.println("进入登录操作,name:="+name);
		
		LoginBean loginUser = loginService.getLoginUserByName(name);
		System.out.println("在LoginRealm中，数据库查询完毕：loginUser=" + loginUser);

		if (loginUser != null) {			
			AuthenticationInfo info = new SimpleAuthenticationInfo(loginUser,loginUser.getPassword(),getName());	
			// 把用户信息放在session里
			Session session = SecurityUtils.getSubject().getSession();
			session.setAttribute("user", loginUser);
	    	session.setAttribute("userId", loginUser.getId());	    
	    	System.out.println("即将退出登录验证");
	    	return info;
		}else{
			System.out.println("loginUser为null");
			return null;
		}
	}

	/**
	 * 为当限前登录的用户授予角色和权限
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
			System.out.println("即将进入角色授权");
			
			String name = (String) principals.getPrimaryPrincipal();
			SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
			info.setStringPermissions(loginService.getPermissions(name));
			return info;		
	}
	

//	// 清除缓存
//	public void clearCached() {
//		// 获取当前登录的用户凭证，然后清除
//		PrincipalCollection principals = SecurityUtils.getSubject()
//				.getPrincipals();
//		super.clearCache(principals);
//	}
	
}
