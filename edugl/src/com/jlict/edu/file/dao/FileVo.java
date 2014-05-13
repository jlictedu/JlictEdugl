package com.jlict.edu.file.dao;

public class FileVo {
	private String id;
	private String questions;
	private String answer;
	private String roll;
	private String paperanalysis;	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public String getQuestions() {
		return questions;
	}
	public void setQuestions(String questions){
		this.questions=questions;
	}
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer){
		this.answer=answer;
	}
	
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll){
		this.roll=roll;
	}
	
	public String getPaperanalysis() {
		return paperanalysis;
	}
	public void setPaperanalysis(String paperanalysis) {
		this.paperanalysis = paperanalysis;
	}
}