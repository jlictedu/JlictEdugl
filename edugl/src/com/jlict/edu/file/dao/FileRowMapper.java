package com.jlict.edu.file.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class FileRowMapper implements RowMapper<FileVo> {

	public FileVo mapRow(ResultSet rs, int arg1) throws SQLException {
		FileVo vo = new FileVo();
		
		vo.setId(rs.getString("ID"));
		vo.setQuestions(rs.getString("QUESTIONS"));
		vo.setAnswer(rs.getString("ANSWER"));
		vo.setRoll(rs.getString("ROLL"));
		vo.setPaperanalysis(rs.getString("PAPERANALYSIS"));		
		return vo;
	}
}
