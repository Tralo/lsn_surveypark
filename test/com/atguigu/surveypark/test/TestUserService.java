package com.atguigu.surveypark.test;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.surveypark.model.User;
import com.atguigu.surveypark.service.UserService;

/**
 * 测试UserService
 */
public class TestUserService {
	private UserService us;
	@Before
	public void init(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		us = (UserService) ac.getBean("userService");
	}
	
	@Test
	public void insertUser() throws SQLException{
		User user = new User();
		user.setEmail("aa2@aa2.com");
		user.setName("哈哈");
		user.setPassword("123456");
		user.setNickName("gg");
		us.saveEntity(user);
		
	}
	@Test
	public void getUser() throws SQLException{
		User u = us.getEntity(1);
		System.out.println(u.toString());
	}

}
