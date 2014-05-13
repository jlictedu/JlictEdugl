/**
 * 
 */
package com.jlict.edu.teachingQuality.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.core.util.ResultJson;
import com.jlict.edu.teachingQuality.dao.EvaluationDetailOfStudentVo;
import com.jlict.edu.teachingQuality.dao.TeachEvaluateStudentDao;
import com.jlict.edu.teachingQuality.dao.TeachQualityStudentVo;
import com.jlict.edu.teachingQuality.dao.TeachQualityVo;

/**
 * <p>Title: com.jlict.edu.teachingQuality.service.TeachEvaluateStudentService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Service
public class TeachEvaluateStudentService
{
	@Autowired
	private TeachEvaluateStudentDao dao;
	
	/**
	 * 方法名： evaluateSubmit
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月14日 下午5:44:12
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ResultJson
	 */
	public ResultJson evaluateSubmit(TeachQualityVo tqVo, TeachQualityStudentVo tqsVo)
	{
		return dao.evaluateSubmit(tqVo, tqsVo);
	}
	
	/**
	 * 方法名： initCourses
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月17日 下午3:38:32
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 PagingJson
	 * @param userId 
	 * @param deptId 
	 */
	public PagingJson initCourses(String userId, int pageIndex, int pageSize)
	{
		return dao.initCourses(userId, pageIndex, pageSize);
	}

	/**
	 * 方法名： initHeadInfo
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月2日 下午12:15:36
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object initHeadInfo(String deptId, String evaluationId) {
		return this.dao.initHeadInfo(deptId, evaluationId);
	}

	/**
	 * 方法名： initData
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月9日 下午12:31:20
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public EvaluationDetailOfStudentVo initData(String userId, String evaluationId) {
		return this.dao.initData(userId, evaluationId);
	}
}
