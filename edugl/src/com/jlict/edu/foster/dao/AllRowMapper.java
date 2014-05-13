package com.jlict.edu.foster.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jlict.edu.core.util.SysLogUtil;

/**
 * <p>Title: com.jlict.edu.foster.dao.AllRowMapper.java</p>
 * <p>Description: 入学年份RowMapper</p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 王森玉
 * @version 1.0
 */
public class AllRowMapper implements RowMapper<AllVo>{

	public AllVo mapRow(ResultSet rs, int arg1){
		AllVo vo=new AllVo();
		try {
			vo.setId(rs.getString("ID"));
			vo.setDeptid(rs.getString("DEPTID"));
			vo.setDeptname(rs.getString("DEPTNAME"));
			vo.setYear(rs.getString("YEAR"));
		} catch (SQLException e) {
			SysLogUtil.error(e);
		}
		return vo;
	}

	
}
