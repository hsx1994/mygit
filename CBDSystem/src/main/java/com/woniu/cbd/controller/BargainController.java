package com.woniu.cbd.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.BargainBean;
import com.woniu.cbd.bean.OtherParkingBean;
import com.woniu.cbd.service.IBargainService;
import com.woniu.cbd.service.IOtherParkingService;
import com.woniu.cbd.util.FileUpUtil;

@Controller
public class BargainController {
	@Autowired
	private IBargainService service;
	@Autowired
	private IOtherParkingService otherParkingService;
	/**
	 * 添加第三方合约
	 * @param bean
	 * @return
	 */
	@RequestMapping("bargainAdd.do")
	public @ResponseBody String bargainAdd(HttpServletRequest request,BargainBean bean,String[] parkingAddress,
			String[] parkingNumber,String startNumber,String endNumber,String[] price,
			@RequestParam(value="parkingImg", required=true) MultipartFile[] parkingImg,
			@RequestParam(value="barginCopy", required=true) MultipartFile[] barginCopy) {
		String result = "添加失败";
		
		if(parkingAddress == null || parkingNumber == null || startNumber == null ||
				endNumber == null || parkingImg == null || price == null || barginCopy == null
		   ){
			return "输入不能为空";
		}
		if(parkingAddress.length < 1 || parkingNumber.length <1 || startNumber.trim().length() < 1 ||
				endNumber.trim().length() < 1 || parkingImg.length < 1|| price.length< 1 || barginCopy.length < 1
		   ){
			return "输入不能为空字符";
		}
		bean.setImg(FileUpUtil.fileUpUtil(barginCopy, request, "/images/bargain").get(0));
		boolean re = service.bargainAdd(bean);
		if (re) {
			result = "添加成功";
			List<String> list = FileUpUtil.fileUpUtil(parkingImg, request, "/images/otherparking");
			String[] imgPath = new String[list.size()];
			list.toArray(imgPath);
			otherParkingService.addOtherParking(bean, parkingAddress, parkingNumber, imgPath, price, startNumber, endNumber);
		}
		return result;
	}

	@RequestMapping("bargainDelete.do")
	public @ResponseBody String bargainDelete(Integer id) {
		String result = "删除失败";
		boolean re = service.bargainDelete(id);
		if (re) {
			result = "删除成功";
		}
		return result;
	}
	
	@RequestMapping("bargainUpdate.do")
	public @ResponseBody String bargainUpdate(BargainBean bean) {
		String result = "更改失败";
		boolean re = service.bargainUpdate(bean);
		if (re) {
			result = "更改成功";
		}
		return result;
	}
	/**
	 * 查看第三方合约
	 * @param bean
	 * @param page
	 * @return
	 */
	@RequestMapping("bargainSelect.do")
	public ModelAndView bargainSelect(BargainBean bean,Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page,10,true);
		List<BargainBean> bargain = service.bargainSelect(bean);
		PageInfo<BargainBean> pageInfo = new PageInfo<BargainBean>(bargain);
		
		if(bargain != null){
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list",bargain);
		} else {
			mav.addObject("bargain","尚未签订合约");
		}
		mav.setViewName("views/out_contract_info.jsp");

		return mav;
	}
	/**
	 * 查看所有第三方合约
	 * @param page
	 * @return
	 */
	@RequestMapping("allBargainSelect.do")
	public ModelAndView allBargainSelect(Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page,10,true);
		List<BargainBean> bargain = service.allBargainSelect();
		PageInfo<BargainBean> pageInfo = new PageInfo<BargainBean>(bargain);
		
		if(bargain != null){
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list",bargain);
		} else {
			mav.addObject("allBargain","尚未签订合约");
		}
		mav.setViewName("");

		return mav;
	}
	/**
	 * 查询在用的合约
	 * @param page
	 * @return
	 */
	@RequestMapping("findUseingBargain.do")
	public ModelAndView findUseingBargain(Integer page) {
		ModelAndView mav = new ModelAndView();
		
		PageHelper.startPage(page,10,true);
		List<BargainBean> list = service.bargainSelectByState(0);
		PageInfo<BargainBean> pageInfo = new PageInfo<BargainBean>(list);
		
		if(list != null){
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list",list);
		} else {
			mav.addObject("pageinfo","尚未签订合约");
		}
		mav.setViewName("views/out_contract_info.jsp");

		return mav;
	}
	/**
	 * 查看已废弃的合约
	 * @param page
	 * @return
	 */
	@RequestMapping("findUnuseingBargain.do")
	public ModelAndView findUnseingBargain(Integer page) {
		ModelAndView mav = new ModelAndView();

		PageHelper.startPage(page,10,true);
		List<BargainBean> bargain = service.bargainSelectByState(1);
		PageInfo<BargainBean> pageInfo = new PageInfo<BargainBean>(bargain);
		
		if(bargain != null){
			mav.addObject("pageinfo", pageInfo);
			mav.addObject("list",bargain);
		} else {
			mav.addObject("unuseingBargain","没有废弃的合约");
		}
		mav.setViewName("views/out_history_contract.jsp");

		return mav;
	}
	
	/**
	 * 管理员根据条件查询执行中第三方合同
	 * @param page
	 * @param condition
	 * @return
	 */
	@RequestMapping("queryOutUseingBargain.do")
	public ModelAndView queryUseingBargainByCondition(Integer page,String condition){
		ModelAndView mv = new ModelAndView();
		if(condition!=null){
			PageHelper.startPage(page,10,true);
			List<BargainBean> list = service.queryUseingBargainByCondition(condition);
			PageInfo<BargainBean> pageInfo = new PageInfo<BargainBean>(list);
			mv.addObject("condition", condition);
			mv.addObject("pageinfo", pageInfo);
			mv.addObject("list",list);
			mv.setViewName("views/out_contract_info.jsp");
		}
		return mv;
		
	}
	
	/**
	 * 管理员根据条件查询第三方历史合同
	 * @param page
	 * @param condition
	 * @return
	 */
	@RequestMapping("queryOutHistoryBargain.do")
	public ModelAndView queryHistoryBargainByCondition(Integer page,String condition){
		ModelAndView mv = new ModelAndView();
		if(condition!=null){
			PageHelper.startPage(page,10,true);
			List<BargainBean> list = service.queryHistoryBargainByCondition(condition);
			PageInfo<BargainBean> pageInfo = new PageInfo<BargainBean>(list);
			mv.addObject("condition", condition);
			mv.addObject("pageinfo", pageInfo);
			mv.addObject("list",list);
			mv.setViewName("views/out_history_contract.jsp");
		}
		return mv;
		
	}
	/**
	 * 显示合约详情
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("showOutDetailsBargain.do")
	public Map<String, Object> showDetailsBargain(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		BargainBean bean = service.showDetailsBargain(id);		
		List<OtherParkingBean> list = bean.getParking();
		String num = "";
		for (int i = 0; i < list.size(); i++) {
			if(i==0){
				num=list.get(i).getParkingNum();
			}
			num+="、"+list.get(i).getParkingNum();
		}
		map.put("bargin", bean);
		map.put("carNum", num);
		return map;
		
	}
	
	/**
	 * 外部合约续约详情
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("outContractExtension.do")
	public Map<String, Object> outContractExtension(int id){
		Map<String, Object> map = new HashMap<String, Object>();
		BargainBean bean = service.showDetailsBargain(id);		
		List<OtherParkingBean> list = bean.getParking();
		String num = "";
		for (int i = 0; i < list.size(); i++) {
			if(i==0){
				num=list.get(i).getParkingNum();
			}
			num+="、"+list.get(i).getParkingNum();
		}
		map.put("bargin", bean);
		map.put("carNum", num);
		return map;
		
	}
	

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		format.setLenient(true);  //是否需要严格转化
		
		//使用springmvc封装好的类进行格式转换
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format, true));
	}
}
