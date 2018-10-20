package com.woniu.cbd.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
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
	public @ResponseBody String ApplicationParking(MultipartFile imgFile, ParkingBean bean, MultipartFile ImgFile,HttpServletRequest req) {
		
		// 获取上传文件的文件名
		String img =UUID.randomUUID()+"_"+imgFile.getOriginalFilename();
		String certImg = UUID.randomUUID()+"_"+ImgFile.getOriginalFilename();
		// 将文件名放入对象中
		bean.setImg(img);
		bean.setCertImg(certImg);

		ServletContext context = req.getServletContext();
		ServletContext text = req.getServletContext();
        //车位图片路径
		String path = context.getRealPath("/image");
		//产权证图片路径
		String sum = text.getRealPath("/certImg");
		
		File g = new File(sum);
		File f = new File(path);
		if (!f.exists() &&!g.exists())
			f.mkdirs();
		    g.mkdirs();
		// 创建服务器路径下的文件
		File file = new File(path, UUID.randomUUID()+"_"+imgFile.getOriginalFilename());
		// 创建服务器路径下的文件
		File file1 = new File(sum, UUID.randomUUID()+"_"+ImgFile.getOriginalFilename());
		try {
			// 将文件保存到服务器image文件夹
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
		boolean num = park.AddParking(parking);
		String result = "失败";
		if (num) {
			result = "成功";
		}
		return result;

	}

	// 时间格式转换
	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(false);// 是否严格按照格式

		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));

	}

	// 抢租客查看所有上架车位
	@RequestMapping("showall.do")
	public ModelAndView ShowAll(Integer page) {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page, 10, true);
		List<ParkingBean> bean = park.ShowAll();
		PageInfo<ParkingBean> pageInfo = new PageInfo<ParkingBean>(bean);

		mav.addObject("pageinfo", pageInfo);
		mav.addObject("list", bean);
		mav.setViewName("");

		return mav;

	}

	// 抢租客查看单个上架车位
	@RequestMapping("showOne.do")
	public ModelAndView ShowOne(Integer id) {
		ModelAndView mav = new ModelAndView();
		ParkingBean bean = park.SelectParkOne(id);

		mav.addObject("one", bean);
		mav.setViewName("");

		return mav;

	}

	// 抢租客车位号模糊查询上架车位

	@RequestMapping("findbynum.do")
	public ModelAndView SelectParkByNum(String num, Integer page) {

		ModelAndView mav = new ModelAndView();
		List<ParkingBean> bean = park.SelectParkByNum(num);
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

	@RequestMapping("findbyprice.do")
	public ModelAndView SelectPark(Integer price, Integer page) {

		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page, 10, true);
		List<ParkingBean> bean = park.SelectPark(price);
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
}
