/**
 * 
 */
package com.jlict.edu.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.manager.dao.RoleDao;

/**
 * <p>Title: com.jlict.hrgl.manager.service.RoleService.java</p>
 * <p>Description: 系统角色模块服务层</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Service
public class RoleService {
	@Autowired
	RoleDao roleDao;
	
	/**
	 * 方法名: queryRole   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午04:29:42 
	 * 描述: 查询系统角色信息
	 * 返回类型 List       
	 */
	@SuppressWarnings("rawtypes")
	public List queryRole(){
		return this.roleDao.queryRole();
	}
}
