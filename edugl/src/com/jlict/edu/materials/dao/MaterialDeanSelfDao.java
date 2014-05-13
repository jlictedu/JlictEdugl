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
public class MaterialDeanSelfDao extends BaseDao
{
	/**
	 * 方法名： queryApplys
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月26日 上午1:51:45
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 PagingJson
	 */
	public PagingJson queryApplys(String year, String deptId, int pageIndex, int pageSize)
	{
		try
		{
			String countSql = "SELECT COUNT(S.ID) " +
										"FROM T_MATERIALS_SELF S, T_MATERIALS_SELF_ORDER O " + 
										"WHERE S.ID = O.MATERIAL_ID AND APPLY_YEAR = ? AND DIRECTOR = '1' AND APPLY_RESULT != '1' AND USER_ID IN (SELECT USER_ID FROM T_USER WHERE DEPT_ID IN (SELECT DEPT_ID FROM T_DEPARTMENT WHERE BOSS_DEPT_ID = ?))";
			String querySql = "SELECT S.ID, USER_ID,MATERIALS_NAME, EDITOR, PRESS, PRICE, ISBN, COUNT, USE_CLASS, SUMMARY, APPLY_DATE, APPLY_YEAR, APPLY_SEASON, DIRECTOR, DIRECTOR_IDEA, DEAN, DEAN_IDEA, APPLY_RESULT " +
					  					"FROM T_MATERIALS_SELF S, T_MATERIALS_SELF_ORDER O " + 
					  					"WHERE S.ID = O.MATERIAL_ID AND APPLY_YEAR = ? AND DIRECTOR = '1' AND APPLY_RESULT != '1' AND USER_ID IN (SELECT USER_ID FROM T_USER WHERE DEPT_ID IN (SELECT DEPT_ID FROM T_DEPARTMENT WHERE BOSS_DEPT_ID = ?))";
			Object[] para = {year, deptId};
			
			return this.queryPagingList(countSql, querySql, para, pageIndex, pageSize, new MaterialSelfItemRowMapper());
		}
		catch(Exception e)
		{
			SysLogUtil.error("查询自编教材审批Dao层出错！", e);
			return null;
		}
	}

	/**
	 * 方法名： readApply
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月27日 上午10:37:17
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public MaterialSelfVo readApproval(String id)
	{
		try
		{
			String sql = "SELECT S.ID, USER_ID,MATERIALS_NAME, EDITOR, PRESS, PRICE, ISBN, COUNT, USE_CLASS, SUMMARY, APPLY_DATE, APPLY_YEAR, APPLY_SEASON, DIRECTOR, DIRECTOR_IDEA, DEAN, DEAN_IDEA, APPLY_RESULT " +
			  					"FROM T_MATERIALS_SELF S, T_MATERIALS_SELF_ORDER O " + 
			  					"WHERE S.ID = O.MATERIAL_ID AND S.ID = ?";
			Object[] para = {id};
			
			return this.jdbcTemplate.queryForObject(sql, para, new MaterialSelfRowMapper());
		}
		catch(Exception e)
		{
			SysLogUtil.error("阅读自编教材申请Dao层出错！", e);
			return null;
		}
	}

	/**
	 * 方法名： approval
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月1日 下午6:06:36
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean approval(String id, String approvalAction)
	{
		try
		{
			String sql = "UPDATE T_MATERIALS_SELF SET DEAN = ? WHERE ID = ?";
			Object[] para = {approvalAction, id};
			int effect = this.jdbcTemplate.update(sql, para);
			
			if(effect != 1)
			{
				return false;
			}
			return true;
		}
		catch(Exception e)
		{
			return false;
		}
	}
	
}
