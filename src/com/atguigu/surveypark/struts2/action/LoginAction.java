package com.atguigu.surveypark.struts2.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atguigu.surveypark.model.User;
import com.atguigu.surveypark.service.UserService;

@Controller
@Scope("prototype")
public class LoginAction extends BaseAction<User> {

	private static final long serialVersionUID = 1720208723721475688L;


	@Resource
	private UserService userService;
	
	/**
	 * 到达登录页面
	 */
	public void toLoginPage(){
		
	}


}
