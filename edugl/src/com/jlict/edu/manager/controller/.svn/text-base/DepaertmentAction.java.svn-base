/**
 * 
 */
package com.jlict.edu.manager.controller;


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
import com.jlict.edu.manager.dao.DepartmentVo;
import com.jlict.edu.manager.service.DepartmentService;

/**
 * <p>Title: com.jlict.hrgl.manager.controller.DepaertmentAction.java</p>
 * <p>Description: 部门管理模块控制层</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Controller
public class DepaertmentAction extends BaseAction {
	@Autowired
	DepartmentService departmentService;
	
	/**
	 * 方法名: departmentManagerInit   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午02:53:30 
	 * 描述: 部门管理页面
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/department.do",method=RequestMethod.GET)
	public ModelAndView departmentManagerInit(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/manager/department-manager");
	}
	
	/**
	 * 方法名: departmentCreateInit   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午02:54:20 
	 * 描述: 部门创建页面初始化
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/department.do",method=RequestMethod.GET,params="m=createInit")
	public ModelAndView departmentCreateInit(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/manager/department-create");
	}
	
	/**
	 * 方法名: departmentModifyInit   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午02:54:58 
	 * 描述: 部门修改页面初始化
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/department.do",method=RequestMethod.GET,params="m=modifyInit")
	public ModelAndView departmentModifyInit(HttpServletRequest request, HttpServletResponse response){
		DepartmentVo vo = null;
		try{
			String id = request.getParameter("id");
			vo = this.departmentService.queryDepartmentById(id);
		}catch(Exception e){
			SysLogUtil.error("修改部门初始化错误");
			e.printStackTrace();
		}
		return new ModelAndView("/manager/department-modify","department",vo);
	}
	
	/**
	 * 方法名: queryDepartmentDetail   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午02:55:14 
	 * 描述: 部门详细信息分页查询
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/department.do",method=RequestMethod.POST,params="m=query")
	@ResponseBody  
    public Object queryDepartmentDetail(HttpServletRequest request, HttpServletResponse response) {
		PagingJson json = null;
		try{
			int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			String name = request.getParameter("name");
			int people = Integer.parseInt(request.getParameter("people"));
			json = this.departmentService.queryDepartmentDetail(pageIndex, pageSize, name, people);
			SysLogUtil.info("查询部门信息列表");
		}catch(Exception e){
			SysLogUtil.error("查询部门列表信息出错");
			e.printStackTrace();
		}
		return json;
		
	}	
	
	
	/**
	 * 方法名: updateDepartmentName   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午02:56:17 
	 * 描述: 部门修改
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/department.do",method=RequestMethod.POST,params="m=modify")
	@ResponseBody 
	public Object updateDepartmentName(HttpServletRequest request, HttpServletResponse response){
		ResultJson json=new ResultJson();	
		try{
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			String bossId = request.getParameter("bossId");
			if(this.departmentService.updateName(id, name,bossId)){
				json.setResultCode(0);
				SysLogUtil.info("修改部门信息");
			}
			else{
				json.setResultCode(1);
				json.setText("部门重复");
			}
		}catch(Exception e){
			SysLogUtil.error("修改部门名称异常");
			json.setResultCode(2);
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * 方法名: deleteDepartment   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午02:57:02 
	 * 描述: 部门删除
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/department.do",method=RequestMethod.POST,params="m=delete")
	@ResponseBody 
	public Object deleteDepartment(HttpServletRequest request, HttpServletResponse response){
		ResultJson json=new ResultJson();	
		try{
			String id = request.getParameter("id");
			if(this.departmentService.delete(id)){
				json.setResultCode(0);
				SysLogUtil.info("解散部门");
			}
			else{
				json.setResultCode(1);
				json.setText("部门不存在");
			}
		}catch(Exception e){
			SysLogUtil.error("解散部门异常");
			json.setResultCode(2);
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * 方法名: createDepartment   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午02:57:15 
	 * 描述: 部门创建
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/department.do",method=RequestMethod.POST,params="m=create")
	@ResponseBody 
	public Object createDepartment(HttpServletRequest request, HttpServletResponse response){
		ResultJson json=new ResultJson();	
		try{
			String name = request.getParameter("name");	
			String bossId = request.getParameter("bossId");
			if(this.departmentService.create(name,bossId)){
				json.setResultCode(0);
				SysLogUtil.info("创建部门");
			}
			else{
				json.setResultCode(1);
				json.setText("部门重复");
			}
		}catch(Exception e){
			e.printStackTrace();
			SysLogUtil.error("创建部门异常");
			json.setResultCode(2);
			
		}
		return json;
	}
}
