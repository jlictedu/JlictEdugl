package com.jlict.edu.foster.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.foster.dao.FosterDao;
import com.jlict.edu.foster.dao.FosterVo;
import com.jlict.edu.foster.dao.UpVo;

/**
 * <p>Title: com.jlict.edu.foster.service.FosterService.java</p>
 * <p>Description: 培养方案管理服务层</p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 王森玉
 * @version 1.0
 */
@Service
public class FosterService {
	@Autowired
	FosterDao fosterDao;
	
	/**
	 * 方法名: getAll   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-10 下午04:53:08 
	 * 描述: 查询所在院系培养方案入学年份
	 * 参数：deptid 说明：部门id
	 * 参数：pageIndex 说明：分页索引
	 * 参数：pageSize 说明：单个分页记录数
	 * 返回类型 PagingJson       
	 */
	public PagingJson getAll(String dept_id, int pageIndex, int pageSize){
		return this.fosterDao.getAll(dept_id,dept_id, pageIndex, pageSize);
	}

	/**
	 * 方法名: readFosterDown   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-10 下午04:53:13 
	 * 描述: 查询课程信息
	 * 参数：id 说明：年份id
	 * 参数：pageIndex 说明：分页索引
	 * 参数：pageSize 说明：单个分页记录数
	 * 返回类型 PagingJson       
	 */
	public PagingJson readFosterDown(String id,int pageIndex, int pageSize) {		
		return this.fosterDao.readFosterDown(id,pageIndex, pageSize);
	}

	/**
	 * 方法名: readFosterUp   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-10 下午04:53:16 
	 * 描述: 查询院系基本
	 * 参数：deptid 说明：部门id
	 * 参数：id 说明：年份id
	 * 返回类型 UpVo       
	 */
	public UpVo readFosterUp(String deptid,String id) {	
		return this.fosterDao.readFosterUp(deptid,deptid,id);
	}

	/**
	 * 方法名: getDepartment   
	 * 建立者：王森玉
	 * 建立时间：2014-1-10 下午04:53:19 
	 * 描述: 查询部门信息
	 * 参数：deptid 说明：部门id
	 * 返回类型 List       
	 */
	@SuppressWarnings("unchecked")
	public List getDepartment(String deptId) {
		return this.fosterDao.queryDepartment(deptId,deptId,deptId);
	}

	/**
	 * 方法名: SaveAll   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-10 下午04:53:22 
	 * 描述: 保存入学年份信息
	 * 参数：id 说明：年份id
	 * 参数：deptid 说明：部门id
	 * 参数：year 说明：入学年份
	 * 返回类型 boolean       
	 */
	public boolean SaveAll(String id, String departmentId, String year) {
		return this.fosterDao.SaveAll(id,departmentId, year);
	}

	/**
	 * 方法名: deleteTC   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-10 下午04:53:27 
	 * 描述: 删除相应年份培养方案
	 * 参数：deptid 说明：部门id
	 * 参数：id 说明：年份id
	 * 返回类型 void       
	 */
	public void deleteTC(String deptid, String id) {
		this.fosterDao.deleteTC(deptid, id);	
	}

	/**
	 * 方法名: deleteTCY   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-10 下午04:53:31 
	 * 描述: 删除相应年份
	 * 参数：deptid 说明：部门id
	 * 参数：id 说明：年份id
	 * 返回类型 boolean       
	 */
	public boolean deleteTCY(String deptid, String id) {
		return this.fosterDao.deleteTCY(deptid, id);	
	}
	
	/**
	 * 方法名: getSort   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-12 上午11:19:25 
	 * 描述: 查询院系信息
	 * 返回类型 List       
	 */
	@SuppressWarnings("unchecked")
	public List getSort() {
		return this.fosterDao.querySort();
	}
	
	/**
	 * 方法名: SaveFoster   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-12 上午11:20:22 
	 * 描述: 保存课程信息
	 * 参数：id 说明：课程id
	 * 参数：coding 说明：课程编码
	 * 参数：name 说明：课程名称
	 * 参数：attribute 说明：课程属性
	 * 参数：exam 说明：考核方式
	 * 参数：credit 说明：课程学分
	 * 参数：prelect 说明：讲课学时
	 * 参数：experiment 说明：实验学时
	 * 参数：computer 说明：上机学时
	 * 参数：term 说明：上课学期
	 * 参数：sort 说明：课程类别
	 * 参数：allperiod 说明：总学时
	 * 参数：deptid 说明：院系名称
	 * 参数：yearid 说明：入学年份
	 * 返回类型 boolean       
	 */
	public boolean SaveFoster(String id, String coding, String name,
			String attribute, String exam, String credit, String prelect,
			String experiment, String computer, String term, String sort,
			String allperiod, String deptid, String yearid,String weeks,String weekcla) {
		return this.fosterDao.SaveFoster(id,coding,name,attribute ,exam,credit,prelect,experiment,computer,term,sort,allperiod,deptid,yearid,weeks,weekcla);
	}

	/**
	 * 方法名: UpadteFoster   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午02:24:19 
	 * 描述: 读取课程信息
	 * 参数：id 说明：课程id
	 * 返回类型 FosterVo       
	 */
	public FosterVo UpadteFoster(String id) {		
		return this.fosterDao.UpadteFoster(id);
	}

	/**
	 * 方法名: deleteFoster   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午02:26:22 
	 * 描述: 删除课程信息
	 * 参数：id 说明：课程id
	 * 返回类型 boolean       
	 */
	public boolean deleteFoster(String id) {
		return this.fosterDao.deleteFoster(id);	
	}

	/**
	 * 方法名: getYear   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午02:28:11 
	 * 描述: 获取年份信息
	 * 参数：deptid 说明：院系信息
	 * 返回类型 List       
	 */
	@SuppressWarnings("unchecked")
	public List getYear(String deptid) {
		return this.fosterDao.getYear(deptid);
	}

	/**
	 * 方法名: Copy   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午02:29:17 
	 * 描述: 复制部分培养方案
	 * 参数：yearid 说明：入学年份
	 * 参数：deptid 说明：院系信息
	 * 返回类型 boolean       
	 */
	public int Copy(String yearid, String deptid) {
		return this.fosterDao.Copy(yearid,deptid);
		
	}

	/**
	 * 方法名: copyFoster   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午06:05:59 
	 * 描述: 复制培养方案
	 * 参数：id 说明：课程id
	 * 参数：year 说明：入学年份
	 * 返回类型 boolean       
	 */
	public boolean copyFoster(String id, String year) {
		return this.fosterDao.copyFoster(id,year);
	}

	/**
	 * 方法名: deleteCopy   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午06:07:57 
	 * 描述: 清空缓存
	 * 返回类型 void       
	 */
	public void deleteCopy() {
		this.fosterDao.deleteCopy();
	}

}
