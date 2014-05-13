/**
 * 
 */
package com.jlict.edu.teachingQuality.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * <p>Title: com.jlict.edu.teachingQuality.dao.EvaluationSettingItemRow.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
public class EvaluationSettingItemRow implements RowMapper<EvaluationSettingItemVo>
{

	@Override
	public EvaluationSettingItemVo mapRow(ResultSet rs, int arg1) throws SQLException
	{
		EvaluationSettingItemVo vo = new EvaluationSettingItemVo();
		
		try
		{
			vo.setId(rs.getString("ID"));
			vo.setCoding(rs.getString("CODING"));
			vo.setName(rs.getString("COURSE_NAME"));
			vo.setAttribute(rs.getString("ATTRIBUTE"));
			vo.setExam(rs.getString("EXAM"));
			vo.setTerm(rs.getString("TERM"));
			vo.setYear(rs.getString("YEAR"));
			vo.setStatus(rs.getString("STATUS"));
			vo.setTeacherId(rs.getString("TEACHER_ID"));
			vo.setTeacherName(rs.getString("TEACHER_NAME"));
			vo.setEvaluationId(rs.getString("EVALUATION_ID"));
			vo.setAttendClass(rs.getString("DEPT_NAME"));
			vo.setDeptId(rs.getString("DEPT_ID"));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		
		return vo;
	}

}
