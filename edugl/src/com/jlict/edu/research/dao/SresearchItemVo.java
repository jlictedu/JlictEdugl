package com.jlict.edu.research.dao;

public class SresearchItemVo {
	private String id;
	private String projectName;
	private String projectSources;
	private String beginendTime;
	private String funds;
	private String fundsAvaliable;
	private String performance;
	private String role;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectSources() {
		return projectSources;
	}
	public void setProjectSources(String projectSources) {
		this.projectSources = projectSources;
	}
	public String getBeginendTime() {
		return beginendTime;
	}
	public void setBeginendTime(String beginendTime) {
		this.beginendTime = beginendTime;
	}
	public String getFunds() {
		return funds;
	}
	public void setFunds(String funds) {
		this.funds = funds;
	}
	public String getFundsAvaliable() {
		return fundsAvaliable;
	}
	public void setFundsavaliable(String fundsAvaliable) {
		this.fundsAvaliable = fundsAvaliable;
	}
	public String getPerformance() {
		return performance;
	}
	public void setPerformance(String performance) {
		this.performance = performance;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
}