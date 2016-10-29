package com.atguigu.surveypark.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atguigu.surveypark.dao.BaseDao;
import com.atguigu.surveypark.model.User;
import com.atguigu.surveypark.service.UserService;
import com.atguigu.surveypark.util.ValidateUtil;

@Service("userService")
public class UserServiceImpl extends BaseServiceImpl<User> implements
		UserService {
	@Resource(name = "userDao")
	@Override
	public void setDao(BaseDao<User> dao) {
		// TODO Auto-generated method stub
		super.setDao(dao);
	}

	/**
	 * 判断email是否被注册
	 */
	@Override
	public boolean isRegister(String email) {
		String hql = "from User u where u.email = ?";
		List<User> list = this.findEntityByHQL(hql, email);

		return ValidateUtil.isValid(list);
	}

}
