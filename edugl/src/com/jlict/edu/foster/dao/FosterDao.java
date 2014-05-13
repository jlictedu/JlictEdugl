package com.jlict.edu.foster.dao;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;

/**
 * <p>Title: com.jlict.edu.foster.dao.FosterDao.java</p>
 * <p>Description: 培养方案管理持久层</p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 王森玉
 * @version 1.0
 */
@Repository
public class FosterDao extends BaseDao{
	/**
	 * 方法名: getAll   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-10 下午04:40:18 
	 * 描述: 查询所在院系培养方案入学年份
	 * 参数：deptid 说明：部门id
	 * 参数：deptid2 说明：部门id
	 * 参数：pageIndex 说明：分页索引
	 * 参数：pageSize 说明：单个分页记录数
	 * 返回类型 PagingJson       
	 */
	public PagingJson getAll(String deptid,String deptid2,int pageIndex, int pageSize){
		String countSql = "SELECT COUNT(YEAR) FROM T_CC_YEAR TC JOIN T_DEPARTMENT TD ON TC.DEPT_ID=TD.DEPT_ID WHERE TC.DEPT_ID=? OR TD.BOSS_DEPT_ID=?";
		
		String listSql="SELECT ID,TC.DEPT_ID AS DEPTID,DEPT_NAME AS DEPTNAME,YEAR  FROM T_CC_YEAR TC JOIN T_DEPARTMENT TD ON TC.DEPT_ID=TD.DEPT_ID where  TC.DEPT_ID=? OR TD.BOSS_DEPT_ID=? ORDER BY DEPTID,YEAR";
		Object[] para = new Object[]{deptid,deptid2};
		return this.queryPagingList(countSql, listSql, para, pageIndex, pageSize,new AllRowMapper());
	}

	/**
	 * 方法名: queryDepartment   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-10 下午04:40:22 
	 * 描述: 查询部门信息
	 * 参数：deptid 说明：部门id
	 * 参数：deptid2 说明：部门id
	 * 参数：deptid3 说明：部门id
	 * 返回类型 List<DepartmentVo>       
	 */
	public List<BaseVo> queryDepartment(String deptid,String deptid2,String deptid3) {		
		String sql = "SELECT DEPT_ID AS ID,DEPT_NAME AS NAME FROM T_DEPARTMENT  WHERE BOSS_DEPT_ID=? OR (BOSS_DEPT_ID!=? AND DEPT_ID=?)";			
		Object[] para = new Object[]{deptid,deptid2,deptid3};
		return this.jdbcTemplate.query(sql,para, new BaseRowMapper());		
	}
	
	/**
	 * 方法名: readFosterDown   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-10 下午04:40:45 
	 * 描述: 查询课程信息
	 * 参数：id 说明：年份id
	 * 参数：pageIndex 说明：分页索引
	 * 参数：pageSize 说明：单个分页记录数
	 * 返回类型 PagingJson       
	 */
	public PagingJson readFosterDown(String id,int pageIndex, int pageSize) {
		try{
			StringBuffer sql=new StringBuffer();
			String countSql = "SELECT COUNT(YEAR) FROM T_CURRICULA WHERE YEAR=?";
			sql.append("SELECT TC.ID,CODING,TC.NAME,ATTRIBUTE ,EXAM,CREDIT,");
			sql.append("PRELECT,EXPERIMENT,COMPUTER,TERM,SORT AS SORTID,TCS.NAME AS SORT,");
			sql.append("ALLPERIOD,TC.DEPT_ID AS DEPTID,TD.DEPT_NAME AS DEPT,");
			sql.append("YEAR,WEEKS,WEEKCLA FROM T_CURRICULA TC,T_DEPARTMENT TD,");
			sql.append("T_CC_SORT TCS WHERE TC.DEPT_ID=TD.DEPT_ID AND TC.SORT=TCS.ID");
			sql.append(" AND YEAR=? ORDER BY TERM");
			Object[] para = new Object[]{id};
			return this.queryPagingList(countSql, sql.toString(), para, pageIndex, pageSize,new FosterRowMapper());
			}catch(EmptyResultDataAccessException e){
				return null;
			}
	}

	/**
	 * 方法名: readFosterUp   
	 * 建立者： 王森玉
	 * 描述: 查询院系基本
	 * 参数：deptid 说明：部门id
	 * 参数：deptid2 说明：部门id
	 * 参数：id 说明：年份id
	 * 返回类型 UpVo       
	 */
	public UpVo readFosterUp(String deptid,String deptid2,String id) {
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
	 * 方法名: SaveAll   
	 * 建立者： 王森玉 
	 * 建立时间：2014-1-10 下午04:40:30 
	 * 描述: 保存入学年份信息
	 * 参数：id 说明：年份id
	 * 参数：deptid 说明：部门id
	 * 参数：year 说明：入学年份
	 * 返回类型 boolean       
	 */
	public boolean SaveAll(String id, String departmentId, String year) {
		String sql = "INSERT INTO T_CC_YEAR VALUES (?,?,?)";
		Object[] para = new Object[]{id,departmentId, year};
		return 1==this.jdbcTemplate.update(sql, para);
	}

	/**
	 * 方法名: deleteTC   
	 * 建立者： 王森玉 
	 * 建立时间：2014-1-10 下午04:40:38 
	 * 描述: 删除相应年份培养方案
	 * 参数：deptid 说明：部门id
	 * 参数：id 说明：年份id
	 * 返回类型 void       
	 */
	public void deleteTC(String deptid, String id) {
		String sql = "DELETE T_CURRICULA WHERE DEPT_ID=? AND YEAR=?";
		Object[] para = new Object[]{deptid,id};
		this.jdbcTemplate.update(sql, para);
	}

	/**
	 * 方法名: deleteTCY   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-10 下午04:30:55 
	 * 描述: 删除相应年份
	 * 参数：deptid 说明：部门id
	 * 参数：id 说明：年份id
	 * 返回类型 boolean       
	 */
	public boolean deleteTCY(String deptid, String id) {
		String sql = "DELETE T_CC_YEAR WHERE DEPT_ID=? AND ID=?";
		Object[] para = new Object[]{deptid,id};
		return 1==this.jdbcTemplate.update(sql, para);
	}
	
	/**
	 * 方法名: querySort   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-12 上午11:30:12 
	 * 描述: 查询院系信息
	 * 返回类型 List<BaseVo>       
	 */
	public List<BaseVo> querySort() {		
		String sql = "SELECT ID,NAME FROM T_CC_SORT";			
		Object[] para = new Object[]{};
		return this.jdbcTemplate.query(sql,para, new BaseRowMapper());		
	}
	
	/**
	 * 方法名: SaveFoster   
	 * 建立者： 王森玉 
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
	public boolean SaveFoster(String id, String coding, String name,
			String attribute, String exam, String credit, String prelect,
			String experiment, String computer, String term, String sort,
			String allperiod, String deptid, String yearid,String weeks,String weekcla) {
		String sql = "INSERT INTO T_CURRICULA VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Object[] para = new Object[]{id,coding,name,attribute ,exam,credit,prelect,experiment,computer,term,sort,allperiod,deptid,yearid,weeks,weekcla};
		return 1==this.jdbcTemplate.update(sql, para);
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
		try{
			StringBuffer sql=new StringBuffer();
			sql.append("SELECT TC.ID,CODING,TC.NAME,ATTRIBUTE ,EXAM,CREDIT,");
			sql.append("PRELECT,EXPERIMENT,COMPUTER,TERM,SORT AS SORTID,TCS.NAME AS SORT,");
			sql.append("ALLPERIOD,TC.DEPT_ID AS DEPTID,TD.DEPT_NAME AS DEPT,");
			sql.append("YEAR,WEEKS,WEEKCLA FROM T_CURRICULA TC,T_DEPARTMENT TD,T_CC_SORT TCS WHERE");
			sql.append(" TC.DEPT_ID=TD.DEPT_ID AND TC.SORT=TCS.ID AND TC.ID=?");
			Object[] para = new Object[]{id};
			return this.jdbcTemplate.queryForObject(sql.toString(), para, new FosterRowMapper());
			}catch(EmptyResultDataAccessException e){
				return null;
			}
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
		String sql = "DELETE T_CURRICULA WHERE ID=?";
		Object[] para = new Object[]{id};
		return 1==this.jdbcTemplate.update(sql, para);
	}

	/**
	 * 方法名: getYear   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午02:28:11 
	 * 描述: 获取年份信息
	 * 参数：deptid 说明：院系信息
	 * 返回类型 List       
	 */
	public List<BaseVo> getYear(String deptid) {
		String sql = "SELECT ID,YEAR AS NAME FROM T_CC_YEAR WHERE DEPT_ID=?";			
		Object[] para = new Object[]{deptid};
		return this.jdbcTemplate.query(sql,para, new BaseRowMapper());
	}
	
	/**
	 * 方法名: Copy   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午02:29:17 
	 * 描述: 复制培养方案
	 * 参数：yearid 说明：入学年份
	 * 参数：deptid 说明：院系信息
	 * 返回类型 boolean       
	 */
	public int Copy(String yearid, String deptid) {
		String sql = "INSERT INTO T_CURRICULACOPY SELECT ID,CODING,NAME,ATTRIBUTE,EXAM,CREDIT,PRELECT,EXPERIMENT,COMPUTER,TERM,SORT,ALLPERIOD,DEPT_ID,WEEKS,WEEKCLA FROM T_CURRICULA WHERE YEAR=? AND DEPT_ID=?";			
		Object[] para = new Object[]{yearid,deptid};
		return this.jdbcTemplate.update(sql, para);
	}

	/**
	 * 方法名: copyFoster   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午06:08:45 
	 * 描述: 复制培养方案
	 * 参数：id 说明：课程id
	 * 参数：year 说明：入学年份
	 * 返回类型 boolean       
	 */
	public boolean copyFoster(String id, String year) {
		StringBuffer sql=new StringBuffer();
		sql.append("INSERT INTO T_CURRICULA VALUES (?,");
		sql.append("(SELECT CODING FROM T_CURRICULACOPY WHERE ID=(SELECT MIN(ID) FROM T_CURRICULACOPY)),");
		sql.append("(SELECT NAME FROM T_CURRICULACOPY WHERE ID=(SELECT MIN(ID) FROM T_CURRICULACOPY)),");
		sql.append("(SELECT ATTRIBUTE FROM T_CURRICULACOPY WHERE ID=(SELECT MIN(ID) FROM T_CURRICULACOPY)),");
		sql.append("(SELECT EXAM FROM T_CURRICULACOPY WHERE ID=(SELECT MIN(ID) FROM T_CURRICULACOPY)),");
		sql.append("(SELECT CREDIT FROM T_CURRICULACOPY WHERE ID=(SELECT MIN(ID) FROM T_CURRICULACOPY)),");
		sql.append("(SELECT PRELECT FROM T_CURRICULACOPY WHERE ID=(SELECT MIN(ID) FROM T_CURRICULACOPY)),");
		sql.append("(SELECT EXPERIMENT FROM T_CURRICULACOPY WHERE ID=(SELECT MIN(ID) FROM T_CURRICULACOPY)),");
		sql.append("(SELECT COMPUTER FROM T_CURRICULACOPY WHERE ID=(SELECT MIN(ID) FROM T_CURRICULACOPY)),");
		sql.append("(SELECT TERM FROM T_CURRICULACOPY WHERE ID=(SELECT MIN(ID) FROM T_CURRICULACOPY)),");
		sql.append("(SELECT SORT FROM T_CURRICULACOPY WHERE ID=(SELECT MIN(ID) FROM T_CURRICULACOPY)),");
		sql.append("(SELECT ALLPERIOD FROM T_CURRICULACOPY WHERE ID=(SELECT MIN(ID) FROM T_CURRICULACOPY)),");
		sql.append("(SELECT DEPT_ID FROM T_CURRICULACOPY WHERE ID=(SELECT MIN(ID) FROM T_CURRICULACOPY)),");
		sql.append("?,");
		sql.append("(SELECT WEEKS FROM T_CURRICULACOPY WHERE ID=(SELECT MIN(ID) FROM T_CURRICULACOPY)),");
		sql.append("(SELECT WEEKCLA FROM T_CURRICULACOPY WHERE ID=(SELECT MIN(ID) FROM T_CURRICULACOPY)))");		
		Object[] para = new Object[]{id,year};
		if(1==this.jdbcTemplate.update(sql.toString(), para)){
			if(this.deleteFosterCopy()){
				return true;
			}
			else{
				return false;
			}
		}
		else{
			return false;
		}
	}

	/**
	 * 方法名: deleteFosterCopy   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午06:09:13 
	 * 描述: 清理已用缓存
	 * 返回类型 boolean       
	 */
	private boolean deleteFosterCopy() {
		String sql = "DELETE T_CURRICULACOPY WHERE ID=(SELECT MIN(ID) FROM T_CURRICULACOPY)";
		Object[] para = new Object[]{};
		return 1==this.jdbcTemplate.update(sql, para);
	}

	/**
	 * 方法名: deleteCopy   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午06:10:26 
	 * 描述: 清空缓存
	 * 返回类型 void       
	 */
	public void deleteCopy() {
		String sql = "DELETE T_CURRICULACOPY";
		Object[] para = new Object[]{};
		this.jdbcTemplate.update(sql, para);
	}
	
}
