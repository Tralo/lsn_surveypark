package com.atguigu.surveypark.struts2.action;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.struts2.util.ServletContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.atguigu.surveypark.model.Survey;
import com.atguigu.surveypark.model.User;
import com.atguigu.surveypark.service.SurveyService;
import com.atguigu.surveypark.struts2.UserAware;
import com.atguigu.surveypark.util.StringUtil;
import com.atguigu.surveypark.util.ValidateUtil;

/**
 * SurveyAction
 */
@Controller
@Scope("prototype")
public class SurveyAction extends BaseAction<Survey> implements UserAware,ServletContextAware {

	private static final long serialVersionUID = -4566933269660204230L;

	// 注入SurveyService
	@Resource
	private SurveyService surveyService;

	private User user;
	// 接收sid参数
	private Integer sid;

	public Integer getSid() {
		return sid;
	}

	public void setSid(Integer sid) {
		this.sid = sid;
	}

	private List<Survey> mySurveys;

	public List<Survey> getMySurveys() {
		return mySurveys;
	}

	public void setMySurveys(List<Survey> mySurveys) {
		this.mySurveys = mySurveys;
	}

	public String mySurveys() {
		this.mySurveys = surveyService.findMySurveys(user);
		return "mySurveyListPage";
	}

	/**
	 * 新建调查
	 */
	public String newSurvey() {
		this.model = surveyService.newSurvey(user);
		return "designSurveyPage";
	}

	public String designSurvey() {
		this.model = surveyService.getSurveyWithChildren(sid);
		return "designSurveyPage";
	}

	/**
	 * 跳转编辑调查页面
	 */
	public String editSurvey(){
		this.model = surveyService.getSurvey(sid);
		return "editSurveyPage";
	}
	/**
	 * 更新调查
	 */
	public String updateSurvey(){
		this.sid = model.getId();
		//保持关联关系
		this.model.setUser(user);
		surveyService.updateSurvey(model);
		return "designSurveyAction";
	}
	
	/**
	 * 删除调查
	 */
	public String deleteSurvey(){
		surveyService.deleteSurvey(sid);
		return "findMySurveysAction";
	}
	
	/**
	 * 清除调查
	 */
	public String clearAnswers(){
		surveyService.clearAnswers(sid);
		return "findMySurveysAction";
	}
	/**
	 * 打开/关闭
	 */
	public String toggleStatus(){
		surveyService.toggleStatus(sid);
		return "findMySurveysAction";
	}
	
	/**
	 * 到达增加logo的页面
	 */
	public String toAddLogoPage(){
		return "addLoogoPage";
	}
	//上传文件
	private File logoPhoto;
	//文件名称
	private String logoPhotoFileName;
	//接收servletContext对象
	private ServletContext sc;
	
	public File getLogoPhoto() {
		return logoPhoto;
	}

	public void setLogoPhoto(File logoPhoto) {
		this.logoPhoto = logoPhoto;
	}

	public String getLogoPhotoFileName() {
		return logoPhotoFileName;
	}

	public void setLogoPhotoFileName(String logoPhotoFileName) {
		this.logoPhotoFileName = logoPhotoFileName;
	}

	/**
	 * 实现logo的上传
	 */
	public String doAddLogo(){
		//1.实现上传
		if(ValidateUtil.isValid(logoPhotoFileName)){
			// /upload文件夹的真实路径
			String dir = sc.getRealPath("/upload");
			//扩展名
			String ext = logoPhotoFileName.substring(logoPhotoFileName.lastIndexOf("."));
			//纳秒时间爱呢作为文件名
			long l = System.nanoTime();
			File newFile = new File(dir,l + ext);
			//文件另存为
			logoPhoto.renameTo(newFile);
			//更新路径
			surveyService.updateLogoPathoPath(sid,"u/pload/" + l + ext);
			
		}
		//2.更新路径
		return "designSurveyAction";
	}

	@Override
	public void setUser(User user) {
		this.user = user;
	}
	/**
	 * 注入ServletContext对象
	 */
	@Override
	public void setServletContext(ServletContext arg0) {
		this.sc = arg0;
	}

	
}
