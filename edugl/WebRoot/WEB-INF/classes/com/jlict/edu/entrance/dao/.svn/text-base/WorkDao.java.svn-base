/**
 * 
 */
package com.jlict.edu.entrance.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;



/**
 * <p>Title: com.jlict.hrgl.entrance.dao.WorkDao.java</p>
 * <p>Description: 工作信息管理模块持久层</p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 于旭东
 * @version 1.0
 */
@Repository
public class WorkDao extends BaseDao {
	/**
	 * 
	 * 方法名: queryById   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午09:11:51 
	 * 描述: 根据id查询工作信息
	 * 参数：id 说明：员工id
	 * 返回类型 List<Map<String,Object>>       
	 */
	public List<Map<String,Object>> queryById(String id) {
		StringBuffer sql = new StringBuffer(251);
		sql.append("SELECT experience, to_char(start_date,'yyyy-mm-dd') start_date,to_char(end_date,'yyyy-mm-dd') end_date");
		sql.append(" FROM  t_job_experience WHERE user_id=?");
		Object[] params=new Object[]{id};
		return super.jdbcTemplate.queryForList(sql.toString(), params);
	}
	
	/**
	 * 
	 * 方法名: deletewk   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午09:12:19 
	 * 描述: 根据id删除工作信息
	 * 参数：id 说明：员工id
	 * 返回类型 void       
	 */
	public void deletewk(String id) {
		
	    StringBuffer sql=new StringBuffer(251);
	    sql.append("DELETE FROM t_job_experience WHERE USER_ID='");
		sql.append(id);
		sql.append("'");
	  
	    jdbcTemplate.execute(sql.toString());
	}
	
	/**
	 * 
	 * 方法名: insertwk   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午09:12:51 
	 * 描述: 插入工作信息
	 * 参数：wkvo 说明：工作信息VO
	 * 返回类型 void       
	 */
	public void insertwk(JobExperienceVo workVo) {
		String sql="INSERT INTO T_JOB_EXPERIENCE VALUES(?,?,TO_DATE(?,'YYYY-MM-DD'),TO_DATE(?,'YYYY-MM-DD'))";
		Object[] params = new Object[]{workVo.getUserId(),workVo.getWorkExperience(),workVo.getWorkStartDate(),workVo.getWorkEndDate()};
		super.jdbcTemplate.update(sql.toString(),params);
		
	}

}
