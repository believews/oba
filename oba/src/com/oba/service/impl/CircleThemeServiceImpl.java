package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.CircleTheme;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.CircleThemeMybatisDao;
import com.oba.service.CircleThemeService;
 

/**
 * CircleThemeService实现类
 * @author ws
 */
@Service
public class CircleThemeServiceImpl extends BaseServiceImpl<CircleTheme,java.lang.Long> implements CircleThemeService{
	
	@Resource
	private CircleThemeMybatisDao circleThemeMybatisDao;

	@Override
	protected BaseDao<CircleTheme, Long> getDao() {
		return circleThemeMybatisDao;
	}
	
}
