package com.woniu.cbd.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.bean.UserBean;
import com.woniu.cbd.service.IParkingService;
import com.woniu.cbd.util.FileUpUtil;

@Controller
public class ParkingController {
	@Autowired
	private IParkingService park;

	// 包租婆添加车位信息
	@RequestMapping("/application.do")
	public String applicationParking(
			@RequestParam(value="imgFile", required=true)MultipartFile[] imgFile, ParkingBean bean, 
			@RequestParam(value="ImgFile", required=true)MultipartFile[] ImgFile,
			HttpServletRequest req) {
		if(bean.getAddress() == null || bean.getCertificate() == null){
			return "输入不能为空";
		}
		if(imgFile == null || ImgFile == null || bean.getAddress().trim().length() < 1 ||
				bean.getCertificate().trim().length() < 1 || bean.getEndTime() == null ||
				bean.getStartTime() == null){
			return "输入不能为空";
		}
		int row = bean.getStartTime().compareTo(bean.getEndTime());
		if(row >= 0){
			return "开始时间不能在结束时间之后";
		}
		if(bean.getPrice() == 0){
			return "价格不能为空且不能为0";
		}
		// 获取上传文件的文件名
	
		// 将文件名放入对象中
		bean.setImg(FileUpUtil.fileUpUtil(imgFile, req, "/images/parking").get(0));
		bean.setCertImg(FileUpUtil.fileUpUtil(ImgFile, req, "/images/parking").get(0));

		// session中取得当前包租婆的id给parking实体类
		int uid=(int) req.getSession().getAttribute("id");
		UserBean user = new UserBean();
		user.setId(uid);
		bean.setUser(user);


		List<ParkingBean> parking = new ArrayList<ParkingBean>();
		parking.add(bean);
		boolean num = park.addParking(parking);
		String result = "redirect:/jsp/LookOneUser.jsp";
		if (num) {
			result = "redirect:/jsp/LookMyCar.jsp";
		}
		return result;

	}

	// 包租婆查看单个上架车位
	@RequestMapping("/landladyshowOne.do")
	public ModelAndView showOne(Integer id) {
		ModelAndView mav = new ModelAndView();
		ParkingBean bean = park.selectParkingOne(id);
		mav.addObject("one", bean);
		mav.setViewName("/jsp/DetailsParkingSpace.jsp");

		return mav;

	}

	// 抢租客查看所有上架车位
	@ResponseBody
	@RequestMapping("showall.do")
	public ModelAndView ShowAll(Integer page) {

		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page, 8, true);
		List<ParkingBean> bean = park.showAll();

		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);
		mav.addObject("paging", pageInfo);
		mav.addObject("all", bean);
		mav.setViewName("/index.jsp");
		return mav;
	}

	// 抢租客查看单个上架车位
	@RequestMapping("showOne.do")
	public ModelAndView showOneById(Integer id) {
		ModelAndView mav = new ModelAndView();

		ParkingBean bean = park.selectParkingOne(id);
		mav.addObject("one", bean);
		mav.setViewName("/jsp/DetailsParkingSpace.jsp");
		return mav;

	}

	// 抢租客车位号模糊查询上架车位

		@RequestMapping("findByNum.do")
		public ModelAndView selectParkingByNum(String num, Integer page) {
			PageHelper.startPage(page, 8, true);
			ModelAndView mav = new ModelAndView();
			List<ParkingBean> bean = park.selectParkingByNum(num);
			PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);

			if (bean != null) {
				mav.addObject("paging", pageInfo);
				mav.addObject("all", bean);
				mav.setViewName("/numparking.jsp");
			} else {
				mav.addObject("notFound","抱歉，未找到合适的车位");
				mav.setViewName("/index.jsp");
			}
			return mav;

		}

		// 抢租客根据价格查询上架车位
		@RequestMapping("/findByPrice.do")
		public ModelAndView selectParking(HttpSession session, Integer price1,
				Integer price2, Integer page) {
			/**
			 * 第一次搜索是会填价格，并将其存入session，在分页功能时直接从session中获取第一次输入的价格
			 */
			if (price1 != null || price2 != null) {
				session.setAttribute("price1", price1);
				session.setAttribute("price2", price2);
			}

			Integer relprice1 = (Integer) session.getAttribute("price1");
			Integer relprice2 = (Integer) session.getAttribute("price2");

			ModelAndView mav = new ModelAndView();
			PageHelper.startPage(page, 8, true);
			List<ParkingBean> bean = park.selectParking(relprice1, relprice2);
			PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);

			if (bean.size() > 0) {
				mav.addObject("paging", pageInfo);
				mav.addObject("all", bean);
			} else {		
				mav.addObject("notFound","抱歉，未找到合适的车位");
			}
			mav.setViewName("/index.jsp");
			return mav;
			
		}
	
	// 抢租客根据时间查询车位信息
		@RequestMapping("/findByTime.do")
		public ModelAndView selectParkingByTime(String startTime, String endTime,
				Integer page) {
			ModelAndView mav = new ModelAndView();
			//判断两个时间的先后
			int row = startTime.compareTo(endTime);
			if(row >= 0){
				mav.addObject("err","开始时间不能在结束时间之后");
				mav.setViewName("/index.jsp");
				return mav;
			}
			
			PageHelper.startPage(page, 8, true);
			List<ParkingBean> bean = park.selectParking(startTime, endTime);

			PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);
			if (bean.size() != 0) {
				mav.addObject("paging", pageInfo);
				mav.addObject("all", bean);
				mav.setViewName("/jsp/timeparking.jsp");
			} else {
				mav.addObject("notFound","抱歉，未找到合适的车位");
				mav.setViewName("/index.jsp");
			}
			return mav;
		}

	// 包租婆查看自己的车位信息
	@RequestMapping("/showme.do")
	public ModelAndView showMe(HttpServletRequest request, Integer page) {
        //在session中取得当前登录的包租婆id
		int id=(int) request.getSession().getAttribute("id");
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(page, 5, true);
		List<ParkingBean> bean = park.showMe(id);
		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);

		if (bean != null) {
			mav.addObject("all", bean);
			mav.addObject("paging", pageInfo);

		} else {
			mav.addObject("noresult", "尚未添加车位");
		}
		mav.setViewName("/jsp/LookMyCar.jsp");
		return mav;
	}
	/**
	 * 通过ID查询单个车位信息
	 * @param id
	 * @return
	 */
	@RequestMapping("showDetailsParking.do")
	public ModelAndView findParkingById(Integer id){
		ModelAndView mav = new ModelAndView();
		ParkingBean bean = park.findParkingById(id);
		
		mav.addObject("park",bean);
		mav.setViewName("views/landlord_carpart_check.jsp");
		return mav;
	}
	/**
	 * 通过ID删除车位
	 * @param id
	 * @return
	 */
	@RequestMapping("parkingDelete.do")
	public @ResponseBody String parkingDelete(Integer id) {
		String result = "删除失败";
		boolean re = park.parkingDelete(id);
		if (re) {
			result = "删除成功";
		}
		return result;
	}

	@RequestMapping("parkingSelect.do")
	public ModelAndView parkingSelect(Integer page) {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page, 10, true);
		List<ParkingBean> list = park.parkingSelect();
		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(list);

		mav.addObject("pageinfo", pageInfo);
		mav.addObject("list", list);
		mav.setViewName("views/landlord_carpart_apply.jsp");

		return mav;
	}
	
	@RequestMapping("passApply.do")
	public @ResponseBody String passApply(Integer id) {
		String result = "通过失败";
		boolean re = park.passApply(id);
		if (re) {
			result = "通过成功";
		}
		return result;
	}

	@RequestMapping("passApplyFail.do")
	public @ResponseBody String passApplyFail(Integer id) {
		String result = "驳回失败";
		boolean re = park.passApplyFail(id);
		if (re) {
			result = "成功驳回";
		}
		return result;
	}
	
	/**
	 * springmvc提供的数据类型转换器
	 * @param binder
	 */
	@org.springframework.web.bind.annotation.InitBinder
	public void initBinder(WebDataBinder binder) {
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);  //是否需要严格转化
		
		//使用springmvc封装好的类进行格式转换
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
}

