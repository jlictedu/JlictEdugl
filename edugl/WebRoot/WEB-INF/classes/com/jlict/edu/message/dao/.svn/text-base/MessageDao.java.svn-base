/**
 * 
 */
package com.jlict.edu.message.dao;


import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;

/**
 * <p>Title: com.jlict.hrgl.message.dao.MessageDao.java</p>
 * <p>Description: 站内信息模块持久层</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Repository
public class MessageDao extends BaseDao {
	/**
	 * 方法名: getNewMessageCount   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-6-27 下午09:43:23 
	 * 描述: 查询用户的新消息的数量
	 * 参数：receiver 说明：收件人id
	 * 返回类型 int       
	 */
	public int getNewMessageCount(String receiver){
		String sql = "SELECT COUNT(ID) FROM T_MESSAGE WHERE TO_ID = ? AND READ_FLAG='0' AND valid='1' ";
		return this.jdbcTemplate.queryForInt(sql, receiver);
	}	
	
	/**
	 * 方法名: queryInbox   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:23:52 
	 * 描述: 分页查询用户收件箱中的信息
	 * 参数：receiver 说明：收件人id
	 * 参数：pageIndex 说明：分页索引
	 * 参数：pageSize 说明：单个分页记录数
	 * 返回类型 PagingJson       
	 */
	public PagingJson queryInbox(String receiver,int pageIndex, int pageSize){
		String countSql = "SELECT COUNT(ID) FROM T_MESSAGE WHERE TO_ID=? AND VALID='1'";
		String listSql = "SELECT T_MESSAGE.ID,TITLE,T_USER.NAME AS FROM_NAME,SEND_DATE,READ_FLAG FROM T_MESSAGE ,T_USER WHERE  TO_ID=? AND T_USER.USER_ID=FROM_ID AND T_MESSAGE.VALID='1' ORDER BY SEND_DATE DESC";
		Object[] para = new Object[]{receiver};
		return this.queryPagingList(countSql, listSql, para, pageIndex, pageSize,new MessageReadSummaryRowMapper());
	}
	
	/**
	 * 方法名: queryOutbox   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:25:46 
	 * 描述: 分页查询用户发件箱中的信息
	 * 参数：sender 说明：发件人id
	 * 参数：pageIndex 说明：分页索引
	 * 参数：pageSize 说明：单个分页记录数
	 * 返回类型 PagingJson       
	 */
	public PagingJson queryOutbox(String sender,int pageIndex, int pageSize){
		String countSql = "SELECT COUNT(ID) FROM T_MESSAGE WHERE FROM_ID=?";
		String listSql = "SELECT T_MESSAGE.ID,TITLE,T_USER.NAME AS TO_NAME,SEND_DATE,READ_FLAG FROM T_MESSAGE ,T_USER WHERE FROM_ID=? AND T_USER.USER_ID=TO_ID ORDER BY SEND_DATE DESC";
		Object[] para = new Object[]{sender};
		return this.queryPagingList(countSql, listSql, para, pageIndex, pageSize,new MessageWriteSummaryRowMapper());
	}
	
	/**
	 * 方法名: readMessage   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:26:31 
	 * 描述: 读取收件箱信息
	 * 参数：id 说明：信息主键id
	 * 参数：receiver 说明：收件人
	 * 返回类型 MessageReadVo       
	 */
	public MessageReadVo readMessage(String id,String receiver){
		String sql = "SELECT T_MESSAGE.ID,TITLE,T_USER.NAME AS FROM_NAME,FROM_ID,TEXT,SEND_DATE FROM T_MESSAGE ,T_USER WHERE T_MESSAGE.ID=? AND TO_ID=? AND T_MESSAGE.VALID='1' AND T_USER.USER_ID=FROM_ID";
		Object[] para = new Object[]{id,receiver};
		return this.jdbcTemplate.queryForObject(sql, para, new MessageReadRowMapper());		
	}
	
	/**
	 * 方法名: readSendMessage   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:27:22 
	 * 描述: 读取发件箱信息
	 * 参数：id 说明：信息主键id
	 * 参数：sender 说明：发件人
	 * 返回类型 MessageWriteVo       
	 */
	public MessageWriteVo readSendMessage(String id,String sender){
		try{
		String sql = "SELECT T_MESSAGE.ID,TITLE,T_USER.NAME AS TO_NAME,TO_ID,TEXT,SEND_DATE FROM T_MESSAGE ,T_USER WHERE T_MESSAGE.ID=? AND FROM_ID=? AND T_USER.USER_ID=TO_ID";
		Object[] para = new Object[]{id,sender};
		return this.jdbcTemplate.queryForObject(sql, para, new MessageWriteRowMapper());
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	/**
	 * 方法名: sendMessage   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:29:43 
	 * 描述: 发送信息
	 * 参数：receiver 说明：收件人
	 * 参数：sender 说明：发件人
	 * 参数：title 说明：消息主题
	 * 参数：content 说明：消息内容
	 * 返回类型 boolean       
	 */
	public boolean sendMessage(String receiver,String sender,String title,String content){
		String sql = "INSERT INTO T_MESSAGE VALUES(SYS_GUID(),?,?,?,?,SYSDATE,'0','1')";
		Object[] para = new Object[]{title,content,sender,receiver};
		return 0<this.jdbcTemplate.update(sql, para);		
	}
	
	/**
	 * 方法名: FlagRead   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:31:44 
	 * 描述: 将信息标志为已经阅读
	 * 参数：id 说明：细腻下主键id
	 * 参数：receiver 说明：收件人
	 * 返回类型 void       
	 */
	public void FlagRead(String id,String receiver){
		String sql="UPDATE T_MESSAGE SET READ_FLAG='1' WHERE ID=? AND TO_ID=?";
		Object[] para = new Object[]{id,receiver};
		this.jdbcTemplate.update(sql, para);
	}
	
	/**
	 * 方法名: delete   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:32:29 
	 * 描述: 删除信息
	 * 参数：id 说明：信息主键id
	 * 参数：receiver 说明：收件人
	 * 返回类型 void       
	 */
	public void delete(String id,String receiver){
		String sql="UPDATE T_MESSAGE SET VALID='0' WHERE ID=? AND TO_ID=?";
		Object[] para = new Object[]{id,receiver};
		this.jdbcTemplate.update(sql, para);
	}
	
}
