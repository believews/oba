package com.oba.web.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class FileUtils {

	/**
	 * 按照日期创建文件夹
	 * 
	 * @param prefix
	 * @return
	 */
	public static String mkdir(String path, String prefix) {
		Calendar date = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");

		File file = new File(path + prefix + "/" + format.format(date.getTime()) + "/");
		// 判断文件夹是否存在,如果不存在则创建文件夹
		if (!file.exists()) {
			file.mkdir();
		}
		return prefix + "/" + format.format(date.getTime()) + "/";
	}
	// 根据文件根目录和传入的文件目录，创建目录
	public static boolean createFilePath(String basePath, String path) {
		boolean ret = false;
		String[] paths = path.split("/");
		if (paths != null && paths.length > 0) {
			String cPath = basePath;
			for (int f = 0; f < paths.length; f++) {
				File baseFile = new File(cPath + "/" + paths[f]);
				if (!baseFile.exists())
					baseFile.mkdir();
				cPath += "/" + paths[f];
			}
			ret = true;
		}
		return ret;
	}
}
