package com.jlict.edu.teachingQuality.controller;

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
import com.jlict.edu.teachingQuality.dao.TeachQualityStudentVo;
import com.jlict.edu.teachingQuality.dao.TeachQualityVo;
import com.jlict.edu.teachingQuality.service.TeachEvaluateStudentService;
import com.jlict.edu.teachingQuality.util.GenerateTeachQualityStudentVo;
import com.jlict.edu.teachingQuality.util.GenerateTeachQualityVo;

/**
 * <p>Title: .TeachEvaluateStudentAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Controller
public class TeachEvaluateStudentAction extends BaseAction
{
	@Autowired
	private TeachEvaluateStudentService service;
	
	/**
	 * 方法名： initEvaluate
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月17日 下午2:31:08
	 * 描述：教学质量评估-学生 初始化
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/studentOfEvaluation.do",method=RequestMethod.GET)
	public ModelAndView initEvaluate(HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("/teachingQuality/studentOfEvaluationPanel");
	}
	
	/**
	 * 方法名： initEvaluation
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月26日 下午1:45:19
	 * 描述：返回空白评估表
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/studentOfEvaluation.do",method=RequestMethod.GET,params="m=initEvaluation")
	public ModelAndView initEvaluation(HttpServletRequest request, HttpServletResponse response)
	{
		String evaluationId = request.getParameter("evaluationId");
		
		return new ModelAndView("/teachingQuality/studentOfEvaluation", "evaluationId", evaluationId);
	}
	
	/**
	 * 方法名：evaluateSubmit
	 * 建立者： 孟兆祥 
	 * 建立时间：2014年1月14日 下午3:28:04 
	 * 描述：教学质量评估-学生 提交
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ResultJson       
	 */
	@RequestMapping(value="/studentOfEvaluation.do",method=RequestMethod.POST, params="m=evaluationSubmit")
	@ResponseBody
	public ResultJson evaluateSubmit(HttpServletRequest request, HttpServletResponse response)
	{
		ResultJson resultJson = new ResultJson();
		
		try 
		{
			GenerateTeachQualityStudentVo getRequestData = new GenerateTeachQualityStudentVo(request);
			GenerateTeachQualityVo generateTeachQualityVo = new GenerateTeachQualityVo();
			String evaluateSettingId = request.getParameter("evaluateSettingId");
			TeachQualityVo tqVo = null;
			TeachQualityStudentVo tqsVo = null;

			getRequestData.setVoStudentId(getUserId(request));
			tqsVo = getRequestData.getTeachQualityStudentVo();
			
			generateTeachQualityVo.setEvaluateSettingId(evaluateSettingId);
			tqVo = generateTeachQualityVo.getTeachQualityVo(tqsVo);
			
			resultJson =  this.service.evaluateSubmit(tqVo, tqsVo);
		}
		catch(Exception e)
		{
			resultJson.setResultCode(0);
			resultJson.setText("课堂教学质量评估提交失败！");
			SysLogUtil.error("提交课程评估出错！", e);
			
			return resultJson;
		}
		
		return resultJson;
	}
	
	/**
	 * 方法名： initCourses
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月17日 下午3:16:29
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 PagingJson
	 */
	@RequestMapping(value="/studentOfEvaluation.do",method=RequestMethod.POST, params="m=initCourses")
	@ResponseBody
	public PagingJson initCourses(HttpServletRequest request, HttpServletResponse response)
	{
		PagingJson json = null;
		
		try
		{
			int pageIndex= Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize= Integer.parseInt(request.getParameter("pageSize"));
			String userId = this.getUserId(request);
			
			return this.service.initCourses(userId, pageIndex, pageSize);
		}
		catch(Exception e)
		{
			SysLogUtil.error("返回评估课程信息组错误", e);
		}
		
		return json;
	}
	
	/**
	 * 方法名： readEvaluation
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月17日 下午5:22:43
	 * 描述：阅读质量评估详细
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 PagingJson
	 */
	@RequestMapping(value="/studentOfEvaluation.do",method=RequestMethod.GET, params="m=readEvaluation")
	public ModelAndView readEvaluation(HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("/teachingQuality/teachEvaluateStudent");
	}
	
	/**
	 * 方法名： initHeadInfo
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月3日 上午10:22:45
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	@RequestMapping(value="/studentOfEvaluation.do",method=RequestMethod.POST, params="m=initHeadInfo")
	@ResponseBody
	public Object initHeadInfo(HttpServletRequest request, HttpServletResponse response)
	{
		String evaluationId = request.getParameter("evaluationId");
		String deptId = this.getDepartmentId(request);
		
		return this.service.initHeadInfo(deptId, evaluationId);
	}
	
	/**
	 * 方法名： initData
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月9日 下午2:16:15
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	@RequestMapping(value="/studentOfEvaluation.do",method=RequestMethod.POST,params="m=initData")
	@ResponseBody
	public Object initData(HttpServletRequest request, HttpServletResponse response)
	{
		String evaluationId = request.getParameter("evaluationId");
		String userId = this.getUserId(request);
		
		return this.service.initData(userId, evaluationId);
	}
}
