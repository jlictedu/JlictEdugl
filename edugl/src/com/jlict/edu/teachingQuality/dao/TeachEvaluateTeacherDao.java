/**
 * 
 */
package com.jlict.edu.teachingQuality.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.core.util.SysLogUtil;

/**
 * <p>Title: com.jlict.edu.teachingQuality.dao.TeachEvaluateTeacherDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Repository
public class TeachEvaluateTeacherDao extends BaseDao
{
	/**
	 * 方法名： getYears
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月19日 下午12:59:52
	 * 描述：返回该用户所有教学年份
	 * 参数：para 说明：TODO
	 * 返回类型 List<String>
	 */
	public List<String> getYears(String userId)
	{
		try
		{
			String sql = "SELECT SCHOOL_YEAR FROM (SELECT GET_SCHOOL_YEAR(S.YEAR, S.TERM) AS SCHOOL_YEAR FROM T_EVALUATE_SETTING S WHERE S.TEACHER_ID = ?) GROUP BY SCHOOL_YEAR ORDER BY SCHOOL_YEAR";
			Object[] para = {userId};
			
			return this.jdbcTemplate.queryForList(sql, para, String.class);
		}
		catch(Exception e)
		{
			SysLogUtil.error(e);
			return null;
		}
	}
	
	/**
	 * 方法名： getCourses
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月19日 下午1:14:08
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 List<String>
	 */
	public List<String> getCourses(String userId)
	{
		return null;
	}

	/**
	 * 方法名： initCourses
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月10日 上午10:25:49
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 PagingJson
	 */
	public PagingJson initCourses(String userId, int pageIndex, int pageSize)
	{
		try
		{
			String countSql = "SELECT COUNT(S.ID) " +
										"FROM T_EVALUATE_SETTING S, T_USER U, T_DEPARTMENT D " +
										"WHERE S.TEACHER_ID = U.USER_ID AND S.DEPARTMENT_ID = D.DEPT_ID AND S.TEACHER_ID = ? AND S.STATUS = '1'";
			String querySql = "SELECT S.ID EVALUATION_ID, S.COURSE_ID ID, S.CODING, S.COURSE_NAME, S.COURSE_PROPERTY ATTRIBUTE, S.COURSE_EXAM EXAM, S.TERM, S.YEAR, S.STATUS, S.TEACHER_ID, U.NAME TEACHER_NAME, D.DEPT_ID, D.DEPT_NAME " +
										"FROM T_EVALUATE_SETTING S, T_USER U, T_DEPARTMENT D " +
										"WHERE S.TEACHER_ID = U.USER_ID AND S.DEPARTMENT_ID = D.DEPT_ID AND S.TEACHER_ID = ? AND S.STATUS = '1'";
			Object[] para = {userId};
			
			return this.queryPagingList(countSql, querySql, para, pageIndex, pageSize, new EvaluationSettingItemRow());
		}
		catch(Exception e)
		{
			SysLogUtil.error(e);
			return null;
		}
	}

	/**
	 * 方法名： readEvaluations
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月14日 上午10:46:46
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public List<String> readEvaluations(String evaluationSettingId)
	{
		try
		{
			String sql = "SELECT Q.EVALUATE_ID FROM T_TEACH_QUALITY Q WHERE Q.EVALUATE_SETTING_ID = ? AND Q.EVALUATE_CATEGORY = '1'";
			Object[] para = {evaluationSettingId};
			
			return this.jdbcTemplate.queryForList(sql, para, String.class);
		}
		catch(Exception e)
		{
			SysLogUtil.error(e);
			return null;
		}
	}

	/**
	 * 方法名： initHeadInfo
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月14日 下午3:36:21
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object initHeadInfo(String evaluationId)
	{
		try
		{
			String sql = "SELECT C.NAME COURSE_NAME, U.NAME TEACHER_NAME, D.DEPT_NAME ATTEND_CLASS " + 
								"FROM T_EVALUATE_SETTING S, T_USER U, T_DEPARTMENT D, T_CURRICULA C " +
								"WHERE S.ID IN (SELECT Q.EVALUATE_SETTING_ID FROM T_TEACH_QUALITY Q WHERE Q.EVALUATE_ID = ?) " +
								"AND S.COURSE_ID = C.ID " +
								"AND S.TEACHER_ID = U.USER_ID " +
								"AND D.DEPT_ID = S.DEPARTMENT_ID";
			Object[] para = {evaluationId};
			EvaluateHeadInfoOfStudentVo vo = this.jdbcTemplate.queryForObject(sql, para, new EvaluateHeadInfoOfStudentRowMapper());
			
			vo.setEducationCollege(getEducationCollege(evaluationId));
			return vo;
			
		}
		catch(Exception e)
		{
			SysLogUtil.error(e);
			return null;
		}
	}
	
	/**
	 * 方法名： initHeadInfoByDirector
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月14日 下午3:36:21
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object initHeadInfoByDirector(String evaluationSettingId)
	{
		try
		{
			String sql = "SELECT C.NAME COURSE_NAME, U.NAME TEACHER_NAME, D.DEPT_NAME ATTEND_CLASS " + 
					"FROM T_EVALUATE_SETTING S, T_USER U, T_DEPARTMENT D, T_CURRICULA C " +
					"WHERE S.ID = ? " +
					"AND S.COURSE_ID = C.ID " +
					"AND S.TEACHER_ID = U.USER_ID " +
					"AND D.DEPT_ID = S.DEPARTMENT_ID";
			Object[] para = {evaluationSettingId};
			EvaluateHeadInfoOfStudentVo vo = this.jdbcTemplate.queryForObject(sql, para, new EvaluateHeadInfoOfStudentRowMapper());
			
			vo.setEducationCollege(getEducationCollegeByDirector(evaluationSettingId));
			return vo;
			
		}
		catch(Exception e)
		{
			SysLogUtil.error(e);
			return null;
		}
	}
	
	/**
	 * 方法名： getEducationCollege
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月14日 下午3:49:58
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 String
	 */
	private String getEducationCollege(String evaluationId)
	{
		String sql = "SELECT D.DEPT_NAME FROM T_DEPARTMENT D WHERE D.DEPT_ID IN " + 
							"(SELECT D.BOSS_DEPT_ID FROM T_DEPARTMENT D WHERE D.DEPT_ID IN " + 
							"(SELECT D.BOSS_DEPT_ID FROM T_DEPARTMENT D WHERE D.DEPT_ID IN " + 
							"(SELECT S.DEPARTMENT_ID FROM T_EVALUATE_SETTING S WHERE S.ID IN " + 
							"(SELECT Q.EVALUATE_SETTING_ID FROM T_TEACH_QUALITY Q WHERE Q.EVALUATE_ID = ?))))";
		Object[] para = {evaluationId};
		
		return this.jdbcTemplate.queryForObject(sql, String.class, para);
	}
	
	/**
	 * 方法名： getEducationCollegeByDirector
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月14日 下午3:49:58
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 String
	 */
	private String getEducationCollegeByDirector(String evaluationSettingId)
	{
		String sql = "SELECT D.DEPT_NAME FROM T_DEPARTMENT D WHERE D.DEPT_ID IN " + 
							"(SELECT D.BOSS_DEPT_ID FROM T_DEPARTMENT D WHERE D.DEPT_ID IN " + 
							"(SELECT D.BOSS_DEPT_ID FROM T_DEPARTMENT D WHERE D.DEPT_ID IN " + 
							"(SELECT S.DEPARTMENT_ID FROM T_EVALUATE_SETTING S WHERE S.ID = ?)))";
		Object[] para = {evaluationSettingId};
		
		return this.jdbcTemplate.queryForObject(sql, String.class, para);
	}

	/**
	 * 方法名： initData
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月14日 下午4:26:30
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object initData(String evaluationId)
	{
		try
		{
			String sql = "SELECT ID, STU_ID, TA_EI1, TA_EI2, TC_EI1, TC_EI2, TC_EI3, TC_EI4, TC_EI5, TM_EI1, TM_EI2, TM_EI3, TE_EI1, IDEA " + 
								"FROM T_TEACH_QUALITY_STU S WHERE S.ID = ? "; 
			Object[] para = {evaluationId};
			
			return this.jdbcTemplate.queryForObject(sql, para, new EvaluationDetailOfStudentRowMapper());
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	/**
	 * 方法名： getEvaluations
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月15日 下午3:04:18
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object getEvaluations(String userId, String year, String term, int pageIndex, int pageSize)
	{
		try
		{
			String countSql = "SELECT COUNT(S.ID) " +
										"FROM T_EVALUATE_SETTING S, T_USER U, T_DEPARTMENT D " +
										"WHERE S.TEACHER_ID = U.USER_ID AND S.DEPARTMENT_ID = D.DEPT_ID AND S.TEACHER_ID = ? AND S.YEAR = ? AND S.TERM = ?";
			String querySql = "SELECT S.ID EVALUATION_ID, S.COURSE_ID ID, S.CODING, S.COURSE_NAME, S.COURSE_PROPERTY ATTRIBUTE, S.COURSE_EXAM EXAM, S.TERM, S.YEAR, S.STATUS, S.TEACHER_ID, U.NAME TEACHER_NAME, D.DEPT_ID, D.DEPT_NAME " +
										"FROM T_EVALUATE_SETTING S, T_USER U, T_DEPARTMENT D " +
										"WHERE S.TEACHER_ID = U.USER_ID AND S.DEPARTMENT_ID = D.DEPT_ID AND S.TEACHER_ID = ? AND S.YEAR = ? AND S.TERM = ?";
			Object[] para = {userId, year, term};
			
			return this.queryPagingList(countSql, querySql, para, pageIndex, pageSize, new EvaluationSettingItemRow());
		}
		catch(Exception e)
		{
			SysLogUtil.error(e);
			return null;
		}
	}

	/**
	 * 方法名： initDataByDirector
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月22日 上午3:35:05
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object initDataByDirector(String evaluationSettingId)
	{
		try
		{
			String sql = "SELECT ID, DIRECTOR_ID, EVALUATION_TOTAL, IDEA " + 
								"FROM T_TEACH_QUALITY_TEA T WHERE T.ID IN " + 
								"(SELECT Q.EVALUATE_ID FROM T_TEACH_QUALITY Q " + 
								"WHERE Q.EVALUATE_SETTING_ID = ?)"; 
			Object[] para = {evaluationSettingId};
			
			return this.jdbcTemplate.queryForObject(sql, para, new EvaluationDetailOfDirectorRowMapper());
		}
		catch(Exception e)
		{
			return null;
		}
	}
}