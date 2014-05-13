/**
 * 
 */
package com.jlict.edu.sys.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;


/**
 * <p>Title: com.jlict.sys.dao.SysMenuRowMapper.java</p>
 * <p>Description: 系统菜单节点RowMapper</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
public class SysMenuRowMapper implements RowMapper<SysMenuVo> {

	public SysMenuVo mapRow(ResultSet rs, int arg1) throws SQLException {
		// TODO Auto-generated method stub
		SysMenuVo vo = new SysMenuVo();
		try{
			vo.setId(rs.getString("MENU_ID"));
			vo.setIsLeaf(rs.getString("LEAF"));
			vo.setUrl(rs.getString("MENU_URL"));
			vo.setText(rs.getString("MENU_NAME"));
			vo.setParentId(rs.getString("PARENT_ID"));
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return vo;
	}

}
