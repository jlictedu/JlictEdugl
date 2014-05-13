/**
 * 
 */
package com.jlict.edu.teachingQuality.controller;

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
import com.jlict.edu.teachingQuality.dao.TeachQualityVo;
import com.jlict.edu.teachingQuality.service.TeachEvaluateDirectorService;

/**
 * <p>Title: com.jlict.edu.teachingQuality.controller.TeachEvaluateDirectorAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Controller
public class EvaluateOfDirectorAction extends BaseAction
{
	@Autowired
	private TeachEvaluateDirectorService service;
	
	/**
	 * 方法名： initEvaluate
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月26日 下午1:31:02
	 * 描述：评估操作初始化
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/directorOfEvaluation.do",method=RequestMethod.GET)
	public ModelAndView initEvaluate(HttpServletRequest request, HttpServletResponse response)
	{
		return new ModelAndView("/teachingQuality/directorOfEvaluationPanel");
	}

	/**
	 * 方法名： queryCourses
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月16日 上午10:25:56
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 PagingJson
	 */
	@RequestMapping(value="/directorOfEvaluation.do",method=RequestMethod.POST,params="m=queryEvaluations")
	@ResponseBody
	public PagingJson queryEvaluations(HttpServletRequest request, HttpServletResponse response)
	{
		try
		{
			Date date = new Date();
			String year = new SimpleDateFormat("yyyy").format(date);
			String month = new SimpleDateFormat("MM").format(date);
			String departmentId = this.getDepartmentId(request);
			int grade = Integer.parseInt(request.getParameter("grade"));
			int pageIndex= Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize= Integer.parseInt(request.getParameter("pageSize"));
			
			return this.service.queryCoursesByPanel(year, month, grade, departmentId, pageIndex, pageSize);
		}
		catch(Exception exception)
		{
			SysLogUtil.error("评估设置查询失败", exception);
		}
		
		return null;
	}
	
	/**
	 * 方法名： getHeadInfo
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月16日 下午12:58:07
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	@RequestMapping(value="/directorOfEvaluation.do",method=RequestMethod.POST,params="m=getHeadInfo")
	@ResponseBody
	public Object getHeadInfo(HttpServletRequest request, HttpServletResponse response)
	{
		String evaluationSettingId = request.getParameter("evaluationSettingId");
		
		return this.service.getHeadInfo(evaluationSettingId);
	}
	
	/**
	 * 方法名： evaluate
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月26日 下午1:45:19
	 * 描述：返回空白评估表
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView
	 */
	@RequestMapping(value="/directorOfEvaluation.do",method=RequestMethod.GET,params="m=evaluate")
	public ModelAndView evaluate(HttpServletRequest request, HttpServletResponse response)
	{
		String evaluationSettingId = request.getParameter("evaluationId");
		
		return new ModelAndView("/teachingQuality/directorOfEvaluation", "evaluationSettingId", evaluationSettingId);
	}
	
	/**
	 * 方法名： evaluationSubmit
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月26日 下午1:51:02
	 * 描述：评估提交
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ResultJson
	 */
	@RequestMapping(value="/directorOfEvaluation.do",method=RequestMethod.POST,params="m=evaluationSubmit")
	@ResponseBody
	public ResultJson evaluationSubmit(HttpServletRequest request, HttpServletResponse response)
	{
		ResultJson resultJson = new ResultJson();
		
		try 
		{
			TeachQualityVo vo = new TeachQualityVo();
			boolean result = false;
			String evaluationSettingId = request.getParameter("evaluationSettingId");
			String id = request.getParameter("personEvaluationId");
			String userId = this.getUserId(request);
			String evaluationTotal = request.getParameter("evaluationTotal");
			String idea = request.getParameter("ideaContent");
			
			if(id == null)
			{
				id = UUID.randomUUID().toString();
				vo.setId(UUID.randomUUID().toString());
				vo.setEvaluate_id(id);
				vo.setEvaluate_category(2);
				vo.setEvaluate_setting_id(evaluationSettingId);
				vo.setDate_time(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
				result = this.service.evaluationSubmit(id, userId, evaluationTotal, idea, vo);
			}
			else
			{
				result = this.service.evaluationSubmit(id, evaluationTotal, idea);
			}
			
			if(result)
			{
				resultJson.setResultCode(1);
				resultJson.setText("课堂教学质量评估提交成功！");
			}
			else
			{
				resultJson.setResultCode(0);
				resultJson.setText("课堂教学质量评估提交失败！");
			}
		}
		catch(Exception e)
		{
			resultJson.setResultCode(0);
			resultJson.setText("课堂教学质量评估提交失败！");
			SysLogUtil.error("提交课程评估出错！", e);
		}
		
		return resultJson;
	}
	
	/**
	 * 方法名： initData
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月16日 下午2:45:17
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	@RequestMapping(value="/directorOfEvaluation.do",method=RequestMethod.POST,params="m=initData")
	@ResponseBody
	public Object initData(HttpServletRequest request, HttpServletResponse response)
	{
		String evaluationSettingId = request.getParameter("evaluationSettingId");
		String userId = this.getUserId(request);
		
		return this.service.initData(userId, evaluationSettingId);
	}
}
