/**
 * 
 */
package com.jlict.edu.sys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>Title: com.jlict.sys.dao.UserVoRowMapper.java</p>
 * <p>Description: 用户RowMapper</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
public class UserVoRowMapper implements RowMapper<UserVo>{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	public UserVo mapRow(ResultSet rs, int arg1) {
		// TODO Auto-generated method stub\
		UserVo vo = new UserVo();	
		try {			
			vo.setId(rs.getString("USER_ID"));
			vo.setName(rs.getString("NAME"));
			vo.setDepartmentId(rs.getString("DEPT_ID"));
			vo.setStationId(rs.getString("STATION_ID"));
			vo.setLastModify(rs.getString("MODIFY_ID"));
			vo.setLastModifyDate(rs.getString("MODIFY_DATE"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return vo;
	}
}
