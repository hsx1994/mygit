package com.woniu.cbd.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.woniu.cbd.util.AlipayUtil;

@Controller
public class AlipayController {
	@RequestMapping("/getQRcode.do")
	public String getQRcode(HttpServletRequest request){
		String result ="<!DOCTYPE html><html lang='en'><head><meta charset='UTF-8'><title>Title</title></head><body>";
		result += AlipayUtil.getQRcode(request);
		result += "</body></html>";
		return result;
	}
}
