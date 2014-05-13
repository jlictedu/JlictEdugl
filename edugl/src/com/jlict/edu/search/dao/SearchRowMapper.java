package com.jlict.edu.search.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class SearchRowMapper implements RowMapper<SearchVo> {

	public SearchVo mapRow(ResultSet rs, int arg1) throws SQLException {
		SearchVo vo = new SearchVo();
		
		vo.setId(rs.getString("ID"));
		vo.setNumber(rs.getString("NUMBER"));			
		return vo;
	}
}