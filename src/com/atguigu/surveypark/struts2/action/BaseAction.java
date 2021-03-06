package com.atguigu.surveypark.struts2.action;

import java.lang.reflect.ParameterizedType;

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

	protected T model;
	public BaseAction() {
		try {
			ParameterizedType type = (ParameterizedType) this.getClass().getGenericSuperclass();
			Class clazz = (Class) type.getActualTypeArguments()[0];
			model = (T) clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void prepare() throws Exception {

	}

	public T getModel(){
		return model;
	}
}
