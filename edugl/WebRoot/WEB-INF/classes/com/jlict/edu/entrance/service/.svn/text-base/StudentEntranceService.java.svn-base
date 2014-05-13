package com.jlict.edu.entrance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.entrance.dao.EducateExperienceVo;
import com.jlict.edu.entrance.dao.EducationDao;
import com.jlict.edu.entrance.dao.FamilyDao;
import com.jlict.edu.entrance.dao.FamilyVo;
import com.jlict.edu.entrance.dao.StudentEntranceDao;
import com.jlict.edu.entrance.dao.StudentVo;
import com.jlict.edu.sys.dao.UserDao;
import com.jlict.edu.sys.dao.UserVo;


@Service
public class StudentEntranceService {
	@Autowired
	StudentEntranceDao StudentEntranceDao;
	@Autowired
	UserDao UserDao;
	@Autowired	
	EducationDao educationdao;
	@Autowired
	 FamilyDao familydao;
	/**
	 * 
	 * 方法名: getdpmbByid   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午02:06:18 
	 * 描述: 根据id查询子部门
	 * 参数：id 说明：部门id
	 * 返回类型 List       
	 */
	public List getdpmbByid(String id) {
		
		return StudentEntranceDao.getdpmbByid(id);
	}
    /**
     * 
     * 方法名: queryDepartment   
     * 建立者： 于旭东
     * 建立时间：2014-1-1 下午02:06:49 
     * 描述: 查询所有部门
     * 返回类型 List       
     */
	public List queryDepartment() {
		// TODO Auto-generated method stub
		return StudentEntranceDao.queryDepartment();
	}
    /**
     * 
     * 方法名: queryeUser   
     * 建立者： 于旭东
     * 建立时间：2014-1-1 下午02:07:34 
     * 描述: 根据条件查询学生信息
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
		return StudentEntranceDao.queryeUser(pageIndex, pageSize, dp1,dp2,dp3,name,sex, studentNumber);
		
	}
	/**
	 * 
	 * 方法名: insertep   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午02:10:12 
	 * 描述: 插入一个学生信息
	 * 参数：userVo 说明：用户实体类
	 * 参数：studentVo 说明：学生信息实体类
	 * 参数：educateList 说明：教育信息链表
	 * 参数：familyList 说明：家庭信息链表
	 * 返回类型 void       
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertep(UserVo userVo, StudentVo studentVo,
			List<EducateExperienceVo> educateList, List<FamilyVo> familyList) {
		// TODO Auto-generated method stub
		List l=this.StudentEntranceDao.select();
		StudentVo s=(StudentVo) l.get(0);
		String ss=s.getId();
		userVo.setId(ss);
		this.StudentEntranceDao.insertuser(userVo);
		studentVo.setId(ss);
		this.StudentEntranceDao.insertStudent(studentVo);
		
		EducateExperienceVo edvo=null;;
		for(int i=0; i<educateList.size(); i++){
			edvo=educateList.get(i);
			edvo.setUserId(ss);
			//edvo.setXh(i+1);
			this.educationdao.insertEducateExperience(edvo);
		}
		FamilyVo flvo=null;;
		for(int i=0; i<familyList.size(); i++){
			flvo=familyList.get(i);
			flvo.setUserId(ss);
			//edvo.setXh(i+1);
			this.familydao.insertfl(flvo);
		}
		
	}
/**
 * 
 * 方法名: getStudentbyId   
 * 建立者： 于旭东
 * 建立时间：2014-1-1 下午02:11:52 
 * 描述: 根据id查询学生
 * 参数：para 说明：TODO
 * 返回类型 StudentVo       
 */
	public StudentVo getStudentbyId(String id) {
		// TODO Auto-generated method stub
		return StudentEntranceDao.getStudentbyId(id);
	}
/**
 * 
 * 方法名: geteducationById   
 * 建立者： 于旭东
 * 建立时间：2014-1-1 下午02:12:16 
 * 描述: 根据id查询教育信息
 * 参数：id 说明：员工id
 * 返回类型 List       
 */
	public List geteducationById(String id) {
		// TODO Auto-generated method stub
		return educationdao.queryById(id);
	}
/**
 * 
 * 方法名: getfamilyById   
 * 建立者： 于旭东
 * 建立时间：2014-1-1 下午02:12:49 
 * 描述: 根据id查询家庭信息
 * 参数：id 说明：员工id
 * 返回类型 List       
 */
	public List getfamilyById(String id) {
		// TODO Auto-generated method stub
		return familydao.queryById(id);
	}
/**
 * 
 * 方法名: updatestudent   
 * 建立者： 于旭东
 * 建立时间：2014-1-1 下午02:13:48 
 * 描述: 更新学生信息
 * 参数：userVo 说明：用户实体类
 * 参数：studentVo 说明：学生信息实体类
 * 参数：educateList 说明：教育信息链表
 * 参数：familyList 说明：家庭信息链表
 * 返回类型 void       
 */
	
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updatestudent(UserVo userVo, StudentVo studentVo,
			List<EducateExperienceVo> educateList, List<FamilyVo> familyList) {
		// TODO Auto-generated method stub
		
		this.StudentEntranceDao.updateUser(userVo);
		this.StudentEntranceDao.updatestudent(studentVo);
		
		
		this.educationdao.deleteed(studentVo.getId());
		EducateExperienceVo edvo=null;;
		for(int i=0; i<educateList.size(); i++){
			edvo=educateList.get(i);
			this.educationdao.insertEducateExperience(edvo);
		}
		this.familydao.deletefamily(studentVo.getId());
		FamilyVo flvo=null;;
		for(int i=0; i<familyList.size(); i++){
			flvo=familyList.get(i);
			this.familydao.insertfl(flvo);
		}
		
	}



	


	

	

}
