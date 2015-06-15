package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.Comment;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.CommentMybatisDao;
import com.oba.service.CommentService;
 

/**
 * CommentService实现类
 * @author ws
 */
@Service
public class CommentServiceImpl extends BaseServiceImpl<Comment,java.lang.Long> implements CommentService{
	
	@Resource
	private CommentMybatisDao commentMybatisDao;

	@Override
	protected BaseDao<Comment, Long> getDao() {
		return commentMybatisDao;
	}
	
}
