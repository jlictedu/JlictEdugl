/**
 * 
 */
package com.jlict.edu.manager.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;

/**
 * <p>Title: com.jlict.hrgl.manager.dao.DepartMentDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Repository
public class DepartmentDao extends BaseDao {
	
	/**
	 * 方法名: queryDepartmentDetail   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:08:00 
	 * 描述: 部门详细信息分页查询
	 * 参数：pageIndex 说明：分页索引
	 * 参数：pageSize 说明：单个分页记录数
	 * 参数：departmentName 说明： 部门名称
	 * 参数：name 说明：名称
	 * 参数：people 说明：人数
	 * 返回类型 PagingJson       
	 */
	public PagingJson queryDepartmentDetail(int pageIndex,int pageSize, String name, int people){
		List<Object> para = new ArrayList<Object>();
		StringBuilder countSql = new StringBuilder();
		StringBuilder listSql = new StringBuilder();
		countSql.append("SELECT COUNT( DISTINCT T_DEPARTMENT.DEPT_ID) FROM T_DEPARTMENT LEFT JOIN T_USER ON");
		countSql.append(" T_USER.DEPT_ID = T_DEPARTMENT.DEPT_ID");		
		listSql.append("SELECT A.DEPT_ID,A.DEPT_NAME,A.BOSS_DEPT_ID,B.DEPT_NAME AS BOSS_NAME,COUNT(T_USER.USER_ID) AS PEOPLE");
		listSql.append(" FROM T_DEPARTMENT A LEFT JOIN T_USER ON T_USER.DEPT_ID = A.DEPT_ID LEFT JOIN T_DEPARTMENT B ON A.BOSS_DEPT_ID=B.DEPT_ID ");
		StringBuilder queryCondition = new StringBuilder();
		if(name != null){
			queryCondition.append(" WHERE A.DEPT_NAME LIKE ?");
			para.add('%'+name+'%');
		}
		countSql.append(queryCondition);		
	    listSql.append(queryCondition);
		listSql.append(" GROUP BY A.DEPT_ID,A.DEPT_NAME,A.BOSS_DEPT_ID,B.DEPT_NAME");
		queryCondition = new StringBuilder();
		if(people >0){
			queryCondition.append(" HAVING COUNT(T_USER.ID)>=?");
			para.add(people);
		}
		countSql.append(queryCondition);		
	    listSql.append(queryCondition);
		
		return this.queryPagingList(countSql.toString(), listSql.toString(), para.toArray(), pageIndex, pageSize, new DepartmentDetailRowMapper());
	}
	
	/**
	 * 方法名: queryDepartment   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:08:04 
	 * 描述: 部门信息查询
	 * 返回类型 List<DepartmentVo>       
	 */
	public List<DepartmentVo> queryDepartment() {		
		String sql = "SELECT A.DEPT_ID,A.DEPT_NAME,A.BOSS_DEPT_ID,B.DEPT_NAME AS BOSS_DEPT_NAME FROM T_DEPARTMENT A LEFT JOIN T_DEPARTMENT B ON A.BOSS_DEPT_ID=B.DEPT_ID";			
		return this.jdbcTemplate.query(sql, new DepartmentRowMapper());		
	}
	
	/**
	 * 方法名: queryDepartmentById   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:08:07 
	 * 描述: 通过部门id查询部门信息
	 * 参数：id 说明：部门id
	 * 返回类型 DepartmentVo       
	 */
	public DepartmentVo queryDepartmentById(String id){
		String sql = "SELECT A.DEPT_ID,A.DEPT_NAME,A.BOSS_DEPT_ID,B.DEPT_NAME AS BOSS_DEPT_NAME FROM T_DEPARTMENT A LEFT JOIN T_DEPARTMENT B ON A.BOSS_DEPT_ID=B.DEPT_ID WHERE A.DEPT_ID=?";
		Object[] para = new Object[]{id};
		return this.jdbcTemplate.queryForObject(sql, new DepartmentRowMapper(),para);
	}
	
	/**
	 * 方法名: updateDepartmentName   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:08:13 
	 * 描述: 更改部门名字
	 * 参数：id 说明：部门id
	 * 参数：name 说明：部门新名称
	 * 返回类型 boolean       
	 */
	public boolean updateDepartmentName(String id,String name,String bossId){
		String sql = "UPDATE T_DEPARTMENT SET DEPT_NAME = ?,BOSS_DEPT_ID = ? WHERE DEPT_ID=?";
		Object[] para = new Object[]{name,bossId,id};
		return 1==this.jdbcTemplate.update(sql, para);
	}
	
	/**
	 * 方法名: deleteDepartment   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:08:12 
	 * 描述: 删除部门
	 * 参数：id 说明：部门id
	 * 返回类型 boolean       
	 */
	public boolean deleteDepartment(String id){
		String sql = "DELETE T_DEPARTMENT WHERE DEPT_ID=?";
		Object[] para = new Object[]{id};
		return 1==this.jdbcTemplate.update(sql, para);
	}
	
	/**
	 * 方法名: createDepartment   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:08:10 
	 * 描述: 创建部门
	 * 参数：name 说明：部门名称
	 * 返回类型 boolean       
	 */
	public boolean createDepartment(String name,String bossId){
		String sql = "INSERT INTO T_DEPARTMENT VALUES (S_COMMON.NEXTVAL,?,?)";
		Object[] para = new Object[]{name,bossId};
		return 1==this.jdbcTemplate.update(sql, para);
	}
}
