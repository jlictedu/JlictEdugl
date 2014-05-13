/**
 * 
 */
package com.jlict.edu.core.dao;

import java.util.List;

/**
 * <p>Title: com.jlict.hrgl.core.dao.PagingJson.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */

public class PagingJson {
	
	@SuppressWarnings("rawtypes")
	List rows;
	int total;
	@SuppressWarnings("rawtypes")
	public List getRows() {
		return rows;
	}
	@SuppressWarnings("rawtypes")
	public void setRows(List rows) {
		this.rows = rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
}
