/**
 * 
 */
package com.jlict.edu.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.manager.dao.PermissionDao;

/**
 * <p>Title: com.jlict.hrgl.manager.service.PermissionService.java</p>
 * <p>Description: 权限模块服务层</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Service
public class PermissionService {
	@Autowired
	PermissionDao permissionDao;
	/**
	 * 方法名: queryRule   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午04:30:13 
	 * 描述: 权限规则分页查询
	 * 参数：pageIndex 说明：分页索引
	 * 参数：pageSize 说明：单个分页记录数
	 * 参数：departmentName 说明： 部门名称
	 * 参数：stationName 说明：岗位名称
	 * 参数：roleName 说明：系统角色名称
	 * 返回类型 PagingJson       
	 */
	public PagingJson queryRule(int pageIndex, int pageSize, String departmentName, String stationName, String roleName){
		return this.permissionDao.queryRule(pageIndex, pageSize, departmentName, stationName, roleName);
	}
	
	/**
	 * 方法名: createRule   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午04:32:19 
	 * 描述: 创建权限规则
	 * 参数：departmentId 说明： 部门Id
	 * 参数：stationId 说明：岗位Id
	 * 参数：roleId 说明：系统角色Id
	 * 返回类型 boolean       
	 */
	public boolean createRule(String departmentId, String stationId, String roleId){
		return this.permissionDao.createRule(departmentId, stationId, roleId);
	}
	
	/**
	 * 方法名: deleteRule   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午04:33:07 
	 * 描述: 删除权限规则
	 * 参数：departmentId 说明： 部门Id
	 * 参数：stationId 说明：岗位Id
	 * 参数：roleId 说明：系统角色Id
	 * 返回类型 boolean       
	 */
	public boolean deleteRule(String departmentId, String stationId, String roleId){
		return this.permissionDao.deleteRule(departmentId, stationId, roleId);
	}
}
