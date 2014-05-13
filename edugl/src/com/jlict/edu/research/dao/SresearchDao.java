package com.jlict.edu.research.dao;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;

@Repository
public class SresearchDao extends BaseDao {
	public PagingJson queryUsers(int pageIndex, int pageSize) {
		String countSql = "SELECT COUNT(ID) FROM T_SRESEARCH";
		String querySql = "SELECT ID,SRESEARCH_PROJECTNAME,SRESEARCH_PROJECTSOURCES,SRESEARCH_BEGINENDTIME,SREASERCH_FUNDS,SREASERCH_FUNDSAVALIABLE,SREASERCH_PERFORMANCE,SREASERCH_ROLE FROM T_SRESEARCH";
		Object[] para = null;
		
		return this.queryPagingList(countSql, querySql, para, pageIndex, pageSize, new SresearchItemRowMapper());
	}

	public SresearchItemVo getSresearch(String id) {
		String sql = "SELECT SRESEARCH_PROJECTNAME,SRESEARCH_PROJECTSOURCES,SRESEARCH_BEGINENDTIME,SREASERCH_FUNDS,SREASERCH_FUNDSAVALIABLE,SREASERCH_PERFORMANCE,SREASERCH_ROLE FROM T_SRESEARCH WHERE ID = ?";
		Object[] para = {id};
		
		return this.jdbcTemplate.queryForObject(sql, para, new SresearchItemRowMapper());
	}
}
