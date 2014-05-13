package com.jlict.edu.entrance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TeacherIdMapper implements RowMapper{

	public TeacherVo mapRow(ResultSet resultSet, int value) throws SQLException {
		// TODO Auto-generated method stub
		TeacherVo vo = new TeacherVo();;
		vo.setId(resultSet.getString("user_id"));
		return vo;
	}

}
