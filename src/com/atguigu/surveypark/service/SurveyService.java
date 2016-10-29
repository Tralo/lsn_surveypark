package com.atguigu.surveypark.service;

import java.util.List;

import com.atguigu.surveypark.model.Survey;
import com.atguigu.surveypark.model.User;

public interface SurveyService {

	/**
	 * 查询调查列表
	 */
	List<Survey> findMySurveys(User user);

	/**
	 * 新建调查
	 */
	Survey newSurvey(User user);

}
