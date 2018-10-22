package com.woniu.cbd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.UserBean;
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
	
	@RequestMapping("pay.do")
	public @ResponseBody int pay(HttpServletRequest req,OrderBean bean){
		int id = (int) req.getSession().getAttribute("id");
		UserBean user = new UserBean();
		user.setId(id);
		bean.setUser(user);
		order.privateOrder(bean);
		int oid = bean.getId();
		return oid;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setLenient(false);  //是否需要严格转化
		
		//使用springmvc封装好的类进行格式转换
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
}
