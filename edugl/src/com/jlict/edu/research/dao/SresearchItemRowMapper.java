package com.jlict.edu.research.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class SresearchItemRowMapper implements RowMapper<SresearchItemVo> {

	public SresearchItemVo mapRow(ResultSet rs, int arg1) throws SQLException {
		SresearchItemVo vo = new SresearchItemVo();
		vo.setId(rs.getString("ID"));
		vo.setProjectName(rs.getString("SRSESARCH_PROJECTNAME"));
		vo.setProjectSources(rs.getString("SRSESARCH_PROJECTSOURCES"));
		vo.setBeginendTime(rs.getString("SRSESARCH_BEGINENDTIME"));
		vo.setFunds(rs.getString("SRSESARCH_FUNDS"));
		vo.setFundsavaliable(rs.getString("SRSESARCH_FUNDSAVALIABLE"));
		vo.setPerformance(rs.getString("SRSESARCH_PERFORMANCE"));
		vo.setRole(rs.getString("STRSESARCH_ROLE"));
		return vo;
		
	}

}
