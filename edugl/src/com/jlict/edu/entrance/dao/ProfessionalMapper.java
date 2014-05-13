package com.jlict.edu.entrance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;



public class ProfessionalMapper implements RowMapper<ProfessionalVo>{

	public ProfessionalVo mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProfessionalVo vo = new ProfessionalVo();
		vo.setId(rs.getString("ID"));
		vo.setName(rs.getString("NAME"));
		return vo;
	}

}
