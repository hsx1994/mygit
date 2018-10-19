package com.woniu.cbd.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.service.IUserService;

@Controller
public class UserController {
	@Autowired
	private IUserService user;
	
	// 包租婆查看自己的车位信息
	@RequestMapping("/showme.do")
	public ModelAndView ShowMe(Integer id,Integer page) {
		ModelAndView mav = new ModelAndView();
//		System.out.println("id:"+id);
//		System.out.println("page:"+page);
		PageHelper.startPage(page,8,true);
		List<ParkingBean> bean = user.ShowMe(id);

		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);
		if(bean != null){
			mav.addObject("all", bean);
			mav.addObject("paging",pageInfo);
			
		}else{
			mav.addObject("noresult","尚未添加车位");
		}
		mav.setViewName("063/ShowLandladyParking.jsp");
		return mav;
	}
//	// 包租婆查看自己的车位信息
//		@RequestMapping("/showme.do")
//		public ModelAndView ShowMe(HttpSession session,Integer page) {
//			//获取用户id（uid）
//			Integer uid = (Integer)session.getAttribute("uid");
//			ModelAndView mav = new ModelAndView();
//			
//			PageHelper.startPage(page,8,true);
//			List<ParkingBean> bean = user.ShowMe(uid);
//			PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);
//			if(bean != null){
//				mav.addObject("all", bean);
//				mav.addObject("paging",pageInfo);
//				
//			}else{
//				mav.addObject("noresult","尚未添加车位");
//			}
//			mav.setViewName("063/ShowLandladyParking.jsp");
//			return mav;
//		}

	// 包租婆查看自己的被租赁记录
	@RequestMapping("/selectlog.do")
	public ModelAndView SelectLog(Integer id,Integer page) {
		ModelAndView mav = new ModelAndView();		
		PageHelper.startPage(page,8,true);
		List<ParkingBean> bean = user.SelectLog(id);
		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);
		if(bean != null){
			mav.addObject("lease",pageInfo);	
		} else {
			mav.addObject("lease","尚未有车位被租赁");
		}
		
		mav.setViewName("");
		return mav;
	}
	
	//抢租客查看租赁记录
	@RequestMapping("/showlog.do")
	public ModelAndView ShowLog(Integer id,Integer page){
		ModelAndView mav = new ModelAndView();
	
		PageHelper.startPage(page,5,true);
		List<OrderBean> bean=user.ShowLog(id);
		PageInfo<OrderBean> pageInfo = new PageInfo<OrderBean>(bean);
		
		if(bean != null){
			mav.addObject("Lease",pageInfo);
		} else {
			mav.addObject("Lease","尚未租过车位");
		}
		mav.setViewName("");
		return mav;
	}
}
