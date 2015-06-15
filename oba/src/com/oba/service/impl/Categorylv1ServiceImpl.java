package com.oba.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.Categorylv1;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.Categorylv1MybatisDao;
import com.oba.service.Categorylv1Service;
 

/**
 * Categorylv1Service实现类
 * @author ws
 */
@Service
public class Categorylv1ServiceImpl extends BaseServiceImpl<Categorylv1,java.lang.Long> implements Categorylv1Service{
	
	@Resource
	private Categorylv1MybatisDao categorylv1MybatisDao;

	@Override
	protected BaseDao<Categorylv1, Long> getDao() {
		return categorylv1MybatisDao;
	}

	@Override
	public List<Categorylv1> listCategorylv1() {
		
		return categorylv1MybatisDao.listCategorylv1();
	}
	
}
