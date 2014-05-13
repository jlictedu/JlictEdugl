/**
 * 
 */
package com.jlict.edu.sys.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.jlict.edu.core.util.Md5;
import com.jlict.edu.sys.dao.LoginDao;
import com.jlict.edu.sys.dao.MenuDao;
import com.jlict.edu.sys.dao.SysMenuVo;
import com.jlict.edu.sys.dao.UserDao;
import com.jlict.edu.sys.dao.UserVo;


/**
 * <p>Title: com.jlict.sys.service.LoginService.java</p>
 * <p>Description: </p>
 * <p>Copyright: 员工登录业务层Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Service
public class LoginService {
	@Autowired
	private LoginDao loginDao;
	@Autowired
	private MenuDao menuDao;
	@Autowired
	private UserDao userDao;
	
	/**
	 * 方法名: Login   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:36:47 
	 * 描述: 登录并返回用户信息
	 * 参数：userName 说明：用户id
	 * 参数：password 说明：密码
	 * 返回类型 UserVo       
	 */
	public UserVo login(String userName,String password){
		if(this.loginDao.login(userName, Md5.getMD5(password))){
			return userDao.getUserByUserName(userName);
		}
		else{
			return null;
		}
	}
	
	public boolean validatePassword(String userId,String password){
		return this.loginDao.validatePassword(userId, password);
	}
	
	/**
	 * 方法名: getMenuData   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:37:37 
	 * 描述: TODO(这里用一句话描述这个方法的作用)
	 * 参数：departmentId 说明：部门id
	 * 参数：stationId 说明：岗位id
	 * 返回类型 List<SysMenuVo>       
	 */
	public List<SysMenuVo>getMenuData(String departmentId, String stationId){
		return menuDao.getMenu(departmentId, stationId);
	}
}
