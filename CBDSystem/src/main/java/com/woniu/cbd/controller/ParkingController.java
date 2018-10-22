package com.woniu.cbd.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.ParkingBean;
import com.woniu.cbd.service.IParkingService;

@Controller
public class ParkingController {
	@Autowired
	private IParkingService park;

	// 包租婆批量添加车位信息
	@RequestMapping("/application.do")
	public @ResponseBody String applicationParking(HttpServletRequest request, MultipartFile imgFile, ParkingBean bean,
			MultipartFile ImgFile, HttpServletRequest req) {

		// 获取上传文件的文件名
		String img = UUID.randomUUID() + "_" + imgFile.getOriginalFilename();
		String certImg = UUID.randomUUID() + "_" + ImgFile.getOriginalFilename();
		// 将文件名放入对象中
		bean.setImg(img);
		bean.setCertImg(certImg);

		// session中取得当前包租婆的id给parking实体类
		/* UserBean user=request.getSession().getAttribute(""); */

		ServletContext context = req.getServletContext();
		ServletContext text = req.getServletContext();
		// 车位图片路径
		String path = context.getRealPath("/img");
		// 产权证图片路径
		String sum = text.getRealPath("/certImg");

		File g = new File(sum);
		File f = new File(path);
		if (!f.exists() && !g.exists())
			f.mkdirs();
		g.mkdirs();
		// 创建服务器路径下的文件用uuid命名
		File file = new File(path, UUID.randomUUID() + "_" + imgFile.getOriginalFilename());
		// 创建服务器路径下的文件用uuid命名
		File file1 = new File(sum, UUID.randomUUID() + "_" + ImgFile.getOriginalFilename());
		try {
			// 将文件保存到服务器img文件夹
			imgFile.transferTo(file);
			// 将文件保存到服务器certImg文件夹
			ImgFile.transferTo(file1);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		List<ParkingBean> parking = new ArrayList<ParkingBean>();
		parking.add(bean);
		boolean num = park.addParking(parking);
		String result = "失败";
		if (num) {
			result = "成功";
		}
		return result;

	}

	// 时间格式转换
	@org.springframework.web.bind.annotation.InitBinder
	public void InitBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);// 是否严格按照格式

		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));

	}

	// 包租婆查看单个上架车位
	@RequestMapping("/landladyshowOne.do")
	public ModelAndView showOne(Integer id) {
		ModelAndView mav = new ModelAndView();
		ParkingBean bean = park.selectParkingOne(id);
		mav.addObject("one", bean);
		mav.setViewName("063/ DetailsLandladyParking.jsp");

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
		mav.setViewName("/jsp/ShowParkingSpace.jsp");
		System.out.println(page);
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

		ModelAndView mav = new ModelAndView();
		List<ParkingBean> bean = park.selectParkingByNum(num);
		if (bean != null) {
			mav.addObject("num", bean);
			mav.setViewName("");
		} else {
			mav.addObject("空");
			mav.setViewName("");
		}
		return mav;

	}

	// 抢租客根据价格查询上架车位
	@RequestMapping("findByPrice.do")

	public ModelAndView selectParking(Integer price, Integer page) {

		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page, 8, true);
		List<ParkingBean> bean = park.selectParking(price);

		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);

		if (bean != null) {

			mav.addObject("price", pageInfo);
			mav.addObject("list", bean);
		} else {
			mav.addObject("空");
		}
		mav.setViewName("");
		return mav;

	}

	// 包租婆查看自己的车位信息
	@RequestMapping("/showme.do")
	public ModelAndView showMe(HttpServletRequest request, Integer page) {
        //在session中取得当前登录的包租婆id
		/*int id=request.getSession().getAttribute("");*/
		int id=1;//测试使用
		
		ModelAndView mav = new ModelAndView();
		PageHelper.startPage(page, 8, true);
		List<ParkingBean> bean = park.showMe(id);
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
		String result = "失败";
		boolean re = park.passApplyFail(id);
		if (re) {
			result = "成功";
		}
		return result;
	}

	@org.springframework.web.bind.annotation.InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		format.setLenient(false);  //是否需要严格转化
		
		//使用springmvc封装好的类进行格式转换
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));		
	}
}
