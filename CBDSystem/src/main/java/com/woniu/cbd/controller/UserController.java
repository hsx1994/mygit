package com.woniu.cbd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.CompanyInfoBean;
import com.woniu.cbd.bean.LoginBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.service.IUserService;
import com.woniu.cbd.util.Md5pwdUtil;

@Controller
public class UserController {
	@Autowired
	private IUserService user;

	// 包租婆查看自己的车位信息
	@RequestMapping("showme.do")
	public ModelAndView ShowMe(Integer id, Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page, 8, true);
		List<ParkingBean> bean = user.ShowMe(id);

		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);

		if (bean != null) {
			mav.addObject("all", bean);
			mav.addObject("paging", pageInfo);

		} else {
			mav.addObject("noresult", "尚未添加车位");
		}
		mav.setViewName("063/ShowLandladyParking.jsp");
		return mav;
	}

	// 包租婆查看自己的被租赁记录
	@RequestMapping("selectlog.do")
	public ModelAndView SelectLog(Integer id, Integer page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(page, 8, true);
		List<ParkingBean> bean = user.SelectLog(id);
		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);
		if (bean != null) {
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list", bean);
		} else {
			mav.addObject("lease", "尚未有车位被租赁");
		}

		mav.setViewName("");
		return mav;
	}

	// 抢租客查看租赁记录
	@RequestMapping("showlog.do")
	public ModelAndView ShowLog(Integer id, Integer page) {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page, 5, true);
		List<OrderBean> bean = user.ShowLog(id);
		PageInfo<OrderBean> pageInfo = new PageInfo<OrderBean>(bean);

		if (bean != null) {
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list", bean);
		} else {
			mav.addObject("Lease", "尚未租过车位");
		}
		mav.setViewName("");
		return mav;
	}

	// 手机发送验证码测试
	@RequestMapping("/phone.do")
	public ModelAndView Num(HttpServletRequest request, String number) {
		ModelAndView mav = new ModelAndView();
		HttpSession session = request.getSession();
		// 发送验证码
		// String code=PhoneCodeUtil.Number(number);
		// 将session放到session中
		session.setAttribute("code", "123123");
		System.out.println(number);
		mav.setViewName("");
		return mav;

	}

	// 注册测试
	@RequestMapping("regist.do")
	public @ResponseBody String Regist(HttpServletRequest request,UserBean bean, String code) {
		HttpSession session = request.getSession();
		// 获取session给中的验证码
		String num = (String) session.getAttribute("code");
		// 验证验证码
		if (!code.equals(num)) {
			return "验证码错误";
		}		
		// 密码加密
		String pass = Md5pwdUtil.md5(bean.getLogin().getPassword(), bean.getLogin().getName());
		LoginBean login = bean.getLogin();
		login.setPassword(pass);
		int id = user.addUser(login);
		if(id == 0){
			return "用户名或密码注册失败";
		}
		boolean re = user.addUserInfor(bean);
		if(re){
			return "注册成功";
		}
		return "注册失败";
	}

	/***
	 * 修改个人信息是否成功
	 * @param user
	 * @return
	 */
	@RequestMapping("up.do")
	public @ResponseBody String updateUser(@Validated UserBean bean){
		boolean row = user.updateUser(bean);
		String result = "修改失败";
		if (row) {
			result = "修改成功";
		}
		return result;
	}
	
	
	/***
	 * 修改企业信息是否成功
	 * @param user
	 * @return
	 */
	@RequestMapping("companyUpdate.do")
	public String updateCompany(@Validated CompanyInfoBean company){
		int row = user.updateCompany(company);
		if(row>0){
			return "/某页面";	
		}else{
			return "/ModificationPersonal.jsp";	
		}
	}
}
