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
public class MaterialSelfDao extends BaseDao
{

	/**
	 * 方法名： addSubmit
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月25日 上午4:13:25
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean addSubmit(MaterialSelfVo vo)
	{
		try
		{
			String sql = "INSERT INTO T_MATERIALS_SELF(ID, ISBN, "
					+ "MATERIALS_NAME, EDITOR, PRESS, PRICE, COUNT, USE_CLASS, APPLY_DATE, APPLY_SEASON, APPLY_YEAR, USER_ID) "
					+ "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			Object[] para = {vo.getId(), vo.getIsbn(), vo.getMaterialName(), vo.getEditor(), vo.getPress(), vo.getPrice(), vo.getCount(), vo.getUseClass(), vo.getApplyDate(), vo.getSeason(),  vo.getYear(), vo.getUserId()};
			
			this.jdbcTemplate.update(sql, para);
			return true;
		}
		catch(Exception e)
		{
			SysLogUtil.error("添加自编教材申请Dao层出错！", e);
			return false;
		}
	}

	/**
	 * 方法名： queryApplys
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月26日 上午1:51:45
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 PagingJson
	 */
	public PagingJson queryApplys(String year, String userId, int pageIndex, int pageSize)
	{
		try
		{
			String countSql = "SELECT COUNT(S.ID) FROM T_MATERIALS_SELF S, T_MATERIALS_SELF_ORDER O WHERE S.ID = O.MATERIAL_ID AND APPLY_YEAR = ? AND USER_ID = ?";
			String querySql = "SELECT S.ID, ISBN, MATERIALS_NAME, EDITOR, PRESS, PRICE, COUNT, USE_CLASS, S.USER_ID, " + 
										"DIRECTOR, DIRECTOR_IDEA, DEAN, DEAN_IDEA, APPLY_RESULT, APPLY_DATE " +
										"FROM T_MATERIALS_SELF S, T_MATERIALS_SELF_ORDER O " + 
										"WHERE S.ID = O.MATERIAL_ID AND APPLY_YEAR = ? AND USER_ID = ?";
			Object[] para = {year, userId};
			
			return this.queryPagingList(countSql, querySql, para, pageIndex, pageSize, new MaterialSelfItemRowMapper());
		}
		catch(Exception e)
		{
			SysLogUtil.error("查询自编教材申请Dao层出错！", e);
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
	public MaterialSelfVo readApply(String id)
	{
		try
		{
			String sql = "SELECT S.ID, ISBN, MATERIALS_NAME, EDITOR, PRESS, PRICE, COUNT, USE_CLASS, USER_ID, " + 
								"DIRECTOR, DIRECTOR_IDEA, DEAN, DEAN_IDEA, APPLY_RESULT, APPLY_DATE " +
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
	 * 方法名： deleteApply
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月27日 下午12:38:23
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 ResultJson
	 */
	public Boolean deleteApply(String id)
	{
		try
		{
			String sql = "DELETE FROM T_MATERIALS_SELF WHERE ID = ?";
			Object[] para = {id};
			
			this.jdbcTemplate.update(sql, para);
			return true;
		}
		catch(Exception e)
		{
			SysLogUtil.error("删除自编教材申请Dao层出错！", e);
			return false;
		}
	}

	/**
	 * 方法名： updateApply
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月28日 上午10:44:49
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean updateApply(MaterialSelfVo vo)
	{
		try
		{
			String sql = "DELETE FROM T_MATERIALS_SELF WHERE ID = ?";
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
			SysLogUtil.error("修改自编教材申请Dao层出错！", e);
			return false;
		}
	}
	
}
