package com.oba.service.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import com.oba.service.UploadService;
import com.oba.web.comm.syscontains.UploadUrlsConfigurer;
import com.oba.web.util.FileUtils;
import com.oba.web.util.Identities;

@SuppressWarnings("all")
@Service("uploadService")
public class UploadServiceImpl implements UploadService {

	@Resource
	protected UploadUrlsConfigurer uploadUrlsConfigurer;
	
	/* 
	 * @see com.cf.service.UploadService#uploadFile(org.springframework.web.multipart.MultipartFile, java.lang.String, javax.servlet.http.HttpServletRequest)
	 */
	
	public String uploadFile(MultipartFile file, HttpServletRequest request) throws IOException {
		String filepath = FileUtils.mkdir(request.getRealPath("/"), uploadUrlsConfigurer.getContextProperty(request)) + Identities.uuid2() + file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf("."));
		FileCopyUtils.copy(file.getBytes(), new File(request.getRealPath("/") + filepath));
		return "/" + filepath;
	}
}
