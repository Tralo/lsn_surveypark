package com.atguigu.surveypark.struts2.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atguigu.surveypark.model.Page;
import com.atguigu.surveypark.model.Survey;
import com.atguigu.surveypark.service.SurveyService;
@Controller
@Scope("prototype") 
public class PageAction extends BaseAction<Page>{

	private static final long serialVersionUID = -5742084421658080415L;
	@Resource
	private SurveyService surveyService;
	
	private Integer sid;
	
	private Integer pid;
	
	public Integer getPid() {
		return pid;
	}
	public void setPid(Integer pid) {
		this.pid = pid;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}


	/**
	 * 达到添加page的界面
	 * @return
	 */
	public String toAddPage(){
		return "addPagePage";
	}
	/**
	 * 保存/更新页面
	 */
	public String saveOrUpdatePage(){
		Survey s = new Survey();
		s.setId(sid);
		model.setSurvey(s);
		surveyService.saveOrUpdatePage(model);
		return "designSurveyAction";
	}
	/**
	 * 进入编辑页面
	 * @return
	 */
	public String editPage(){
		this.model = surveyService.getPage(pid);
		return "editPagePage";
	}

}
