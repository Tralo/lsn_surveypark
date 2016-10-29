package com.atguigu.surveypark.struts2.action;

import java.util.Map;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atguigu.surveypark.model.User;
import com.atguigu.surveypark.service.UserService;
import com.atguigu.surveypark.util.DataUtil;

@Controller
@Scope("prototype")
public class LoginAction extends BaseAction<User> implements SessionAware {

	private static final long serialVersionUID = 1720208723721475688L;
	@Resource
	private UserService userService;
	// 接受session的map
	private Map<String, Object> sessionMap;

	/**
	 * 到达登录页面
	 */
	public String toLoginPage() {
		return "loginPage";
	}

	public String doLogin() {
		
		return SUCCESS;
	}

	/**
	 * 校验登录信息
	 */
	public void validateDoLogin() {
		// 1.验证登录信息
		User user = userService.validateLoginInfo(model.getEmail(),
				DataUtil.md5(model.getPassword()));
		// 2.失败:错误信息, index.jsp
		if (user == null) {
			addActionError("email/password错误");
		} else {
			sessionMap.put("user", user);
		}
	}

	@Override
	public void setSession(Map<String, Object> map) {
		this.sessionMap = map;
	}

}
