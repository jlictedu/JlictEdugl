package com.jlict.edu.teachfile.dao;

public class SumbitItemVo {
	private String id;
	private String name;
	private String jobTitle;
	private String message;
	private String sumbitTime;
	private String completing;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jboTitle) {
		this.jobTitle = jboTitle;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSumbitTime() {
		return sumbitTime;
	}
	public void setSumbitTime(String sumbitTime) {
		this.sumbitTime = sumbitTime;
	}
	public String getCompleting() {
		return completing;
	}
	public void setCompleting(String completing) {
		this.completing = completing;
	}
}
