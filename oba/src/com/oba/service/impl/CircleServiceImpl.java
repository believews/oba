package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.Circle;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.CircleMybatisDao;
import com.oba.service.CircleService;
 

/**
 * CircleService实现类
 * @author ws
 */
@Service
public class CircleServiceImpl extends BaseServiceImpl<Circle,java.lang.Long> implements CircleService{
	
	@Resource
	private CircleMybatisDao circleMybatisDao;

	@Override
	protected BaseDao<Circle, Long> getDao() {
		return circleMybatisDao;
	}
	
}
