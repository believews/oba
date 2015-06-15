package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.Product;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.ProductMybatisDao;
import com.oba.service.ProductService;
 

/**
 * ProductService实现类
 * @author ws
 */
@Service
public class ProductServiceImpl extends BaseServiceImpl<Product,java.lang.Long> implements ProductService{
	
	@Resource
	private ProductMybatisDao productMybatisDao;

	@Override
	protected BaseDao<Product, Long> getDao() {
		return productMybatisDao;
	}
	
}
