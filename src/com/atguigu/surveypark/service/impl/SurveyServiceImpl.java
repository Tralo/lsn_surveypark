package com.atguigu.surveypark.service.impl;

import java.util.Iterator;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.atguigu.surveypark.dao.BaseDao;
import com.atguigu.surveypark.model.Answer;
import com.atguigu.surveypark.model.Page;
import com.atguigu.surveypark.model.Question;
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
	@Resource
	private BaseDao<Question> questionDao;
	@Resource
	private BaseDao<Answer> answerDao;
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
		return s;
	}
	/**
	 * 按照id查询Survey,同时携带所有的孩子
	 */
	@Override
	public Survey getSurveyWithChildren(Integer id) {
//		Survey s = surveyDao.getEntity(id);
		Survey s = this.getSurvey(id);//高内聚低耦合，推荐这样写
		//强行初始化pages和questions集合
		for(Page p : s.getPages()){
			p.getQuestions().size();
		}
		return s;
	}
	/**
	 * 更新调查
	 */
	@Override
	public void updateSurvey(Survey model) {
		surveyDao.updateEntity(model);
	}
	/**
	 * 保存或更新页面
	 */
	@Override
	public void saveOrUpdatePage(Page model) {
		pageDao.saveOrUpdateEntity(model);
	}
	@Override
	public Page getPage(Integer pid) {
		return pageDao.getEntity(pid);
	}
	/**
	 * 保存或者更新问题
	 */
	@Override
	public void saveOrUpdateQuestion(Question model) {
		questionDao.saveOrUpdateEntity(model);
		
	}
	/**
	 * 删除问题,同时山南出答案
	 */
	@Override
	public void deleteQuestion(Integer qid) {
		//1.删除answers
		String hql = "delete from Answer a where a.questionId = ?";
		answerDao.batchEntityByHQL(hql, qid);
		//2.删除问题
		hql = "delete from Question q where q.id = ?";
		questionDao.batchEntityByHQL(hql, qid);
		
	}
	
}
