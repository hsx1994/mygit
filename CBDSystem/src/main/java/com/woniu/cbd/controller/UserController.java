package com.woniu.cbd.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.aliyuncs.exceptions.ClientException;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.service.IUserService;
import com.woniu.cbd.util.MD5_Encoding;
import com.woniu.cbd.util.PhoneCodeUtil;

@Controller
public class UserController {
	@Autowired
	private IUserService user;

	// 包租婆查看自己的车位信息

	@RequestMapping("/showme.do")
	public ModelAndView ShowMe(Integer id, Integer page) {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page, 5, true);
		List<ParkingBean> bean = user.ShowMe(id);
		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);

		if (bean != null) {
			mav.addObject("application", pageInfo);
		} else {
			mav.addObject("application", "尚未添加车位");
		}
		mav.setViewName("");
		return mav;
	}

	// 包租婆查看自己的被租赁记录
	@RequestMapping("/selectlog.do")
	public ModelAndView SelectLog(Integer id, Integer page) {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page, 5, true);
		List<ParkingBean> bean = user.SelectLog(id);
		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);
		if (bean != null) {
			mav.addObject("lease", pageInfo);
		} else {
			mav.addObject("lease", "尚未有车位被租赁");
		}
		return mav;
	}

	// 抢租客查看租赁记录
	@RequestMapping("/showlog.do")
	public ModelAndView ShowLog(Integer id, Integer page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(page, 5, true);
		List<OrderBean> bean = user.ShowLog(id);
		PageInfo<OrderBean> pageInfo = new PageInfo<OrderBean>(bean);

		if (bean != null) {
			mav.addObject("Lease", pageInfo);
		} else {
			mav.addObject("Lease", "尚未租过车位");
		}
		mav.setViewName("");
		return mav;

	}

	// 手机发送验证码测试
	@RequestMapping("/phone.do")
	public void Num(HttpServletRequest request, String number) throws ClientException {
		HttpSession session = request.getSession();
		// 发送验证码
		String code = PhoneCodeUtil.Number(number);
		// 将session放到session中
		session.setAttribute("code", code);

	}
	// 注册测试
	@RequestMapping("/regist.do")
	public @ResponseBody String Regist(HttpServletRequest request, String name, String password, UserBean user,
			String code) {
		HttpSession session = request.getSession();
		// 密码加密
		String pass = MD5_Encoding.lowerMD5(password);

		// 获取session给中的验证码
		String num = (String) session.getAttribute("code");
		// 验证验证码
		if (code.equals(num)) {
			System.out.println("验证码验证成功");
			return "注册成功";
		} else {
			System.out.println("验证码验证失败");
			return "注册失败";
		}

	}
}
