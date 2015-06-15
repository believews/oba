package com.oba.web.comm.syscontains;

import javax.annotation.Resource;

import com.oba.web.util.StringTool;

/**
 * 本系统取配置文件的信息类
 * 
 * @author keke
 * 
 */

@SuppressWarnings("all")
public class SysUrlConfServices {
	
	private String DOMAIN = "domain";
	private String WEB_URL = "web.url";
	private String WEBSERVICE_URL = "webservice.url";

	@Resource
	private CustomizedConfigurer customizedConfigurer;
	private static SysUrlConfServices sysUrlConfServices = null;

	public static SysUrlConfServices getInstance() {
		if (sysUrlConfServices == null) {
			sysUrlConfServices = new SysUrlConfServices();
			return sysUrlConfServices;
		} else {
			return sysUrlConfServices;
		}
	}
	public String getDomain() {
		return StringTool.nullToString(customizedConfigurer.getContextProperty(DOMAIN));
	}
	public String getWebUrl() {
		return StringTool.nullToString(customizedConfigurer.getContextProperty(WEB_URL));
	}
	public String getWebServiceUrl() {
		return StringTool.nullToString(customizedConfigurer.getContextProperty(WEBSERVICE_URL));
	}
	
	public String getWebUrlJS() {
		return getWebUrl();
	}

	public String getWebUrlCSS() {
		return getWebUrl();
	}

	public String getWebUrlImages() {
		return getWebUrl();
	}

	// Web.js 加载js资源地址
	public String getWebJsUrl() {
		return getWebUrlJS();
	}

	// Web.css 加载css资源地址
	public String getWebCssUrl() {
		return getWebUrlCSS();
	}

	// Web.image，加载资源图片用
	public String getWebImagesUrl() {
		return getWebUrlImages();
	}

	/**
	 * 登陆地址
	 * 
	 * @return
	 */
	public String getLoginUrl() {
		return getWebUrl() + "/login";
	}

}
