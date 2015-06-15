package com.oba.mybatis;

import com.oba.entity.User;

/**
 * UserDao
 * @author ws
 */
@MyBatisRepository
public interface UserMybatisDao extends BaseDao<User,java.lang.Long>{

	User getByMobile(String mobile);
	

}
