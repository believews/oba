package com.oba.web.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * cookie常用类
 * 
 * @author keke
 * 
 */
public class CookieUtils {

	// public static String DOMAIN = "";

	public static void setCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String str, String domain) {
		int age = -1;
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(cookieName)) {
					cookies[i].setValue(str);
					cookies[i].setMaxAge(age);
					cookies[i].setPath("/");
					cookies[i].setDomain(domain);
					response.addCookie(cookies[i]);
					break;
				}
				if (i == (cookies.length - 1)) {
					Cookie newCookie = new Cookie(cookieName, str);
					newCookie.setMaxAge(age);
					newCookie.setPath("/");
					newCookie.setDomain(domain);
					response.addCookie(newCookie);
				}
			}
		}
	}

	public static String getCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
		Cookie[] cookies = request.getCookies();
		String cookie = null;
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(cookieName)) {
					cookie = cookies[i].getValue();
				}
			}
		}
		return cookie;
	}

	public static void dropCookie(HttpServletRequest request, HttpServletResponse response, String cookieName, String domain) {
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (int i = 0; i < cookies.length; i++) {
				if (cookies[i].getName().equals(cookieName)) {
					cookies[i].setMaxAge(0);
					cookies[i].setPath("/");
					cookies[i].setDomain(domain);
					response.addCookie(cookies[i]);
					break;
				}
			}
		}
	}

}