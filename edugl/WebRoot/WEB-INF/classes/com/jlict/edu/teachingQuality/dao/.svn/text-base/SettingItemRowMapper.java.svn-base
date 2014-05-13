/**
 * 
 */
package com.jlict.edu.teachingQuality.dao;

import java.sql.ResultSet;

import org.springframework.jdbc.core.RowMapper;

import com.jlict.edu.core.util.SysLogUtil;

/**
 * <p>Title: com.jlict.edu.teachingQuality.dao.SettingItemRowMapper.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
public class SettingItemRowMapper implements RowMapper<SettingItemVo>
{
	@Override
	public SettingItemVo mapRow(ResultSet rs, int arg1)
	{
		SettingItemVo vo = new SettingItemVo();
		
		try
		{
			vo.setId(rs.getString("id"));
			vo.setTeacher(rs.getString("teacher"));
			vo.setCourse(rs.getString("course"));
			vo.setAttendClass(rs.getString("attendClass"));
			vo.setCategory(rs.getString("category"));
			vo.setStatus(rs.getString("status"));
		}
		catch(Exception e)
		{
			SysLogUtil.error(e);
		}

		return vo;
	}
}
