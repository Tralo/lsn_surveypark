package com.atguigu.surveypark.struts2.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atguigu.surveypark.model.Page;
import com.atguigu.surveypark.model.Question;
import com.atguigu.surveypark.model.Survey;
import com.atguigu.surveypark.service.SurveyService;
@Controller
@Scope("prototype")
public class QuestionAction extends BaseAction<Question> {

	private static final long serialVersionUID = -4877070727923971608L;
	@Resource
	private SurveyService surveyService;
	
	private Integer sid;
	private Integer pid;
	private Integer qid;
	public Integer getQid() {
		return qid;
	}
	public void setQid(Integer qid) {
		this.qid = qid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	/**
	 * 到达选择题型页面
	 * @return
	 */
	public String toSelectQuestionType(){
		return "selectQuestionTypePage";
	}
	/**
	 * 到达设计问题页面
	 */
	public String toDesignQuestionPage(){
		return "" + model.getQuestionType();
	}
	
	public String saveOrUpdateQuestion(){
		//维护关联关系
		Page page = new Page();
		page.setId(pid);
		model.setPage(page);
		surveyService.saveOrUpdateQuestion(model);
		return "designSurveyAction";
	}
	
	public String editQuestion(){
		model = surveyService.getQuestion(qid);
		return "" + model.getQuestionType();
	}
	
	/**
	 *  删除问题
	 */
	public String deleteQuestion(){
		surveyService.deleteQuestion(qid);
		return "designSurveyAction";
	}
	
}
