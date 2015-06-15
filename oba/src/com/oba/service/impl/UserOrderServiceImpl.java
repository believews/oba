package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.UserOrder;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.UserOrderMybatisDao;
import com.oba.service.UserOrderService;
 

/**
 * UserOrderService实现类
 * @author ws
 */
@Service
public class UserOrderServiceImpl extends BaseServiceImpl<UserOrder,java.lang.Long> implements UserOrderService{
	
	@Resource
	private UserOrderMybatisDao userOrderMybatisDao;

	@Override
	protected BaseDao<UserOrder, Long> getDao() {
		return userOrderMybatisDao;
	}
	
}
