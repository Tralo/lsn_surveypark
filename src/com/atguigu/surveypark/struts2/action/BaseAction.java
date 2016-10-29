package com.atguigu.surveypark.struts2.action;

import org.apache.poi.hssf.record.formula.functions.T;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

/**
 * 抽象 action, 专门用于继承
 */
public abstract class BaseAction<T> extends ActionSupport implements
		ModelDriven<T>, Preparable {

	private static final long serialVersionUID = 8099928971665413318L;

	@Override
	public void prepare() throws Exception {

	}

	public abstract T getModel();
}
