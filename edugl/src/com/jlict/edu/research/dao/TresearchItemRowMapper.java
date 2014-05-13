package com.jlict.edu.research.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
public class TresearchItemRowMapper implements RowMapper<TresearchItemVo> {

	public TresearchItemVo mapRow(ResultSet rs, int arg1) throws SQLException {
		TresearchItemVo vo = new TresearchItemVo();
		vo.setId(rs.getString("ID"));
		vo.setProjectName(rs.getString("TRSESARCH_PROJECTNAME"));
		vo.setProjectSources(rs.getString("TRSESARCH_PROJECTSOURCES"));
		vo.setBeginendTime(rs.getString("TRSESARCH_BEGINENDTIME"));
		vo.setFunds(rs.getString("TRSESARCH_FUNDS"));
		vo.setFundsavaliable(rs.getString("TRSESARCH_FUNDSAVALIABLE"));
		vo.setPerformance(rs.getString("TRSESARCH_PERFORMANCE"));
		vo.setRole(rs.getString("TRSESARCH_ROLE"));
		return vo;
		
	}

}
