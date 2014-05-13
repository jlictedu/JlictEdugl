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
public class EvaluationDetailOfStudentRowMapper implements RowMapper<EvaluationDetailOfStudentVo> {

	@Override
	public EvaluationDetailOfStudentVo mapRow(ResultSet rs, int arg1)
	{
		EvaluationDetailOfStudentVo vo = new EvaluationDetailOfStudentVo();
		
		try
		{
			vo.setId(rs.getString("ID"));
			vo.setStuId(rs.getInt("STU_ID"));
			vo.setTaEi1(rs.getInt("TA_EI1"));
			vo.setTaEi2(rs.getInt("TA_EI2"));
			vo.setTcEi1(rs.getInt("TC_EI1"));
			vo.setTcEi2(rs.getInt("TC_EI2"));
			vo.setTcEi3(rs.getInt("TC_EI3"));
			vo.setTcEi4(rs.getInt("TC_EI4"));
			vo.setTcEi5(rs.getInt("TC_EI5"));
			vo.setTmEi1(rs.getInt("TM_EI1"));
			vo.setTmEi2(rs.getInt("TM_EI2"));
			vo.setTmEi3(rs.getInt("TM_EI3"));
			vo.setTeEi1(rs.getInt("TE_EI1"));
			vo.setIdea(rs.getString("IDEA"));
		}
		catch(Exception e)
		{
			SysLogUtil.error(e);
		}
		return vo;
	}

}
