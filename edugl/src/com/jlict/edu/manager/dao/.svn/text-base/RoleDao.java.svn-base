/**
 * 
 */
package com.jlict.edu.manager.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;

/**
 * <p>Title: com.jlict.hrgl.manager.dao.PermissionDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Repository
public class RoleDao extends BaseDao {	
	
	/**
	 * 方法名: queryRole   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:07:31 
	 * 描述: 查询系统角色信息
	 * 返回类型 List       
	 */
	@SuppressWarnings("rawtypes")
	public List queryRole(){
		String sql = "SELECT ROLE_ID,ROLE_NAME FROM T_DM_ROLE";
		return this.jdbcTemplate.query(sql, new RoleRowMapper());
	}
}
