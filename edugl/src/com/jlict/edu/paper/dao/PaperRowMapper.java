package com.jlict.edu.paper.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class PaperRowMapper implements RowMapper<PaperVo> {

	public PaperVo mapRow(ResultSet rs, int arg1) throws SQLException {
		PaperVo vo = new PaperVo();
		
		vo.setId(rs.getString("ID"));
		vo.setRebuild(rs.getString("REBUILD"));
		vo.setResit(rs.getString("RESIT"));
		vo.setExamination(rs.getString("EXAMINATION"));
		vo.setAtonic(rs.getString("ATONIC"));		
		return vo;
	}
}