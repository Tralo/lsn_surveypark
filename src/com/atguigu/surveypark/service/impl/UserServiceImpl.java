package com.atguigu.surveypark.service.impl;

import org.springframework.stereotype.Service;

import com.atguigu.surveypark.model.User;
import com.atguigu.surveypark.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {

}
