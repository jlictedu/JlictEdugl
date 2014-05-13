/**
 * 
 */
package com.jlict.edu.teachingQuality.dao;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.core.util.ResultJson;
import com.jlict.edu.core.util.SysLogUtil;

/**
 * <p>Title: com.jlict.edu.teachingQuality.dao.TeachEvaluateStudentDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Repository
public class TeachEvaluateStudentDao extends BaseDao
{
	/**
	 * 方法名： evaluateSubmit
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月14日 下午5:44:29
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ResultJson
	 */
	public ResultJson evaluateSubmit(TeachQualityVo tqVo, TeachQualityStudentVo tqsVo)
	{
		ResultJson result = new ResultJson();
		
		try
		{
			String sql = "INSERT INTO T_TEACH_QUALITY_STU(ID, STU_ID, TA_EI1, TA_EI2, TC_EI1, TC_EI2, TC_EI3, TC_EI4, TC_EI5, TM_EI1, TM_EI2, TM_EI3, TE_EI1, IDEA) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Object[] para = new Object[]{tqsVo.getId(), tqsVo.getStu_id(), tqsVo.getTa_ei1(), tqsVo.getTa_ei2(),
					tqsVo.getTc_ei1(), tqsVo.getTc_ei2(), tqsVo.getTc_ei3(), tqsVo.getTc_ei4(), tqsVo.getTc_ei5(),
					tqsVo.getTm_ei1(), tqsVo.getTm_ei2(), tqsVo.getTm_ei3(), tqsVo.getTe_ei1(), tqsVo.getIdea()};
			
			this.deleteEvaluationByDetail(tqsVo.getId());
			this.jdbcTemplate.update(sql, para);
			
			sql = "INSERT INTO T_TEACH_QUALITY(ID, EVALUATE_ID, DATE_TIME, EVALUATE_CATEGORY, EVALUATE_SETTING_ID) VALUES(?, ?, ?, ?, ?)";
			para = new Object[]{tqVo.getId(), tqVo.getEvaluate_id(), tqVo.getDate_time(), tqVo.getEvaluate_category(), tqVo.getEvaluate_setting_id()};
			
			this.deleteEvaluation(this.getEvaluationId(tqsVo.getId()));
			this.jdbcTemplate.update(sql, para);
			
			result.setResultCode(1);
			result.setText("课堂教学质量评估提交成功！");
		}
		catch(EmptyResultDataAccessException e)
		{
			SysLogUtil.error("提交课程评估Dao层出错！", e);
			result.setResultCode(0);
			result.setText("课堂教学质量评估提交失败！");
			
			return result;
		}
		
		return result;
	}
	
	/**
	 * 方法名： initCourses
	 * 建立者： 孟兆祥
	 * 建立时间：2014年1月17日 下午3:37:49
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 PagingJson
	 * @param userId 
	 * @param deptId 
	 */
	public PagingJson initCourses(String userId, int pageIndex, int pageSize)
	{
		try
		{
			String countSql = "SELECT COUNT(S.ID) " +
										"FROM T_EVALUATE_SETTING S, T_USER U, T_DEPARTMENT D " +
										"WHERE S.DEPARTMENT_ID = ? AND S.TERM = ?" +
										"AND S.YEAR = ? AND S.TEACHER_ID = U.USER_ID  AND S.DEPARTMENT_ID = D.DEPT_ID";
			String listSql = "SELECT S.ID EVALUATION_ID, S.COURSE_ID ID, S.CODING, S.COURSE_NAME, S.COURSE_PROPERTY ATTRIBUTE, S.COURSE_EXAM EXAM, S.TERM, S.YEAR, S.STATUS, S.TEACHER_ID, U.NAME TEACHER_NAME, D.DEPT_ID, D.DEPT_NAME " +
									"FROM T_EVALUATE_SETTING S, T_USER U, T_DEPARTMENT D " +
									"WHERE S.DEPARTMENT_ID = ? AND S.TERM = ?" +
									"AND S.YEAR = ? AND S.TEACHER_ID = U.USER_ID  AND S.DEPARTMENT_ID = D.DEPT_ID AND STATUS = '1'";
			String schoolYear = this.getSchoolYear(userId);
			String classId = this.getClassId(userId);
			String term = String.valueOf(this.getTermByUser(schoolYear));
			Object[] para = {classId, term, schoolYear};

			return  this.queryPagingList(countSql, listSql, para, pageIndex, pageSize, new EvaluationSettingItemRow());
		}
		catch(Exception e)
		{
			SysLogUtil.error("查询可评估课程Dao层出错！", e);
			return null;
		}
	}
	
	/**
	 * 方法名： getSchoolYear
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月2日 上午10:32:06
	 * 描述：获得用户入学年份
	 * 参数：userId 说明：用户ID
	 * 返回类型 String
	 */
	private String getSchoolYear(String userId)
	{
		String sql = "SELECT S.JOIN_DATE FROM T_STUDENT S WHERE S.ID = ?";
		Object[] para = {userId};
		
		return this.jdbcTemplate.queryForObject(sql, String.class, para).substring(0, 4);
	}
	
	/**
	 * 方法名： getTermByUser
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月2日 上午10:48:03
	 * 描述：获得学期数
	 * 参数：para 说明：TODO
	 * 返回类型 int
	 */
	private int getTermByUser(String schoolYear)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
		Date date = new Date();
		String year, month;
		
		year = sdf.format(date);
		sdf.applyPattern("MM");
		month = sdf.format(date);
		
		return ((Integer.parseInt(year) - Integer.parseInt(schoolYear)) << 1) + (Integer.parseInt(month) < 9 ? 0 : 1);
	}
	
	private String getClassId(String userId)
	{
		String sql = "SELECT CLASS_ID FROM T_STUDENT S WHERE ID = ?";
		Object[] para = {userId};
		
		return this.jdbcTemplate.queryForObject(sql, String.class, para);
	}

	/**
	 * 方法名： getEducationCollege
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月3日 上午10:01:34
	 * 描述：获得学生所在教学院
	 * 参数：para 说明：TODO
	 * 返回类型 String
	 */
	private String getEducationCollege(String deptId)
	{
		String sql = "SELECT DEPT_NAME FROM T_DEPARTMENT WHERE DEPT_ID IN (SELECT BOSS_DEPT_ID FROM T_DEPARTMENT WHERE DEPT_ID = ?)";
		Object[] para = {deptId};
		
		return this.jdbcTemplate.queryForObject(sql, String.class, para);
	}
	
	/**
	 * 方法名： initHeadInfo
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月2日 下午12:16:09
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public Object initHeadInfo(String deptId, String evaluationId)
	{
		String sql =  "SELECT S.COURSE_NAME, U.NAME TEACHER_NAME, D.DEPT_NAME ATTEND_CLASS " +
				"FROM T_EVALUATE_SETTING S, T_USER U, T_DEPARTMENT D " +
				"WHERE S.ID = ? AND S.TEACHER_ID = U.USER_ID  AND S.DEPARTMENT_ID = D.DEPT_ID";
		Object[] para = {evaluationId};
		EvaluateHeadInfoOfStudentVo vo = this.jdbcTemplate.queryForObject(sql, para, new EvaluateHeadInfoOfStudentRowMapper());
		
		vo.setEducationCollege(this.getEducationCollege(deptId));
		return vo;
	}

	/**
	 * 方法名： initData
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月9日 下午12:31:42
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public EvaluationDetailOfStudentVo initData(String userId, String evaluationId)
	{
		try
		{
			String sql = "SELECT ID, STU_ID, TA_EI1, TA_EI2, TC_EI1, TC_EI2, TC_EI3, TC_EI4, TC_EI5, TM_EI1, TM_EI2, TM_EI3, TE_EI1, IDEA " + 
								"FROM T_TEACH_QUALITY_STU S WHERE S.STU_ID = ? AND S.ID IN " + 
								"(SELECT Q.EVALUATE_ID FROM T_TEACH_QUALITY Q WHERE Q.EVALUATE_SETTING_ID = ?)";
			Object[] para = {userId, evaluationId};
			
			return this.jdbcTemplate.queryForObject(sql, para, new EvaluationDetailOfStudentRowMapper());
		}
		catch(Exception e)
		{
			return null;
		}
	}
	
	/**
	 * 方法名： deleteEvaluation
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月9日 下午2:24:35
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean deleteEvaluationByDetail(String id)
	{
		try
		{
			String sql = "DELETE FROM T_TEACH_QUALITY_STU S WHERE S.ID = ?";
			Object[] para = {id};
			int effect = this.jdbcTemplate.update(sql, para);
			
			return effect != 1;
		}
		catch(Exception e)
		{
			//SysLogUtil.error(e);
			return false;
		}
	}
	
	/**
	 * 方法名： deleteEvaluation
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月9日 下午2:36:04
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean deleteEvaluation(String id)
	{
		try
		{
			String sql = "DELETE FROM T_TEACH_QUALITY Q WHERE Q.ID = ?";
			Object[] para = {id};
			int effect = this.jdbcTemplate.update(sql, para);
			
			return effect != 1;
		}
		catch(Exception e)
		{
			//SysLogUtil.error(e);
			return false;
		}
	}
	
	/**
	 * 方法名： getEvaluationId
	 * 建立者： 孟兆祥
	 * 建立时间：2014年4月9日 下午2:41:04
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 String
	 */
	public String getEvaluationId(String id)
	{
		try
		{
			String sql = "SELECT Q.ID FROM T_TEACH_QUALITY Q WHERE EVALUATE_ID = ?";
			Object[] para = {id};
			
			return this.jdbcTemplate.queryForObject(sql, String.class, para);
		}
		catch(Exception e)
		{
			//SysLogUtil.error(e);
			return null;
		}
	}
}
