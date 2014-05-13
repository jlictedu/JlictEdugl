/**
 * 
 */
package com.jlict.edu.userinfo.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jlict.edu.core.controller.BaseAction;
import com.jlict.edu.core.util.SysLogUtil;
import com.jlict.edu.materials.dao.MaterialItemVo;
import com.jlict.edu.userinfo.service.UserInfoService;

/**
 * <p>Title: com.jlict.edu.userinfo.controller.UserInfoAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Controller
public class UserInfoAction extends BaseAction {
	@Autowired
	private UserInfoService service;
	
	@RequestMapping(value="/insertuser.do",method=RequestMethod.GET)
	public ModelAndView initMaterialSelfPanel()
	{
		return new ModelAndView("/userinfo/insertuserinfo");
	}
	
	@RequestMapping(value="/insertuser.do",method=RequestMethod.POST,params="m=insertuser")
	@ResponseBody
	public String insertUser(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			String name = request.getParameter("name");
			String age = request.getParameter("age");
			
			return this.service.insertUser(name, age);
		}
		catch(Exception e)
		{
			SysLogUtil.error("阅读教材征订Action层出错！", e);
			return "false";
		}
	}
}
