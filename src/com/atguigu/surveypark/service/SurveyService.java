package com.atguigu.surveypark.service;

import java.util.List;

import com.atguigu.surveypark.model.Page;
import com.atguigu.surveypark.model.Question;
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

	/**
	 * 按照id查询Survey
	 */
	Survey getSurvey(Integer id);
	/**
	 * 按照id查询Survey,同时携带所有的孩子
	 */
	Survey getSurveyWithChildren(Integer sid);

	/**
	 * 更新调查
	 */
	void updateSurvey(Survey model);

	/**
	 * 保存或更新页面
	 */
	void saveOrUpdatePage(Page model);

	/**
	 * 按照id查询页面
	 */
	Page getPage(Integer pid);

	/**
	 * 保存或者更新问题
	 */
	void saveOrUpdateQuestion(Question model);

	/**
	 * 删除问题,同时山南出答案
	 */
	void deleteQuestion(Integer qid);

	/**
	 * 删除页面同时删除问题和答案
	 */
	void deletePage(Integer pid);


}
