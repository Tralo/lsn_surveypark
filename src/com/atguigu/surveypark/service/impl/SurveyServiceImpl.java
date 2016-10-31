package com.atguigu.surveypark.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atguigu.surveypark.dao.BaseDao;
import com.atguigu.surveypark.model.Page;
import com.atguigu.surveypark.model.Survey;
import com.atguigu.surveypark.model.User;
import com.atguigu.surveypark.service.SurveyService;
/**
 * SurveyService实现
 */
@Service("surveyService")
public class SurveyServiceImpl implements SurveyService{
	
	@Resource
	private BaseDao<Survey> surveyDao;
	
	@Resource
	private BaseDao<Page> pageDao;
	
	/**
	 * 查询调查集合
	 */
	@Override
	public List<Survey> findMySurveys(User user) {
		String hql = "from Survey s where s.user.id = ?";
		return surveyDao.findEntityByHQL(hql, user.getId());
	}
	/**
	 * 新建调查
	 */
	@Override
	public Survey newSurvey(User user) {
		Survey s = new Survey();
		Page p = new Page();
		
		//设置关联关系
		s.setUser(user);
		p.setSurvey(s);
		s.getPages().add(p);
		surveyDao.saveEntity(s);
		pageDao.saveEntity(p);
		return s;
	}
	
	/**
	 * 按照id查询id
	 */
	@Override
	public Survey getSurvey(Integer id) {
		Survey s = surveyDao.getEntity(id);
		System.out.println(s.toString());
		Iterator<Page> pages = s.getPages().iterator();
		if(pages.hasNext()){
			pages.next().getQuestions().iterator();
		}
		
		return s;
	}
	
}
