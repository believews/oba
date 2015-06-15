package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.Shop;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.ShopMybatisDao;
import com.oba.service.ShopService;
 

/**
 * ShopService实现类
 * @author ws
 */
@Service
public class ShopServiceImpl extends BaseServiceImpl<Shop,java.lang.Long> implements ShopService{
	
	@Resource
	private ShopMybatisDao shopMybatisDao;

	@Override
	protected BaseDao<Shop, Long> getDao() {
		return shopMybatisDao;
	}
	
}
