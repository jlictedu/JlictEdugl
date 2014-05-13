/**
 * 
 */
package com.jlict.edu.sys.dao;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;

/**
 * <p>Title: com.jlict.sys.dao.LoginDao.java</p>
 * <p>Description: 登录模块持久层</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Repository
public class LoginDao extends BaseDao {
	/**
	 * 方法名: login   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-6-25 上午01:01:44 
	 * 描述: 验证登录信息是否正确
	 * 参数：userName 说明：用户名
	 * 参数：password 说明：密码
	 * 返回类型 boolean       
	 */
	public boolean login(String userName,String password){
		String sql = "SELECT COUNT(*) FROM T_LOGIN WHERE USER_NAME=? AND PASSWORD=?";
		Object [] para = {userName,password};
		return 1==this.jdbcTemplate.queryForInt(sql,para);
	}
	
	public boolean validatePassword(String userId,String password){
		String sql = "SELECT COUNT(*) FROM T_LOGIN WHERE USER_ID=? AND PASSWORD=?";
		Object [] para = {userId,password};
		return 1==this.jdbcTemplate.queryForInt(sql,para);
	}
}
