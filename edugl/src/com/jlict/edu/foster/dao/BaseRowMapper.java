/**
 * 
 */
package com.jlict.edu.foster.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * <p>Title: com.jlict.hrgl.manager.dao.DepartMentRowMapper.java</p>
 * <p>Description: 部门RowMapper</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 王森玉
 * @version 1.0
 */
public class BaseRowMapper implements RowMapper<BaseVo> {

	public BaseVo mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		BaseVo vo = new BaseVo();
		vo.setId(rs.getString("ID"));
		vo.setName(rs.getString("NAME"));
		return vo;
	}

}
