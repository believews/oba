package com.oba.web.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;



/**
 * 
 */
@SuppressWarnings("all")
public class XmlUtils {
	/**
	 * 解析XML
	 * @param body
	 * @return
	 * @throws Exception
	 */
	public static String praseStringfromXml(String body) throws Exception {
		String status="";
		Document doc = DocumentHelper.parseText(body); // 将字符串转为XML
        Element rootElt = doc.getRootElement(); // 获取根节点smsReport  
        Iterator iters = rootElt.elementIterator(); // 获取根节点下的子节点sms
        while (iters.hasNext()) {
            Element recordEle = (Element) iters.next();
            if(recordEle.getName().equalsIgnoreCase("State")){
            	status = recordEle.getText();
            }
        }
		return status;
	}
	
	public static String praseStringfromXml2(String body) throws Exception {
		String status="";
		Document doc = DocumentHelper.parseText(body); // 将字符串转为XML
        Element rootElt = doc.getRootElement(); // 获取根节点smsReport  
        status = rootElt.getText();
		return status;
	}
	public static void main(String[] agrs) throws Exception{
		System.out.println(praseStringfromXml2("<?xml version='1.0' encoding='utf-8'?><string xmlns='http://tempuri.org/'>-7222733112341060284</string>").length());
	}
}