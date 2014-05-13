/**
 * 
 */
package com.jlict.edu.teachingQuality.dao;

/**
 * <p>
 * Title: com.jlict.edu.teachingQuality.dao.TeachQualityStudentVo.java
 * </p>
 * <p>
 * Description:
 * </p>
 * <p>
 * Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院
 * </p>
 * <p>
 * Company: 吉林化工学院
 * </p>
 * 
 * @author 孟兆祥
 * @version 1.0
 */
public class TeachQualityTeacherVo
{
	private String id;
	private String teaId;
	private int total;
	private String idea;
	
	/**
	 * @return the id
	 */
	public String getId()
	{
		return id;
	}
	
	/**
	 * @param id the id to set
	 */
	public void setId(String id)
	{
		this.id = id;
	}
	
	public String getIdea()
	{
		return idea;
	}
	
	/**
	 * @param idea the idea to set
	 */
	public void setIdea(String idea)
	{
		this.idea = idea;
	}

	/**
	 * @return the teaId
	 */
	public String getTeaId() {
		return teaId;
	}

	/**
	 * @param teaId the teaId to set
	 */
	public void setTeaId(String teaId) {
		this.teaId = teaId;
	}

	/**
	 * @return the total
	 */
	public int getTotal() {
		return total;
	}

	/**
	 * @param total the total to set
	 */
	public void setTotal(int total) {
		this.total = total;
	}
}
