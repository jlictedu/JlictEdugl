/**
 * 
 */
package com.jlict.edu.manager.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * <p>Title: com.jlict.hrgl.manager.dao.StationRowMapper.java</p>
 * <p>Description: 详细岗位rowmapper</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
public class StationDetailRowMapper implements RowMapper<StationVo> {

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	public StationVo mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		StationVo vo = new StationVo();
		vo.setId(rs.getString("STATION_ID"));
		vo.setName(rs.getString("STATION_NAME"));
		vo.setPeople(rs.getInt("PEOPLE"));
		return vo;
	}

}
