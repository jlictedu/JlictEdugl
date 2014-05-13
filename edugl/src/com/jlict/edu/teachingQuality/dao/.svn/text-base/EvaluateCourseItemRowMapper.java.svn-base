/**
 * 
 */
package com.jlict.edu.teachingQuality.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jlict.edu.core.util.SysLogUtil;

/**
 * <p>Title: com.jlict.edu.teachingQuality.dao.EvaluateCourseItemRowMapper.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
public class EvaluateCourseItemRowMapper implements RowMapper<EvaluateCourseItemVo>
{
	@Override
	public EvaluateCourseItemVo mapRow(ResultSet rs, int arg1) 
	{
		EvaluateCourseItemVo vo = new EvaluateCourseItemVo();
		
		try
		{
			vo.setId(rs.getString("id"));
			vo.setTeacher(rs.getString("teacher"));
			vo.setCategory(rs.getString("category"));
			vo.setStatus(rs.getString("status"));
		}
		catch(SQLException se)
		{
			SysLogUtil.error(se);
		}
		catch(Exception e)
		{
			SysLogUtil.error(e);
		}

		return vo;
	}
}
