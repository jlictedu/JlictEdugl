package com.jlict.edu.foster.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jlict.edu.core.util.SysLogUtil;


/**
 * <p>Title: com.jlict.edu.foster.dao.FosterRowMapper.java</p>
 * <p>Description: 课程信息RowMapper</p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 王森玉
 * @version 1.0
 */
public class FosterRowMapper implements RowMapper<FosterVo>{

	public FosterVo mapRow(ResultSet rs, int arg1){
		FosterVo vo=new FosterVo();
		try {
			vo.setId(rs.getString("ID"));
			vo.setCoding(rs.getString("CODING"));
			vo.setName(rs.getString("NAME"));
			vo.setAttribute(rs.getString("ATTRIBUTE"));
			vo.setExam(rs.getString("EXAM"));
			vo.setCredit(rs.getString("CREDIT"));
			vo.setPrelect(rs.getString("PRELECT"));
			vo.setExperiment(rs.getString("EXPERIMENT"));
			vo.setComputer(rs.getString("COMPUTER"));
			vo.setTerm(rs.getString("TERM"));
			vo.setSortid(rs.getString("SORTID"));
			vo.setSort(rs.getString("SORT"));
			vo.setAllperiod(rs.getString("ALLPERIOD"));
			vo.setDept_id(rs.getString("DEPTID"));
			vo.setDept(rs.getString("DEPT"));
			vo.setYear(rs.getString("YEAR"));
			vo.setWeeks(rs.getString("WEEKS"));
			vo.setWeekcla(rs.getString("WEEKCLA"));
		} catch (SQLException e) {
			SysLogUtil.error(e);
		}
		return vo;
	}

	
}
