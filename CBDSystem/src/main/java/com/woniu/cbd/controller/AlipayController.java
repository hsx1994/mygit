package com.woniu.cbd.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.service.IOrderService;
import com.woniu.cbd.service.IUserService;
import com.woniu.cbd.util.AlipayUtil;


@Controller
public class AlipayController {
	@Autowired
	private IUserService userService;
	@Autowired
	private IOrderService orderService;
	@RequestMapping("/apply.do")
	public ModelAndView getQRcode(HttpServletRequest request,int orderId){
		OrderBean order2 = orderService.findOrderById(orderId);
		ModelAndView result = new ModelAndView();
		if (order2 != null) {
			if(order2.getStartTime().compareTo(new Date())<=0){
				result.setViewName("/jsp/two.jsp");
			}else{
				result.setViewName("/alipay/apply.jsp");
				result.addObject("QRcode", AlipayUtil.getQRcode(request,order2));
				result.addObject("order", order2);
			}
		}else {
			result.setViewName("/index.jsp");
		}
		return result;
	}
	@RequestMapping("/queryState.do")
	public @ResponseBody boolean QueryState(HttpServletRequest request,int orderId){
		boolean b = false;
		String result = AlipayUtil.QueryState(request, orderId);
		if (result!=null&&result.equals("TRADE_SUCCESS")) {
			b = true;
			OrderBean order = new OrderBean();
			order.setId(orderId);
			order.setState(1);
			orderService.changeOrderState(order);
			int userId = (int)request.getSession().getAttribute("id");
			System.out.println("userId");
			UserBean user = userService.findUserInfo(userId);
			user.setOrderCount(user.getOrderCount()+1);
			userService.updateUser(user);
		}
		return b;
	}
}
