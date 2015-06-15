package com.oba.web.util;

import java.net.InetAddress;

import javax.servlet.http.HttpServletRequest;

public class InetAddressTool {

	/**
	 * 获取本机 IP ipv4
	 * 
	 * @return 192.168.42.29
	 */
	public static String getLocalIpv4(HttpServletRequest request) {
		String ip = request.getHeader("x-forwarded-for");
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getHeader("WL-Proxy-Client-IP");
		}
		if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
			ip = request.getRemoteAddr();
		}
		return ip;

	}

	/**
	 * 获取本地主机ip列表
	 * 
	 * @return 两个 192.168.42.29(ipv4) fe80:0:0:0:f510:61a9:91b3:50fc%14(ipv6)
	 */
	public static InetAddress[] getLocalIPs() {
		InetAddress[] mArLocalIP = null;
		try {
			mArLocalIP = InetAddress.getAllByName(InetAddress.getLocalHost().getHostName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return mArLocalIP;
	}

	public static String getRemortIP(final javax.servlet.http.HttpServletRequest request) {

        if (request.getHeader("x-forwarded-for") == null) {

            return request.getRemoteAddr();    

        }     

        return request.getHeader("x-forwarded-for");     

    }
}
