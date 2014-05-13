/**
 * 
 */
package com.jlict.edu.teachingQuality.dao;

/**
 * <p>Title: com.jlict.edu.teachingQuality.dao.EvaluationSettingItemVo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
public class EvaluationSettingItemVo
{
	private String id;
	private String coding;
	private String name;
	private String attribute;
	private String exam;
	private String term;
	private String status;
	private String year;
	private String teacherName;
	private String teacherId;
	private String evaluationId;
	private String attendClass;
	private String deptId;
	
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
	 * @return the coding
	 */
	public String getCoding()
	{
		return coding;
	}
	
	/**
	 * @param coding the coding to set
	 */
	public void setCoding(String coding)
	{
		this.coding = coding;
	}
	
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * @return the attribute
	 */
	public String getAttribute()
	{
		return attribute;
	}
	
	/**
	 * @param attribute the attribute to set
	 */
	public void setAttribute(String attribute)
	{
		this.attribute = attribute;
	}
	
	/**
	 * @return the exam
	 */
	public String getExam()
	{
		return exam;
	}
	
	/**
	 * @param exam the exam to set
	 */
	public void setExam(String exam)
	{
		this.exam = exam;
	}

	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * @return the term
	 */
	public String getTerm() {
		return term;
	}

	/**
	 * @param term the term to set
	 */
	public void setTerm(String term) {
		this.term = term;
	}

	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}

	/**
	 * @return the deptId
	 */
	public String getDeptId() {
		return deptId;
	}

	/**
	 * @param deptId the deptId to set
	 */
	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * @return the teacherName
	 */
	public String getTeacherName() {
		return teacherName;
	}

	/**
	 * @param teacherName the teacherName to set
	 */
	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	/**
	 * @return the teacherId
	 */
	public String getTeacherId() {
		return teacherId;
	}

	/**
	 * @param teacherId the teacherId to set
	 */
	public void setTeacherId(String teacherId) {
		this.teacherId = teacherId;
	}

	/**
	 * @return the evaluationId
	 */
	public String getEvaluationId() {
		return evaluationId;
	}

	/**
	 * @param evaluationId the evaluationId to set
	 */
	public void setEvaluationId(String evaluationId) {
		this.evaluationId = evaluationId;
	}

	/**
	 * @return the attendClass
	 */
	public String getAttendClass() {
		return attendClass;
	}

	/**
	 * @param attendClass the attendClass to set
	 */
	public void setAttendClass(String attendClass) {
		this.attendClass = attendClass;
	}
}
