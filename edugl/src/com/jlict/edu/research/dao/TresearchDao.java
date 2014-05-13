package com.jlict.edu.research.dao;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;

@Repository
public class TresearchDao extends BaseDao {
	public PagingJson queryUsers(int pageIndex, int pageSize) {
		String countSql = "SELECT COUNT(ID) FROM T_TRESEARCH";
		String querySql = "SELECT ID,TREASERCH_PROJECTNAME,TREASERCH_PROJECTSOURCES,TREASERCH_BEGINENDTIME,TREASERCH_FUNDS,TREASERCH_FUNDSAVALIABLE,TREASERCH_PERFORMANCE,TREASERCH_ROLE FROM T_TRESEARCH";
		Object[] para = null;
		
		return this.queryPagingList(countSql, querySql, para, pageIndex, pageSize, new TresearchItemRowMapper());
	}

	public TresearchItemVo getTresearch(String id) {
		String sql = "SELECT  TREASERCH_PROJECTNAME,TREASERCH_PROJECTSOURCES,TREASERCH_BEGINENDTIME,TREASERCH_FUNDS,TREASERCH_FUNDSAVALIABLE,TREASERCH_PERFORMANCE,TREASERCH_ROLE FROM T_TRESEARCH WHERE ID = ?";
		Object[] para = {id};
		
		return this.jdbcTemplate.queryForObject(sql, para, new TresearchItemRowMapper());
	}

}
