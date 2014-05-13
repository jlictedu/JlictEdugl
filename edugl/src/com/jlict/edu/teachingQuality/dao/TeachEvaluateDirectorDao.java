/**
 * 
 */
package com.jlict.edu.teachingQuality.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.core.util.SysLogUtil;

/**
 * <p>Title: com.jlict.edu.teachingQuality.dao.TeachEvaluateDirectorDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Repository
public class TeachEvaluateDirectorDao extends BaseDao
{
	/**
	 * 方法名： queryCourses
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月19日 下午3:13:07
	 * 描述：查询所有可以开启评估的课程
	 * 参数：grade 需要查询的年级
	 * 参数：userId 用户ID
	 * 返回类型 PagingJson
	 */
	public PagingJson queryCourses(String year, String month, int grade, String departmentId, int pageIndex, int pageSize)
	{
		try
		{
			int monthTmp = Integer.parseInt(month);
			int yearTmp = Integer.parseInt(year);
			int schoolYear;
			
			if(monthTmp >= 2 && monthTmp < 9)
			{
				schoolYear = yearTmp - grade;
			}
			else
			{
				if(monthTmp >= 9)
				{
					schoolYear = yearTmp - grade + 1;
				}
				else
				{
					schoolYear = yearTmp - grade;
				}
			}
			
			String countSql = "SELECT COUNT(S.ID) " +
										"FROM T_EVALUATE_SETTING S, T_USER U, T_DEPARTMENT D " +
										"WHERE S.DEPARTMENT_ID IN " +
										"(SELECT DEPT_ID FROM T_DEPARTMENT D WHERE D.BOSS_DEPT_ID = ?) " +
										"AND S.YEAR = ? AND S.TEACHER_ID = U.USER_ID  AND S.DEPARTMENT_ID = D.DEPT_ID";
			String listSql = "SELECT S.ID EVALUATION_ID, S.COURSE_ID ID, S.CODING, S.COURSE_NAME, S.COURSE_PROPERTY ATTRIBUTE, S.COURSE_EXAM EXAM, S.TERM, S.YEAR, S.STATUS, S.TEACHER_ID, U.NAME TEACHER_NAME, D.DEPT_ID, D.DEPT_NAME " +
									"FROM T_EVALUATE_SETTING S, T_USER U, T_DEPARTMENT D " +
									"WHERE S.DEPARTMENT_ID IN " +
									"(SELECT DEPT_ID FROM T_DEPARTMENT D WHERE D.BOSS_DEPT_ID = ?) " +
									"AND S.YEAR = ? AND S.TEACHER_ID = U.USER_ID  AND S.DEPARTMENT_ID = D.DEPT_ID";
			Object[] para = {departmentId, schoolYear};
			
			return this.queryPagingList(countSql, listSql, para, pageIndex, pageSize, new EvaluationSettingItemRow());
		}
		catch(Exception e)
		{
			SysLogUtil.error("查询可评估课程Dao层出错！", e);
		}
		
		return null;
	}
	
	/**
	 * 方法名： queryCoursesByPanel
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月16日 上午11:40:19
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 PagingJson
	 */
	public PagingJson queryCoursesByPanel(String year, String month, int grade, String departmentId, int pageIndex, int pageSize)
	{
		try
		{
			int monthTmp = Integer.parseInt(month);
			int yearTmp = Integer.parseInt(year);
			int schoolYear;
			
			if(monthTmp >= 2 && monthTmp < 9)
			{
				schoolYear = yearTmp - grade;
			}
			else
			{
				if(monthTmp >= 9)
				{
					schoolYear = yearTmp - grade + 1;
				}
				else
				{
					schoolYear = yearTmp - grade;
				}
			}
			
			String countSql = "SELECT COUNT(S.ID) " +
										"FROM T_EVALUATE_SETTING S, T_USER U, T_DEPARTMENT D " +
										"WHERE S.DEPARTMENT_ID IN " +
										"(SELECT DEPT_ID FROM T_DEPARTMENT D WHERE D.BOSS_DEPT_ID = ?) " +
										"AND S.YEAR = ? AND S.TEACHER_ID = U.USER_ID  AND S.DEPARTMENT_ID = D.DEPT_ID AND S.STATUS = '1'";
			String listSql = "SELECT S.ID EVALUATION_ID, S.COURSE_ID ID, S.CODING, S.COURSE_NAME, S.COURSE_PROPERTY ATTRIBUTE, S.COURSE_EXAM EXAM, S.TERM, S.YEAR, S.STATUS, S.TEACHER_ID, U.NAME TEACHER_NAME, D.DEPT_ID, D.DEPT_NAME " +
									"FROM T_EVALUATE_SETTING S, T_USER U, T_DEPARTMENT D " +
									"WHERE S.DEPARTMENT_ID IN " +
									"(SELECT DEPT_ID FROM T_DEPARTMENT D WHERE D.BOSS_DEPT_ID = ?) " +
									"AND S.YEAR = ? AND S.TEACHER_ID = U.USER_ID  AND S.DEPARTMENT_ID = D.DEPT_ID AND S.STATUS = '1'";
			Object[] para = {departmentId, schoolYear};
			
			return this.queryPagingList(countSql, listSql, para, pageIndex, pageSize, new EvaluationSettingItemRow());
		}
		catch(Exception e)
		{
			SysLogUtil.error("查询可评估课程Dao层出错！", e);
		}
		
		return null;
	}
	
	/**
	 * 方法名： openStatus
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月20日 下午1:57:15
	 * 描述：开启课程评估
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean openStatus(String evaluationId)
	{
		try
		{
			String sql = "UPDATE T_EVALUATE_SETTING SET STATUS = '1' WHERE ID = ?";
			Object[] para = {evaluationId};
			int effect = this.jdbcTemplate.update(sql, para);
			
			return effect != 1;
		}
		catch(Exception e)
		{
			SysLogUtil.error("开启课程评估Dao层出错！", e);
			return false;
		}
	}
	
	/**
	 * 方法名： closeStatus
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月20日 下午1:58:46
	 * 描述：关闭课程评估
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean closeStatus(String evaluationId)
	{
		try
		{
			String sql = "UPDATE T_EVALUATE_SETTING SET STATUS = 0 WHERE ID = ?";
			Object[] para = new Object[]{evaluationId};
			
			return this.jdbcTemplate.update(sql, para) == 1;
		}
		catch(Exception e)
		{
			SysLogUtil.error("关闭课程评估Dao层出错！", e);
			return false;
		}
	}
	
	/**
	 * 方法名： clearStatus
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月20日 下午2:00:06
	 * 描述：清除课程评估
	 * 参数：evaluationId：评估ID
	 * 返回类型 boolean
	 */
	@Transactional(propagation=Propagation.REQUIRED)
	public boolean clearStatus(String evaluationId)
	{
		try
		{
			String sql = "SELECT EVALUATE_ID FROM T_TEACH_QUALITY WHERE ID = ? AND EVALUATE_CATEGORY = 1";
			Object[] para = new Object[]{evaluationId};
			List<String> evaluationIds = this.jdbcTemplate.queryForList(sql, String.class, para);
			
			//删除T_TEACH_QUALITY_STU所有符合条件的记录
			for(String id : evaluationIds)
			{
				sql = "DELETE T_TEACH_QUALITY_STU WHERE ID = ?";
				para[0] = id;
				this.jdbcTemplate.update(sql, para);
			}
			
			//删除T_TEACH_QUALITY_TEA符合条件的记录
			sql = "SELECT EVALUATE_ID FROM T_TEACH_QUALITY WHERE ID = ? AND EVALUATE_CATEGORY = 2";
			para[0] = evaluationId;
			String id = this.jdbcTemplate.queryForObject(sql, para, String.class);
			sql = "DELETE T_TEACH_QUALITY_TEA WHERE ID = ?";
			para[0] = id;
			this.jdbcTemplate.update(sql, para);
			
			//删除T_TEACH_QUALITY所有符合条件的记录
			sql = "DELETE T_TEACH_QUALITY WHERE EVALUATE_SETTING_ID = ?";
			para[0] = evaluationId;
			this.jdbcTemplate.update(sql, para);
			
			//删除T_EVALUATE_SETTING符合条件的记录
			sql = "DELETE T_EVALUATE_SETTING WHERE ID = ?";
			this.jdbcTemplate.update(sql, para);
		}
		catch(Exception e)
		{
			SysLogUtil.error("清除课程评估Dao层出错！", e);
			return false;
		}
		
		return true;
	}
	
	/**
	 * 方法名： getHeadInfo
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月14日 下午3:36:21
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object getHeadInfo(String evaluationId)
	{
		try
		{
			String sql = "SELECT C.NAME COURSE_NAME, U.NAME TEACHER_NAME, D.DEPT_NAME ATTEND_CLASS " + 
								"FROM T_EVALUATE_SETTING S, T_USER U, T_DEPARTMENT D, T_CURRICULA C " +
								"WHERE S.ID = ? " +
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
							"(SELECT S.DEPARTMENT_ID FROM T_EVALUATE_SETTING S WHERE S.ID = ?)))";
		Object[] para = {evaluationId};
		
		return this.jdbcTemplate.queryForObject(sql, String.class, para);
	}

	/**
	 * 方法名： evaluationSubmit
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月16日 下午2:13:07
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ResultJson
	 */
	public boolean evaluationSubmit(String id, String userId, String evaluationTotal, String idea, TeachQualityVo vo)
	{
		try
		{
			String sql = "INSERT INTO T_TEACH_QUALITY_TEA(ID, DIRECTOR_ID, EVALUATION_TOTAL, IDEA) VALUES(?, ?, ?, ?)";
			Object[] para = {id, userId, evaluationTotal, idea};
			int effect = this.jdbcTemplate.update(sql, para);
			
			if(effect != 1)
			{
				return false;
			}
			
			sql = "INSERT INTO T_TEACH_QUALITY(ID, EVALUATE_ID, DATE_TIME, EVALUATE_CATEGORY, EVALUATE_SETTING_ID) VALUES(?, ?, ?, ?, ?)";
			para = new Object[]{vo.getId(), vo.getEvaluate_id(), vo.getDate_time(), vo.getEvaluate_category(), vo.getEvaluate_setting_id()};
			effect = this.jdbcTemplate.update(sql, para);
			
			if(effect != 1)
			{
				return false;
			}
		}
		catch(Exception e)
		{
			SysLogUtil.error(e);
			return false;
		}
		
		return true;
	}
	
	/**
	 * 方法名： initData
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月16日 下午2:45:58
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object initData(String userId, String evaluationId)
	{
		try
		{
			String sql = "SELECT ID, DIRECTOR_ID, EVALUATION_TOTAL, IDEA " + 
								"FROM T_TEACH_QUALITY_TEA S WHERE S.DIRECTOR_ID = ? AND S.ID IN " + 
								"(SELECT Q.EVALUATE_ID FROM T_TEACH_QUALITY Q WHERE Q.EVALUATE_SETTING_ID = ?)";
			Object[] para = {userId, evaluationId};
			
			return this.jdbcTemplate.queryForObject(sql, para, new EvaluationDetailOfDirectorRowMapper());
		}
		catch(Exception e)
		{
			return null;
		}
	}

	/**
	 * 方法名： evaluationSubmit
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月16日 下午3:24:25
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean evaluationSubmit(String id, String evaluationTotal, String idea)
	{
		try
		{
			String sql = "UPDATE T_TEACH_QUALITY_TEA SET EVALUATION_TOTAL = ?, IDEA = ? WHERE ID = ?";
			Object[] para = {Integer.parseInt(evaluationTotal), idea, id};
			int effect = this.jdbcTemplate.update(sql, para);
			
			if(effect != 1)
			{
				return false;
			}
			
			return true;
		}
		catch(Exception e)
		{
			SysLogUtil.error(e);
		}
		
		return false;
	}
}
