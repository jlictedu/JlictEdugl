/**
 * 
 */
package com.jlict.edu.teachingQuality.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.teachingQuality.dao.TeachEvaluateDirectorDao;
import com.jlict.edu.teachingQuality.dao.TeachQualityVo;

/**
 * <p>Title: com.jlict.edu.teachingQuality.service.TeachEvaluateDirectorService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Service
public class TeachEvaluateDirectorService
{
	@Autowired
	private TeachEvaluateDirectorDao dao;
	
	/**
	 * 方法名： queryEvaluationsByPanel
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月2日 上午10:31:37
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 PagingJson
	 */
	public PagingJson queryCoursesByPanel(String year, String month, int grade, String departmentId, int pageIndex, int pageSize)
	{
		return this.dao.queryCoursesByPanel(year, month, grade, departmentId, pageIndex, pageSize);
	}
	
	/**
	 * 方法名： openStatus
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月20日 下午2:02:33
	 * 描述：开启课程评估
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean openStatus(String evaluationId)
	{
		return this.dao.openStatus(evaluationId);
	}
	
	/**
	 * 方法名： closeStatus
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月20日 下午2:02:36
	 * 描述：关闭课程评估
	 * 参数：evaluationId：评估ID
	 * 返回类型 boolean
	 */
	public boolean closeStatus(String evaluationId)
	{
		return this.dao.closeStatus(evaluationId);
	}
	
	/**
	 * 方法名： clearStatus
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月20日 下午2:02:38
	 * 描述：清除课程评估
	 * 参数：evaluationId：评估ID
	 * 返回类型 boolean
	 */
	public boolean clearStatus(String evaluationId)
	{
		return this.dao.clearStatus(evaluationId);
	}

	/**
	 * 方法名： queryCourses
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月31日 上午9:28:51
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 PagingJson
	 */
	public PagingJson queryCourses(String year, String month, int grade, String departmentId, int pageIndex, int pageSize)
	{
		return this.dao.queryCourses(year, month, grade, departmentId, pageIndex, pageSize);
	}
	
	/**
	 * 方法名： getHeadInfo
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月16日 下午1:10:04
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object getHeadInfo(String evaluationId) {
		return this.dao.getHeadInfo(evaluationId);
	}

	/**
	 * 方法名： evaluateSubmit
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月16日 下午2:12:07
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ResultJson
	 */
	public boolean evaluationSubmit(String id, String userId, String evaluationTotal, String idea, TeachQualityVo vo)
	{
		return this.dao.evaluationSubmit(id, userId, evaluationTotal, idea, vo);
	}

	/**
	 * 方法名： initData
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月16日 下午2:45:33
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object initData(String userId, String evaluationId) {
		return this.dao.initData(userId, evaluationId);
	}

	/**
	 * 方法名： evaluationSubmit
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月16日 下午3:22:37
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean evaluationSubmit(String id, String evaluationTotal, String idea)
	{
		return this.dao.evaluationSubmit(id, evaluationTotal, idea);
	}

	/**
	 * 方法名： queryEvaluations
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月22日 上午2:22:42
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 PagingJson
	 */
	public PagingJson queryEvaluations(String year, String month, int grade, String departmentId, int pageIndex, int pageSize)
	{
		return this.dao.queryCoursesByPanel(year, month, grade, departmentId, pageIndex, pageSize);
	}
}
