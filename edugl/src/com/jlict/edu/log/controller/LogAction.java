/**
 * 
 */
package com.jlict.edu.log.controller;

import java.io.File;

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
import com.jlict.edu.core.util.SysLogUtil;
import com.jlict.edu.log.service.LogService;

/**
 * <p>Title: com.jlict.hrgl.log.controller.LogAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Controller
public class LogAction extends BaseAction {
	@Autowired
	LogService LogService;
	@RequestMapping(value="/log.do",method=RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/manager/log");
	}
	
	@RequestMapping(value="/log.do",method=RequestMethod.GET,params="m=read")
	public ModelAndView read(HttpServletRequest request, HttpServletResponse response){
		String file = request.getParameter("name");
		SysLogUtil.info("读取日志");
		return new ModelAndView("/manager/log-read","file",file);
	}
	
	@RequestMapping(value="/log.do",method=RequestMethod.POST,params="m=query")
	@ResponseBody
	public Object queryLog(HttpServletRequest request, HttpServletResponse response){
		PagingJson json=null;
		File directory;
		try{
			directory = new File(request.getSession().getServletContext().getRealPath("/WEB-INF/log"));
			int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			json = this.LogService.queryLog(directory, pageIndex, pageSize);
			SysLogUtil.info("查询日志列表");
		}catch(Exception e){
			SysLogUtil.error("获取日志列表出错",e);
		}
		return json;
	}
}
