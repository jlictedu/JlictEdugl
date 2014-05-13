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
 * <p>Title: com.jlict.hrgl.message.dao.MessageWriteRowMapper.java</p>
 * <p>Description:发件箱信息RowMapper </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
public class MessageWriteRowMapper implements RowMapper<MessageWriteVo> {

	public MessageWriteVo mapRow(ResultSet rs, int arg1) {
		// TODO Auto-generated method stub
		MessageWriteVo vo = new MessageWriteVo();
		try{
			vo.setId(rs.getString("ID"));
			vo.setTitle(rs.getString("TITLE"));
			Clob text = rs.getClob("TEXT");
			vo.setText(text.getSubString(1, (int) text.length()));
			vo.setReceiverId(rs.getString("TO_ID"));
			vo.setReceiver(rs.getString("TO_NAME"));
			vo.setSendDate(rs.getString("SEND_DATE"));
		}catch(SQLException e){
			SysLogUtil.error(e);
		}
		return vo;
	}

}
