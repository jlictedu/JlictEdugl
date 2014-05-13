package com.jlict.edu.paper.dao;

public class PaperVo {
	private String id;
	private String rebuild;
	private String resit;
	private String examination;
	private String atonic;	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getRebuild() {
		return rebuild;
	}
	public void setRebuild(String rebuild){
		this.rebuild=rebuild;
	}
	
	public String getResit() {
		return resit;
	}
	public void setResit(String resit){
		this.resit=resit;
	}
	
	public String getExamination() {
		return examination;
	}
	public void setExamination(String examination){
		this.examination=examination;
	}
	
	public String getAtonic() {
		return atonic;
	}
	public void setAtonic(String atonic) {
		this.atonic = atonic;
	}
}