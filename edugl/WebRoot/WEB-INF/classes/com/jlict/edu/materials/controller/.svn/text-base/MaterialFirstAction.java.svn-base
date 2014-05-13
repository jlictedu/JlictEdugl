/**
 * 
 */
package com.jlict.edu.materials.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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
import com.jlict.edu.materials.dao.MaterialFirstVo;
import com.jlict.edu.materials.service.MaterialFirstService;

/**
 * <p>Title: com.jlict.edu.materials.controller.MaterialFirstAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Controller
public class MaterialFirstAction extends BaseAction
{
	@Autowired
	private MaterialFirstService service;
	
	@RequestMapping(value="/materialFirst.do",method=RequestMethod.GET)
	public ModelAndView initMaterialSelfPanel()
	{
		return new ModelAndView("/subscription/materialFirstPanel");
	}
	
	@RequestMapping(value="/materialFirst.do",method=RequestMethod.GET,params="m=addApply")
	public ModelAndView addApply()
	{
		return new ModelAndView("/subscription/materialFirstAddApply");
	}
	
	@RequestMapping(value="/materialFirst.do",method=RequestMethod.POST,params="m=addSubmit")
	@ResponseBody
	public ResultJson addSubmit(HttpServletRequest request, HttpServletResponse response)
	{
		ResultJson result = new ResultJson();
		MaterialFirstVo vo = new MaterialFirstVo();
		Date date = new Date();
		SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
		int month = Integer.parseInt(new SimpleDateFormat("mm").format(date));
		
		if(month >=3 && month < 9)
		{
			vo.setSeason("0");
		}
		else
		{
			vo.setSeason("1");
		}
		
		try
		{
			vo.setId(UUID.randomUUID().toString());
			vo.setUserId(this.getUserId(request));
			vo.setCourseName(request.getParameter("courseName"));
			vo.setCourseProperty(request.getParameter("courseProperty"));
			vo.setIsbn(request.getParameter("isbn"));
			vo.setMaterialName(request.getParameter("materialName"));
			vo.setEditor(request.getParameter("editor"));
			vo.setRevision(request.getParameter("revision"));
			vo.setPress(request.getParameter("press"));
			vo.setTel(request.getParameter("tel"));
			vo.setStudentCount(Integer.parseInt(request.getParameter("studentCount")));
			vo.setTeacherCount(Integer.parseInt(request.getParameter("teacherCount")));
			vo.setUseClass(request.getParameter("useClass"));
			vo.setYear(sdfYear.format(date));
			vo.setApplyDate(new SimpleDateFormat("yyyy年mm月dd日").format(date));
			
			if(this.service.addSubmit(vo))
			{
				result.setResultCode(1);
			}
			
			return result;
		}
		catch(Exception e)
		{
			result.setResultCode(0);
			SysLogUtil.error("添加首次教材申请Action层出错！", e);
			return result;
		}
	}
	
	@RequestMapping(value="/materialFirst.do",method=RequestMethod.POST,params="m=queryApplys")
	@ResponseBody
	public PagingJson queryApplys(HttpServletRequest request, HttpServletResponse response)
	{
		PagingJson json = new PagingJson();
		
		try
		{
			String userId = this.getUserId(request);
			String year = request.getParameter("year");
			int pageIndex= Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize= Integer.parseInt(request.getParameter("pageSize"));
			
			json = this.service.queryApplys(year, userId, pageIndex, pageSize);
		}
		catch(Exception e)
		{
			SysLogUtil.error("查询自编教材申请Action层出错！", e);
		}
		
		return json;
	}
	
	@RequestMapping(value="/materialFirst.do",method=RequestMethod.GET,params="m=initReadApply")
	public ModelAndView initReadApply()
	{
		return new ModelAndView("/subscription/materialFirstReadApply");
	}
	
	@RequestMapping(value="/materialFirst.do",method=RequestMethod.POST,params="m=readApply")
	@ResponseBody
	public MaterialFirstItemVo readApply(HttpServletRequest request, HttpServletResponse response)
	{
		MaterialFirstItemVo vo = new MaterialFirstItemVo();
		
		try
		{
			String id = request.getParameter("id");
			
			vo = this.service.readApply(id);
		}
		catch(Exception e)
		{
			SysLogUtil.error("阅读自编教材申请Action层出错！", e);
		}
		
		return vo;
	}
	
	@RequestMapping(value="/materialFirst.do",method=RequestMethod.GET,params="m=initUpdateApply")
	public ModelAndView initUpdateApply(HttpServletRequest request, HttpServletResponse response)
	{
		String id = request.getParameter("id");
		MaterialFirstItemVo vo = this.service.readApply(id);
		
		return new ModelAndView("/subscription/materialFirstUpdateApply", "data", vo);
	}
	
	@RequestMapping(value="/materialFirst.do",method=RequestMethod.POST,params="m=updateApply")
	@ResponseBody
	public ResultJson updateApply(HttpServletRequest request, HttpServletResponse response)
	{
		ResultJson result = new ResultJson();
		MaterialFirstVo vo = new MaterialFirstVo();
		Date date = new Date();
		SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
		int month = Integer.parseInt(new SimpleDateFormat("mm").format(date));
		
		if(month >=3 && month < 9)
		{
			vo.setSeason("0");
		}
		else
		{
			vo.setSeason("1");
		}
		
		try
		{
			vo.setId(request.getParameter("id"));
			vo.setUserId(this.getUserId(request));
			vo.setCourseName(request.getParameter("courseName"));
			vo.setCourseProperty(request.getParameter("courseProperty"));
			vo.setIsbn(request.getParameter("isbn"));
			vo.setMaterialName(request.getParameter("materialName"));
			vo.setEditor(request.getParameter("editor"));
			vo.setRevision(request.getParameter("revision"));
			vo.setPress(request.getParameter("press"));
			vo.setTel(request.getParameter("tel"));
			vo.setStudentCount(Integer.parseInt(request.getParameter("studentCount")));
			vo.setTeacherCount(Integer.parseInt(request.getParameter("teacherCount")));
			vo.setUseClass(request.getParameter("useClass"));
			vo.setYear(sdfYear.format(date));
			vo.setApplyDate(new SimpleDateFormat().format(date));
			
			if(this.service.updateApply(vo))
			{
				result.setResultCode(1);
			}
			
			return result;
		}
		catch(Exception e)
		{
			result.setResultCode(0);
			SysLogUtil.error("添加首次教材申请Action层出错！", e);
			return result;
		}
	}
	
	@RequestMapping(value="/materialFirst.do",method=RequestMethod.POST,params="m=deleteApply")
	@ResponseBody
	public ResultJson deleteApply(HttpServletRequest request, HttpServletResponse response)
	{
		ResultJson json = new ResultJson();
		
		try
		{
			String id = request.getParameter("id");
			
			if(this.service.deleteApply(id))
			{
				json.setResultCode(1);
			}
			
			return json;
		}
		catch(Exception e)
		{
			SysLogUtil.error("查询首次教材申请Action层出错！", e);
			json.setResultCode(0);
			return json;
		}
	}
}
