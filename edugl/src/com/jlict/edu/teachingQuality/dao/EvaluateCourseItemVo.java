/**
 * 
 */
package com.jlict.edu.teachingQuality.dao;

/**
 * <p>Title: com.jlict.edu.teachingQuality.dao.EvaluateCourseItemVo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
public class EvaluateCourseItemVo
{
	private String id;
	private String teacher;
	private String category;
	private String status;
	
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
	/**
	 * @return the teacher
	 */
	public String getTeacher()
	{
		return teacher;
	}
	/**
	 * @param teacher the teacher to set
	 */
	public void setTeacher(String teacher)
	{
		this.teacher = teacher;
	}
	/**
	 * @return the category
	 */
	public String getCategory()
	{
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(String category)
	{
		this.category = category;
	}
	/**
	 * @return the status
	 */
	public String getStatus()
	{
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status)
	{
		this.status = status;
	}
}
