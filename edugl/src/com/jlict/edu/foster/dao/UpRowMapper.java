package com.jlict.edu.foster.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jlict.edu.core.util.SysLogUtil;

/**
 * <p>Title: com.jlict.edu.foster.dao.UpRowMapper.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
/**
 * <p>Title: com.jlict.edu.foster.dao.UpRowMapper.java</p>
 * <p>Description: 院系RowMapper</p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 王森玉
 * @version 1.0
 */
public class UpRowMapper implements RowMapper<UpVo>{

	public UpVo mapRow(ResultSet rs, int arg1){
		UpVo vo=new UpVo();
		try {
			vo.setDeptid(rs.getString("DEPTID"));
			vo.setDeptname(rs.getString("DEPTNAME"));
			vo.setBossdeptid(rs.getString("BOSSDEPTID"));
			vo.setBossdeptname(rs.getString("BOSSDEPTNAME"));
			vo.setYear(rs.getString("YEAR"));
		} catch (SQLException e) {
			SysLogUtil.error(e);
		}
		return vo;
	}

}
