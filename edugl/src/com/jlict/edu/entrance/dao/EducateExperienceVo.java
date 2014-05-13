/**
 * 
 */
package com.jlict.edu.entrance.dao;



/**
 * <p>Title: com.jlict.hrgl.entrance.controller.TEducateExperienceVo.java</p>
 * <p>Description: 教育经验数据模型</p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 于旭东
 * @version 1.0
 */

public class EducateExperienceVo{
	/**
	* 学历  
	 */    
	private String education;
	/**
	* 用户id  
	*/
    private String userId;  
    /**
     *学历id   
     */
    private String educationId;  
    /**
     *经历   
     */
    private String experience;  
    /**
     *开始时间   
     */
    private String startDate;  
    /**
     * 结束时间
     */
    private String endDate;
	public String getEducation() {
		return education;
	}
	public void setEducation(String education) {
		this.education = education;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getEducationId() {
		return educationId;
	}
	public void setEducationId(String educationId) {
		this.educationId = educationId;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}  
}