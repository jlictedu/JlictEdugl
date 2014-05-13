/**
 * 
 */
package com.jlict.edu.materials.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jlict.edu.core.util.SysLogUtil;

/**
 * <p>Title: com.jlict.edu.materials.dao.MaterialSelfItemRowMapper.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
public class MaterialItemRowMapper implements RowMapper<MaterialItemVo>
{

	@Override
	public MaterialItemVo mapRow(ResultSet rs, int arg1) throws SQLException
	{
		MaterialItemVo vo = new MaterialItemVo();
		
		try
		{
			vo.setId(rs.getString("ID"));
			vo.setCourseName(rs.getString("course_name"));
			vo.setCourseProperty(rs.getString("course_property"));
			vo.setIsbn(rs.getString("ISBN"));
			vo.setMaterialName(rs.getString("MATERIALS_NAME"));
			vo.setEditor(rs.getString("EDITOR"));
			vo.setRevision(rs.getString("REVISION"));
			vo.setPress(rs.getString("PRESS"));
			vo.setStudentCount(Integer.parseInt(rs.getString("STUDENT_COUNT")));
			vo.setTeacherCount(Integer.parseInt(rs.getString("TEACHER_COUNT")));
			vo.setUseClass(rs.getString("USE_CLASS"));
			vo.setTel(rs.getString("TEL"));
			vo.setApplyDate(rs.getString("APPLY_DATE"));
			vo.setApplyResult(rs.getString("APPLY_RESULT"));
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
