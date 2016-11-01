package com.atguigu.surveypark.struts2.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atguigu.surveypark.model.Page;
@Controller
@Scope("prototype") 
public class PageAction extends BaseAction<Page>{

	private static final long serialVersionUID = -5742084421658080415L;
	
	private Integer sid;
	
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

}
