package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.City;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.CityMybatisDao;
import com.oba.service.CityService;
 

/**
 * CityService实现类
 * @author ws
 */
@Service
public class CityServiceImpl extends BaseServiceImpl<City,java.lang.Long> implements CityService{
	
	@Resource
	private CityMybatisDao cityMybatisDao;

	@Override
	protected BaseDao<City, Long> getDao() {
		return cityMybatisDao;
	}
	
}
