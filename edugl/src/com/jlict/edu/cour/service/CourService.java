package com.jlict.edu.cour.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.cour.dao.CourDao;
import com.jlict.edu.cour.dao.CourVo;
import com.jlict.edu.cour.dao.UpVo;
import com.jlict.edu.cour.dao.BaseVo;

/**
 * <p>Title: com.jlict.edu.foster.service.FosterService.java</p>
 * <p>Description: 排课管理服务层</p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 刘向平
 * @version 1.0
 */
@Service
public class CourService {
	@Autowired
	CourDao courDao;
	
	/**
	 * 方法名: readCourUp   
	 * 建立者： 刘向平
	 * 建立时间：2014-1-10 下午04:53:16 
	 * 描述: 查询院系基本
	 * 参数：deptid 说明：部门id
	 * 参数：id 说明：年份id
	 * 返回类型 UpVo       
	 */
	public UpVo readCourUp(String deptid,String id) {	
		return this.courDao.readCourUp(deptid,deptid,id);
	}
	/**
	 * 方法名: readCourDown   
	 * 建立者： 刘向平
	 * 建立时间：2014-1-10 下午04:53:13 
	 * 描述: 查询课程信息
	 * 参数：id 说明：年份id
	 * 参数：pageIndex 说明：分页索引
	 * 参数：pageSize 说明：单个分页记录数
	 * 返回类型 PagingJson       
	 */
	@SuppressWarnings("unchecked")
	public List readCourDown() {		
		return this.courDao.readCourDown();
	}
	/**
	 * 方法名: SaveCour  
	 * 建立者：刘向平
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
	public boolean SaveCour(String id, String coding, String name,
			String attribute, String exam, String credit, String prelect,
			String experiment, String computer, String term, String sort,
			String allperiod, String deptid, String yearid,String weeks,String weekcla) {
		return this.courDao.SaveCour(id,coding,name,attribute ,exam,credit,prelect,experiment,computer,term,sort,allperiod,deptid,yearid,weeks,weekcla);
	}
	

}
