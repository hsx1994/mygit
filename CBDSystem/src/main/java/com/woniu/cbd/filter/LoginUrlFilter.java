package com.woniu.cbd.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.woniu.cbd.bean.LoginBean;

public class LoginUrlFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp,
			FilterChain chain) throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		HttpSession session = request.getSession();
		LoginBean login = (LoginBean) session.getAttribute("login");
		String url = request.getServletPath();
		
		if (url.endsWith("login.jsp") || url.endsWith("login.do")  || url.endsWith("regist.jsp")) {
			chain.doFilter(request, response);
		}else{
			if(login==null){
			response.sendRedirect("/CBDSystem/jsp/login.jsp");
			} else {
				chain.doFilter(request, response);
			}
			
		}
		
		

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
