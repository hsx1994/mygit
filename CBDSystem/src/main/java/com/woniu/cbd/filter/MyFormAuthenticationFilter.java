package com.woniu.cbd.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

	private static final Logger log = LoggerFactory
			.getLogger(FormAuthenticationFilter.class);

	@Override
	public void setLoginUrl(String loginUrl) {
		String previous = getLoginUrl();
		if (previous != null) {
			this.appliedPaths.remove(previous);
		}
		super.setLoginUrl(loginUrl);
		if (log.isTraceEnabled()) {
			log.trace("Adding login url to applied paths.");
		}

		this.appliedPaths.put(getLoginUrl(), null);
	}

	/*
	 * 重写登录失败后跳转的页面
	 */
	@Override
	protected boolean onLoginFailure(AuthenticationToken token,
			AuthenticationException e, ServletRequest req, ServletResponse resp) {
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		return super.onLoginFailure(token, e, request, response);
	}

	@Override
	protected void setFailureAttribute(ServletRequest request,
			AuthenticationException ae) {

		String className = ae.getClass().getName();
		request.setAttribute(getFailureKeyAttribute(), className);
	}

}
