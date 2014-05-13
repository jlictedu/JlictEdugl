/**
 * 
 */
package com.jlict.edu.message.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.message.dao.MessageDao;
import com.jlict.edu.message.dao.MessageReadVo;
import com.jlict.edu.message.dao.MessageWriteVo;

/**
 * <p>Title: com.jlict.hrgl.message.service.MessageService.java</p>
 * <p>Description: 站内信息模块业务层</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Service
public class MessageService {
	@Autowired
	MessageDao messageDao;
	
	/**
	 * 方法名: getNewMessageCount   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:36:26 
	 * 描述: 得到未读信息数量
	 * 参数：receiver 说明：信息接受者
	 * 返回类型 int       
	 */
	public int getNewMessageCount(String receiver){
		return this.messageDao.getNewMessageCount(receiver);
	}
	
	/**
	 * 方法名: queryInbox   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:36:28 
	 * 描述: 发件箱信息分页查询
	 * 参数：receiver 说明：收件人id
	 * 参数：pageIndex 说明：分页索引
	 * 参数：pageSize 说明：单个分页记录数
	 * 返回类型 PagingJson       
	 */
	public PagingJson queryInbox(String receiver,int pageIndex, int pageSize){
		return this.messageDao.queryInbox(receiver, pageIndex, pageSize);
	}
	
	/**
	 * 方法名: queryOutbox   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:41:42 
	 * 描述: 收件箱信息分页查询
	 * 参数：sender 说明：发件人id
	 * 参数：pageIndex 说明：分页索引
	 * 参数：pageSize 说明：单个分页记录数
	 * 返回类型 PagingJson       
	 */
	public PagingJson queryOutbox(String sender,int pageIndex, int pageSize){
		return this.messageDao.queryOutbox(sender, pageIndex, pageSize);
	}
	
	/**
	 * 方法名: readMessage   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:42:40 
	 * 描述: 读取收件箱信息
	 * 参数：id 说明：信息主键id
	 * 参数：receiver 说明：收件人
	 * 返回类型 MessageReadVo       
	 */
	public MessageReadVo readMessage(String id,String receiver,boolean isNew){
		if(isNew){
			this.messageDao.FlagRead(id, receiver);
		}
		return this.messageDao.readMessage(id, receiver);
	}
	
	/**
	 * 方法名: delete   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:42:58 
	 * 描述: 删除信息
	 * 参数：id 说明：信息主键id
	 * 参数：receiver 说明：收件人
	 * 返回类型 void       
	 */
	public void delete(String id,String receiver){
		this.messageDao.delete(id, receiver);
	}
	
	/**
	 * 方法名: readSendMessage   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:43:27 
	 * 描述: 读取收件箱信息
	 * 参数：id 说明：信息主键id
	 * 参数：receiver 说明：收件人
	 * 返回类型 MessageWriteVo       
	 */
	public MessageWriteVo readSendMessage(String id,String sender){		
		return this.messageDao.readSendMessage(id, sender);
	}
	
	/**
	 * 方法名: sendMessage   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:43:56 
	 * 描述: 发送信息
	 * 参数：receiver 说明：收件人
	 * 参数：sender 说明：发件人
	 * 参数：title 说明：消息主题
	 * 参数：content 说明：消息内容
	 * 返回类型 boolean       
	 */
	public boolean sendMessage(String receiver,String sender,String title,String content){
		return this.messageDao.sendMessage(receiver, sender, title, content);
	}
}
