package com.jlict.edu.research.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class ThesisItemRowMapper implements RowMapper<ThesisItemVo> {

	public ThesisItemVo mapRow(ResultSet rs, int arg1) throws SQLException {
		ThesisItemVo vo = new ThesisItemVo();
		vo.setId(rs.getString("ID"));
		vo.setTitle(rs.getString("THESIS_TITLE"));
		vo.setPeriodical(rs.getString("THESIS_PERIODICAL"));
		vo.setPostTime(rs.getString("THESIS_POSTTIME"));
		vo.setRole(rs.getString("THESIS_ROLE"));
		vo.setLevel(rs.getString("THESIS_LEVEL"));
		vo.setName(rs.getString("THESIS_NAME"));
		return vo;
		
	}

}
