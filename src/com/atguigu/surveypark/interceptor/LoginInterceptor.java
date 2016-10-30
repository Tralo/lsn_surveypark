package com.atguigu.surveypark.interceptor;

import com.atguigu.surveypark.model.User;
import com.atguigu.surveypark.struts2.action.BaseAction;
import com.atguigu.surveypark.struts2.action.LoginAction;
import com.atguigu.surveypark.struts2.action.RegAction;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{

	private static final long serialVersionUID = 7175204562267641123L;

	@Override
	public void destroy() {
		
	}

	@Override
	public void init() {
		
	}

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		BaseAction action = (BaseAction) arg0.getAction();
		if(action instanceof LoginAction || action instanceof RegAction){
			//放行
			return arg0.invoke();
		} else {
			User user = (User) arg0.getInvocationContext().getSession().get("user");
			if(user == null){
				//登录页面
				return "login";
			} else {
				//放行
				return arg0.invoke();
			}
		}
	}

}
