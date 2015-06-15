package com.oba.web.comm.syscontains;

import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;

import com.oba.web.util.StringTool;
import com.oba.web.util.WebUtil;

/**
 * 获取配置文件
 * @author keke
 *
 */
public class UploadUrlsConfigurer extends PropertyPlaceholderConfigurer {
	private static Map<String, String> uploadUrlsPropertiesMap = new HashMap<String, String>();

	protected void processProperties(ConfigurableListableBeanFactory beanFactoryToProcess, Properties props) throws BeansException {
		super.processProperties(beanFactoryToProcess, props);
		uploadUrlsPropertiesMap = new HashMap<String, String>();
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			String value = props.getProperty(keyStr);
			uploadUrlsPropertiesMap.put(keyStr, value);
		}
	}

	public String getContextProperty(HttpServletRequest request) {
		String value = uploadUrlsPropertiesMap.get(WebUtil.getNoAppNamedRequestURI(request));
		if(StringTool.isEmpty(StringTool.nullToString(value))){
			return uploadUrlsPropertiesMap.get("default.url");
		}
		return value;
	}
}
