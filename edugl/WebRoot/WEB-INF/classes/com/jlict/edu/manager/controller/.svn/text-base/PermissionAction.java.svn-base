/**
 * 
 */
package com.jlict.edu.manager.controller;

import java.util.List;

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
import com.jlict.edu.core.util.ResultJson;
import com.jlict.edu.core.util.SysLogUtil;
import com.jlict.edu.manager.service.DepartmentService;
import com.jlict.edu.manager.service.PermissionService;
import com.jlict.edu.manager.service.RoleService;
import com.jlict.edu.manager.service.StationService;

/**
 * <p>Title: com.jlict.hrgl.manager.controller.PermissionAction.java</p>
 * <p>Description: 权限管理模块控制层</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Controller
public class PermissionAction extends BaseAction {
	@Autowired
	PermissionService permissionService;
	@Autowired
	DepartmentService departmentService;
	@Autowired
	StationService stationService; 
	@Autowired
	RoleService roleService;
	
	/**
	 * 方法名: permissionManagerInit   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:29:52 
	 * 描述: 权限管理页面初始化
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/permission.do",method=RequestMethod.GET)
	public ModelAndView permissionManagerInit(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/manager/permission-manager");
	}
	
	/**
	 * 方法名: permissionCreateInit   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:30:29 
	 * 描述: 权限创建页面初始化
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/permission.do",method=RequestMethod.GET,params="m=createInit")
	public ModelAndView permissionCreateInit(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/manager/permission-create");
	}
	
	/**
	 * 方法名: getDepartment   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:30:47 
	 * 描述: 查询部门信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/permission.do",method=RequestMethod.POST,params="m=queryDepartment")
	@ResponseBody  
    public Object getDepartment(HttpServletRequest request, HttpServletResponse response) {
		List json = null;
		try{
			json = this.departmentService.queryDepartment();
		}catch(Exception e){
			SysLogUtil.error("查询所有部门信息出错");
			e.printStackTrace();
		}
		return json;
		
	}
	
	/**
	 * 方法名: getRole   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:31:09 
	 * 描述: 查询系统角色信息
	 * 参数：para 说明：TODO
	 * 返回类型 Object       
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/permission.do",method=RequestMethod.POST,params="m=queryRole")
	@ResponseBody  
    public Object getRole(HttpServletRequest request, HttpServletResponse response) {
		List json = null;
		try{
			json = this.roleService.queryRole();
		}catch(Exception e){
			SysLogUtil.error("查询所有角色信息出错");
			e.printStackTrace();
		}
		return json;
		
	}
	
	/**
	 * 方法名: getStation   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:31:34 
	 * 描述: 查询岗位信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/permission.do",method=RequestMethod.POST,params="m=queryStation")
	@ResponseBody  
    public Object getStation(HttpServletRequest request, HttpServletResponse response) {
		List json = null;
		try{
			json = this.stationService.queryStation();
		}catch(Exception e){
			SysLogUtil.error("查询所有岗位信息出错");
			e.printStackTrace();
		}
		return json;
		
	}
	
	/**
	 * 方法名: queryRole   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:31:48 
	 * 描述: 权限规则信息分页查询
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/permission.do",method=RequestMethod.POST,params="m=query")
	@ResponseBody  
    public Object queryRule(HttpServletRequest request, HttpServletResponse response){
		PagingJson json = null;
		try{
			int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			String departmentName = request.getParameter("departmentName");
			String stationName = request.getParameter("stationName");
			String roleName = request.getParameter("roleName");
			json = this.permissionService.queryRule(pageIndex, pageSize, departmentName, stationName, roleName);
			SysLogUtil.info("查询权限信息列表");
		}catch(Exception e){
			SysLogUtil.error("查询角色列表信息出错");
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * 方法名: createRule   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:32:41 
	 * 描述: 创建权限规则
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/permission.do",method=RequestMethod.POST,params="m=create")
	@ResponseBody  
    public Object createRule(HttpServletRequest request, HttpServletResponse response){
		ResultJson json = new ResultJson();
		try{			
			String departmentId = request.getParameter("departmentId");
			String stationId = request.getParameter("stationId");
			String roleId = request.getParameter("roleId");
			if(this.permissionService.createRule(departmentId, stationId, roleId)){
				json.setResultCode(0);
				SysLogUtil.info("添加权限规则");
			}else{
				json.setResultCode(1);
				json.setText("权限重复");
			}
		}catch(Exception e){
			json.setResultCode(2);
			SysLogUtil.error("授予系统权限失败");			
		}
		return json;
	}
	
	/**
	 * 方法名: deleteRule   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:33:46 
	 * 描述: 删除权限规则
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/permission.do",method=RequestMethod.POST,params="m=delete")
	@ResponseBody  
    public Object deleteRule(HttpServletRequest request, HttpServletResponse response){
		ResultJson json = new ResultJson();
		try{			
			String departmentId = request.getParameter("departmentId");
			String stationId = request.getParameter("stationId");
			String roleId = request.getParameter("roleId");
			if(this.permissionService.deleteRule(departmentId, stationId, roleId)){
				json.setResultCode(0);
				SysLogUtil.info("取消权限规则");
			}else{
				json.setResultCode(1);
				json.setText("权限不存在");
			}
		}catch(Exception e){
			json.setResultCode(2);
			SysLogUtil.error("解除系统权限失败");			
		}
		return json;
	}
}
