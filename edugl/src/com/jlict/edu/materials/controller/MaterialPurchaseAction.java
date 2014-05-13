/**
 * 
 */
package com.jlict.edu.materials.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
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
import com.jlict.edu.materials.dao.ExportExcelVo;
import com.jlict.edu.materials.dao.MaterialItemVo;
import com.jlict.edu.materials.service.MaterialPurchaseService;
import com.jlict.edu.materials.util.ExportExcel;

/**
 * <p>Title: com.jlict.edu.materials.controller.MaterialFirstAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Controller
public class MaterialPurchaseAction extends BaseAction
{
	@Autowired
	private MaterialPurchaseService service;
	
	/**
	 * 方法名： initMaterialPurchasePanel
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月2日 下午4:05:24
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/materialPurchase.do",method=RequestMethod.GET)
	public ModelAndView initMaterialPurchasePanel(HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("/subscription/materialPurchasePanel");
	}
	
	@RequestMapping(value="/materialPurchase.do",method=RequestMethod.GET,params="m=exportExcel")
	public ModelAndView initExportExcel(HttpServletRequest request, HttpServletResponse response)
	{
		ExportExcelVo vo = new ExportExcelVo();
		
		try
		{
			int month = Integer.parseInt(new SimpleDateFormat("mm").format(new Date()));
			String deptId = this.getDepartmentId(request);
			String year = request.getParameter("year");
			List<?> list = this.service.queryApplys(year, deptId);	
			String[] rowName = {"序号", "课程名称", "课程属性", "本季征订代号或ISBN号", "教材名称", "编者", "版次", "出版社", "订购数量-学生", "订购数量-教师", "使用班级", "联系人（电话）"};
			String[] getterAtt = {"CourseName", "CourseProperty", "Isbn", "MaterialName", "Editor", "Revision", "Press", "StudentCount", "TeacherCount", "UseClass", "Tel"};
			
			vo.setYear(request.getParameter("year"));
			if(month<9)
			{
				vo.setSeason("秋季");
			}
			else
			{
				vo.setSeason("春季");
			}
			String headName = "吉林化工学院" + vo.getYear() + "年-" + vo.getSeason() + " 教材征订表";
			ExportExcel ee = new ExportExcel(list, headName, rowName, getterAtt);
			vo.setUrl(ee.exportExcel());
		}
		catch(Exception e)
		{
			SysLogUtil.error("导出教材征订Action层出错！", e);
		}
		
		return new ModelAndView("/subscription/exportExcel", "data", vo);
	}
	
	/**
	 * 方法名： purchase
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月2日 下午4:48:44
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ResultJson
	 */
	@RequestMapping(value="/materialPurchase.do",method=RequestMethod.POST,params="m=purchase")
	@ResponseBody
	public ResultJson purchase(HttpServletRequest request, HttpServletResponse response)
	{
		ResultJson json = new ResultJson();
		
		try
		{
			String id = request.getParameter("id");
			
			if(this.service.purchase(id))
			{
				json.setResultCode(1);
			}
			
			return json;
		}
		catch(Exception e)
		{
			SysLogUtil.error("删除教材征订Action层出错！", e);
			json.setResultCode(0);
			return json;
		}
	}
	
	@RequestMapping(value="/materialPurchase.do",method=RequestMethod.POST,params="m=queryApplys")
	@ResponseBody
	public PagingJson queryApplys(HttpServletRequest request, HttpServletResponse response)
	{
		PagingJson json = new PagingJson();
		
		try
		{
			String deptId = this.getDepartmentId(request);
			String year = request.getParameter("year");
			int pageIndex= Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize= Integer.parseInt(request.getParameter("pageSize"));
			
			json = this.service.queryApplys(year, deptId, pageIndex, pageSize);
		}
		catch(Exception e)
		{
			SysLogUtil.error("查询教材征订Action层出错！", e);
		}
		
		return json;
	}
	
	@RequestMapping(value="/materialPurchase.do",method=RequestMethod.GET,params="m=initReadApply")
	public ModelAndView initReadApply(HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("/subscription/materialPurchaseReadApply");
	}
	
	@RequestMapping(value="/materialPurchase.do",method=RequestMethod.POST,params="m=readApply")
	@ResponseBody
	public MaterialItemVo readApply(HttpServletRequest request, HttpServletResponse response)
	{
		MaterialItemVo vo = new MaterialItemVo();
		
		try
		{
			String id = request.getParameter("id");
			
			vo = this.service.readApply(id);
		}
		catch(Exception e)
		{
			SysLogUtil.error("阅读教材征订Action层出错！", e);
		}
		
		return vo;
	}
}
