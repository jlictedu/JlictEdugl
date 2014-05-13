/**
 * 
 */
package com.jlict.edu.core.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;

/**
 * <p>Title: com.jlict.core.controller.BaseAction.java</p>
 * <p>Description:基础controller类</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Controller
public class BaseAction {
	
	
	/**
	 * 方法名: getUserId   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-6-24 下午10:50:34 
	 * 描述: 获取当前用户的id
	 * 参数：request 说明：当前用户的请求
	 * 返回类型 String       
	 */
	protected String getUserId(HttpServletRequest request){
		String id;
		try{
			HttpSession session = request.getSession();
			id = (String) session.getAttribute("userId");
		}
		catch(Exception e){
			id = "";
		}
		return id;
	}
	
		
	/**
	 * 方法名: getName   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-6-24 下午10:52:56 
	 * 描述: 描述: 获取当前用户的名字
	 * 参数：request 说明：当前用户的请求
	 * 返回类型 String       
	 */
	protected String getName(HttpServletRequest request){
		String name;
		try{
			HttpSession session = request.getSession();
			name = (String) session.getAttribute("name");
		}
		catch(Exception e){
			name = "";
		}
		return name;
	}
	
	/**
	 * 方法名: getDepartmentId   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-6-26 上午02:49:09 
	 * 描述: 获取当前用户的部门id
	 * 参数：request 说明：当前用户的请求
	 * 返回类型 String       
	 */
	protected String getDepartmentId(HttpServletRequest request){
		String departmentId;
		try{
			HttpSession session = request.getSession();
			departmentId = (String) session.getAttribute("departmentId");
		}
		catch(Exception e){
			departmentId = "";
		}
		return departmentId;
	}
	
	/**
	 * 方法名: getStationtId   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-6-26 上午02:49:07 
	 * 描述: 获取当前用户的岗位id
	 * 参数：request 说明：当前用户的请求
	 * 返回类型 String       
	 */
	protected String getStationtId(HttpServletRequest request){
		String stationId;
		try{
			HttpSession session = request.getSession();
			stationId = (String) session.getAttribute("stationId");
		}
		catch(Exception e){
			stationId = "";
		}
		return stationId;
	}
	
}
