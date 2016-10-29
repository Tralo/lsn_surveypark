package com.atguigu.surveypark.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atguigu.surveypark.dao.BaseDao;
import com.atguigu.surveypark.model.User;
import com.atguigu.surveypark.service.UserService;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {
	@Resource(name="userDao")
	@Override
	public void setDao(BaseDao<User> dao) {
		// TODO Auto-generated method stub
		super.setDao(dao);
	}

}
