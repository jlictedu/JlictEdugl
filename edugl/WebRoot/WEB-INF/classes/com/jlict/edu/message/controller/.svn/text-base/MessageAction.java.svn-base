/**
 * 
 */
package com.jlict.edu.message.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jlict.edu.core.controller.BaseAction;
import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.core.util.HtmlStringUtil;
import com.jlict.edu.core.util.ResultJson;
import com.jlict.edu.core.util.SysLogUtil;
import com.jlict.edu.message.dao.MessageReadVo;
import com.jlict.edu.message.dao.MessageWriteVo;
import com.jlict.edu.message.service.MessageService;

/**
 * <p>Title: com.jlict.hrgl.message.controller.MessageAction.java</p>
 * <p>Description: 站内信息模块控制层</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Controller
public class MessageAction extends BaseAction {
	@Autowired
	MessageService messageService;
	
	/**
	 * 方法名: inboxInit   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:12:20 
	 * 描述: 初始化收件箱
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/inbox.do",method=RequestMethod.GET)
	public ModelAndView inboxInit(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/message/inbox");
	}
	
	/**
	 * 方法名: readMessage   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:13:00 
	 * 描述: 从收件箱中读取信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/inbox.do",method=RequestMethod.GET,params="m=read")
	public ModelAndView readMessage(HttpServletRequest request, HttpServletResponse response){
		MessageReadVo vo=null;
		try{
			String id = request.getParameter("id");
			boolean isNew = request.getParameter("readFlag").equals("false")?true:false;
			String userId = this.getUserId(request);			
			vo = this.messageService.readMessage(id, userId,isNew);
			vo.setText(HtmlStringUtil.lineConvert(vo.getText()));
			SysLogUtil.info("读取收件箱信件");
		}catch(Exception e){
			SysLogUtil.error("读取收件箱消息出错",e);
		}
		return new ModelAndView("/message/inbox-read","message",vo);
	}
	
	/**
	 * 方法名: queryInbox   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:13:07 
	 * 描述: 收件箱信息分页查询
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/inbox.do",method=RequestMethod.POST,params="m=query")
	@ResponseBody  
	public Object queryInbox(HttpServletRequest request, HttpServletResponse response){
		PagingJson json=null;	
		try{
		String userId = this.getUserId(request);
		int pageIndex= Integer.parseInt(request.getParameter("pageIndex"));
		int pageSize= Integer.parseInt(request.getParameter("pageSize"));
		json = this.messageService.queryInbox(userId, pageIndex, pageSize);
		SysLogUtil.info("查询收件箱信件列表");
		}catch(Exception e){
			SysLogUtil.error("查询收件箱出错", e);
		}
		return json;
	}
	
	/**
	 * 方法名: delete   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:13:13 
	 * 描述: 从收件箱中删除信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/inbox.do",method=RequestMethod.GET,params="m=delete")
	@ResponseBody  
	public Object delete(HttpServletRequest request, HttpServletResponse response){
		ResultJson json = new ResultJson();		
		try{
			String id = request.getParameter("id");
			String userId = this.getUserId(request);
			this.messageService.delete(id, userId);
			json.setResultCode(0);
			SysLogUtil.info("删除收件箱信件");
		}catch(Exception e){
			json.setResultCode(1);
			json.setText("删除失败");
		}
		return json;
	}
	
	/**
	 * 方法名: outboxInit   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:13:20 
	 * 描述: 发件箱初始化
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/outbox.do",method=RequestMethod.GET)
	public ModelAndView outboxInit(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/message/outbox");
	}
	
	/**
	 * 方法名: queryOutbox   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:13:25 
	 * 描述: 发件箱信息分页查询
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/outbox.do",method=RequestMethod.POST,params="m=query")
	@ResponseBody  
	public Object queryOutbox(HttpServletRequest request, HttpServletResponse response){
		PagingJson json=null;	
		try{
		String userId = this.getUserId(request);
		int pageIndex= Integer.parseInt(request.getParameter("pageIndex"));
		int pageSize= Integer.parseInt(request.getParameter("pageSize"));
		json = this.messageService.queryOutbox(userId, pageIndex, pageSize);
		SysLogUtil.info("查询发件箱信件列表");
		}catch(Exception e){
			SysLogUtil.error("查询发件箱出错", e);
		}
		return json;
	}
	
	/**
	 * 方法名: readSendMessage   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:13:32 
	 * 描述: 从发件箱中读取信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/outbox.do",method=RequestMethod.GET,params="m=read")
	public ModelAndView readSendMessage(HttpServletRequest request, HttpServletResponse response){
		MessageWriteVo vo=null;
		try{
			String id = request.getParameter("id");
			String userId = this.getUserId(request);			
			vo = this.messageService.readSendMessage(id, userId);
			vo.setText(vo.getText().replaceAll("\n", "<br />"));
			SysLogUtil.info("读取收件箱信件");
		}catch(Exception e){
			SysLogUtil.error("读取发件箱消息出错",e);
		}
		return new ModelAndView("/message/outbox-read","message",vo);
	}
	
	/**
	 * 方法名: sendInit   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:13:39 
	 * 描述: 发送信息页面初始化
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/outbox.do",method=RequestMethod.GET,params="m=sendInit")
	public ModelAndView sendInit(HttpServletRequest request, HttpServletResponse response){		
		return new ModelAndView("/message/send-init");
	}
	
	/**
	 * 方法名: sendMessage   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:13:43 
	 * 描述: 发送信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/outbox.do",method=RequestMethod.POST,params="m=send")
	@ResponseBody 
	public Object sendMessage(HttpServletRequest request, HttpServletResponse response){
		ResultJson json=new ResultJson();
		try{
			String receiver = request.getParameter("receiverId");
			String sender = this.getUserId(request);
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			if(this.messageService.sendMessage(receiver, sender, title, content)){
				json.setResultCode(0);
				SysLogUtil.info("发送信件");
			}else{
				json.setResultCode(2);
				json.setText("发送失败");
			}
		}catch(Exception e){
			SysLogUtil.error("发送消息出错",e);
			json.setResultCode(1);
		}
		return json;
	}
}
