/**
 * 
 */
package com.jlict.edu.userinfo.dao;

import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;

/**
 * <p>Title: com.jlict.edu.userinfo.dao.UserInfoDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Repository
public class UserInfoDao extends BaseDao {

	/**
	 * 方法名： insertUser
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月30日 下午2:16:14
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 String
	 */
	public String insertUser(String name, String age) {
		String sql = "INSERT INTO T_USER_INFO(ID, NAME, AGE) VALUES(?, ?, ?)";
		String id = UUID.randomUUID().toString();
		
		Object[] para = {id, name, Integer.parseInt(age)};
		
		this.jdbcTemplate.update(sql, para);
		return "true";
	}
	
}
