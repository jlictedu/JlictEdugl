package com.jlict.edu.entrance.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class TeacherMapperSummary implements RowMapper{

	public Object mapRow(ResultSet resultSet, int rowNum) throws SQLException {
		TeacherVo vo = new TeacherVo();
		vo.setId(resultSet.getString("ID"));
        vo.setName(resultSet.getString("NAME"));
		vo.setPolitical_appearance(resultSet.getString("POLITICAL_APPEARANCE"));
		vo.setBorn_date(resultSet.getString("BORN_DATE"));	
		vo.setHouse_registe(resultSet.getString("HOUSE_REGISTE"));
		vo.setJoin_date(resultSet.getString("JOIN_DATE"));
		vo.setNation(resultSet.getString("NATION"));
		vo.setDept_name(resultSet.getString("DNAME"));
		//vo.setClass_name(resultSet.getString("CNAME"));
		vo.setSchool_name(resultSet.getString("SNAME"));
		vo.setDept_id(resultSet.getString("DID"));
		vo.setSchool_id(resultSet.getString("SID"));
	    vo.setSex(resultSet.getString("SEX"));
	    vo.setBirth_place(resultSet.getString("BIRTH_PLACE"));
	   vo.setCredential_number(resultSet.getString("CREDENTIAL_NUMBER"));
	   vo.setStation(resultSet.getString("STATION_NAME"));
	   vo.setStationid(resultSet.getString("STATION_ID"));
	   vo.setEmergency_contact_person(resultSet.getString("EMERGENCY_CONTACT_PERSON"));
	   vo.setEmergency_contact_tel(resultSet.getString("EMERGENCY_CONTACT_TEL"));
	   vo.setProfessional(resultSet.getString("PROFESSIONAL"));
	   vo.setProfessional_id(resultSet.getString("PROFESSIONAL_ID"));
       return vo;
	}

}
