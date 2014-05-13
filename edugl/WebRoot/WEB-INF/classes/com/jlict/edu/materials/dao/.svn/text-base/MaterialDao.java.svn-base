/**
 * 
 */
package com.jlict.edu.materials.dao;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.core.util.SysLogUtil;

/**
 * <p>Title: com.jlict.edu.materials.dao.MaterialSelfDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Repository
public class MaterialDao extends BaseDao
{

	/**
	 * 方法名： addSubmit
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月25日 上午4:13:25
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean addSubmit(MaterialVo vo)
	{
		try
		{
			String sql = "INSERT INTO T_MATERIALS(ID, ISBN, COURSE_NAME, COURSE_PROPERTY, "
					+ "MATERIALS_NAME, EDITOR, REVISION, PRESS, STUDENT_COUNT, TEACHER_COUNT, TEL, USE_CLASS, APPLY_DATE, APPLY_SEASON, APPLY_YEAR, USER_ID) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Object[] para = {vo.getId(), vo.getIsbn(), vo.getCourseName(), vo.getCourseProperty(), vo.getMaterialName(), vo.getEditor(), vo.getRevision(), vo.getPress(), vo.getStudentCount(), vo.getTeacherCount(), vo.getTel(), vo.getUseClass(), vo.getApplyDate(), vo.getSeason(),  vo.getYear(), vo.getUserId()};
			
			this.jdbcTemplate.update(sql, para);
			return true;
		}
		catch(Exception e)
		{
			SysLogUtil.error("添加教材征订Dao层出错！", e);
			return false;
		}
	}

	/**
	 * 方法名： queryApplys
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月26日 下午1:53:41
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 PagingJson
	 */
	public PagingJson queryApplys(String year, String userId, int pageIndex, int pageSize)
	{
		try
		{
			String countSql = "SELECT COUNT(M.ID) FROM T_MATERIALS M, T_MATERIALS_ORDER O WHERE M.ID = O.MATERIAL_ID AND M.APPLY_YEAR = ? AND USER_ID = ?";
			String querySql = "SELECT M.ID, COURSE_NAME, COURSE_PROPERTY, ISBN, MATERIALS_NAME, EDITOR, REVISION, PRESS, STUDENT_COUNT, TEACHER_COUNT, USE_CLASS, M.USER_ID, APPLY_RESULT, TEL, APPLY_DATE " +
										"FROM T_MATERIALS M, T_MATERIALS_ORDER O " +
										"WHERE M.ID = O.MATERIAL_ID AND M.APPLY_YEAR = ? AND USER_ID = ?";
			Object[] para = {year, userId};
			
			return this.queryPagingList(countSql, querySql, para, pageIndex, pageSize, new MaterialItemRowMapper());
		}
		catch(Exception e)
		{
			SysLogUtil.error("查询教材征订Dao层出错！", e);
			return null;
		}
	}
	
	public Boolean deleteApply(String id)
	{
		try
		{
			String sql = "DELETE FROM T_MATERIALS WHERE ID = ?";
			Object[] para = {id};
			
			this.jdbcTemplate.update(sql, para);
			return true;
		}
		catch(Exception e)
		{
			SysLogUtil.error("删除教材征订Dao层出错！", e);
			return false;
		}
	}

	/**
	 * 方法名： readApply
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月28日 上午10:18:10
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 MaterialFirstVo
	 */
	public MaterialItemVo readApply(String id)
	{
		try
		{
			String sql = "SELECT M.ID, COURSE_NAME, COURSE_PROPERTY, ISBN, MATERIALS_NAME, EDITOR, REVISION, PRESS, STUDENT_COUNT, TEACHER_COUNT, USE_CLASS, M.USER_ID, APPLY_RESULT, TEL, APPLY_DATE " +
										"FROM T_MATERIALS M, T_MATERIALS_ORDER O " +
										"WHERE M.ID = O.MATERIAL_ID AND M.ID = ?";
			Object[] para = {id};
			
			return this.jdbcTemplate.queryForObject(sql, para, new MaterialItemRowMapper());
		}
		catch(Exception e)
		{
			SysLogUtil.error("阅读教材征订Dao层出错！", e);
			return null;
		}
	}

	/**
	 * 方法名： updateApply
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月28日 上午10:54:07
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean updateApply(MaterialVo vo)
	{
		try
		{
			String sql = "DELETE FROM T_MATERIALS WHERE ID = ?";
			Object[] para = {vo.getId()};
			int effect = this.jdbcTemplate.update(sql, para);
			
			if(effect == 0)
			{
				return false;
			}
			
			return this.addSubmit(vo);
		}
		catch(Exception e)
		{
			SysLogUtil.error("修改教材征订Dao层出错！", e);
			return false;
		}
	}
	
}
