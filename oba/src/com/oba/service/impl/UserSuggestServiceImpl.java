package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.UserSuggest;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.UserSuggestMybatisDao;
import com.oba.service.UserSuggestService;
 

/**
 * UserSuggestService实现类
 * @author ws
 */
@Service
public class UserSuggestServiceImpl extends BaseServiceImpl<UserSuggest,java.lang.Long> implements UserSuggestService{
	
	@Resource
	private UserSuggestMybatisDao userSuggestMybatisDao;

	@Override
	protected BaseDao<UserSuggest, Long> getDao() {
		return userSuggestMybatisDao;
	}
	
}
