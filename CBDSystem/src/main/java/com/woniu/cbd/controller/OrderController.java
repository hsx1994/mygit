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
	public ModelAndView showLog(Integer id,Integer page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(page, 5, true);
		List<OrderBean> bean = order.findOrderByState(id, 0);
		PageInfo<OrderBean> pageInfo = new PageInfo<OrderBean>(bean);
		
		mav.addObject("pageinfo", pageInfo);
		mav.addObject("list", bean);
		mav.setViewName("jsp/LookTwoCar.jsp");
		return mav;

	}
	@RequestMapping("/showSuccessOrder.do")
	public ModelAndView showUserOrder(Integer id,Integer page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(page, 5, true);
		List<OrderBean> bean = order.findOrderByState(id, 1);
		PageInfo<OrderBean> pageInfo = new PageInfo<OrderBean>(bean);
		mav.addObject("pageinfo", pageInfo);
		mav.addObject("list", bean);
		mav.setViewName("jsp/LookTwoUser.jsp");
		return mav;

	}
	// 包租婆查看自己的被租赁记录
	@RequestMapping("/selectlog.do")
	public ModelAndView selectLog(Integer id,Integer page) {
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(page, 5, true);
		List<ParkingBean> bean = order.selectLog(id);
		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);
		if (bean != null) {
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list", bean);
		} else {
			mav.addObject("list", "尚未有车位被租赁");
		}
		mav.setViewName("jsp/LookCar.jsp");
		return mav;
	}
	//查看单个订单详情
	@RequestMapping("/showOneOrder.do")
	public ModelAndView showOneOrder(Integer id) {
		ModelAndView mav = new ModelAndView();
		OrderBean bean=order.findOrderById(id);
        mav.addObject("order",bean);
        mav.setViewName("/views/hu/showorder.jsp");
		return mav;
	}
	
	@RequestMapping("/pay.do")
	public @ResponseBody String pay(HttpServletRequest req,OrderBean bean){
		
		if(bean.getStartTime() == null ||bean.getEndTime() == null ){
			return "时间不能为空";
		}
		int row = bean.getStartTime().compareTo(bean.getEndTime());
		if(row >= 0){
			return "开始时间不能在结束时间之后";
		}
		int id = (int) req.getSession().getAttribute("id");
		UserBean user = new UserBean();
		user.setId(id);
		bean.setUser(user);
		String re = order.privateOrder(bean);
		if(re.equals("订单插入成功")){
			re = bean.getId() + "";
		}
		return re;
	}
	// 包租婆查看自己的被租赁记录
		@RequestMapping("/selectOrder.do")
		public ModelAndView selectOrder(Integer id,Integer page) {
			ModelAndView mav = new ModelAndView();
			PageHelper.startPage(page, 5, true);
			List<ParkingBean> bean = order.selectLog(id);
			PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);
			if (bean != null) {
				mav.addObject("pageinfo", pageInfo);
				mav.addObject("list", bean);
			} else {
				mav.addObject("list", "尚未有车位被租赁");
			}
			mav.setViewName("jsp/LookOrder.jsp");
			return mav;
		}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setLenient(false);  //是否需要严格转化
		
		//使用springmvc封装好的类进行格式转换
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
}
