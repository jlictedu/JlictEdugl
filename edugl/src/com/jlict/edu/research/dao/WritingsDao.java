package com.jlict.edu.research.dao;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;

@Repository
public class WritingsDao extends BaseDao {
	public PagingJson queryUsers(int pageIndex, int pageSize) {
		String countSql = "SELECT COUNT(ID) FROM T_WRITINGS";
		String querySql = "SELECT ID,WRITINGS_NAME,WRITINGS_PRESS, WRITINGS_PUBLICATIONTIME,WRITINGS_ROLE,WRITINGS_WORDNUMBER FROM T_WRITINGS";
		Object[] para = null;
		
		return this.queryPagingList(countSql, querySql, para, pageIndex, pageSize, new WritingsItemRowMapper());
	}

	public WritingsItemVo getWritings(String id) {
		String sql = "SELECT  ID,WRITINGS_NAME,WRITINGS_PRESS, WRITINGS_PUBLICATIONTIME,WRITINGS_ROLE,WRITINGS_WORDNUMBER FROM T_WRITINGS WHERE ID = ?";
		Object[] para = {id};
		
		return this.jdbcTemplate.queryForObject(sql, para, new WritingsItemRowMapper());
	}
}
