/**
 * 
 */
package com.jlict.edu.teachingQuality.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.teachingQuality.dao.TeachEvaluateTeacherDao;

/**
 * <p>Title: com.jlict.edu.teachingQuality.service.TeachEvaluateTeacherService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Service
public class TeachEvaluateTeacherService
{
	@Autowired
	private TeachEvaluateTeacherDao dao;
	
	/**
	 * 方法名： getYears
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月19日 下午1:14:32
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 List<String>
	 */
	public List<String> getYears(String userId)
	{
		return this.dao.getYears(userId);
	}
	
	/**
	 * 方法名： getCourses
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月19日 下午1:14:27
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 List<String>
	 */
	public List<String> getCourses(String userId)
	{
		return this.dao.getCourses(userId);
	}

	/**
	 * 方法名： initCourses
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月10日 上午10:25:21
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 PagingJson
	 */
	public PagingJson initCourses(String userId, int pageIndex, int pageSize)
	{
		return this.dao.initCourses(userId, pageIndex, pageSize);
	}

	/**
	 * 方法名： readEvaluations
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月14日 上午10:46:15
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public List<String> readEvaluations(String evaluationSettingId)
	{
		return this.dao.readEvaluations(evaluationSettingId);
	}

	/**
	 * 方法名： initHeadInfo
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月14日 下午3:35:56
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object initHeadInfo(String evaluationId)
	{
		return this.dao.initHeadInfo(evaluationId);
	}
	
	/**
	 * 方法名： initData
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月14日 下午4:25:48
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object initData(String evaluationId)
	{
		return this.dao.initData(evaluationId);
	}

	/**
	 * 方法名： getEvaluations
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月15日 下午3:03:43
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object getEvaluations(String userId, String year, String term, int pageIndex, int pageSize)
	{
		return this.dao.getEvaluations(userId, year, term, pageIndex, pageSize);
	}

	/**
	 * 方法名： initDataByDirector
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月22日 上午3:34:05
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object initDataByDirector(String evaluationSettingId)
	{
		return this.dao.initDataByDirector(evaluationSettingId);
	}

	/**
	 * 方法名： initHeadInfoByDirector
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月22日 上午3:51:25
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object initHeadInfoByDirector(String evaluationSettingId)
	{
		return this.dao.initHeadInfoByDirector(evaluationSettingId);
	}
}
