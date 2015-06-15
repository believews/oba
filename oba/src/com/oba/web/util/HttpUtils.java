package com.oba.web.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;



public class HttpUtils {
	/**
	 * http://192.168.1.132:8088/WebServer/student.do
	 * @param url
	 * @throws Exception
	 */
	public static String post(String url, List<NameValuePair> params) {

		CloseableHttpClient client = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		HttpResponse response = null; 
		String data = ""; 
		// 编码格式转换
		UrlEncodedFormEntity entity;
		try {
			entity = new UrlEncodedFormEntity(params, "UTF-8");
			post.setEntity(entity);
			response = client.execute(post);
			
			if (response.getStatusLine().getStatusCode() == 200) {
				HttpEntity resEntity = response.getEntity();
				data = EntityUtils.toString(resEntity);
			}
		} catch (Exception e) {
			throw new RuntimeException("请求接口ERROR");
		}
		return data;
	}
	
	public static <T> void outPrint(HttpServletResponse response, T target)  throws ServletException, IOException {
		JsonMapper jsonMapper = new JsonMapper();
		String resJson = jsonMapper.toJson(target);
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print(resJson);
		out.flush();
		out.close();
	}
	
    public static String getRequestPath(HttpServletRequest request) { 
    	try {
			request.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
    	Map<String,String[]> a =  request.getParameterMap();
    	StringBuilder sb = new StringBuilder();
    	for(String name : a.keySet()){
    		sb.append(name);
    		sb.append(":");
    		sb.append(Arrays.toString(a.get(name)));
    		sb.append("&");
    	}
    	
        String requestPath = request.getRequestURI() + "?" + sb.toString();  
        return requestPath;  
    } 
	
    
}