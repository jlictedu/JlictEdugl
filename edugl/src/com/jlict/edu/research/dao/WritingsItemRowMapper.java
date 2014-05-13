package com.jlict.edu.research.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class WritingsItemRowMapper implements RowMapper<WritingsItemVo> {

	public WritingsItemVo mapRow(ResultSet rs, int arg1) throws SQLException {
		WritingsItemVo vo = new WritingsItemVo();
		vo.setId(rs.getString("ID"));
		vo.setName(rs.getString("WRITINGS_NAME"));
		vo.setPress(rs.getString("WRITINGS_PRESS"));
		vo.setPublicationTime(rs.getString("WRITINGS_PUBLICATIONTIME"));
		vo.setRole(rs.getString("WRITINGS_ROLE"));
		vo.setWordNumber(rs.getString("WRITINGS_WORDNUMBER"));
		return vo;
	}

}
