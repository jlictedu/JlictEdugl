package com.jlict.edu.file.dao;

import org.springframework.stereotype.Repository;
import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;

@Repository
public class FileDao extends BaseDao {
	public PagingJson queryFile(int pageIndex, int pageSize) {
		String countSql = "SELECT COUNT(ID) FROM T_STUDENT";
		String querySql = "SELECT ID, QUESTIONS,ANSWER,ROLL,PAPERANALYSIS, FROM T_TYPE";
		Object[] para = null;
		
		return this.queryPagingList(countSql, querySql, para, pageIndex, pageSize, new FileRowMapper());
	}

	public FileVo getFile(String id) {
		String sql = "SSELECT ID,QUESTIONS,ANSWER,ROLL,PAPERANALYSIS, FROM T_TYPE WHERE ID = ?";
		Object[] para = {id};
		
		return this.jdbcTemplate.queryForObject(sql, para, new FileRowMapper());
	}
}