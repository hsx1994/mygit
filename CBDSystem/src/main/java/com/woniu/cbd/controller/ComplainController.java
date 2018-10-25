package com.woniu.cbd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.bean.OrderBean;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.service.IComplainService;
import com.woniu.cbd.service.IOrderService;
import com.woniu.cbd.service.IParkingService;
import com.woniu.cbd.service.IUserService;

/**
 * 处理投诉信息
 * 
 * @author Administrator
 *
 */
@Controller
public class ComplainController {
	@Autowired
	private IComplainService service;
	@Autowired
	private IUserService user;
	@Autowired
	private IParkingService parking;
	@Autowired
	private IOrderService orderService;

	/**
	 * 显示所有待处理的投诉信息
	 * 
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("showComplain.do")
	public ModelAndView showComplain(Integer page) {
		ModelAndView model = new ModelAndView();

		// 设置分页处理 (第page页，每页显示10个，必须写在sql语句之前，不然分页不能生效，true可以省略)
		PageHelper.startPage(page, 10, true);
		List<ComplainBean> list = service.showComplain();
		// 取分页信息,需要填入你查询出的集合
		PageInfo<ComplainBean> pageInfo = new PageInfo<ComplainBean>(list);
		model.addObject("pageinfo", pageInfo);
		model.addObject("list", list);
		model.setViewName("views/complain_info.jsp");
		return model;
	}

	/**
	 * 显示正在处理投诉详细信息
	 * 
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("showDetailsComplain.do")
	public ModelAndView showComplainById(int id) {

		ModelAndView model = new ModelAndView();
		ComplainBean bean = service.showComplainById(id);

		model.addObject("complain", bean);
		model.setViewName("views/complain_details.jsp");
		return model;

	}

	/**
	 * 处理投诉信息
	 * 
	 * @param state 1:通过,2:驳回
	 * @param id
	 * @return
	 */
	@RequestMapping("acceptComplain.do")
	public @ResponseBody String acceptComplain(Integer state, Integer id) {
		
		String result = service.acceptComplain(state, id);
		if(state.equals(1)){
			ComplainBean bean = service.findById(id);
			UserBean u = bean.getBuser();
			int count = u.getComplaintCount();
			int newCount = count + 1;
			u.setComplaintCount(newCount);
			boolean re = user.updaCount(u);
			if(!re){
				result = "处理失败";
			}
		}
		return result;

	}

	// 抢租客针对订单添加投诉信息
	@RequestMapping("/addComplaint.do")
	public @ResponseBody String addCompiaint(HttpServletRequest request,OrderBean order, String text) {
		if(order.getId() == 0){
			return "投诉失败";
		}
		if(text.trim().length() < 1){
			return "投诉内容不能为空";
		}
		
		// 在session中获取到当前登录用户的id
		order = orderService.findOrderById(order.getId());
		// 由订单的id在车位表中获取到车位所有人的id
		ParkingBean bean = parking.selectParkingByOrderID(order.getParking().getId());
		int uid = bean.getUser().getId();

		UserBean user = new UserBean();
		user.setId((int)request.getSession().getAttribute("id"));

		UserBean buser = new UserBean();
		buser.setId(uid);

		ComplainBean complaint = new ComplainBean();
		// 投诉内容
		complaint.setContent(text);
		// 当前登录用户的id
		complaint.setUser(user);
		// 被投诉人的id
		complaint.setBuser(buser);
		// 投诉订单id
		complaint.setOrder(order);
		String result = service.addComplaint(complaint);
		return result;

	}

	// 包租婆针对订单添加投诉
	@RequestMapping("/accComplaint.do")
	public @ResponseBody String aComplain(HttpServletRequest req, OrderBean order, String text) {
		ComplainBean complaint = new ComplainBean();
		if(text.trim().length() < 1){
			return "投诉内容不能为空";
		}
		HttpSession session = req.getSession();
		// 在session中获取到当前登录包租婆用户的id
		int i = (int) session.getAttribute("id");
		UserBean user = new UserBean();
		user.setId(i);
		OrderBean o =  orderService.findOrderById(order.getId());
		int nuid = o.getUser().getId();
		
		UserBean buser = new UserBean();
		buser.setId(nuid);
		// 当前登录用户的id
		complaint.setUser(user);
		// 投诉内容
		complaint.setContent(text);
		// 投诉订单id
		complaint.setOrder(order);
		//被投诉的抢租客ID
		complaint.setBuser(buser);		
		String result = service.addComplaint(complaint);
		return result;
	}
	
	@org.springframework.web.bind.annotation.InitBinder
	public void InitBinder(WebDataBinder dataBinder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	    dateFormat.setLenient(false);
	    dataBinder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
}
