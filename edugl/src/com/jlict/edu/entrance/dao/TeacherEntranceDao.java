package com.jlict.edu.entrance.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.sys.dao.UserVo;



@Repository
public class TeacherEntranceDao extends BaseDao{
	/**
	 * 
	 * 方法名: queryprofessional   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午02:25:11 
	 * 描述: 查询职称
	 * 参数：para 说明：TODO
	 * 返回类型 List<ProfessionalVo>       
	 */
	public List<ProfessionalVo> queryprofessional(){
		String sql = "SELECT ID,name FROM T_DM_PROFESSIONAL";
		return this.jdbcTemplate.query(sql, new ProfessionalMapper());
	}
    /**
     * 
     * 方法名: queryeUser   
     * 建立者： 于旭东
     * 建立时间：2014-1-1 下午02:25:46 
     * 描述: 根据条件查询教职工信息
     * 参数：pageIndex 说明：页数
     * 参数：pageSize 说明：行数
     * 参数：dp1 说明：学校id
     * 参数：dp2 说明：系部id
     * 参数：professional 说明：职称
     * 参数：name 说明：姓名
     * 参数：sex 说明：性别
     * 参数：station 说明：角色职务
     * 返回类型 PagingJson       
     */
	public PagingJson queryeUser(int pageIndex, int pageSize, String dp1,
			String dp2, String professional, String name, String sex,
			String station) {
		StringBuilder countSql = new StringBuilder();
		countSql.append("SELECT COUNT(T_USER.USER_ID) FROM T_USER  JOIN t_teacher ON t_teacher.ID=T_USER.USER_ID WHERE VALID='1' ");
		StringBuilder listSql = new StringBuilder();
		listSql.append("SELECT user_id,p.name professional,to_char(t_teacher.BORN_DATE,'yyyy-mm-dd') BORN_DATE");
		listSql.append(",to_char(t_teacher.JOIN_DATE,'yyyy-mm-dd') JOIN_DATE,t_teacher.dept_id,t_teacher.political_appearance,");
		listSql.append(" T_USER.NAME,t_teacher.SEX,t_teacher.NATION,HOUSE_REGISTE FROM T_USER  JOIN t_teacher ON t_teacher.ID=T_USER.USER_ID JOIN T_DM_professional p on p.id=t_teacher.professional_id join t_dm_station s on s.station_id=T_user.station_id WHERE VALID='1' ");
		StringBuilder queryCondition = new StringBuilder();
		List<Object> para = new ArrayList<Object>();
		if(dp1!=null){
			queryCondition.append(" AND t_teacher.SCHOOL_ID = ?");
			para.add(dp1);
		}
		if(dp2!=null){
			queryCondition.append(" AND t_teacher.DEPT_ID = ?");
			para.add(dp2);
		}
		if(professional!=null){
			queryCondition.append(" AND t_teacher.professional_id = ?");
			para.add(professional);
		}
		if(sex!=null){
			queryCondition.append(" AND t_teacher.SEX = ?");
			para.add(sex);
		}
		
        if(station!=null){
			queryCondition.append(" AND t_user.station_id = ?");
			para.add(station);
		}
        if(name!=null){
			queryCondition.append(" AND T_user.name = ?");
			para.add(name);
		}
       countSql.append(queryCondition);		
       listSql.append(queryCondition);
       return this.queryPagingList(countSql.toString(), listSql.toString(), para.toArray(), pageIndex, pageSize, new TeacherMapper());
	}

	@SuppressWarnings("unchecked")
	public List select() {
		String sql="select s_user.nextval user_id from dual";
		return this.jdbcTemplate.query(sql, new TeacherIdMapper());	
	}
   /**
    * 
    * 方法名: insertuser   
    * 建立者： 于旭东
    * 建立时间：2014-1-1 下午02:26:46 
    * 描述: 插入用户信息
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
      * 方法名: insertStudent   
      * 建立者： 于旭东
      * 建立时间：2014-1-1 下午02:27:20 
      * 描述: 插入学生信息
      * 参数：vo 说明：学生信息实体类
      * 返回类型 void       
      */
	public void insertStudent(TeacherVo vo) {
		// TODO Auto-generated method stub
		String sql = "INSERT INTO T_TEACHER(ID,SEX,POLITICAL_APPEARANCE,CREDENTIAL_NUMBER,NATION,BORN_DATE,BIRTH_PLACE,HOUSE_REGISTE,JOIN_DATE,EMERGENCY_CONTACT_PERSON,EMERGENCY_CONTACT_TEL,DEPT_ID,SCHOOL_ID，PROFESSIONAL_ID) ";
		sql=sql+" VALUES(?,?,?,?,?,TO_DATE(?,'YYYY-MM-DD'),?,?,TO_DATE(?,'YYYY-MM-DD'),?,?,?,?,?)";
		Object[] params = new Object[] {vo.getId(), vo.getSex(),vo.getPolitical_appearance(),vo.getCredential_number(), vo.getNation(), vo.getBorn_date(), vo.getBirth_place(),
					vo.getHouse_registe(), vo.getJoin_date(), vo.getEmergency_contact_person(), vo.getEmergency_contact_tel(),vo.getDept_id(),vo.getSchool_id(),vo.getProfessional_id()
					}; 
		    jdbcTemplate.update(sql,params);
	}
     /**
      * 
      * 方法名: getTeacherbyId   
      * 建立者： 于旭东
      * 建立时间：2014-1-1 下午02:28:09 
      * 描述: 根据id查询教职工
      * 参数：id 说明：教职工id
      * 返回类型 TeacherVo       
      */
	@SuppressWarnings("unchecked")
	public TeacherVo getTeacherbyId(String id) {
		StringBuilder sql=new StringBuilder();
		sql.append("select t.ID,t_user.name,v.station_name,p.name PROFESSIONAL,professional_id,v.station_id,HOUSE_REGISTE,SEX,POLITICAL_APPEARANCE,CREDENTIAL_NUMBER,NATION, to_char(BORN_DATE,'yyyy-mm-dd') BORN_DATE ,BIRTH_PLACE,HOUSE_REGISTE,to_char(JOIN_DATE,'yyyy-mm-dd') JOIN_DATE ,EMERGENCY_CONTACT_PERSON,EMERGENCY_CONTACT_TEL, d.dept_name dname,d.dept_id did,c.dept_id sid, c.dept_name sname from T_TEACHER t join T_user on t.id=T_user.User_Id left join t_Department d on d.dept_id=t.dept_id  join t_Department c on c.dept_id=t.school_id join t_Dm_Station v on v.station_id=T_user.Station_Id join t_dm_professional p on p.id=t.professional_id  where t.id=? and t_user.valid=1");
		Object[] params=new Object []{id};
		return super.jdbcTemplate.queryForObject(sql.toString(), params, new TeacherMapperSummary());
	}
    /**
     * 
     * 方法名: updateUser   
     * 建立者： 于旭东
     * 建立时间：2014-1-1 下午02:28:55 
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
     * 方法名: updateteacher   
     * 建立者： 于旭东
     * 建立时间：2014-1-1 下午02:29:29 
     * 描述: 更新教职工信息
     * 参数：vo 说明：教职工信息实体类
     * 返回类型 boolean       
     */
	public boolean updateteacher(TeacherVo vo) {
		// TODO Auto-generated method stub
		StringBuilder sql=new StringBuilder();
		sql.append( "UPDATE T_teacher SET SEX=?,POLITICAL_APPEARANCE=?,CREDENTIAL_NUMBER=?,NATION=?,EMERGENCY_CONTACT_TEL=?,");
		sql.append(" BORN_DATE=TO_DATE(?,'YYYY-MM-DD'),BIRTH_PLACE=?,HOUSE_REGISTE=?,JOIN_DATE=TO_DATE(?,'YYYY-MM-DD'),");
		sql.append(" EMERGENCY_CONTACT_PERSON=? ,professional_id=?,DEPT_ID=?,SCHOOL_ID=? WHERE ID=? ");
		Object[] params = new Object[] {vo.getSex(),vo.getPolitical_appearance(),vo.getCredential_number(),vo.getNation(),vo.getEmergency_contact_tel(),
				vo.getBorn_date(),vo.getBirth_place(),vo.getHouse_registe(),vo.getJoin_date(),
				vo.getEmergency_contact_person(),vo.getProfessional_id(),vo.getDept_id(),vo.getSchool_id(),vo.getId()}; 
	    return 1==jdbcTemplate.update(sql.toString(),params);
	}

}
