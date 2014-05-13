package com.jlict.edu.cour.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;


/**
 * <p>Title: com.jlict.edu.foster.dao.FosterDao.java</p>
 * <p>Description: 排课管理持久层</p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 刘向平
 * @version 1.0
 */
@Repository
public class CourDao extends BaseDao{
	
	
	
	/**
	 * 方法名: readCourDown   
	 * 建立者： 刘向平
	 * 建立时间：2014-1-10 下午04:40:45 
	 * 描述: 查询课程信息	 
	 * 返回类型 List<UpVo>       
	 */
	public List<UpVo> readCourDown() {
		try{
			StringBuffer sql=new StringBuffer();			
			sql.append("SELECT TC.ID,CODING,TC.NAME,ATTRIBUTE,EXAM,CREDIT,");
			sql.append("PRELECT,EXPERIMENT,COMPUTER,TERM,SORT AS SORTID,TCS.NAME AS SORT,");
			sql.append("ALLPERIOD,TC.DEPT_ID AS DEPTID,TD.DEPT_NAME AS DEPT,");
			sql.append("YEAR,WEEKS,WEEKCLA FROM T_CURRICULA TC,T_DEPARTMENT TD,");
			sql.append("T_CC_SORT TCS WHERE TC.DEPT_ID=TD.DEPT_ID  ");
			
			Object[] para = new Object[]{};
			return this.jdbcTemplate.query( sql.toString(), para, new UpRowMapper());
			}catch(EmptyResultDataAccessException e){
				return null;
			}
	}

	/**
	 * 方法名: readCourUp   
	 * 建立者： 刘向平
	 * 描述: 查询院系基本
	 * 参数：deptid 说明：部门id
	 * 参数：deptid2 说明：部门id
	 * 参数：id 说明：年份id
	 * 返回类型 UpVo       
	 */
	public UpVo readCourUp(String deptid,String deptid2,String id) {
		try{
			StringBuffer sql=new StringBuffer();
			sql.append("SELECT TD.DEPT_ID AS DEPTID,DEPT_NAME AS DEPTNAME,");
			sql.append("BOSS_DEPT_ID AS BOSSDEPTID ,");
			sql.append("(SELECT DEPT_NAME FROM T_DEPARTMENT WHERE ");
			sql.append("DEPT_ID=(SELECT BOSS_DEPT_ID FROM T_DEPARTMENT ");
			sql.append("WHERE DEPT_ID=? )) AS BOSSDEPTNAME,YEAR ");
			sql.append("FROM T_DEPARTMENT TD,T_CC_YEAR TC WHERE ");
			sql.append("TC.DEPT_ID=TD.DEPT_ID  AND TD.DEPT_ID=? AND TC.ID=?");
			sql.append("GROUP BY TD.DEPT_ID,DEPT_NAME,BOSS_DEPT_ID,YEAR ");
			Object[] para = new Object[]{deptid,deptid2,id};
			return this.jdbcTemplate.queryForObject(sql.toString(), para, new UpRowMapper());
			}catch(EmptyResultDataAccessException e){
				return null;
			}
	}

	/**
	 * 方法名: SaveCour   
	 * 建立者： 刘向平
	 * 建立时间：2014-1-10 下午04:40:30 
	 * 描述: 保存教师信息
	 * 参数：id 说明：课程ID	
	 * 返回类型 boolean       
	 */
	public boolean SaveAll(String id, String departmentId, String year) {
		String sql = "INSERT INTO T_CC_YEAR VALUES (?,?,?)";
		Object[] para = new Object[]{id,departmentId, year};
		return 1==this.jdbcTemplate.update(sql, para);
	}
	
	
	/**
	 * 方法名: SaveCour   
	 * 建立者： 刘向平 
	 * 建立时间：2014-1-12 上午11:30:38 
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
		String sql = "INSERT INTO T_CURRICULA VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] para = new Object[]{id,coding,name,attribute ,exam,credit,prelect,experiment,computer,term,sort,allperiod,deptid,yearid,weeks,weekcla};
		return 1==this.jdbcTemplate.update(sql, para);
	}

}
