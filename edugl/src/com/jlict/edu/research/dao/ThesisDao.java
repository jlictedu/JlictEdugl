package com.jlict.edu.research.dao;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;

@Repository
public class ThesisDao extends BaseDao {
	public PagingJson queryUsers(int pageIndex, int pageSize) {
		String countSql = "SELECT COUNT(ID) FROM T_THESIS";
		String querySql = "SELECT ID,THESIS_TITLE, THESIS_PERIODICAL, THESIS_POSTTIME,THESIS_ROLE,THESIS_LEVEL,THESIS_NAME FROM T_THESIS";
		Object[] para = null;
		
		return this.queryPagingList(countSql, querySql, para, pageIndex, pageSize, new ThesisItemRowMapper());
	}

	public ThesisItemVo getThesis(String id) {
		String sql = "SELECT  THESIS_TITLE, THESIS_PERIODICAL, THESIS_POSTTIME,THESIS_ROLE,THESIS_LEVEL,THESIS_NAME,ID FROM T_THESIS WHERE ID = ?";
		Object[] para = {id};
		
		return this.jdbcTemplate.queryForObject(sql, para, new ThesisItemRowMapper());
	}
}
