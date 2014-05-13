/**
 * 
 */
package com.jlict.edu.teachingQuality.dao;

/**
 * <p>Title: com.jlict.edu.teachingQuality.dao.EvaluateHeadInfoOfStudentVo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
public class EvaluateHeadInfoOfStudentVo 
{
	private String educationCollege;
	private String attendClass;
	private String teacherName;
	private String courseName;
	
	/**
	 * @return the educationCollege
	 */
	public String getEducationCollege() {
		return educationCollege;
	}
	
	/**
	 * @param educationCollege the educationCollege to set
	 */
	public void setEducationCollege(String educationCollege) {
		this.educationCollege = educationCollege;
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
	 * @return the courseName
	 */
	public String getCourseName() {
		return courseName;
	}
	
	/**
	 * @param courseName the courseName to set
	 */
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
}
