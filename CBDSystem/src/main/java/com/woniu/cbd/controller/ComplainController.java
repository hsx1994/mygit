package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.service.IComplainService;

/**
 * 处理投诉信息
 * @author Administrator
 *
 */
@Controller
public class ComplainController {
	@Autowired
	private IComplainService service;
	/**
	 * 显示所有待处理的投诉信息
	 * @param page
	 * @return
	 */
	@ResponseBody
	@RequestMapping("showComplain.do")
	public ModelAndView showComplain(Integer page){
		ModelAndView model = new ModelAndView();
		

		//设置分页处理 (第page页，每页显示10个，必须写在sql语句之前，不然分页不能生效，true可以省略)
		PageHelper.startPage(page,10,true);
		List<ComplainBean> list = service.showComplain();
		//取分页信息,需要填入你查询出的集合
		PageInfo<ComplainBean> pageInfo = new PageInfo<ComplainBean>(list);
		model.addObject("pageinfo",pageInfo);
		model.addObject("list",list);
		model.setViewName("views/complain_info.jsp");
		return model;
		
	}
	/**
	 * 显示正在处理投诉详细信息
	 * @param id
	 * @return
	 */
	@ResponseBody
	@RequestMapping("showDetailsComplain.do")
	public ModelAndView showComplainById(int id){
		
		ModelAndView model = new ModelAndView();
		ComplainBean bean = service.showComplainById(id);
		
		model.addObject("complain" ,bean);
		model.setViewName("views/complain_details.jsp");
		return model;
		
	}
	/**
	 * 处理投诉信息
	 * @param state
	 * @param id
	 * @return
	 */
	@RequestMapping("acceptComplain.do")
	public @ResponseBody String acceptComplain(Integer state,Integer id){
		
		String result = service.acceptComplain(state, id);
		
		return result;
			
	}
}
