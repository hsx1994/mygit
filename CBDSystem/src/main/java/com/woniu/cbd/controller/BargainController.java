package com.woniu.cbd.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.BargainBean;
import com.woniu.cbd.bean.OtherParkingBean;
import com.woniu.cbd.service.IBargainService;

@Controller
public class BargainController {
	@Autowired
	private IBargainService service;

	@RequestMapping("bargainAdd.do")
	public @ResponseBody String bargainAdd(BargainBean bean) {
		String result = "添加失败";
		boolean re = service.bargainAdd(bean);
		if (re) {
			result = "添加成功";
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
}
