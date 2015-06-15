package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.CommentPhoto;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.CommentPhotoMybatisDao;
import com.oba.service.CommentPhotoService;
 

/**
 * CommentPhotoService实现类
 * @author ws
 */
@Service
public class CommentPhotoServiceImpl extends BaseServiceImpl<CommentPhoto,java.lang.Long> implements CommentPhotoService{
	
	@Resource
	private CommentPhotoMybatisDao commentPhotoMybatisDao;

	@Override
	protected BaseDao<CommentPhoto, Long> getDao() {
		return commentPhotoMybatisDao;
	}
	
}
