/**
 * 
 */
package com.jlict.edu.manager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * <p>Title: com.jlict.hrgl.manager.dao.RoleRowmapper.java</p>
 * <p>Description: 权限规则rowmapper</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
public class RuleRowMapper implements RowMapper<RuleVo> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	public RuleVo mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		RuleVo vo = new RuleVo();
		vo.setDepartmentId(rs.getString("DEPT_ID"));
		vo.setDepartmentName(rs.getString("DEPT_NAME"));
		vo.setStationId(rs.getString("STATION_ID"));
		vo.setStationName(rs.getString("STATION_NAME"));
		vo.setRoleId(rs.getString("ROLE_ID"));
		vo.setRoleName(rs.getString("ROLE_NAME"));
		return vo;
	}

}
