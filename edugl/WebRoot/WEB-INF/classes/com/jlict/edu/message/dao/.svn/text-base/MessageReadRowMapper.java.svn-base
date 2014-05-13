/**
 * 
 */
package com.jlict.edu.message.dao;


import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jlict.edu.core.util.SysLogUtil;

/**
 * <p>Title: com.jlict.hrgl.message.dao.MessageReadRowMapper.java</p>
 * <p>Description: 收件箱信息RowMapper</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
public class MessageReadRowMapper implements RowMapper<MessageReadVo> {

	public MessageReadVo mapRow(ResultSet rs, int arg1){
		// TODO Auto-generated method stub
		MessageReadVo vo = new MessageReadVo();
		try{
			vo.setId(rs.getString("ID"));
			vo.setTitle(rs.getString("TITLE"));
			Clob text = rs.getClob("TEXT");
			vo.setText(text.getSubString(1, (int) text.length()));
			vo.setSenderId(rs.getString("FROM_ID"));
			vo.setSender(rs.getString("FROM_NAME"));
			vo.setSendDate(rs.getString("SEND_DATE"));
		}catch(SQLException e){
			SysLogUtil.error(e);
		}
		return vo;
	}

}
