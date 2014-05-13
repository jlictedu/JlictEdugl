/**
 * 
 */
package com.jlict.edu.message.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.jlict.edu.core.util.SysLogUtil;

/**
 * <p>Title: com.jlict.hrgl.message.dao.MessageReadSummaryRowMapper.java</p>
 * <p>Description: 收件箱信息概要RowMapper</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
public class MessageReadSummaryRowMapper implements RowMapper<MessageReadSummaryVo> {

	public MessageReadSummaryVo mapRow(ResultSet rs, int arg1) {
		// TODO Auto-generated method stub
		MessageReadSummaryVo vo = new MessageReadSummaryVo();
		try{
			vo.setId(rs.getString("ID"));
			vo.setTitle(rs.getString("TITLE"));
			vo.setSender(rs.getString("FROM_NAME"));
			vo.setSendDate(rs.getString("SEND_DATE"));
			vo.setReadFlag(rs.getString("READ_FLAG").equals("0")?false:true);
		}catch(SQLException e){
			SysLogUtil.error(e);
		}
		return vo;
	}

}
