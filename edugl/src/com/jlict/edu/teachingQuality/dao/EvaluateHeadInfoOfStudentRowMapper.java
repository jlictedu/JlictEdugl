/**
 * 
 */
package com.jlict.edu.teachingQuality.dao;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

import com.jlict.edu.core.util.SysLogUtil;


/**
 * <p>Title: com.jlict.edu.teachingQuality.dao.EvaluateHeadInfoOfStudentRowMapper.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
public class EvaluateHeadInfoOfStudentRowMapper implements RowMapper<EvaluateHeadInfoOfStudentVo>
{

	@Override
	public EvaluateHeadInfoOfStudentVo mapRow(ResultSet rs, int arg1)
	{
		EvaluateHeadInfoOfStudentVo vo = new EvaluateHeadInfoOfStudentVo();
		
		try
		{
			vo.setCourseName(rs.getString("COURSE_NAME"));
			vo.setTeacherName(rs.getString("TEACHER_NAME"));
			vo.setAttendClass(rs.getString("ATTEND_CLASS"));
		}
		catch(Exception e)
		{
			SysLogUtil.error(e);
		}
		
		return vo;
	}

}
