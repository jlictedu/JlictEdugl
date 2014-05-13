package com.jlict.edu.entrance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TeacherMapper implements RowMapper{
	

	public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		TeacherVo vo = new TeacherVo();
		vo.setId(resultSet.getString("USER_ID"));
		vo.setName(resultSet.getString("NAME"));
		vo.setPolitical_appearance(resultSet.getString("POLITICAL_APPEARANCE"));
		vo.setBorn_date(resultSet.getString("BORN_DATE"));	
		vo.setHouse_registe(resultSet.getString("HOUSE_REGISTE"));
		vo.setJoin_date(resultSet.getString("JOIN_DATE"));
		vo.setNation(resultSet.getString("NATION"));
		//vo.setDept_id(resultSet.getString("dept_id"));
	    vo.setSex(resultSet.getString("SEX"));
	   vo.setProfessional(resultSet.getString("PROFESSIONAL"));
		return vo;
	};
	
	  

}
