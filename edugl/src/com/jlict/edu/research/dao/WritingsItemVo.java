package com.jlict.edu.research.dao;

public class WritingsItemVo {
	private String id;
	private String name;
	private String press;
	private String publicationTime;
	private String wordNumber;
	private String role;
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
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
	public String getPress() {
		return press;
	}
	public void setPress(String press) {
		this.press = press;
	}
	public String getPublicationTime() {
		return publicationTime;
	}
	public void setPublicationTime(String publicationTime) {
		this.publicationTime = publicationTime;
	}
	public String getWordNumber() {
		return wordNumber;
	}
	public void setWordNumber(String wordNumber) {
		this.wordNumber = wordNumber;
	}

}
