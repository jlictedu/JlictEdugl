package com.jlict.edu.teachfile.dao;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;

@Repository
public class ConnectDao extends BaseDao {
	public PagingJson queryUsers(int pageIndex, int pageSize) {
		String countSql = "SELECT COUNT(ID) FROM T_CONNECT";
		String querySql = "SELECT CONNECT_NAME,CONNECT_MANIFEST,CONNECT_STATE,CONNECT_NOTES,CONNECT_REMARK  FROM T_CONNECT";
		Object[] para = null;
		
		return this.queryPagingList(countSql, querySql, para, pageIndex, pageSize, new SumbitItemRowMapper());
	}

	public ConnectItemVo getConnect(String id) {
		String sql = "SELECT CONNECT_NAME,CONNECT_MANIFEST,CONNECT_STATE,CONNECT_NOTES,CONNECT_REMARK  FROM T_CONNECT WHERE ID = ?";
		Object[] para = {id};
		
		return this.jdbcTemplate.queryForObject(sql, para, new ConnectItemRowMapper());
	}
}
