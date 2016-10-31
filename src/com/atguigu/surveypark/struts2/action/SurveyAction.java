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
import com.atguigu.surveypark.struts2.UserAware;

/**
 * SurveyAction
 */
@Controller
@Scope("prototype")
public class SurveyAction extends BaseAction<Survey> implements UserAware {

	private static final long serialVersionUID = -4566933269660204230L;

	// 注入SurveyService
	@Resource
	private SurveyService surveyService;

	private User user;
	// 接收sid参数
	private Integer sid;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	private List<Survey> mySurveys;

	public List<Survey> getMySurveys() {
		return mySurveys;
	}

	public void setMySurveys(List<Survey> mySurveys) {
		this.mySurveys = mySurveys;
	}

	public String mySurveys() {
		this.mySurveys = surveyService.findMySurveys(user);
		return "mySurveyListPage";
	}

	/**
	 * 新建调查
	 */
	public String newSurvey() {
		this.model = surveyService.newSurvey(user);
		return "designSurveyPage";
	}

	public String designSurvey() {
		return "designSurveyPage";
	}
	
	public void prepareDesignSurvey() {
		this.model = surveyService.getSurvey(sid);
	}


	@Override
	public void setUser(User user) {
		this.user = user;
	}

	
}
