/**
 * 
 */
package com.jlict.edu.teachingQuality.dao;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

import com.jlict.edu.core.util.SysLogUtil;

/**
 * <p>Title: com.jlict.edu.teachingQuality.dao.EvaluationDetailOfStudentRowMapper.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
public class EvaluationDetailOfDirectorRowMapper implements RowMapper<TeachQualityTeacherVo> {

	@Override
	public TeachQualityTeacherVo mapRow(ResultSet rs, int arg1)
	{
		TeachQualityTeacherVo vo = new TeachQualityTeacherVo();
		
		try
		{
			vo.setId(rs.getString("ID"));
			vo.setTeaId(rs.getString("DIRECTOR_ID"));
			vo.setTotal(rs.getInt("EVALUATION_TOTAL"));
			vo.setIdea(rs.getString("IDEA"));
		}
		catch(Exception e)
		{
			SysLogUtil.error(e);
		}
		return vo;
	}

}
