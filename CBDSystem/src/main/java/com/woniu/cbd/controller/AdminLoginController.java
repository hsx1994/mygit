
package com.woniu.cbd.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.util.Md5pwdUtil;

/**
 * 用户Controller层
 * @author Administrator
 *
 */
@Controller
public class AdminLoginController {

	
	/**
	 * 用户登录
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping("/adminLogin.do")
	public String login(LoginBean user, String checkcode,HttpServletRequest request){
		System.out.println("user=" + user + ":" + "checkcode" + checkcode);
		// 加密密码Md5
		String realPassword = Md5pwdUtil.md5(user.getPassword(), user.getName());
		System.out.println("加密密码:" + realPassword);
		
		Subject subject=SecurityUtils.getSubject();
		UsernamePasswordToken token=new UsernamePasswordToken(user.getName(), realPassword);
		try{
			subject.login(token);
			Session session=subject.getSession();
			System.out.println("sessionId:"+session.getId());
			System.out.println("sessionHost:"+session.getHost());
			System.out.println("sessionTimeout:"+session.getTimeout());
			session.setAttribute("info", "session的数据");
			return "redirect:views/manage.jsp";
		}catch(Exception e){
			request.setAttribute("user", user);
			request.setAttribute("errorMsg", "用户名或密码错误！");
			return "/views/login.jsp";
		}
	}
}

//package com.woniu.cbd.controller;
//
//import net.sf.ehcache.store.disk.ods.AATreeSet;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.UnknownAccountException;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.AuthorizationException;
//import org.apache.shiro.crypto.hash.Md5Hash;
//import org.apache.shiro.session.Session;
//import org.apache.shiro.subject.Subject;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.woniu.cbd.bean.LoginBean;
//import com.woniu.cbd.util.Md5pwdUtil;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * 用户Controller层
// * 
// * @author Administrator
// *
// */
//@Controller
//@RequestMapping("/admin")
//public class AdminLoginController {
//
//	/**
//	 * 用户登录
//	 * 
//	 * @param adminBean
//	 * @param request
//	 * @return
//	 */
//	@RequestMapping("/adminlogin")
//	public String login(LoginBean user, String checkcode, HttpServletRequest request,HttpServletResponse resp) {
//
//		System.out.println("user=" + user + ":" + "checkcode" + checkcode);
//		// 加密密码Md5
//		String realPassword = Md5pwdUtil.md5(user.getPassword(), user.getName());
//		System.out.println("加密密码:" + realPassword);
//
//		Subject subject = SecurityUtils.getSubject();
//		UsernamePasswordToken token = new UsernamePasswordToken(user.getName(), realPassword);
//		try {
//
//			// 4、登录，即身份验证
//			subject.login(token);
//			System.out.println("身份验证成功,即将进行授权操作");
//
//			Session session = subject.getSession();
//			System.out.println("sessionId:" + session.getId());
//			System.out.println("sessionHost:" + session.getHost());
//			System.out.println("sessionTimeout:" + session.getTimeout());
//			session.setAttribute("info", "session的数据");
//			
//			System.out.println("断点1");
//			resp.sendRedirect("/success.jsp");
//			System.out.println("断点2");
//			
//			return "redirect:/admin/adminIndex.jsp";
//		
//		} catch (Exception e) {
//			e.printStackTrace();
//			request.setAttribute("user", user);
//			request.setAttribute("errorMsg", "用户名或密码错误！");
//
//			System.out.println("即将返回登录页面，密码错误");
//			return "adminIndex.jsp";
//		}
//
//	}
//
//}
