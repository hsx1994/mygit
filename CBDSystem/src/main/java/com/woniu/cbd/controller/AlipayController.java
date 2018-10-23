package com.woniu.cbd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.service.IOrderService;
import com.woniu.cbd.util.AlipayUtil;


@Controller
public class AlipayController {
	
	@Autowired
	private IOrderService orderService;
	@RequestMapping("/apply.do")
	public ModelAndView getQRcode(HttpServletRequest request,int orderId){
		OrderBean order2 = orderService.findOrderById(orderId);
		ModelAndView result = new ModelAndView();
		if (order2 != null) {
			result.setViewName("/alipay/apply.jsp");
			result.addObject("QRcode", AlipayUtil.getQRcode(request,order2));
			result.addObject("order", order2);
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
		}
		return b;
	}
}
