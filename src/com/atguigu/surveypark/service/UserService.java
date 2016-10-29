package com.atguigu.surveypark.service;

import com.atguigu.surveypark.model.User;

/**
 * UserService
 */
public interface UserService extends BaseService<User> {

	/**
	 * 判断email是否被注册
	 */
	boolean isRegister(String email);

}
