package com.atguigu.surveypark.model;

import java.util.Date;
/**
 * 调查类
 */
public class Survey {

	
	private Integer id;
	private String title = "未命名";
	private String preText = "上一步";
	private String nextText = "下一步";
	private String exitText = "推出";
	private String doneText = "完成";
	private Date createTime = new Date();
	
	//建立从Survey到User之间多对一关联关系
	private User user;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPreText() {
		return preText;
	}
	public void setPreText(String preText) {
		this.preText = preText;
	}
	public String getNextText() {
		return nextText;
	}
	public void setNextText(String nextText) {
		this.nextText = nextText;
	}
	public String getExitText() {
		return exitText;
	}
	public void setExitText(String exitText) {
		this.exitText = exitText;
	}
	public String getDoneText() {
		return doneText;
	}
	public void setDoneText(String doneText) {
		this.doneText = doneText;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Survey [id=" + id + ", title=" + title + ", preText=" + preText
				+ ", nextText=" + nextText + ", exitText=" + exitText
				+ ", doneText=" + doneText + ", createTime=" + createTime + "]";
	}
	
	
	
	
}
