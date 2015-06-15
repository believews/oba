package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.ShopCategory;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.ShopCategoryMybatisDao;
import com.oba.service.ShopCategoryService;
 

/**
 * ShopCategoryService实现类
 * @author ws
 */
@Service
public class ShopCategoryServiceImpl extends BaseServiceImpl<ShopCategory,java.lang.Long> implements ShopCategoryService{
	
	@Resource
	private ShopCategoryMybatisDao shopCategoryMybatisDao;

	@Override
	protected BaseDao<ShopCategory, Long> getDao() {
		return shopCategoryMybatisDao;
	}
	
}
