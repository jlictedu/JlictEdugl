/**
 * 
 */
package com.jlict.edu.manager.dao;

/**
 * <p>Title: com.jlict.hrgl.manager.dao.StationVo.java</p>
 * <p>Description: 岗位vo</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
public class StationVo {
	String id;
	String name;
	int people;
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
	public int getPeople() {
		return people;
	}
	public void setPeople(int people) {
		this.people = people;
	}
	
}
