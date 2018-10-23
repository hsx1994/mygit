package com.woniu.cbd.filter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
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

		System.out.println("这是登录失败需要返回的默认路径");
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
		String url = request.getServletPath();
		System.out.println("登录失败url" + url);

		return super.onLoginFailure(token, e, request, response);
	}

	/*
	 * 重写登录成功后跳转的页面
	 */
	@Override
	protected boolean onLoginSuccess(AuthenticationToken token,
			Subject subject, ServletRequest request, ServletResponse response)
			throws Exception {

		System.out.println("进入了MyFormAuthenticationFilter");



		WebUtils.getAndClearSavedRequest(request);

		HttpServletRequest req = (HttpServletRequest) request;

		String url = req.getServletPath();
		System.out.println("登录成功的url" + url);
		// WebUtils.redirectToSavedRequest(request, response, fallbackUrl);
		issueSuccessRedirect(req, response);
		// we handled the success redirect directly, prevent the chain from
		// continuing:
		return false;
	}

	@Override
	protected void setFailureAttribute(ServletRequest request,
			AuthenticationException ae) {

		System.out.println("设置失败的路径");
		String className = ae.getClass().getName();
		System.out.println("className="+className);
		System.out.println("getFailureKeyAttribute()="+getFailureKeyAttribute());
		request.setAttribute(getFailureKeyAttribute(), className);
	}

}
