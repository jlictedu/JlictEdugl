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
import com.jlict.edu.entrance.dao.JobExperienceVo;
import com.jlict.edu.entrance.dao.StudentVo;
import com.jlict.edu.entrance.dao.TeacherEntranceDao;
import com.jlict.edu.entrance.dao.TeacherVo;
import com.jlict.edu.entrance.dao.WorkDao;
import com.jlict.edu.sys.dao.UserDao;
import com.jlict.edu.sys.dao.UserVo;

@Service
public class TeacherEntranceService {
	@Autowired
	TeacherEntranceDao TeacherEntranceDao;
	@Autowired
	UserDao UserDao;
	@Autowired	
	EducationDao educationdao;
	@Autowired
	 FamilyDao familydao;
	@Autowired
	WorkDao workdao;
/**
 * 
 * 方法名: queryprofessional   
 * 建立者： 于旭东
 * 建立时间：2014-1-1 下午02:14:42 
 * 描述: 获得职称
 * 参数：para 说明：TODO
 * 返回类型 List       
 */
	public List queryprofessional() {
		// TODO Auto-generated method stub
		return this.TeacherEntranceDao.queryprofessional();
	}
    /**
     * 
     * 方法名: queryeUser   
     * 建立者： 于旭东
     * 建立时间：2014-1-1 下午02:15:10 
     * 描述:根据条件查询教职工信息
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
		// TODO Auto-generated method stub
		return TeacherEntranceDao.queryeUser(pageIndex, pageSize, dp1,dp2,professional,name,sex, station);
	}
	/**
	 * 
	 * 方法名: insertep   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午02:17:11 
	 * 描述: 插入教职工信息
	 * 参数：userVo 说明：用户实体类
	 * 参数：teacherVo 说明：教职工信息实体类
	 * 参数：educateList 说明：教育信息链表
	 * 参数：familyList 说明：家庭信息链表
	 * 参数：jobExperienceList 说明：工作信息链表
	 * 返回类型 void       
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void insertep(UserVo userVo, TeacherVo teacherVo,
			List<EducateExperienceVo> educateList, List<FamilyVo> familyList,
			List<JobExperienceVo> jobExperienceList) {
		// TODO Auto-generated method stub
		List l=this.TeacherEntranceDao.select();
		TeacherVo s=(TeacherVo) l.get(0);
		String ss=s.getId();
		userVo.setId(ss);
		this.TeacherEntranceDao.insertuser(userVo);
		teacherVo.setId(ss);
		this.TeacherEntranceDao.insertStudent(teacherVo);
		
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
		
		JobExperienceVo wkvo=null;;
		for(int i=0; i<jobExperienceList.size(); i++){
			wkvo=jobExperienceList.get(i);
			wkvo.setUserId(ss);
			//edvo.setXh(i+1);
			this.workdao.insertwk(wkvo);
		}
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
	 * 方法名: getTeacherbyId   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午02:11:52 
	 * 描述: 根据id查询教职工
	 * 参数：id 说明：员工id
	 * 返回类型 TeacherVo       
	 */
	public TeacherVo getTeacherbyId(String id) {
		// TODO Auto-generated method stub
		return TeacherEntranceDao.getTeacherbyId(id);
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
    * 方法名: getworkById   
    * 建立者： 于旭东
    * 建立时间：2014-1-1 下午02:19:45 
    * 描述: 根据id查询工作信息
    * 参数：id 说明：员工id
    * 返回类型 List       
    */
	public List getworkById(String id) {
		// TODO Auto-generated method stub
		return workdao.queryById(id);
	}
	/**
	 * 
	 * 方法名: updateteacher   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午02:21:58 
	 * 描述: 更新教职工信息
	 * 参数：userVo 说明：用户实体类
	 * 参数：teacherVo 说明：教职工信息实体类
	 * 参数：educateList 说明：教育信息链表
	 * 参数：familyList 说明：家庭信息链表
	 * 参数：jobExperienceList 说明：工作信息链表
	 * 返回类型 void       
	 */
	@Transactional(propagation=Propagation.REQUIRED,rollbackFor=Exception.class)
	public void updateteacher(UserVo userVo, TeacherVo teacherVo,
			List<EducateExperienceVo> educateList, List<FamilyVo> familyList,
			List<JobExperienceVo> jobExperienceList) {
		// TODO Auto-generated method stub

		this.TeacherEntranceDao.updateUser(userVo);
		this.TeacherEntranceDao.updateteacher(teacherVo);
		
		
		this.educationdao.deleteed(teacherVo.getId());
		EducateExperienceVo edvo=null;;
		for(int i=0; i<educateList.size(); i++){
			edvo=educateList.get(i);
			this.educationdao.insertEducateExperience(edvo);
		}
		this.familydao.deletefamily(teacherVo.getId());
		FamilyVo flvo=null;;
		for(int i=0; i<familyList.size(); i++){
			flvo=familyList.get(i);
			this.familydao.insertfl(flvo);
		}
		this.workdao.deletewk(teacherVo.getId());
		JobExperienceVo wkvo=null;;
		for(int i=0; i<jobExperienceList.size(); i++){
			wkvo=jobExperienceList.get(i);
			this.workdao.insertwk(wkvo);
		}
		
	}
	

	

}
