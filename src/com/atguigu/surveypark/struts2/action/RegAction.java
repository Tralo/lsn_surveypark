package com.atguigu.surveypark.struts2.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atguigu.surveypark.model.User;
/**
 * 注册action
 */
@Controller
@Scope("prototype")
public class RegAction extends BaseAction<User>{
	
	private static final long serialVersionUID = -2696677051184614247L;
	
	private User model = new User();
	
	public String toRegPage(){
		return "regPage";
	}

	@Override
	public User getModel() {
		return model;
	}

}
