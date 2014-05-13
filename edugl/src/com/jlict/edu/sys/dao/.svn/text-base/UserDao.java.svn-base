/**
 * 
 */
package com.jlict.edu.sys.dao;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;

/**
 * <p>Title: com.jlict.hrgl.sys.dao.UserDao.java</p>
 * <p>Description: 用户模块持久层</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Repository
public class UserDao extends BaseDao {
	
	/**
	 * 方法名: getUserByUserName   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-12-21 下午05:05:59 
	 * 描述: 通过员工用户名获取员工基本信息
	 * 参数：userName 说明：用户名
	 * 返回类型 UserVo       
	 */
	public UserVo getUserByUserName(String userName){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT USER_ID,NAME,DEPT_ID,STATION_ID,MODIFY_ID,MODIFY_DATE ");
		sql.append("FROM T_USER WHERE USER_ID=(SELECT USER_ID FROM T_LOGIN WHERE USER_NAME = ? ) AND VALID=1");
		Object [] para = {userName};
		return this.jdbcTemplate.queryForObject(sql.toString(), para, new UserVoRowMapper());
	}
	
	/**
	 * 方法名: getUserById   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-6-25 上午01:03:18 
	 * 描述: 通过员工id获取员工基本信息
	 * 参数：id 说明：员工id
	 * 返回类型 UserVo       
	 */
	public UserVo getUserById(String id){
		try{
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT USER_ID,NAME,DEPT_ID,STATION_ID,MODIFY_ID,MODIFY_DATE ");
		sql.append("FROM T_USER WHERE USER_ID=? AND VALID=1");
		Object [] para = {id};
		return this.jdbcTemplate.queryForObject(sql.toString(), para, new UserVoRowMapper());
		}catch(EmptyResultDataAccessException e){
			return null;
		}
	}
	
	/**
	 * 方法名: mofifyPassword   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-27 上午08:56:35 
	 * 描述: 更改密码
	 * 参数：id 说明：员工id
	 * 参数：newPassword 说明：新密码
	 * 返回类型 boolean       
	 */
	public boolean mofifyPassword(String userID,String newPassword){
		String sql = "UPDATE T_LOGIN SET PASSWORD=? WHERE USER_ID=?";
		Object[] para = new Object[]{newPassword,userID};
		return 1==this.jdbcTemplate.update(sql, para);
	}	
		
	/**
	 * 方法名: delete   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-8-15 上午10:33:24 
	 * 描述: 注销员工
	 * 参数：id 说明：员工id
	 * 返回类型 void       
	 */
	public boolean delete(String id){
		String sql = "UPDATE T_USER SET VALID='0' WHERE USER_ID=?";
		Object[] params = new Object[]{id};
		return 1==this.jdbcTemplate.update(sql.toString(),params);
	}
}
