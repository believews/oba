package com.oba.web.comm.interceptor;

import org.apache.log4j.Logger;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebArgumentResolver;
import org.springframework.web.context.request.NativeWebRequest;

/**
 * 
 * 解决 Controller 请求方法里，需要获取 Session 的 用户对象
 * 
 * @see org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter
 */

@SuppressWarnings("all")
public class UserArgumentResolver implements WebArgumentResolver {
	private Logger logger = Logger.getLogger(this.getClass());


	public Object resolveArgument(MethodParameter methodParameter, NativeWebRequest webRequest) throws Exception {

		/*
		 * if (methodParameter.getParameterType().equals(CardOwner.class)) {
		 * HttpServletRequest request = (HttpServletRequest)
		 * webRequest.getNativeRequest(); CardOwner user =
		 * sessionService.getUser(request); if (user == null) { user = new
		 * CardOwner(); } return user; } else { return UNRESOLVED; }
		 */
		return UNRESOLVED;
	}
}
