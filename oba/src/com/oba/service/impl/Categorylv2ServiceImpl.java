package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.Categorylv2;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.Categorylv2MybatisDao;
import com.oba.service.Categorylv2Service;
 

/**
 * Categorylv2Service实现类
 * @author ws
 */
@Service
public class Categorylv2ServiceImpl extends BaseServiceImpl<Categorylv2,java.lang.Long> implements Categorylv2Service{
	
	@Resource
	private Categorylv2MybatisDao categorylv2MybatisDao;

	@Override
	protected BaseDao<Categorylv2, Long> getDao() {
		return categorylv2MybatisDao;
	}
	
}
