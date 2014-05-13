package com.jlict.edu.research.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class AwardsItemRowMapper implements RowMapper<AwardsItemVo> {

	public AwardsItemVo mapRow(ResultSet rs, int arg1) throws SQLException {
		AwardsItemVo vo = new AwardsItemVo();
		
		vo.setId(rs.getString("ID"));
		vo.setName(rs.getString("AWARDS_NAME"));
		vo.setLevel(rs.getString("AWARDS_LEVEL"));
		vo.setRank(rs.getString("AWARDS_RANK"));
		vo.setRole(rs.getString("AWARDS_ROLE"));
		return vo;
	}

}
