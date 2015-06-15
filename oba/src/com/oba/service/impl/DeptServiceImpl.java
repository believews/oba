package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.Dept;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.DeptMybatisDao;
import com.oba.service.DeptService;
 

/**
 * DeptService实现类
 * @author ws
 */
@Service
public class DeptServiceImpl extends BaseServiceImpl<Dept,java.lang.Long> implements DeptService{
	
	@Resource
	private DeptMybatisDao deptMybatisDao;

	@Override
	protected BaseDao<Dept, Long> getDao() {
		return deptMybatisDao;
	}
	
}
