package com.oba.web.comm.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * LogInterceptor 负责记录日志拦截器<br>
 * 
 * @version 1.0
 */
public class LogInterceptor extends HandlerInterceptorAdapter {

	private Logger logger = Logger.getLogger(this.getClass());

	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object target) throws Exception {
		return true;
	}

	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		if (ex != null) {
			logger.info("path:[" + request.getRequestURL().toString() + "]error,cause:[" + ex.getMessage() + "]");
		} else {
			//logger.info("path:[" + request.getRequestURL().toString() + "]success.");
		}
	}

}
