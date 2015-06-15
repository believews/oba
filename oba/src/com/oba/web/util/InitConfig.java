package com.oba.web.util;

import java.util.Properties;

public final class InitConfig {
	public static String AUTO_UPLOAD_PATH;
	public static String AUTO_UPYUN_USER;
	public static String AUTO_UPYUN_PASS;
	public static String AUTO_UPYUN_BUCKET;
	public static String AUTO_IMG_WIDTH;
	public static String AUTO_IMG_HEIGHT;
	public static String AUTO_IMG_URL;
	
	
	public static String AUTO_HOUR_MIN;
	public static String AUTO_HOUR_MAX;
	public static String AUTO_HOUR_BEGIN;
	public static String AUTO_HOUR_END;
	public static String AUTO_HOUR_SECOND_LIST;
	
	//打印模版
	public static String AUTO_PRINT_TEMPLATE;
	public static String AUTO_PRINT_TEMPDIR;
	
	public static String AUTO_TIME_AGO;
	public static String AUTO_TIME_AFTER;
	
	public static String AUTO_SMS_URL;
	
	public static String ATUO_DAY_ORDER_COUNT;
	
	public static Double servicePay = 150d;
	static{
		FileUtil util = new FileUtil();
		Properties prop = util.getProperties("/init-config.properties");
		AUTO_UPLOAD_PATH = prop.getProperty("auto.upload.path");
		AUTO_UPYUN_USER = prop.getProperty("auto.upyun.username");
		AUTO_UPYUN_PASS = prop.getProperty("auto.upyun.password");
		AUTO_UPYUN_BUCKET = prop.getProperty("auto.bucket");
		AUTO_IMG_URL = prop.getProperty("auto.img.url");
		AUTO_IMG_HEIGHT = prop.getProperty("auto.img.height");
		AUTO_IMG_WIDTH = prop.getProperty("auto.img.width");
		
		AUTO_HOUR_MIN = prop.getProperty("auto.hour.min");
		AUTO_HOUR_MAX = prop.getProperty("auto.hour.max");
		AUTO_HOUR_BEGIN = prop.getProperty("auto.hour.begin");
		AUTO_HOUR_END = prop.getProperty("auto.hour.end");
		AUTO_HOUR_SECOND_LIST = prop.getProperty("auto.hour.second.list");
		
		AUTO_PRINT_TEMPLATE = prop.getProperty("auto.print.template");
		AUTO_PRINT_TEMPDIR = prop.getProperty("auto.print.tempdir");
		
		AUTO_TIME_AGO = prop.getProperty("auto.time.ago");
		AUTO_TIME_AFTER = prop.getProperty("auto.time.after");
	
		AUTO_SMS_URL = prop.getProperty("auto.sms.url");
		
		ATUO_DAY_ORDER_COUNT = prop.getProperty("auto.day.order.count");
	}
}
