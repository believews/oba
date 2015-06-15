package com.oba.web.init;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

import com.oba.db.DbUtilsTemplate;

@Component
@SuppressWarnings("all")
public class InitSpringServletContext implements ServletContextAware {

	private Logger logger = Logger.getLogger(this.getClass());
	@Resource
	private DbUtilsTemplate dbUtilsTemplate;
	@Override
	public void setServletContext(ServletContext arg0) {
		// TODO Auto-generated method stub
		
	}

	

	
	
}
