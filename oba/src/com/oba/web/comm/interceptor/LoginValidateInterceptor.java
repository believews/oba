package com.oba.web.comm.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginValidateInterceptor extends HandlerInterceptorAdapter {
	

	// 不需要检查的URL
	private List<String> uncheckedUrls;

	public List<String> getUncheckedUrls() {
		return uncheckedUrls;
	}

	public void setUncheckedUrls(List<String> uncheckedUrls) {
		this.uncheckedUrls = uncheckedUrls;
	}

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object target) throws Exception {
			return true;
	}
}
