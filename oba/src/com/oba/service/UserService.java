package com.oba.service;

import com.oba.entity.User;

/**
 * UserService
 * @author ws
 */
public interface UserService extends BaseService<User,java.lang.Long>{

	User getByMobile(String mobile);

		
}
