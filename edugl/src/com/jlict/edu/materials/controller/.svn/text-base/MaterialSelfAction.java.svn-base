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
import com.jlict.edu.materials.dao.MaterialSelfVo;
import com.jlict.edu.materials.service.MaterialSelfService;

/**
 * <p>Title: com.jlict.edu.materials.controller.MaterialSelfAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Controller
public class MaterialSelfAction extends BaseAction
{
	@Autowired
	private MaterialSelfService service;
	
	@RequestMapping(value="/materialSelf.do",method=RequestMethod.GET)
	public ModelAndView initMaterialSelfPanel()
	{
		return new ModelAndView("/subscription/materialSelfPanel");
	}
	
	@RequestMapping(value="/materialSelf.do",method=RequestMethod.GET,params="m=addApply")
	public ModelAndView addApply()
	{
		return new ModelAndView("/subscription/materialSelfAddApply");
	}
	
	@RequestMapping(value="/materialSelf.do",method=RequestMethod.POST,params="m=addSubmit")
	@ResponseBody
	public ResultJson addSubmit(HttpServletRequest request, HttpServletResponse response)
	{
		ResultJson result = new ResultJson();
		MaterialSelfVo vo = new MaterialSelfVo();
		Date date = new Date();
		SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
		String applyDate = new SimpleDateFormat("yyyy年mm月dd日").format(date);
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
			vo.setIsbn(request.getParameter("isbn"));
			vo.setMaterialName(request.getParameter("materialName"));
			vo.setEditor(request.getParameter("editor"));
			vo.setPress(request.getParameter("press"));
			vo.setPrice(request.getParameter("price"));
			vo.setCount(Integer.parseInt(request.getParameter("count")));
			vo.setUseClass(request.getParameter("useClass"));
			vo.setYear(sdfYear.format(date));
			vo.setApplyDate(applyDate);
			
			if(this.service.addSubmit(vo))
			{
				result.setResultCode(1);
			}
			
			return result;
		}
		catch(Exception e)
		{
			SysLogUtil.error("添加自编教材申请Action层出错！", e);
			result.setResultCode(0);
			return result;
		}
	}
	
	@RequestMapping(value="/materialSelf.do",method=RequestMethod.POST,params="m=queryApplys")
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
	
	@RequestMapping(value="/materialSelf.do",method=RequestMethod.GET,params="m=initReadApply")
	public ModelAndView initReadApply()
	{
		return new ModelAndView("/subscription/materialSelfReadApply");
	}
	
	@RequestMapping(value="/materialSelf.do",method=RequestMethod.POST,params="m=readApply")
	@ResponseBody
	public MaterialSelfVo readApply(HttpServletRequest request, HttpServletResponse response)
	{
		MaterialSelfVo vo = new MaterialSelfVo();
		
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
	
	@RequestMapping(value="/materialSelf.do",method=RequestMethod.GET,params="m=initUpdateApply")
	public ModelAndView initUpdateApply(HttpServletRequest request, HttpServletResponse response)
	{
		String id = request.getParameter("id");
		MaterialSelfVo vo = this.service.readApply(id);
		
		return new ModelAndView("/subscription/materialSelfUpdateApply", "data", vo);
	}
	
	@RequestMapping(value="/materialSelf.do",method=RequestMethod.POST,params="m=updateApply")
	@ResponseBody
	public ResultJson updateApply(HttpServletRequest request, HttpServletResponse response)
	{
		ResultJson result = new ResultJson();
		MaterialSelfVo vo = new MaterialSelfVo();
		Date date = new Date();
		SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
		String applyDate = new SimpleDateFormat("yyyy年mm月dd日").format(date);
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
			vo.setIsbn(request.getParameter("isbn"));
			vo.setMaterialName(request.getParameter("materialName"));
			vo.setEditor(request.getParameter("editor"));
			vo.setPress(request.getParameter("press"));
			vo.setPrice(request.getParameter("price"));
			if(request.getParameter("count") == null)
			{
				vo.setCount(0);
			}
			else
			{
				vo.setCount(Integer.parseInt (request.getParameter("count")));
			}
			vo.setUseClass(request.getParameter("useClass"));
			vo.setYear(sdfYear.format(date));
			vo.setApplyDate(applyDate);
			
			if(this.service.updateApply(vo))
			{
				result.setResultCode(1);
			}
			
			return result;
		}
		catch(Exception e)
		{
			SysLogUtil.error("修改自编教材申请Action层出错！", e);
			result.setResultCode(0);
			return result;
		}
	}
	
	@RequestMapping(value="/materialSelf.do",method=RequestMethod.POST,params="m=deleteApply")
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
			SysLogUtil.error("查询自编教材申请Action层出错！", e);
			json.setResultCode(0);
			return json;
		}
	}
}
