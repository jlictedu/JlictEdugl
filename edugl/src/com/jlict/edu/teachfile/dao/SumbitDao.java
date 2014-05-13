package com.jlict.edu.teachfile.dao;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;

@Repository
public class SumbitDao extends BaseDao {
	public PagingJson queryUsers(int pageIndex, int pageSize) {
		String countSql = "SELECT COUNT(ID) FROM T_SUMBIT";
		String querySql = "SELECT SUMBIT_NAME,SUMBIT_JBOTITLE,SUMBIT_MESSAGE,SUMBIT_SUMBITTIME,SUMBIT_COMPLETING FROM T_SUMBIT";
		Object[] para = null;
		
		return this.queryPagingList(countSql, querySql, para, pageIndex, pageSize, new ConnectItemRowMapper());
	}

	public SumbitItemVo getSumbit(String id) {
		String sql = "SELECT SUMBIT_NAME,SUMBIT_JBOTITLE,SUMBIT_MESSAGE,SUMBIT_SUMBITTIME,SUMBIT_COMPLETING FROM T_SUMBIT WHERE ID = ?";
		Object[] para = {id};
		
		return this.jdbcTemplate.queryForObject(sql, para, new SumbitItemRowMapper());
	}
}
