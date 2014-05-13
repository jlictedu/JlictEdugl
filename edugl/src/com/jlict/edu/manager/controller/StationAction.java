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
import com.jlict.edu.manager.dao.StationVo;
import com.jlict.edu.manager.service.StationService;

/**
 * <p>Title: com.jlict.hrgl.manager.controller.StationAction.java</p>
 * <p>Description: 岗位管理模块控制层</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */

@Controller
public class StationAction extends BaseAction {
	@Autowired
	StationService stationService;

	/**
	 * 方法名: stationManagerInit   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:22:49 
	 * 描述: 部门管理页面
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/station.do",method=RequestMethod.GET)
	public ModelAndView stationManagerInit(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/manager/station-manager");
	}
	
	/**
	 * 方法名: stationCreateInit   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:24:15 
	 * 描述: 岗位创建页面初始化
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/station.do",method=RequestMethod.GET,params="m=createInit")
	public ModelAndView stationCreateInit(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/manager/station-create");
	}
	
	/**
	 * 方法名: stationModifyInit   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:24:17 
	 * 描述: 岗位修改页面初始化
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/station.do",method=RequestMethod.GET,params="m=modifyInit")
	public ModelAndView stationModifyInit(HttpServletRequest request, HttpServletResponse response){
		StationVo vo = null;
		try{
			String id = request.getParameter("id");
			vo = this.stationService.queryStationById(id);
		}catch(Exception e){
			SysLogUtil.error("修改岗位初始化出错");
			e.printStackTrace();
		}
		return new ModelAndView("/manager/station-modify","station",vo);
	}
	
	/**
	 * 方法名: queryStationDetail   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:24:21 
	 * 描述: 岗位详细信息分页查询
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/station.do",method=RequestMethod.POST,params="m=query")
	@ResponseBody  
    public Object queryStationDetail(HttpServletRequest request, HttpServletResponse response){
		PagingJson json = null;
		try{
			int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			String name = request.getParameter("name");
			int people = Integer.parseInt(request.getParameter("people"));
			json = this.stationService.queryStationDetail(pageIndex, pageSize, name, people);
			SysLogUtil.info("查询岗位信息列表");
		}catch(Exception e){
			SysLogUtil.error("查询岗位列表信息出错");
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * 方法名: updateStationName   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:24:23 
	 * 描述: 岗位修改
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/station.do",method=RequestMethod.POST,params="m=modify")
	@ResponseBody 
	public Object updateStationName(HttpServletRequest request, HttpServletResponse response){
		ResultJson json=new ResultJson();	
		try{
			String id = request.getParameter("id");
			String name = request.getParameter("name");
			if(this.stationService.updateName(id, name)){
				json.setResultCode(0);
				SysLogUtil.info("修改岗位信息");
			}
			else{
				json.setResultCode(1);
				json.setText("岗位重复");
			}
		}catch(Exception e){
			SysLogUtil.error("修改岗位名称异常");
			json.setResultCode(2);
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * 方法名: deleteStation   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:24:26 
	 * 描述: 删除岗位
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/station.do",method=RequestMethod.POST,params="m=delete")
	@ResponseBody 
	public Object deleteStation(HttpServletRequest request, HttpServletResponse response){
		ResultJson json=new ResultJson();	
		try{
			String id = request.getParameter("id");
			if(this.stationService.delete(id)){
				json.setResultCode(0);
				SysLogUtil.info("删除岗位");
			}
			else{
				json.setResultCode(1);
				json.setText("岗位不存在");
			}
		}catch(Exception e){
			SysLogUtil.error("取消岗位异常");
			json.setResultCode(2);
			e.printStackTrace();
		}
		return json;
	}
	
	/**
	 * 方法名: createStation   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:24:29 
	 * 描述: 创建岗位
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/station.do",method=RequestMethod.POST,params="m=create")
	@ResponseBody 
	public Object createStation(HttpServletRequest request, HttpServletResponse response){
		ResultJson json=new ResultJson();	
		try{
			String name = request.getParameter("name");			
			if(this.stationService.create(name)){
				json.setResultCode(0);
				SysLogUtil.info("创建岗位");
			}
			else{
				json.setResultCode(1);
				json.setText("岗位重复");
			}
		}catch(Exception e){
			e.printStackTrace();
			SysLogUtil.error("创建岗位异常");
			json.setResultCode(2);
			
		}
		return json;
	}	
}
