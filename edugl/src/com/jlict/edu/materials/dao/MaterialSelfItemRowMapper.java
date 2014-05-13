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
public class MaterialSelfItemRowMapper implements RowMapper<MaterialSelfItemVo>
{

	/* (non-Javadoc)
	 * @see org.springframework.jdbc.core.RowMapper#mapRow(java.sql.ResultSet, int)
	 */
	@Override
	public MaterialSelfItemVo mapRow(ResultSet rs, int arg1) throws SQLException
	{
		MaterialSelfItemVo vo = new MaterialSelfItemVo();
		
		try
		{
			vo.setCount(Integer.parseInt(rs.getString("COUNT")));
			vo.setEditor(rs.getString("EDITOR"));
			vo.setId(rs.getString("ID"));
			vo.setIsbn(rs.getString("ISBN"));
			vo.setMaterialName(rs.getString("MATERIALS_NAME"));
			vo.setPress(rs.getString("PRESS"));
			vo.setResult(rs.getString("APPLY_RESULT"));
			vo.setPrice(rs.getString("Price"));
			vo.setUseClass(rs.getString("USE_CLASS"));
			vo.setUserId(rs.getString("USER_ID"));
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
