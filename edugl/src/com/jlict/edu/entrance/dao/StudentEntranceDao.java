package com.jlict.edu.entrance.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.manager.dao.DepartmentRowMapper;
import com.jlict.edu.sys.dao.UserVo;








@Repository
public class StudentEntranceDao extends BaseDao{
    /**
     * 
     * 方法名: getdpmbByid   
     * 建立者： 于旭东
     * 建立时间：2014-1-1 下午02:36:53 
     * 描述: 根据id查询子部门
     * 参数：id 说明：子部门id
     * 返回类型 List       
     */
	public List getdpmbByid(String id) {
		String sql = "SELECT DEPT_ID,DEPT_NAME,BOSS_DEPT_ID FROM T_DEPARTMENT where BOSS_DEPT_ID="+id;
		return this.jdbcTemplate.query(sql, new DepartmentRowMapper());	

	}
    /**
     * 
     * 方法名: queryDepartment   
     * 建立者： 于旭东
     * 建立时间：2014-1-1 下午02:37:37 
     * 描述: 查询最高部门
     * 参数：para 说明：TODO
     * 返回类型 List       
     */
	public List queryDepartment() {
		String sql = "SELECT * FROM T_DEPARTMENT WHERE BOSS_DEPT_ID IS NULL";
		return this.jdbcTemplate.query(sql, new DepartmentRowMapper());	
	}
    /**
     * 
     * 方法名: queryeUser   
     * 建立者： 于旭东
     * 建立时间：2014-1-1 下午02:38:51 
     * 描述:根据条件查询教职工信息
     * 参数：pageIndex 说明：页数
     * 参数：pageSize 说明：行数
     * 参数：dp1 说明：学校id
     * 参数：dp2 说明：系部id
     * 参数：dp3 说明：班级id
     * 参数：name 说明：姓名
     * 参数：sex 说明：性别
     * 参数：studentNumber 说明：学号
     * 返回类型 PagingJson       
     */
    		
	public PagingJson queryeUser(int pageIndex, int pageSize, String dp1,
			String dp2, String dp3, String name, String sex,
			String studentNumber) {
		// TODO Auto-generated method stub
			StringBuilder countSql = new StringBuilder();
			countSql.append("SELECT COUNT(T_USER.USER_ID) FROM T_USER LEFT JOIN t_student ON t_student.ID=T_USER.USER_ID WHERE VALID='1' ");
			StringBuilder listSql = new StringBuilder();
			listSql.append("SELECT t_student.STUDENT_NUMBER,to_char(t_student.BORN_DATE,'yyyy-mm-dd') BORN_DATE,to_char(t_student.JOIN_DATE,'yyyy-mm-dd') JOIN_DATE,t_student.dept_id,t_student.political_appearance,T_USER.NAME,T_USER.USER_ID,t_student.SEX,t_student.NATION,");
			listSql.append("HOUSE_REGISTE FROM T_USER LEFT JOIN");
			listSql.append(" t_student ON t_student.ID=T_USER.USER_ID WHERE VALID='1' and station_id='22'");
			StringBuilder queryCondition = new StringBuilder();
			List<Object> para = new ArrayList<Object>();
			if(dp1!=null){
				queryCondition.append(" AND t_student.SCHOOL_ID = ?");
				para.add(dp1);
			}
			if(dp2!=null){
				queryCondition.append(" AND t_student.DEPT_ID = ?");
				para.add(dp2);
			}
			if(dp3!=null){
				queryCondition.append(" AND t_student.CLASS_ID = ?");
				para.add(dp3);
			}
			if(sex!=null){
				queryCondition.append(" AND t_student.SEX = ?");
				para.add(sex);
			}
			
	        if(studentNumber!=null){
				queryCondition.append(" AND t_student.STUDENT_NUMBER = ?");
				para.add(studentNumber);
			}
	        if(name!=null){
				queryCondition.append(" AND T_user.name = ?");
				para.add(name);
			}
	       countSql.append(queryCondition);		
	       listSql.append(queryCondition);
	       return this.queryPagingList(countSql.toString(), listSql.toString(), para.toArray(), pageIndex, pageSize, new StudentMapperSummary());

		}

	
    /**
     * 
     * 方法名: insertuser   
     * 建立者： 于旭东
     * 建立时间：2014-1-1 下午02:39:09 
     * 描述: 插入用户信息
     * 参数：vo 说明：用户实体类
     * 返回类型 void       
     */
	public void insertuser(UserVo vo) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append("INSERT INTO T_USER (USER_ID,NAME,MODIFY_ID,MODIFY_DATE,VALID,STATION_ID,DEPT_ID)");
		sql.append(" VALUES (?,?,?,SYSDATE,1,?,?)");
		Object[] params = new Object[]{vo.getId(),vo.getName(),vo.getLastModify(),
				vo.getStationId(),vo.getDepartmentId()};
		this.jdbcTemplate.update(sql.toString(),params);
	}
     /**
      * 
      * 方法名: select   
      * 建立者： 于旭东
      * 建立时间：2014-1-1 下午02:39:38 
      * 描述: 查询下一个id
      * 参数：para 说明：TODO
      * 返回类型 List       
      */
	@SuppressWarnings("unchecked")
	public List select() {
		String sql="select s_user.nextval user_id from dual";
		return this.jdbcTemplate.query(sql, new StudentIdMapper());	
		
		
	}
     /**
      * 
      * 方法名: insertStudent   
      * 建立者： 于旭东
      * 建立时间：2014-1-1 下午02:39:54 
      * 描述: 插入学生信息
      * 返回类型 void       
      */
	public void insertStudent(StudentVo vo) {
	
		String sql = "INSERT INTO T_STUDENT(ID,SEX,POLITICAL_APPEARANCE,CREDENTIAL_NUMBER,NATION,BORN_DATE,BIRTH_PLACE,HOUSE_REGISTE,JOIN_DATE,EMERGENCY_CONTACT_PERSON,EMERGENCY_CONTACT_TEL,DEPT_ID,CLASS_ID,SCHOOL_ID) ";
		sql=sql+" VALUES(?,?,?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?,TO_DATE(?,'YYYY-MM-DD'),?,?,?,?,?)";
		Object[] params = new Object[] {vo.getId(), vo.getSex(),vo.getPolitical_appearance(),vo.getCredential_number(), vo.getNation(), vo.getBorn_date(), vo.getBirth_place(),
					vo.getHouse_registe(), vo.getJoin_date(), vo.getEmergency_contact_person(), vo.getEmergency_contact_tel(),vo.getDept_id(),vo.getClass_id(),vo.getSchool_id()
					}; 
		    jdbcTemplate.update(sql,params);
			
		
		
	}
	/**
	 * 
	 * 方法名: getStudentbyId   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午02:40:53 
	 * 描述: 根据id查询学生信息
	 * 参数：id 说明：用户id
	 * 返回类型 StudentVo       
	 */
	@SuppressWarnings("unchecked")
	public StudentVo getStudentbyId(String id) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append("select ID,STUDENT_NUMBER,name,v.station_name,v.station_id,SEX,POLITICAL_APPEARANCE,CREDENTIAL_NUMBER,NATION, to_char(BORN_DATE,'yyyy-mm-dd') BORN_DATE ,BIRTH_PLACE,HOUSE_REGISTE,to_char(JOIN_DATE,'yyyy-mm-dd') JOIN_DATE ,EMERGENCY_CONTACT_PERSON,EMERGENCY_CONTACT_TEL,a.dept_name cname,  d.dept_name dname,d.dept_id did,a.dept_id cid,c.dept_id sid,c.dept_name sname from t_student t join T_user on t.id=T_user.User_Id join t_Department d on d.dept_id=t.dept_id join t_Department a on a.dept_id=t.class_id  join t_Department c on c.dept_id=t.school_id join t_Dm_Station v on v.station_id=T_user.Station_Id where t.id=? and t_user.valid=1");
		Object[] params=new Object []{id};
		return super.jdbcTemplate.queryForObject(sql.toString(), params, new StudentMapper());
	}
    /**
     * 
     * 方法名: updateUser   
     * 建立者： 于旭东
     * 建立时间：2014-1-1 下午02:41:17 
     * 描述: 更新用户信息
     * 参数：vo 说明：用户信息实体类
     * 返回类型 boolean       
     */
	public boolean updateUser(UserVo vo) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append("UPDATE T_USER SET ");
		List<Object> para = new ArrayList<Object>();		
		if(vo.getDepartmentId()!=null){
			sql.append("DEPT_ID = ?,");
			para.add(vo.getDepartmentId());
		}
		if(vo.getStationId()!=null){
			sql.append("STATION_ID = ?,");
			para.add(vo.getStationId());
		}
		if(vo.getName()!=null){
			sql.append("NAME = ?,");
			para.add(vo.getName());
		}
				
		sql.append(" MODIFY_ID=? ,MODIFY_DATE=sysdate WHERE USER_ID=?");
		para.add(vo.getLastModify());
		para.add(vo.getId());
		return 1==jdbcTemplate.update(sql.toString(),para.toArray());
	
	}
     /**
      * 
      * 方法名: updatestudent   
      * 建立者： 于旭东
      * 建立时间：2014-1-1 下午02:41:49 
      * 描述: 更新学生信息
      * 参数：vo 说明：学生信息实体类
      * 返回类型 boolean       
      */
	public boolean updatestudent(StudentVo vo) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append( "UPDATE T_STUDENT SET SEX=?,POLITICAL_APPEARANCE=?,CREDENTIAL_NUMBER=?,NATION=?,EMERGENCY_CONTACT_TEL=?,");
		sql.append(" BORN_DATE=TO_DATE(?,'YYYY-MM-DD'),BIRTH_PLACE=?,HOUSE_REGISTE=?,JOIN_DATE=TO_DATE(?,'YYYY-MM-DD'),");
		sql.append(" EMERGENCY_CONTACT_PERSON=? ,CLASS_ID=?,DEPT_ID=?,SCHOOL_ID=? WHERE ID=? ");
		Object[] params = new Object[] {vo.getSex(),vo.getPolitical_appearance(),vo.getCredential_number(),vo.getNation(),vo.getEmergency_contact_tel(),
				vo.getBorn_date(),vo.getBirth_place(),vo.getHouse_registe(),vo.getJoin_date(),
				vo.getEmergency_contact_person(),vo.getClass_id(),vo.getDept_id(),vo.getSchool_id(),vo.getId()}; 
	    return 1==jdbcTemplate.update(sql.toString(),params);
	}


	


	

}
