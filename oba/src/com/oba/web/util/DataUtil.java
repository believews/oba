package com.oba.web.util;

import java.util.Random;

public class DataUtil {

	/**
	 * 获取随机六位验证码
	 * @param charCount
	 * @return
	 */
	public static String getRandNum(int charCount) {
		String charValue = "";
	    for (int i = 0; i < charCount; i++){
		    char c = (char) (randomInt(0,10)+'0');
		    charValue += String.valueOf(c);
	    }
		return charValue;
	}
	
	public static int randomInt(int from, int to){
		  Random r = new Random();
		  return from + r.nextInt(to - from);
	}
	
	
	public static String toJsonP(String json){
		return "myCallback(" + json+ ")" ;
	}
	public static void main(String[] args) {
		System.err.println(DataUtil.getRandNum(6));
	}
}
