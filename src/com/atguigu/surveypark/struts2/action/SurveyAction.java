package com.atguigu.surveypark.struts2.action;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.interceptor.SessionAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atguigu.surveypark.model.Survey;
import com.atguigu.surveypark.model.User;
import com.atguigu.surveypark.service.SurveyService;

/**
 *	SurveyAction
 */
@Controller
@Scope("prototype")
public class SurveyAction extends BaseAction<Survey> implements SessionAware{
	
	private static final long serialVersionUID = -4566933269660204230L;

	//注入SurveyService
	@Resource
	private SurveyService surveyService;
	
	private List<Survey> mySurveys;
	//接收sessionMap
	private Map<String,Object> sessionMap;
	
	public List<Survey> getMySurveys() {
		return mySurveys;
	}

	public void setMySurveys(List<Survey> mySurveys) {
		this.mySurveys = mySurveys;
	}

	public String mySurveys(){
		User user = (User) sessionMap.get("user");
		this.mySurveys = surveyService.findMySurveys(user);
		return "mySurveyListPage";
	}
	/**
	 * 新建调查
	 */
	public String newSurvey(){
		User user = (User) sessionMap.get("user");
		this.model = surveyService.newSurvey(user);
		return "designSurveyPage";
	}

	@Override
	public void setSession(Map<String, Object> arg0) {
		this.sessionMap = arg0;
	}
	
}
