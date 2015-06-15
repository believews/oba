package com.oba.mybatis;

import java.util.List;

import com.oba.entity.Categorylv1;

/**
 * Categorylv1Dao
 * @author ws
 */
@MyBatisRepository
public interface Categorylv1MybatisDao extends BaseDao<Categorylv1,java.lang.Long>{

	List<Categorylv1> listCategorylv1();
	

}
