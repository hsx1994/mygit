package com.woniu.cbd.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {
		System.out.println("进入了MyFormAuthenticationFilter");

		WebUtils.getAndClearSavedRequest(request);
		System.out.println("进入了MyFormAuthenticationFilter");

		WebUtils.redirectToSavedRequest(request, response, "/success.jsp");

		return super.onLoginSuccess(token, subject, request, response);
	}

}
