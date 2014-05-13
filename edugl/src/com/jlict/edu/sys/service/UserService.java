/**
 * 
 */
package com.jlict.edu.sys.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.util.Md5;
import com.jlict.edu.sys.dao.UserDao;
import com.jlict.edu.sys.dao.UserVo;

/**
 * <p>Title: com.jlict.hrgl.sys.service.UserService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Service
public class UserService {
	@Autowired
	private UserDao userDao;
	/**
	 * 方法名: getUserByJobNumber   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-6-25 上午01:03:18 
	 * 描述: 通过工号获取员工基本信息
	 * 参数：userName 说明：用户名
	 * 返回类型 UserVo       
	 */
	public UserVo getUserByUserName(String userName){		
		return userDao.getUserByUserName(userName);
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
		return userDao.getUserById(id);
	}
	
	/**
	 * 方法名: mofifyPassword   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-27 上午09:03:34 
	 * 描述: 更改密码
	 * 参数：id 说明：员工id
	 * 参数：newPassword 说明：新密码
	 * 返回类型 boolean       
	 */
	public boolean mofifyPassword(String id,String newPassword){
		return this.userDao.mofifyPassword(id, Md5.getMD5(newPassword));
	}
}
