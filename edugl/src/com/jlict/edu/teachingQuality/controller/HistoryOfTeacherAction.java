/**
 * 
 */
package com.jlict.edu.teachingQuality.controller;

import java.util.ArrayList;
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
import com.jlict.edu.core.util.SysLogUtil;
import com.jlict.edu.teachingQuality.service.TeachEvaluateTeacherService;

/**
 * <p>Title: com.jlict.edu.teachingQuality.controller.TeachEvaluateTeacherAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Controller
public class HistoryOfTeacherAction extends BaseAction
{
	@Autowired
	private TeachEvaluateTeacherService service;
	
	/**
	 * 方法名： initHistoryPanel
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月15日 上午9:42:57
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/teacherOfHistory.do",method=RequestMethod.GET)
	public ModelAndView initHistoryPanel(HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("/teachingQuality/teacherOfEvaluationHistory");
	}
	
	/**
	 * 方法名： getYears
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月19日 下午1:15:49
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object
	 */
	@RequestMapping(value="/teacherOfHistory.do",method=RequestMethod.POST, params="m=getYears")
	@ResponseBody
	public Object getYears(HttpServletRequest request, HttpServletResponse response)
	{
		List<String> years = new ArrayList<String>();
		
		try
		{
			String userId = this.getUserId(request);
			
			years =  this.service.getYears(userId);
		}
		catch(Exception e)
		{
			SysLogUtil.error("返回教学年份信息组错误", e);
		}
		
		return years;
	}
	
	/**
	 * 方法名： getEvaluations
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月19日 下午1:11:33
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object
	 */
	@RequestMapping(value="/teacherOfHistory.do",method=RequestMethod.POST, params="m=getEvaluations")
	@ResponseBody
	public Object getEvaluations(HttpServletRequest request, HttpServletResponse response)
	{
		PagingJson json = null;
		
		try
		{
			int pageIndex= Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize= Integer.parseInt(request.getParameter("pageSize"));
			String year = request.getParameter("year");
			String term = request.getParameter("term");
			String userId = this.getUserId(request);
			
			return this.service.getEvaluations(userId, year, term, pageIndex, pageSize);
		}
		catch(Exception e)
		{
			SysLogUtil.error("返回评估课程信息组错误", e);
		}
		
		return json;
	}
	
	/**
	 * 方法名： readEvaluations
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月14日 上午11:25:52
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/teacherOfHistory.do",method=RequestMethod.GET, params="m=readEvaluations")
	public ModelAndView readEvaluations(HttpServletRequest request, HttpServletResponse response)
	{
		String evaluationSettingId = request.getParameter("evaluationSettingId");
		
		return new ModelAndView("/teachingQuality/teacherOfEvaluation", "evaluationSettingId", evaluationSettingId);
	}
	
	/**
	 * 方法名： readEvaluation
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月14日 上午11:25:52
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/teacherOfHistory.do",method=RequestMethod.GET, params="m=readEvaluation")
	public ModelAndView readEvaluation(HttpServletRequest request, HttpServletResponse response)
	{
		String evaluationSettingId = request.getParameter("evaluationSettingId");
		
		return new ModelAndView("/teachingQuality/teacherOfDirectorEvaluation", "evaluationSettingId", evaluationSettingId);
	}
}
