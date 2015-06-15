package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.Advert;
import com.oba.mybatis.AdvertMybatisDao;
import com.oba.mybatis.BaseDao;
import com.oba.service.AdvertService;
 

/**
 * AdvertService实现类
 * @author ws
 */
@Service
public class AdvertServiceImpl extends BaseServiceImpl<Advert,java.lang.Long> implements AdvertService{
	
	@Resource
	private AdvertMybatisDao advertMybatisDao;

	@Override
	protected BaseDao<Advert, Long> getDao() {
		return advertMybatisDao;
	}
	
}
