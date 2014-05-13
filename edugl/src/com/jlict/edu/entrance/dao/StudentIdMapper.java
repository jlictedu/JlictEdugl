package com.jlict.edu.entrance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class StudentIdMapper implements RowMapper{

	public StudentVo mapRow(ResultSet resultSet, int value) throws SQLException {
		// TODO Auto-generated method stub
		StudentVo vo = new StudentVo();;
		vo.setId(resultSet.getString("user_id"));
		return vo;
	}

}
