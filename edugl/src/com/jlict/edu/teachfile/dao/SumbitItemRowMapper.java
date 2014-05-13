package com.jlict.edu.teachfile.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SumbitItemRowMapper implements RowMapper<SumbitItemVo> {

	public SumbitItemVo mapRow(ResultSet rs, int arg1) throws SQLException {
		SumbitItemVo vo = new SumbitItemVo();
		
		vo.setId(rs.getString("ID"));
		vo.setName(rs.getString("SUMBIT_NAME"));
		vo.setJobTitle(rs.getString("SUMBIT_JBOTITLE"));
		vo.setMessage(rs.getString("SUMBIT_MESSAGE"));
		vo.setSumbitTime(rs.getString("SUMBIT_SUMBITTIME"));
		vo.setCompleting(rs.getString("SUMBIT_COMPLETING"));
		return vo;
	}

}
