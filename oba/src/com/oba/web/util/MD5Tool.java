package com.oba.web.util;

import java.security.MessageDigest;

/**
 * MD5 算法工具类
 * 
 * 
 */
public class MD5Tool {
	/**
	 * 转换字节数组为字符串
	 * 
	 * @param b
	 *            字节数组
	 * @return 字符串
	 */
	public static String toHexString(byte[] b) {
		StringBuffer hexString = new StringBuffer();
		String plainText;

		for (int i = 0; i < b.length; i++) {
			plainText = Integer.toHexString(0xFF & b[i]);
			if (plainText.length() < 2) {
				plainText = "0" + plainText;
			}
			hexString.append(plainText);
		}
		return hexString.toString();
	}

	/**
	 * 用MD5加密密码
	 * 
	 * @param password
	 *            未加密密码
	 * @return 加密密码
	 * @throws Exception
	 *             异常
	 */
	public static String toMD5Password(String password) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		if (password == null) {
			throw new Exception("The password is 'Null',check it please!");
		}
		md.update(password.getBytes("utf-8"));
		return toHexString(md.digest());
	}
	/**
	 * 
	 * @param password
	 * @param charSet
	 * @return
	 * @throws Exception
	 */
	public static String toMD5Password(String password,String charSet) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		if (password == null) {
			throw new Exception("The password is 'Null',check it please!");
		}
		md.update(password.getBytes(charSet));
		return toHexString(md.digest());
	}

	public static void main(String[] args) {
		try {
			////System.out.println(MD5Tool.toMD5Password("123"));
//			////System.out.println(MD5Tool.toMD5Password("test2"));
//			////System.out.println(MD5Tool.toMD5Password("test3"));
//			////System.out.println(MD5Tool.toMD5Password("test4"));
//			////System.out.println(MD5Tool.toMD5Password("test5"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
