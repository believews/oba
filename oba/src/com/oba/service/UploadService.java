package com.oba.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public interface UploadService {

	/**
	 * 上传文件
	 * @param file	文件
	 * @param folder	文件夹名称
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException;
}
