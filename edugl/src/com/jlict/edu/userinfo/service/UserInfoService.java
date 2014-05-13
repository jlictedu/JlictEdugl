/**
 * 
 */
package com.jlict.edu.userinfo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.userinfo.dao.UserInfoDao;

/**
 * <p>Title: com.jlict.edu.userinfo.service.UserInfo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Service
public class UserInfoService {

	@Autowired
	private UserInfoDao dao;
	/**
	 * 方法名： insertUser
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月30日 下午2:14:42
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 String
	 */
	public String insertUser(String name, String age) {
		return this.dao.insertUser(name, age);
	}
	
}
