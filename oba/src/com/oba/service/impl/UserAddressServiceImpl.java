package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.UserAddress;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.UserAddressMybatisDao;
import com.oba.service.UserAddressService;
 

/**
 * UserAddressService实现类
 * @author ws
 */
@Service
public class UserAddressServiceImpl extends BaseServiceImpl<UserAddress,java.lang.Long> implements UserAddressService{
	
	@Resource
	private UserAddressMybatisDao userAddressMybatisDao;

	@Override
	protected BaseDao<UserAddress, Long> getDao() {
		return userAddressMybatisDao;
	}
	
}
