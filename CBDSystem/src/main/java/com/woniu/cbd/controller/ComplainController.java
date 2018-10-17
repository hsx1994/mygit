package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.service.IComplainService;


@Controller
public class ComplainController {
	@Autowired
	private IComplainService service;
	@RequestMapping("showComplain.do")
	public ModelAndView showComplain(Integer page){
		System.out.println(page);
		ModelAndView mv = new ModelAndView();
		//设置分页处理 (第page页，每页显示3个，必须写在sql语句之前，不然分页不能生效，true可以省略)
		PageHelper.startPage(page,3,true);
		List<ComplainBean> list = service.showComplain();
		//取分页信息,需要填入你查询出的集合
		PageInfo<ComplainBean> pageInfo = new PageInfo<ComplainBean>(list);
		mv.addObject("pageinfo",pageInfo);
		System.out.println(pageInfo);
		/*mv.setViewName("views.complain_info.html");*/
		return mv;
		
	}
}
