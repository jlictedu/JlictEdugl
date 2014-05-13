/**
 * 
 */
package com.jlict.edu.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.manager.dao.DepartmentDao;
import com.jlict.edu.manager.dao.DepartmentVo;

/**
 * <p>Title: com.jlict.hrgl.manager.service.DepartmentService.java</p>
 * <p>Description: 部门管理服务层</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Service
public class DepartmentService {
	@Autowired
	DepartmentDao departmentDao;
	/**
	 * 方法名: queryDepartmentDetail   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午03:35:49 
	 * 描述: 部门详细信息分页查询
	 * 参数：pageIndex 说明：分页索引
	 * 参数：pageSize 说明：单个分页记录数
	 * 参数：departmentName 说明： 部门名称
	 * 参数：name 说明：名称
	 * 参数：people 说明：人数
	 * 返回类型 PagingJson       
	 */
	public PagingJson queryDepartmentDetail(int pageIndex,int pageSize, String name, int people){
		return this.departmentDao.queryDepartmentDetail(pageIndex, pageSize, name, people);
	}
	
	/**
	 * 方法名: queryDepartment   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:02:47 
	 * 描述: 部门信息查询
	 * 返回类型 List<DepartmentVo>       
	 */
	public List<DepartmentVo> queryDepartment() {
		return this.departmentDao.queryDepartment();
	}
	
	/**
	 * 方法名: updateName   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:16:18 
	 * 描述: 修改部门名称
	 * 参数：id 说明：部门id
	 * 参数：name 说明：部门名称
	 * 返回类型 boolean       
	 */
	public boolean updateName(String id,String name,String bossId){
		return this.departmentDao.updateDepartmentName(id, name,bossId);
	}
	
	/**
	 * 方法名: delete   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:17:08 
	 * 描述: 删除部门
	 * 参数：id 说明：部门id
	 * 返回类型 boolean       
	 */
	public boolean delete(String id){
		return this.departmentDao.deleteDepartment(id);
	}
	
	/**
	 * 方法名: create   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:17:14 
	 * 描述: 创建部门
	 * 参数：name 说明：部门名称
	 * 返回类型 boolean       
	 */
	public boolean create(String name,String bossId){
		return this.departmentDao.createDepartment(name,bossId);
	}
	
	/**
	 * 方法名: queryDepartmentById   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:17:12 
	 * 描述: 通过部门id查询部门信息
	 * 参数：id 说明：部门id
	 * 返回类型 DepartmentVo       
	 */
	public DepartmentVo queryDepartmentById(String id){
		return this.departmentDao.queryDepartmentById(id);
	}
}
