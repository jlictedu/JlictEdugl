/**
 * 
 */
package com.jlict.edu.core.dao;


import org.apache.commons.lang.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jlict.edu.core.util.SysLogUtil;


/**
 * <p>Title: com.jlict.core.dao.BaseDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Repository
public class BaseDao {
	@Autowired
	protected JdbcTemplate jdbcTemplate;
	
	/**
	 * 方法名: queryPagingList   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-6-26 下午02:16:16 
	 * 描述: 分页查询方法
	 * 参数：countSql 说明：查询记录条数的sql语句，例如select count(*) from t_user
	 * 参数：listSql 说明：查询记录的sql语句，例如select * from t_user
	 * 参数：para 说明：查询记录sql语句的预编译参数
	 * 参数：pageIndex 说明：查询的页的索引数
	 * 参数：pageSize 说明：查询的每页的记录数
	 * 返回类型 PagingJson       
	 */
	protected PagingJson queryPagingList(String countSql, String listSql, Object[] para, int pageIndex, int pageSize) {
		PagingJson data = new PagingJson();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM  (  SELECT TAB_.*, ROWNUM RN  FROM (");				
			int totalCount = jdbcTemplate.queryForInt(countSql,para);		
			int pageCount = totalCount / pageSize;
			if (totalCount > pageSize * pageCount) {  
	            pageCount++;  
	        }
			data.setTotal(totalCount);
			int startRow = (pageIndex - 1) * pageSize;
			int endRow = pageIndex * pageSize;
			sql.append(listSql);
			sql.append(") TAB_ WHERE ROWNUM <= ?  ) WHERE RN > ?");
			data.setRows(jdbcTemplate.queryForList(sql.toString(),ArrayUtils.addAll(para, new Object[]{endRow,startRow})));
		} catch (Exception e) {
			SysLogUtil.error(e);
			
		}
		return data;
	}
	
	/**
	 * 方法名: queryPagingList   
	 *  建立者： 薄景仁 
	 * 建立时间：2013-6-26 下午02:16:16 
	 * 描述: 分页查询方法
	 * 参数：countSql 说明：查询记录条数的sql语句，例如select count(*) from t_user
	 * 参数：listSql 说明：查询记录的sql语句，例如select * from t_user
	 * 参数：para 说明：查询记录sql语句的预编译参数
	 * 参数：pageIndex 说明：查询的页的索引数
	 * 参数：pageSize 说明：查询的每页的记录数
	 * 参数：rowMapper 说明：用于构造vo的RowMapper
	 * 返回类型 PagingJson  
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	protected PagingJson queryPagingList(String countSql, String listSql, Object[] para, int pageIndex, int pageSize,RowMapper rowMapper) {
		PagingJson data = new PagingJson();
		try {
			StringBuilder sql = new StringBuilder();
			sql.append(" SELECT * FROM  (  SELECT TAB_.*, ROWNUM RN  FROM (");			
			int totalCount = jdbcTemplate.queryForInt(countSql,para);			
			int pageCount = totalCount / pageSize;
			if (totalCount > pageSize * pageCount) {  
	            pageCount++;  
	        }
			data.setTotal(totalCount);
			int startRow = (pageIndex - 1) * pageSize;
			int endRow = pageIndex * pageSize;
			sql.append(listSql);
			sql.append(") TAB_ WHERE ROWNUM <= ?  ) WHERE RN > ?");
			Object p[] = ArrayUtils.addAll(para, new Object[]{endRow,startRow});
			data.setRows(jdbcTemplate.query(sql.toString(),p,rowMapper));
		} catch (Exception e) {
			SysLogUtil.error(e);
			
		}
		return data;
	}
}


