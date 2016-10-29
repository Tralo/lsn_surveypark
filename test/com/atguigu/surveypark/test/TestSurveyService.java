package com.atguigu.surveypark.test;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.atguigu.surveypark.model.User;
import com.atguigu.surveypark.service.SurveyService;
import com.atguigu.surveypark.service.UserService;

/**
 * 测试UserService
 */
public class TestSurveyService {
	private SurveyService ss;
	private UserService us;
	
	@Before
	public void init(){
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		ss = (SurveyService) ac.getBean("surveyService");
		us = (UserService) ac.getBean("userService");
	}
	
	@Test
	public void insertUser() throws SQLException{
		User u = us.getEntity(1);
		ss.newSurvey(u);
	}

}
