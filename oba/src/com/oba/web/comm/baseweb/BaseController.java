package com.oba.web.comm.baseweb;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.ModelMap;

import com.oba.db.DbUtilsTemplate;
import com.oba.web.comm.exception.GenericBusinessException;
import com.oba.web.util.InetAddressTool;
import com.oba.web.util.JsonMapper;

/**
 * Controller父类
 * 
 * @author keke
 */
public abstract class BaseController {

	@Resource
	protected DbUtilsTemplate dbUtilsTemplate;


	protected JsonMapper jsonMapper = new JsonMapper();
	
	public final static boolean IS_DEBUG = true;// 标识
	
	public final static int BEGIN_PAGE_SIZE = 0;
	public final static int MAX_PAGE_SIZE = 100000;
	
	//获取功能编号
	protected Long getMenuId(HttpServletRequest request){
		System.out.println(request.getParameter("menuId"));
		return Long.valueOf(request.getParameter("menuId"));
	}


	

	/**
	 * 获取IP
	 * 
	 * @param request
	 * @return
	 */
	protected String getIp(HttpServletRequest request) {
		return InetAddressTool.getLocalIpv4(request);
	}

	/**
	 * 存放自定义异常或者有错误需要处理的错误的MAP--暂时没有用
	 * 
	 * @param map
	 */
	protected String setErrorMaps(ModelMap map, Exception ex) {
		if (IS_DEBUG) {
			ex.printStackTrace();
		}
		return "zcomm/generic_error";
	}

	/**
	 * 存放自定义错误的MAP
	 * 
	 * @param map
	 */
	protected String setErrorMaps(ModelMap map, String message) {
		map.addAttribute("msgs", message);
		return "zcomm/generic_error";
	}

	/**
	 * AJAX 输出字符串
	 * 
	 * 
	 * @throws GenericBusinessException
	 * @throws IOException
	 */

	protected String ajaxWriteStr(String jsonstr, HttpServletResponse response) throws  Exception {
		try {
			response.setContentType("text/html");// 这句设置很重要 对于其他支付方式对接
			// 苹果浏览器和IE下必须设置这个
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(jsonstr);
		} catch (IOException e) {
			if (IS_DEBUG) {
				e.printStackTrace();
			}
			throw new Exception("输出AJAX字符串出错！");
		}
		return null;
	}
	/**
	 * 请取请求参数值toString
	 * @param request
	 * @return
	 */
	public Map<String,String> getRequestMapByParamValues(final javax.servlet.http.HttpServletRequest request){
		Map<String,String[]> requestParams = request.getParameterMap();
		Map<String,String> paramMap=new java.util.HashMap<String, String>();
//		StringBuffer sb=new StringBuffer();
//		int ileng=0;
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
//			if(ileng==0){
//				sb.append("["+name+":"+valueStr+"]");
//			//System.out.printlnnd("\n["+name+":"+valueStr+"]");
//			}else{
//				sb.append("\n["+name+":"+valueStr+"]");
//			}
//			ileng++;
			//System.out.println("Alipay req param ["+name+":"+valueStr+"]");
			
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			paramMap.put(name, valueStr);
		}
		return paramMap;
	}
	public String getRequestParamValues(final javax.servlet.http.HttpServletRequest request){

		//获取支付宝POST过来反馈信息

		Map<String,String[]> requestParams = request.getParameterMap();
		StringBuffer sb=new StringBuffer();
		int ileng=0;
		for (Iterator<String> iter = requestParams.keySet().iterator(); iter.hasNext();) {
			String name = (String) iter.next();
			String[] values = (String[]) requestParams.get(name);
			String valueStr = "";
			for (int i = 0; i < values.length; i++) {
				valueStr = (i == values.length - 1) ? valueStr + values[i]
						: valueStr + values[i] + ",";
			}
			if(ileng==0){
				sb.append("["+name+":"+valueStr+"]");
			//System.out.printlnnd("\n["+name+":"+valueStr+"]");
			}else{
				sb.append("\n["+name+":"+valueStr+"]");
			}
			ileng++;
			//System.out.println("Alipay req param ["+name+":"+valueStr+"]");
			
			//乱码解决，这段代码在出现乱码时使用。如果mysign和sign不相等也可以使用这段代码转化
			//valueStr = new String(valueStr.getBytes("ISO-8859-1"), "gbk");
			//params.put(name, valueStr);
		}
		return sb.toString();

	}
}
