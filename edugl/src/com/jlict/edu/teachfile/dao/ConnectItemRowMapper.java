package com.jlict.edu.teachfile.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class ConnectItemRowMapper implements RowMapper<ConnectItemVo> {

	public ConnectItemVo mapRow(ResultSet rs, int arg1) throws SQLException {
		ConnectItemVo vo = new ConnectItemVo();
		
		vo.setId(rs.getString("ID"));
		vo.setName(rs.getString("CONNECT_NAME"));
		vo.setManifest(rs.getString("CONNECT_MANIFEST"));
		vo.setState(rs.getString("CONNECT_STATE"));
		vo.setNotes(rs.getString("CONNECT_NOTES"));
		vo.setRemark(rs.getString("CONNECT_REMARK"));
		
		return vo;
	}

}
