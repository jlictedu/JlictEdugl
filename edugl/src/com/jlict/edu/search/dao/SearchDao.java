package com.jlict.edu.search.dao;

import org.springframework.stereotype.Repository;
import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;

@Repository
public class SearchDao extends BaseDao {
	public PagingJson querySearch(int pageIndex, int pageSize) {
		String countSql = "SELECT COUNT(ID) FROM T_STUDENT";
		String querySql = "SELECT ID, REBUILD,RESIT,EXAMINATION,ATONIC, FROM T_TYPE";
		Object[] para = null;
		
		return this.queryPagingList(countSql, querySql, para, pageIndex, pageSize, new SearchRowMapper());
	}

	public SearchVo getSearch(String id) {
		String sql = "SSELECT ID,REBUILD,RESIT,EXAMINATION,ATONIC, FROM T_TYPE WHERE ID = ?";
		Object[] para = {id};
		
		return this.jdbcTemplate.queryForObject(sql, para, new SearchRowMapper());
	}
}

