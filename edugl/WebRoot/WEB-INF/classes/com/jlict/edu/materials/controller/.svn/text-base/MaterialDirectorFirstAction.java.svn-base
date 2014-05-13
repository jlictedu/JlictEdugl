/**
 * 
 */
package com.jlict.edu.materials.controller;

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
import com.jlict.edu.materials.dao.MaterialFirstItemVo;
import com.jlict.edu.materials.service.MaterialDirectorFirstService;

/**
 * <p>Title: com.jlict.edu.materials.controller.MaterialFirstAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Controller
public class MaterialDirectorFirstAction extends BaseAction
{
	@Autowired
	private MaterialDirectorFirstService service;
	
	/**
	 * 方法名： initMaterialFirstPanel
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月2日 下午1:24:32
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/materialDirectorFirst.do",method=RequestMethod.GET)
	public ModelAndView initMaterialFirstPanel(HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("/subscription/materialDirectorFirstPanel");
	}

	/**
	 * 方法名： initApproval
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月2日 下午1:24:02
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/materialDirectorFirst.do",method=RequestMethod.GET,params="m=initApproval")
	public ModelAndView initApproval(HttpServletRequest request, HttpServletResponse response)
	{
		MaterialFirstItemVo vo = this.readApproval(request, response);
		return new ModelAndView("/subscription/materialDirectorFirstApproval", "data", vo);
	}

	/**
	 * 方法名： approval
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月2日 下午1:23:52
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ResultJson
	 */
	@RequestMapping(value="/materialDirectorFirst.do",method=RequestMethod.POST,params="m=approval")
	@ResponseBody
	public ResultJson approval(HttpServletRequest request, HttpServletResponse response)
	{
		ResultJson result = new ResultJson();
		String id = request.getParameter("id");
		String approvalAction = request.getParameter("approvalAction");
		
		try
		{
			if(this.service.approval(id, approvalAction))
			{
				result.setResultCode(1);
			}
			
			return result;
		}
		catch(Exception e)
		{
			SysLogUtil.error("首次教材审批Action层出错！", e);
			result.setResultCode(0);
			return result;
		}
	}
	
	/**
	 * 方法名： queryApplys
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月2日 下午1:22:28
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 PagingJson
	 */
	@RequestMapping(value="/materialDirectorFirst.do",method=RequestMethod.POST,params="m=queryApplys")
	@ResponseBody
	public PagingJson queryApplys(HttpServletRequest request, HttpServletResponse response)
	{
		PagingJson json = new PagingJson();
		
		try
		{
			String year = request.getParameter("year");
			String deptId = this.getDepartmentId(request);
			int pageIndex= Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize= Integer.parseInt(request.getParameter("pageSize"));
			
			json = this.service.queryApplys(year, deptId, pageIndex, pageSize);
		}
		catch(Exception e)
		{
			SysLogUtil.error("查询首次教材申请Action层出错！", e);
		}
		
		return json;
	}
	
	/**
	 * 方法名： initReadApply
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月2日 下午1:21:59
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/materialDirectorFirst.do",method=RequestMethod.GET,params="m=initReadApproval")
	public ModelAndView initReadApply(HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("/subscription/materialDirectorFirstReadApproval");
	}
	
	/**
	 * 方法名： readApproval
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月2日 下午1:24:45
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 MaterialFirstItemVo
	 */
	@RequestMapping(value="/materialDirectorFirst.do",method=RequestMethod.POST,params="m=readApply")
	@ResponseBody
	public MaterialFirstItemVo readApproval(HttpServletRequest request, HttpServletResponse response)
	{
		MaterialFirstItemVo vo = new MaterialFirstItemVo();
		
		try
		{
			String id = request.getParameter("id");
			
			vo = this.service.readApproval(id);
		}
		catch(Exception e)
		{
			SysLogUtil.error("阅读首次教材申请Action层出错！", e);
		}
		
		return vo;
	}
}
