/**
 * 
 */
package com.jlict.edu.manager.dao;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;

/**
 * <p>Title: com.jlict.hrgl.manager.dao.PermissionDao.java</p>
 * <p>Description: 权限模块持久层</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Repository
public class PermissionDao extends BaseDao {
	
	/**
	 * 方法名: queryRule   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午04:33:56 
	 * 描述: 权限规则分页查询
	 * 参数：pageIndex 说明：分页索引
	 * 参数：pageSize 说明：单个分页记录数
	 * 参数：departmentName 说明： 部门名称
	 * 参数：stationName 说明：岗位名称
	 * 参数：roleName 说明：系统角色名称
	 * 返回类型 PagingJson       
	 */
	public PagingJson queryRule(int pageIndex, int pageSize, String departmentName, String stationName, String roleName){
		StringBuilder countSql = new StringBuilder();
		StringBuilder listSql = new StringBuilder();
		countSql.append("SELECT COUNT(*)  FROM T_ROLE JOIN T_DEPARTMENT ON");
		countSql.append(" T_ROLE.DEPT_ID=T_DEPARTMENT.DEPT_ID JOIN T_DM_STATION ON" );
		countSql.append(" T_ROLE.STATION_ID=T_DM_STATION.STATION_ID JOIN T_DM_ROLE ON T_ROLE.ROLE_ID=T_DM_ROLE.ROLE_ID");
		listSql.append("SELECT  T_DEPARTMENT.DEPT_ID AS DEPT_ID, T_DEPARTMENT.DEPT_NAME AS DEPT_NAME,");
		listSql.append(" T_DM_STATION.STATION_ID AS STATION_ID, T_DM_STATION.STATION_NAME AS STATION_NAME,");
		listSql.append(" T_DM_ROLE.ROLE_ID AS ROLE_ID,T_DM_ROLE.ROLE_NAME AS ROLE_NAME");
		listSql.append(" FROM T_ROLE JOIN T_DEPARTMENT ON T_ROLE.DEPT_ID=T_DEPARTMENT.DEPT_ID");
		listSql.append(" JOIN T_DM_STATION ON T_ROLE.STATION_ID=T_DM_STATION.STATION_ID JOIN T_DM_ROLE");
		listSql.append(" ON T_ROLE.ROLE_ID=T_DM_ROLE.ROLE_ID ");
		boolean condition=false;
		Object para[] = new Object[]{};
		//附加条件查询语句
		if(departmentName!=null){
			if(!condition){
				listSql.append(" WHERE ");
				countSql.append(" WHERE ");
				condition = true;
			}
			else{
				listSql.append(" AND ");
				countSql.append(" AND ");
			}
			para = ArrayUtils.addAll(para,new Object[]{'%'+departmentName+'%'});
			listSql.append("T_DEPARTMENT.DEPT_NAME LIKE ?");
			countSql.append("T_DEPARTMENT.DEPT_NAME LIKE ?");
		}
		if(stationName!=null){
			if(!condition){
				listSql.append(" WHERE ");
				countSql.append(" WHERE ");
				condition = true;
			}
			else{
				listSql.append(" AND ");
				countSql.append(" AND ");
			}
			para = ArrayUtils.addAll(para,new Object[]{'%'+stationName+'%'});
			listSql.append("T_DM_STATION.STATION_NAME LIKE ?");
			countSql.append("T_DM_STATION.STATION_NAME LIKE ?");
		}
		if(roleName!=null){
			if(!condition){
				listSql.append(" WHERE ");
				countSql.append(" WHERE ");
				condition = true;
			}
			else{
				listSql.append(" AND ");
				countSql.append(" AND ");
			}
			para = ArrayUtils.addAll(para,new Object[]{'%'+roleName+'%'});
			listSql.append("T_DM_ROLE.ROLE_NAME LIKE ?");
			countSql.append("T_DM_ROLE.ROLE_NAME LIKE ?");
		}
		return this.queryPagingList(countSql.toString(), listSql.toString(), para, pageIndex, pageSize, new RuleRowMapper());
	}
	
	/**
	 * 方法名: createRule   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午04:34:17 
	 * 描述: 创建权限规则
	 * 参数：departmentId 说明： 部门Id
	 * 参数：stationId 说明：岗位Id
	 * 参数：roleId 说明：系统角色Id
	 * 返回类型 boolean       
	 */
	public boolean createRule(String departmentId, String stationId, String roleId){
		String sql = "INSERT INTO T_ROLE VALUES (?,?,?)";
		Object[] para = new Object[]{departmentId, stationId, roleId};
		return 1==this.jdbcTemplate.update(sql, para);
	}
	
	/**
	 * 方法名: deleteRule   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午04:34:23 
	 * 描述: 删除权限规则
	 * 参数：departmentId 说明： 部门Id
	 * 参数：stationId 说明：岗位Id
	 * 参数：roleId 说明：系统角色Id
	 * 返回类型 boolean       
	 */
	public boolean deleteRule(String departmentId, String stationId, String roleId){
		String sql = "DELETE T_ROLE WHERE DEPT_ID = ? AND STATION_ID = ? AND ROLE_ID = ?";
		Object[] para = new Object[]{departmentId, stationId, roleId};
		return 1==this.jdbcTemplate.update(sql, para);
	}
}
