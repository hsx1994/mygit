package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.service.IOrderService;

@Controller
public class OrderController {
	@Autowired
	private IOrderService order;

	// 抢租客查看租赁记录
	@RequestMapping("/showlog.do")
	public ModelAndView ShowLog(Integer id, Integer page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(page, 5, true);
		List<OrderBean> bean = order.showLog(id);
		PageInfo<OrderBean> pageInfo = new PageInfo<OrderBean>(bean);

		if (bean != null) {
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list", bean);

		} else {
			mav.addObject("Lease", "尚未租过车位");
		}
		mav.setViewName("/views/hu/showorder.jsp");
		return mav;

	}

	// 包租婆查看自己的被租赁记录
	@RequestMapping("/selectlog.do")
	public ModelAndView selectLog(Integer id, Integer page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(page, 8, true);
		List<ParkingBean> bean = order.selectLog(id);
		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);
		if (bean != null) {
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list", bean);

		} else {
			mav.addObject("lease", "尚未有车位被租赁");
		}

		mav.setViewName("/views/hu/selectlog.jsp");

		return mav;
	}
	//查看单个订单详情
	@RequestMapping("/showOneOrder.do")
	public ModelAndView showOneOrder(Integer id) {
		ModelAndView mav = new ModelAndView();
		OrderBean bean=order.findOrderById(id);
        mav.addObject("order",bean);
        mav.setViewName("/views/hu/oneorder.jsp");
		return mav;
	}

}
