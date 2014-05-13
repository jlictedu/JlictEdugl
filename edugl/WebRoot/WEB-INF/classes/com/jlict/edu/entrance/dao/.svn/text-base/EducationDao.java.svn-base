/**
 * 
 */
package com.jlict.edu.entrance.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;



/**
 * <p>Title: com.jlict.hrgl.entrance.dao.EducationDao.java</p>
 * <p>Description: 入职管理模块持久层</p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 于旭东
 * @version 1.0
 */
@Repository
public class EducationDao extends BaseDao{
	
	/**
	 * 
	 * 方法名: queryById   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午08:54:45 
	 * 描述: 根据id查询教育信息
	 * 参数：id 说明：员工id
	 * 返回类型 List<Map<String,Object>>       
	 */
	public List<Map<String,Object>> queryById(String id) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer(251);
		sql.append("SELECT name EDUCATIONAL, experience, to_char(start_date,'yyyy-mm-dd') start_date,to_char(end_date,'yyyy-mm-dd') end_date");
		sql.append(" FROM  t_educate_experience  JOIN t_dm_education on t_educate_experience.education_id=t_dm_education.id WHERE user_id=?");
		Object[] params=new Object[]{id};
		return super.jdbcTemplate.queryForList(sql.toString(), params);
	}
	
	/**
	 * 
	 * 方法名: deleteed   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午08:55:50 
	 * 描述: 根据id删除教育信息
	 * 参数：id 说明：员工id
	 * 返回类型 void       
	 */
	public void deleteed(String id) {
		StringBuffer sql=new StringBuffer(251);
	    sql.append("DELETE  T_EDUCATE_EXPERIENCE WHERE USER_ID='");
		sql.append(id);
		sql.append("'");
	  
	    jdbcTemplate.execute(sql.toString());
	}
	
	/**
	 * 
	 * 方法名: inserted   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午08:56:40 
	 * 描述:插入教育信息
	 * 参数：edvo 说明：教育信息VO
	 * 返回类型 void       
	 */
	public void insertEducateExperience(EducateExperienceVo EducateVo) {
		String sql="INSERT INTO T_EDUCATE_EXPERIENCE VALUES(?,?,?,TO_DATE(?,'YYYY-MM-DD'),TO_DATE(?,'YYYY-MM-DD'))";
		Object[] params = new Object[]{EducateVo.getUserId(),EducateVo.getEducationId(),EducateVo.getExperience(),
				EducateVo.getStartDate(),EducateVo.getEndDate()};
		super.jdbcTemplate.update(sql,params);
		
	}
}
