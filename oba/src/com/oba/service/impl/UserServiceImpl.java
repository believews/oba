package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.User;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.UserMybatisDao;
import com.oba.service.UserService;
 

/**
 * UserService实现类
 * @author ws
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User,java.lang.Long> implements UserService{
	
	@Resource
	private UserMybatisDao userMybatisDao;

	@Override
	protected BaseDao<User, Long> getDao() {
		return userMybatisDao;
	}

	@Override
	public User getByMobile(String mobile) {
	
		return userMybatisDao.getByMobile(mobile);
	}
	
}
