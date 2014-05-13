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
public class MaterialSelfRowMapper implements RowMapper<MaterialSelfVo>
{

	@Override
	public MaterialSelfVo mapRow(ResultSet rs, int arg1) throws SQLException
	{
		MaterialSelfVo vo = new MaterialSelfVo();
		
		try
		{
			vo.setId(rs.getString("ID"));
			vo.setMaterialName(rs.getString("MATERIALS_NAME"));
			vo.setEditor(rs.getString("EDITOR"));
			vo.setPress(rs.getString("PRESS"));
			vo.setPrice(rs.getString("PRICE"));
			vo.setIsbn(rs.getString("ISBN"));
			vo.setCount(Integer.parseInt(rs.getString("COUNT")));
			vo.setUseClass(rs.getString("USE_CLASS"));
			vo.setApplyDate(rs.getString("APPLY_DATE"));
			vo.setDirector(rs.getString("DIRECTOR"));
			vo.setDirectorIdea(rs.getString("DIRECTOR_IDEA"));
			vo.setDean(rs.getString("DEAN"));
			vo.setDeanIdea(rs.getString("DEAN_IDEA"));
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
