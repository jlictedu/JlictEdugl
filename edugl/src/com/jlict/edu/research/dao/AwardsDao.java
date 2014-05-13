package com.jlict.edu.research.dao;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;

@Repository
public class AwardsDao extends BaseDao {
	public PagingJson queryUsers(int pageIndex, int pageSize) {
		String countSql = "SELECT COUNT(ID) FROM T_AWARDS";
		String querySql = "SELECT ID,AWARDS_NAME,AWARDS_LEVEL,AWARDS_RANK,AWARDS_ROLE FROM T_AWARDS";
		Object[] para = null;
		
		return this.queryPagingList(countSql, querySql, para, pageIndex, pageSize, new AwardsItemRowMapper());
	}

	public AwardsItemVo getAwards(String id) {
		String sql = "SELECT AWARDS_NAME,AWARDS_LEVEL,AWARDS_RANK,AWARDS_ROLE FROM T_AWARDS WHERE ID = ?";
		Object[] para = {id};
		
		return this.jdbcTemplate.queryForObject(sql, para, new AwardsItemRowMapper());
	}

}
