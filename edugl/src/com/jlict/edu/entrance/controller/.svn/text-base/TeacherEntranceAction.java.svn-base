package com.jlict.edu.entrance.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jlict.edu.core.controller.BaseAction;
import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.core.util.ResultJson;
import com.jlict.edu.core.util.SysLogUtil;
import com.jlict.edu.entrance.dao.EducateExperienceVo;
import com.jlict.edu.entrance.dao.FamilyVo;
import com.jlict.edu.entrance.dao.JobExperienceVo;

import com.jlict.edu.entrance.dao.TeacherVo;
import com.jlict.edu.entrance.service.TeacherEntranceService;
import com.jlict.edu.sys.dao.UserVo;


@Controller
public class TeacherEntranceAction extends BaseAction{
	@Autowired
	TeacherEntranceService TeacherEntranceService;
	/**
	 * 
	 * 方法名: EntranceMain   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午02:01:39 
	 * 描述: 教师录入主界面初始化
	 * 参数：request 说明：HttpServletRequest
	 * 参数：response 说明：HttpServletResponse
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/teacherentrance.do",method=RequestMethod.GET)
	public ModelAndView EntranceMain(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/entrance/TeacherEntranceMain");
	}
	
	/**
	 * 
	 * 方法名: getProfessional   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午02:02:10 
	 * 描述: 获得职称
	 * 参数：request 说明：HttpServletRequest
	 * 参数：response 说明：HttpServletResponse
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/teacherentrance.do",method=RequestMethod.POST,params="m=getprofessional")
	@SuppressWarnings("unchecked")
	@ResponseBody 
	public Object getProfessional(HttpServletRequest request, HttpServletResponse response) {
		List json = null;
		try{
			json = this.TeacherEntranceService.queryprofessional();;
		}catch(Exception e){
			SysLogUtil.error("查询所有部门信息出错",e);
		}
		return json;		
	}
	/**
	 * 
	 * 方法名: queryets   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午02:02:59 
	 * 描述: 根据条件查询教职工信息
	 * 参数：request 说明：HttpServletRequest
	 * 参数：response 说明：HttpServletResponse
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/teacherentrance.do",method=RequestMethod.POST,params="m=query")
	@ResponseBody 
	public Object queryets(HttpServletRequest request,HttpServletResponse response) {
		PagingJson json = null;
		try {
			int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			String dp1 = request.getParameter("dp1");
			String dp2 = request.getParameter("dp2");
			String professional = request.getParameter("professional");
			String name =request.getParameter("name");
			String sex = request.getParameter("sex");
			String station = request.getParameter("station");
			json = this.TeacherEntranceService.queryeUser(pageIndex, pageSize, dp1,dp2,professional,name,sex, station);
			SysLogUtil.info("查询员工信息");
		} catch (Exception e) {
			SysLogUtil.error("查询出错", e);
		}
		return json;
	}
	/**
	 * 
	 * 方法名: insertInit   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午02:04:03 
	 * 描述: 教师信息登记界面初始化
	 * 参数：request 说明：HttpServletRequest
	 * 参数：response 说明：HttpServletResponse
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/teacherentrance.do",method=RequestMethod.GET,params="m=insertInit")
	public ModelAndView insertInit(HttpServletRequest request){
		
		return new ModelAndView("/entrance/TeacherEntranceInsert");
	}
	
	/**
	 * 
	 * 方法名: insertInited   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午08:48:39 
	 * 描述: 初始化教育信息界面
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	
	@RequestMapping(value="/teacherentrance.do",method=RequestMethod.GET,params="m=insertInited")
	public ModelAndView insertInited(HttpServletRequest request){
		return new ModelAndView("/entrance/EducationInsert");
	}
	
	/**
	 * 
	 * 方法名: insertInitfl   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午08:48:39 
	 * 描述: 初始化家庭信息界面
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/teacherentrance.do",method=RequestMethod.GET,params="m=insertInitfl")
	public ModelAndView insertInitfl(HttpServletRequest request){
		return new ModelAndView("/entrance/FamilyInsert");
	}
	
	/**
	 * 
	 * 方法名: insertInitwk   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午08:48:39 
	 * 描述: 初始化工作信息界面
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/teacherentrance.do",method=RequestMethod.GET,params="m=insertInitwk")
	public ModelAndView insertInitwk(HttpServletRequest request){
		return new ModelAndView("/entrance/WorkInsert");
	}
	/**
	 * 
	 * 方法名: Insert   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午08:53:05 
	 * 描述:员工信息登记保存
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@ResponseBody
	@RequestMapping(value="/teacherentrance.do",method=RequestMethod.POST,params="m=Insert")
	public Object Insert(HttpServletRequest request,HttpServletResponse response) {
		ResultJson json=new ResultJson();
		try {
			
		//user
			String dp=request.getParameter("departmentId");
			//String cl=request.getParameter("classId");
			String sc=request.getParameter("schoolId");
			String name = request.getParameter("NAME");
			String userId = this.getUserId(request);
			String station = request.getParameter("stationId");	
			String professionalId = request.getParameter("professionalId");
					
			UserVo userVo = new UserVo();
			userVo.setDepartmentId(dp);
			userVo.setName(name);
			userVo.setLastModify(userId);
			userVo.setStationId(station);
			
			//基本信息
			String sex = request.getParameter("SEX");
			String credential_number = request.getParameter("CREDENTIAL_NUMBER");
			String nation = request.getParameter("NATION");
			String emergency_contact_tel = request.getParameter("EMERGENCY_CONTACT_TEL");
			String born_date = request.getParameter("BORN_DATE");
			String birth_place = request.getParameter("BIRTH_PLACE");
			String house_registe = request.getParameter("HOUSE_REGISTE");
			String join_date = request.getParameter("JOIN_DATE");
			String political_appearance = request.getParameter("POLITICAL_APPEARANCE");
			String emergency_contact_person = request.getParameter("EMERGENCY_CONTACT_PERSON");		
//			int ngrs = Integer.parseInt(request.getParameter("NGRS"));
			TeacherVo teacherVo = new TeacherVo();
			teacherVo.setDept_id(dp);
			teacherVo.setProfessional(professionalId);
			teacherVo.setSchool_id(sc);
			teacherVo.setName(name);
			teacherVo.setBirth_place(birth_place);
			teacherVo.setSex(sex);
			teacherVo.setCredential_number(credential_number);
			teacherVo.setNation(nation);
			teacherVo.setEmergency_contact_tel(emergency_contact_tel);
			teacherVo.setEmergency_contact_person(emergency_contact_person);
			teacherVo.setBorn_date(born_date);
			teacherVo.setJoin_date(join_date);
			teacherVo.setPolitical_appearance(political_appearance);
			teacherVo.setHouse_registe(house_registe);
			teacherVo.setProfessional_id(professionalId);
			//其他信息
			String[] educational = request.getParameterValues("EDUCATIONAL");
			String[] experience = request.getParameterValues("EXPERIENCE");
				String[] start_date = request.getParameterValues("START_DATE");
				String[] end_date = request.getParameterValues("END_DATE");

				int count = educational.length;
			List<EducateExperienceVo> educateList = new ArrayList<EducateExperienceVo>();
			EducateExperienceVo edvo = null;

			for (int i = 0; i < count; i++) {
				edvo = new EducateExperienceVo();
				edvo.setEducationId(educational[i]);
				edvo.setExperience(experience[i]);
				edvo.setStartDate(start_date[i]);
				edvo.setEndDate(end_date[i]);
				educateList.add(edvo);
			}
				
				String[] tel = request.getParameterValues("TEL");
				String[] fl_name = request.getParameterValues("FL_NAME");
				String[] relation = request.getParameterValues("RELATION");
				int countfl = relation.length;
				List<FamilyVo> familyList = new ArrayList<FamilyVo>();
				FamilyVo flvo = null;
				
				for (int i = 0; i < countfl; i++) {
					flvo = new FamilyVo();
					flvo.setTel(tel[i]);
					flvo.setName(fl_name[i]);
					flvo.setRelationId(relation[i]);					
					familyList.add(flvo);
				}
				String[] wk_experience = request.getParameterValues("WK_EXPERIENCE");
				String[] wk_start_date = request.getParameterValues("START_DATE");
				String[] wk_end_date = request.getParameterValues("END_DATE");
				int countwk = wk_experience.length;
				List<JobExperienceVo> jobExperienceList = new ArrayList<JobExperienceVo>();
				JobExperienceVo wkvo = null;
				for (int i = 0; i < countwk; i++) {
					wkvo = new JobExperienceVo();					
					wkvo.setWorkExperience(wk_experience[i]);
					wkvo.setWorkStartDate(wk_start_date[i]);
					wkvo.setWorkEndDate(wk_end_date[i]);
					jobExperienceList.add(wkvo);
				}
			this.TeacherEntranceService.insertep(userVo,teacherVo,educateList,familyList,jobExperienceList);
			
			SysLogUtil.info("登记新信息");
			json.setResultCode(0);
	}catch(Exception e){
		SysLogUtil.error("登记出错",e);
		json.setResultCode(1);
	}
	   return json;
	}
	
	/**
	 * 方法名: deatailInit   
	 * 建立者： 于旭东 
	 * 建立时间：2013-8-2 下午02:47:16 
	 * 描述: 初始化教职工详情信息界面
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/teacherentrance.do",method=RequestMethod.GET,params="m=detailInit")
	public ModelAndView deatailInit(HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id) {
		
		Map map=null;
		try{
			map=new HashMap<String,Object>();
			TeacherVo TeacherVo=this.TeacherEntranceService.getTeacherbyId(id);
			map.put("Teacher", TeacherVo);
			List education=this.TeacherEntranceService.geteducationById(id);
			map.put("education", education);
			List work=this.TeacherEntranceService.getworkById(id);
		    map.put("work", work);
			List family=this.TeacherEntranceService.getfamilyById(id);
			map.put("family", family);
		
			//SysLogUtil.info("查询员工详细信息");
		}catch(Exception e){
			SysLogUtil.error("用户信息详情查看初始化异常！",e);
		}
		return new ModelAndView("/entrance/TeacherEntranceDetail","data",map);		
	}
	/**
	 * 
	 * 方法名: editInit   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午08:46:40 
	 * 描述: 初始化修改教职工信息界面
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/teacherentrance.do",method=RequestMethod.GET,params="m=editInit")
	public ModelAndView editInit(HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id) {
		
		Map map=null;
		try{
			map=new HashMap<String,Object>();
			TeacherVo TeacherVo=this.TeacherEntranceService.getTeacherbyId(id);
			map.put("Teacher", TeacherVo);
			List education=this.TeacherEntranceService.geteducationById(id);
			map.put("education", education);
			List family=this.TeacherEntranceService.getfamilyById(id);
			map.put("family", family);
			List work=this.TeacherEntranceService.getworkById(id);
		    map.put("work", work);
		}catch(Exception e){
			SysLogUtil.error("修改初始化异常！",e);
		}
		return new ModelAndView("/entrance/TeacherEntranceEdit","data",map);		
	}
	
	/**
	 * 
	 * 方法名: update   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午08:48:39 
	 * 描述: 修改教职工信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/teacherentrance.do",method=RequestMethod.POST,params="m=update")
	@ResponseBody 
	public Object update(HttpServletRequest request,HttpServletResponse response) {
		ResultJson json=new ResultJson();
		try {
			
		//user
			String id=request.getParameter("ID");
			String dp=request.getParameter("departmentId");
			String professionalId = request.getParameter("professionalId");
			String sc=request.getParameter("schoolId");
			String name = request.getParameter("NAME");
			String userId = this.getUserId(request);
			String station = request.getParameter("stationId");			
			UserVo userVo = new UserVo();
			userVo.setDepartmentId(dp);
			userVo.setName(name);
			userVo.setLastModify(userId);
			userVo.setStationId(station);
			userVo.setId(id);
			
			//基本信息
			String sex = request.getParameter("SEX");
			String credential_number = request.getParameter("CREDENTIAL_NUMBER");
			String nation = request.getParameter("NATION");
			String emergency_contact_tel = request.getParameter("EMERGENCY_CONTACT_TEL");
			String born_date = request.getParameter("BORN_DATE");
			String birth_place = request.getParameter("BIRTH_PLACE");
			String house_registe = request.getParameter("HOUSE_REGISTE");
			String join_date = request.getParameter("JOIN_DATE");
			String political_appearance = request.getParameter("POLITICAL_APPEARANCE");
			String emergency_contact_person = request.getParameter("EMERGENCY_CONTACT_PERSON");		
//			int ngrs = Integer.parseInt(request.getParameter("NGRS"));
			TeacherVo teacherVo = new TeacherVo();
			teacherVo.setDept_id(dp);
			teacherVo.setSchool_id(sc);
			teacherVo.setName(name);
			teacherVo.setBirth_place(birth_place);
			teacherVo.setSex(sex);
			teacherVo.setCredential_number(credential_number);
			teacherVo.setNation(nation);
			teacherVo.setEmergency_contact_tel(emergency_contact_tel);
			teacherVo.setEmergency_contact_person(emergency_contact_person);
			teacherVo.setBorn_date(born_date);
			teacherVo.setJoin_date(join_date);
			teacherVo.setPolitical_appearance(political_appearance);
			teacherVo.setHouse_registe(house_registe);
			teacherVo.setId(id);
			teacherVo.setProfessional_id(professionalId);
			//其他信息
			String[] educational = request.getParameterValues("EDUCATIONAL");
			String[] experience = request.getParameterValues("EXPERIENCE");
				String[] start_date = request.getParameterValues("START_DATE");
				String[] end_date = request.getParameterValues("END_DATE");

				int count = educational.length;
			List<EducateExperienceVo> educateList = new ArrayList<EducateExperienceVo>();
			EducateExperienceVo edvo = null;

			for (int i = 0; i < count; i++) {
				edvo = new EducateExperienceVo();
				edvo.setUserId(id);
				edvo.setEducationId(educational[i]);
				edvo.setExperience(experience[i]);
				edvo.setStartDate(start_date[i]);
				edvo.setEndDate(end_date[i]);
				educateList.add(edvo);
			}
				
				String[] tel = request.getParameterValues("TEL");
				String[] fl_name = request.getParameterValues("FL_NAME");
				String[] relation = request.getParameterValues("RELATION");
				int countfl = relation.length;
				List<FamilyVo> familyList = new ArrayList<FamilyVo>();
				FamilyVo flvo = null;
				
				for (int i = 0; i < countfl; i++) {
					flvo = new FamilyVo();
					flvo.setUserId(id);
					flvo.setTel(tel[i]);
					flvo.setName(fl_name[i]);
					flvo.setRelationId(relation[i]);					
					familyList.add(flvo);
				}
				String[] wk_experience = request.getParameterValues("WK_EXPERIENCE");
				String[] wk_start_date = request.getParameterValues("START_DATE");
				String[] wk_end_date = request.getParameterValues("END_DATE");
				int countwk = wk_experience.length;
				List<JobExperienceVo> jobExperienceList = new ArrayList<JobExperienceVo>();
				JobExperienceVo wkvo = null;
				for (int i = 0; i < countwk; i++) {
					wkvo = new JobExperienceVo();
					wkvo.setUserId(id);;					
					wkvo.setWorkExperience(wk_experience[i]);
					wkvo.setWorkStartDate(wk_start_date[i]);
					wkvo.setWorkEndDate(wk_end_date[i]);
					jobExperienceList.add(wkvo);
				}
			this.TeacherEntranceService.updateteacher(userVo,teacherVo,educateList,familyList,jobExperienceList);
			
			SysLogUtil.info("登记新信息");
			json.setResultCode(0);
	}catch(Exception e){
		SysLogUtil.error("登记出错",e);
		json.setResultCode(1);
	}
	   return json;		
	}

}
