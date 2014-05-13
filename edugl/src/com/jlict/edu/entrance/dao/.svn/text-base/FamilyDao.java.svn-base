/**
 * 
 */
package com.jlict.edu.entrance.dao;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;



/**
 * <p>Title: com.jlict.hrgl.entrance.dao.FamilyDao.java</p>
 * <p>Description: 家庭信息管理模块持久层</p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 于旭东
 * @version 1.0
 */
@Repository
public class FamilyDao extends BaseDao{
	/**
	 * 
	 * 方法名: queryById   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午09:05:00 
	 * 描述: 根据id查询家庭信息
	 * 参数：id 说明：员工id
	 * 返回类型 List<Map<String,Object>>       
	 */
	public List<Map<String,Object>> queryById(String id) {
		// TODO Auto-generated method stub
		StringBuffer sql = new StringBuffer(251);
		sql.append("SELECT t_family.NAME FL_NAME, t_dm_relative.name RELATION,TEL");
		sql.append(" FROM  t_family  JOIN t_dm_relative on t_family.ralation_id=t_dm_relative.ID WHERE user_id=?");
		Object[] params=new Object[]{id};
		return super.jdbcTemplate.queryForList(sql.toString(), params);
	}
	
	/**
	 * 
	 * 方法名: deletefl   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午09:05:30 
	 * 描述: 根据id删除家庭信息
	 * 参数：id 说明：员工id
	 * 返回类型 void       
	 */
	public void deletefamily(String id) {
		
	    StringBuffer sql=new StringBuffer(251);
	    sql.append("DELETE  t_family WHERE USER_ID='");
		sql.append(id);
		sql.append("'");
	  
	    jdbcTemplate.execute(sql.toString());
		
	}
	
	/**
	 * 
	 * 方法名: insertfl   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午09:06:23 
	 * 描述: 插入家庭信息
	 * 参数：flvo 说明：家庭信息VO
	 * 返回类型 void       
	 */
	public void insertfl(FamilyVo familyVo) {
		String sql="INSERT INTO T_FAMILY VALUES(?,?,?,?)";
		Object[] params = new Object[]{familyVo.getUserId(),familyVo.getRelationId(),familyVo.getTel(),familyVo.getName()};
		super.jdbcTemplate.update(sql.toString(),params);
		
	}
}
