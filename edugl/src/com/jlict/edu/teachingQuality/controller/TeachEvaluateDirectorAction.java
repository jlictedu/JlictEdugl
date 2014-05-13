/**
 * 
 */
package com.jlict.edu.teachingQuality.controller;

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
import com.jlict.edu.teachingQuality.service.TeachEvaluateDirectorService;
import com.jlict.edu.teachingQuality.service.TeachEvaluateTeacherService;

/**
 * <p>Title: com.jlict.edu.teachingQuality.controller.TeachEvaluateDirectorAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Controller
public class TeachEvaluateDirectorAction extends BaseAction
{
	@Autowired
	private TeachEvaluateDirectorService service;
	@Autowired
	private TeachEvaluateTeacherService tetService;
	
	/**
	 * 方法名: initSetting
	 * 建立者： 孟兆祥 
	 * 建立时间：2014年1月10日 上午11:26:17 
	 * 描述：评估设置初始化 
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/evaluateSetting.do",method=RequestMethod.GET)
	public ModelAndView initSetting(HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("/teachingQuality/setting");
	}
	
	/**
	 * 方法名: queryCourses
	 * 建立者： 孟兆祥 
	 * 建立时间：2014年1月10日 下午4:15:38 
	 * 描述: 查询所有可以操作评估的课程
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object
	 */
	@RequestMapping(value="/evaluateSetting.do",method=RequestMethod.POST,params="m=queryCourses")
	@ResponseBody
	public PagingJson queryCourses(HttpServletRequest request, HttpServletResponse response)
	{
		PagingJson json = null;
		
		try
		{
			Date date = new Date();
			String year = new SimpleDateFormat("yyyy").format(date);
			String month = new SimpleDateFormat("MM").format(date);
			String departmentId = this.getDepartmentId(request);
			int grade = Integer.parseInt(request.getParameter("grade"));
			int pageIndex= Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize= Integer.parseInt(request.getParameter("pageSize"));
			
			json = this.service.queryCourses(year, month, grade, departmentId, pageIndex, pageSize);
		}
		catch(Exception exception)
		{
			SysLogUtil.error("评估设置查询失败", exception);
		}
		
		return json;
	}
	
	/**
	 * 方法名： openStatus
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月19日 下午3:58:05
	 * 描述：开启评估
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object
	 */
	@RequestMapping(value="/evaluateSetting.do",method=RequestMethod.POST,params="m=openStatus")
	@ResponseBody
	public ResultJson openStatus(HttpServletRequest request, HttpServletResponse response)
	{
		ResultJson result = new ResultJson();
		
		try
		{
			String evaluationId = request.getParameter("evaluationId");
			
			this.service.openStatus(evaluationId);
			result.setResultCode(1);
			result.setText(evaluationId);
		}
		catch(Exception e)
		{
			result.setResultCode(0);
			SysLogUtil.error("开启课程评估失败", e);
		}
		
		return result;
	}
	
	/**
	 * 方法名： closeStatus
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月19日 下午4:19:39
	 * 描述：关闭评估
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object
	 */
	@RequestMapping(value="/evaluateSetting.do",method=RequestMethod.POST,params="m=closeStatus")
	@ResponseBody
	public ResultJson closeStatus(HttpServletRequest request, HttpServletResponse response)
	{
		ResultJson result = new ResultJson();
		
		try
		{
			String evaluationId = request.getParameter("evaluationId");
			
			if(this.service.closeStatus(evaluationId))
			{
				result.setResultCode(1);
			}
			else
			{
				result.setResultCode(0);
			}
		}
		catch(Exception e)
		{
			result.setResultCode(0);
			SysLogUtil.error("关闭课程评估失败", e);
		}
		
		return result;
	}
	
	/**
	 * 方法名： clearStatus
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月19日 下午4:19:46
	 * 描述：清除评估
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object
	 */
	@RequestMapping(value="/evaluateSetting.do",method=RequestMethod.POST,params="m=clearStatus")
	@ResponseBody
	public ResultJson clearStatus(HttpServletRequest request, HttpServletResponse response)
	{
		ResultJson result = new ResultJson();
		
		try
		{
			String evaluationId = request.getParameter("evaluationId");
			
			if(this.service.clearStatus(evaluationId))
				result.setResultCode(1);
			else
				result.setResultCode(0);
		}
		catch(Exception e)
		{
			result.setResultCode(0);
			SysLogUtil.error("清除课程评估失败", e);
		}
		
		return result;
	}
	
	/**
	 * 方法名： readEvaluationHistory
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月26日 下午6:04:07
	 * 描述：返回评估详细记录
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/directorOfEvaluationHistory.do",method=RequestMethod.POST,params="readEvaluationHistory")
	public ModelAndView readEvaluationHistory(HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("/teachingQuality/directorOfEvaluationHistory");
	}
	
	/**
	 * 方法名： initEvaluationsInfo
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月26日 下午2:16:53
	 * 描述：初始化评估信息查询
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/directorOfEvaluationsInfo.do",method=RequestMethod.GET)
	public ModelAndView initEvaluationsInfo(HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("/teachingQuality/directorOfEvaluationsInfo");
	}
	
	/**
	 * 方法名： queryEvaluations
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月26日 下午5:46:46
	 * 描述：返回指定年份、学期、课程所有的评估记录
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 PagingJson
	 */
	@RequestMapping(value="/directorOfEvaluationsInfo.do",method=RequestMethod.POST,params="m=queryEvaluations")
	@ResponseBody
	public PagingJson queryEvaluations(HttpServletRequest request, HttpServletResponse response)
	{
		PagingJson json = null;
		
		try
		{
			Date date = new Date();
			String year = new SimpleDateFormat("yyyy").format(date);
			String month = new SimpleDateFormat("MM").format(date);
			String departmentId = this.getDepartmentId(request);
			int grade = Integer.parseInt(request.getParameter("grade"));
			int pageIndex= Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize= Integer.parseInt(request.getParameter("pageSize"));
			
			json = this.service.queryEvaluations(year, month, grade, departmentId, pageIndex, pageSize);
		}
		catch(Exception exception)
		{
			SysLogUtil.error("评估设置查询失败", exception);
		}
		
		return json;
	}
	
	/**
	 * 方法名： readEvaluations
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月22日 上午2:38:58
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/directorOfEvaluationsInfo.do",method=RequestMethod.GET, params="m=readEvaluations")
	public ModelAndView readEvaluations(HttpServletRequest request, HttpServletResponse response)
	{
		String evaluationSettingId = request.getParameter("evaluationSettingId");
		
		return new ModelAndView("/teachingQuality/directorOfStudentEvaluation", "evaluationSettingId", evaluationSettingId);
	}
	
	/**
	 * 方法名： readEvaluation
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月22日 上午2:38:58
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/directorOfEvaluationsInfo.do",method=RequestMethod.GET, params="m=readEvaluation")
	public ModelAndView readEvaluation(HttpServletRequest request, HttpServletResponse response)
	{
		String evaluationSettingId = request.getParameter("evaluationSettingId");
		
		return new ModelAndView("/teachingQuality/directorOfDirectorEvaluation", "evaluationSettingId", evaluationSettingId);
	}
	
	/**
	 *  方法名： initData
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月15日 上午9:41:05
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	@RequestMapping(value="/directorOfEvaluationsInfo.do",method=RequestMethod.POST,params="m=initData")
	@ResponseBody
	public Object initData(HttpServletRequest request, HttpServletResponse response)
	{
		String evaluationId = request.getParameter("evaluationId");
		
		return this.tetService.initData(evaluationId);
	}
	
	/**
	 *  方法名： initDataByDirector
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月15日 上午9:41:05
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	@RequestMapping(value="/directorOfEvaluationsInfo.do",method=RequestMethod.POST,params="m=initDataByDirector")
	@ResponseBody
	public Object initDataByDirector(HttpServletRequest request, HttpServletResponse response)
	{
		String evaluationSettingId = request.getParameter("evaluationSettingId");
		
		return this.tetService.initDataByDirector(evaluationSettingId);
	}
	
	/**
	 * 方法名： initHeadInfo
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月14日 下午3:34:51
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	@RequestMapping(value="/directorOfEvaluationsInfo.do",method=RequestMethod.POST, params="m=initHeadInfo")
	@ResponseBody
	public Object initHeadInfo(HttpServletRequest request, HttpServletResponse response)
	{
		String evaluationId = request.getParameter("evaluationId");
		
		return this.tetService.initHeadInfo(evaluationId);
	}
	
	/**
	 * 方法名： initHeadInfoByDirector
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月14日 下午3:34:51
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	@RequestMapping(value="/directorOfEvaluationsInfo.do",method=RequestMethod.POST, params="m=initHeadInfoByDirector")
	@ResponseBody
	public Object initHeadInfoByDirector(HttpServletRequest request, HttpServletResponse response)
	{
		String evaluationSettingId = request.getParameter("evaluationSettingId");
		
		return this.tetService.initHeadInfoByDirector(evaluationSettingId);
	}
	
	/**
	 * 方法名： getEvaluationIds
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月14日 上午11:35:02
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	@RequestMapping(value="/directorOfEvaluationsInfo.do",method=RequestMethod.POST, params="m=getEvaluationIds")
	@ResponseBody
	public Object getEvaluationIds(HttpServletRequest request, HttpServletResponse response)
	{
		String evaluationSettingId = request.getParameter("evaluationSettingId");
		List<String> evaluationIds = this.tetService.readEvaluations(evaluationSettingId);
		
		return evaluationIds;
	}
}
