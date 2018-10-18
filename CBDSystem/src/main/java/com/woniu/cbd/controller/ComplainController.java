package com.woniu.cbd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.woniu.cbd.bean.ComplainBean;
import com.woniu.cbd.service.IComplainService;


@Controller
public class ComplainController {
	@Autowired
	private IComplainService service;
	
	@ResponseBody
	@RequestMapping("showComplain.do")
	public String showComplain(Model model,Integer page){
		System.out.println(page);
		//设置分页处理 (第page页，每页显示10个，必须写在sql语句之前，不然分页不能生效，true可以省略)
		PageHelper.startPage(page,10,true);
		List<ComplainBean> list = service.showComplain();
		//取分页信息,需要填入你查询出的集合
		PageInfo<ComplainBean> pageInfo = new PageInfo<ComplainBean>(list);
		System.out.println(pageInfo.getList());
		System.out.println(pageInfo);
		model.addAttribute("pageinfo",pageInfo);
		/*mv.setViewName("views.complain_info.html");*/
		return "complain_info.jsp";
		
	}
}
