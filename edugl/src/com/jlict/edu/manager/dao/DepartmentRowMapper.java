/**
 * 
 */
package com.jlict.edu.manager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * <p>Title: com.jlict.hrgl.manager.dao.DepartMentRowMapper.java</p>
 * <p>Description: 部门rowmapper</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
public class DepartmentRowMapper implements RowMapper<DepartmentVo> {

	public DepartmentVo mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		DepartmentVo vo = new DepartmentVo();
		vo.setId(rs.getString("DEPT_ID"));
		vo.setName(rs.getString("DEPT_NAME"));
		vo.setBossId(rs.getString("BOSS_DEPT_ID"));
		//vo.setBossName(rs.getString("BOSS_DEPT_NAME"));
		return vo;
	}

}
