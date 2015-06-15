package com.oba.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.oba.entity.SmsSendList;
import com.oba.mybatis.BaseDao;
import com.oba.mybatis.SmsSendListMybatisDao;
import com.oba.service.SmsSendListService;
 

/**
 * SmsSendListService实现类
 * @author ws
 */
@Service
public class SmsSendListServiceImpl extends BaseServiceImpl<SmsSendList,java.lang.Long> implements SmsSendListService{
	
	@Resource
	private SmsSendListMybatisDao smsSendListMybatisDao;

	@Override
	protected BaseDao<SmsSendList, Long> getDao() {
		return smsSendListMybatisDao;
	}
	
}
