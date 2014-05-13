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
import com.jlict.edu.entrance.dao.StudentVo;
import com.jlict.edu.entrance.service.StudentEntranceService;
import com.jlict.edu.manager.service.DepartmentService;
import com.jlict.edu.manager.service.StationService;
import com.jlict.edu.sys.dao.UserVo;


/**
 * 
 * <p>Title: com.jlict.edu.entrance.controller.StudentEntranceAction.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 于旭东
 * @version 1.0
 */
@Controller
public class StudentEntranceAction extends BaseAction{
	@Autowired
	StudentEntranceService StudentEntranceService;
	@Autowired
	DepartmentService DepartmentService;
	@Autowired
	StationService StationService;
/**
 * 
 * 方法名: EntranceMain   
 * 建立者： 于旭东
 * 建立时间：2014-1-1 下午01:55:42 
 * 描述: 返回学生录入主界面
 * 参数：request 说明：HttpServletRequest
 * 参数：response 说明：HttpServletResponse
 * 返回类型 ModelAndView       
 */
	@RequestMapping(value="/studententrance.do",method=RequestMethod.GET)
	public ModelAndView EntranceMain(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/entrance/StudentEntranceMain");
	}
	/**
	 * 
	 * 方法名: getDepartment   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午01:56:55 
	 * 描述: 获得部门
	 * 参数：request 说明：HttpServletRequest
	 * 参数：response 说明：HttpServletResponse
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/studententrance.do",method=RequestMethod.POST,params="m=getdp")
	@SuppressWarnings("unchecked")
	@ResponseBody 
	public Object getDepartment(HttpServletRequest request, HttpServletResponse response) {
		List json = null;
		try{
			json = this.StudentEntranceService.queryDepartment();
		}catch(Exception e){
			SysLogUtil.error("查询所有部门信息出错",e);
		}
		return json;		
	}
	/**
	 * 
	 * 方法名: getStation   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午01:57:44 
	 * 描述: 获得角色
     * 参数：request 说明：HttpServletRequest
	 * 参数：response 说明：HttpServletResponse
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/studententrance.do",method=RequestMethod.POST,params="m=getst")
	@SuppressWarnings("unchecked")
	@ResponseBody 
	public Object getStation(HttpServletRequest request, HttpServletResponse response) {
		List json = null;
		try{
			json = this.StationService.queryStation();;
		}catch(Exception e){
			SysLogUtil.error("查询所有部门信息出错",e);
		}
		return json;		
	}
	/**
	 * 
	 * 方法名: dpurl   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午01:58:24 
	 * 描述: 根据id查询子部门
	 * 参数：request 说明：HttpServletRequest
	 * 参数：response 说明：HttpServletResponse
	 * 返回类型 Object       
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/studententrance.do",method=RequestMethod.POST,params="m=dpid")
	@ResponseBody 
	public Object dpurl(HttpServletRequest request,HttpServletResponse response) {
		String dpid = request.getParameter("dpid") ;
			
			List json = null;
			try{
				json = this.StudentEntranceService.getdpmbByid(dpid);
			}catch(Exception e){
				SysLogUtil.error("查询所有部门成员信息出错");
				e.printStackTrace();
			}
			return json;		
	}
	/**
	 * 
	 * 方法名: dpurl1   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午01:58:24 
	 * 描述: 根据id查询子部门
	 * 参数：request 说明：HttpServletRequest
	 * 参数：response 说明：HttpServletResponse
	 * 返回类型 Object       
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/studententrance.do",method=RequestMethod.POST,params="m=dpid1")
	@ResponseBody 
	public Object dpurl1(HttpServletRequest request,HttpServletResponse response) {
		String dpid = request.getParameter("dpid1") ;
			
			List json = null;
			try{
				json = this.StudentEntranceService.getdpmbByid(dpid);
			}catch(Exception e){
				SysLogUtil.error("查询所有部门成员信息出错");
				e.printStackTrace();
			}
			return json;		
	}
	/**
	 * 
	 * 方法名: queryets   
	 * 建立者： 于旭东
	 * 建立时间：2014-1-1 下午01:59:15 
	 * 描述: 根据条件查询学生
	 * 参数：request 说明：HttpServletRequest
	 * 参数：response 说明：HttpServletResponse
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/studententrance.do",method=RequestMethod.POST,params="m=query")
	@ResponseBody 
	public Object queryets(HttpServletRequest request,HttpServletResponse response) {
		PagingJson json = null;
		try {
			int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			String dp1 = request.getParameter("dp1");
			String dp2 = request.getParameter("dp2");
			String dp3 = request.getParameter("dp3");
			String name =request.getParameter("name");
			String sex = request.getParameter("sex");
			String studentNumber = request.getParameter("studentNumber");
			json = this.StudentEntranceService.queryeUser(pageIndex, pageSize, dp1,dp2,dp3,name,sex, studentNumber);
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
	 * 建立时间：2014-1-1 下午02:00:16 
	 * 描述: 学生信息登记初始化
	 * 参数：request 说明：HttpServletRequest
	 * 参数：response 说明：HttpServletResponse
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/studententrance.do",method=RequestMethod.GET,params="m=insertInit")
	public ModelAndView insertInit(HttpServletRequest request){
		
		return new ModelAndView("/entrance/StudentEntranceInsert");
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
	
	@RequestMapping(value="/studententrance.do",method=RequestMethod.GET,params="m=insertInited")
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
	@RequestMapping(value="/studententrance.do",method=RequestMethod.GET,params="m=insertInitfl")
	public ModelAndView insertInitfl(HttpServletRequest request){
		return new ModelAndView("/entrance/FamilyInsert");
	}
	/**
	 * 
	 * 方法名: Insert   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午08:53:05 
	 * 描述:学生信息登记保存
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@ResponseBody
	@RequestMapping(value="/studententrance.do",method=RequestMethod.POST,params="m=Insert")
	public Object Insert(HttpServletRequest request,HttpServletResponse response) {
		ResultJson json=new ResultJson();
		try {
			
		//user
			String dp=request.getParameter("departmentId");
			String cl=request.getParameter("classId");
			String sc=request.getParameter("schoolId");
			String name = request.getParameter("NAME");
			String userId = this.getUserId(request);
			String station = request.getParameter("stationId");			
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
			StudentVo studentVo = new StudentVo();
			studentVo.setDept_id(dp);
			studentVo.setClass_id(cl);
			studentVo.setSchool_id(sc);
			studentVo.setName(name);
			studentVo.setBirth_place(birth_place);
			studentVo.setSex(sex);
			studentVo.setCredential_number(credential_number);
			studentVo.setNation(nation);
			studentVo.setEmergency_contact_tel(emergency_contact_tel);
			studentVo.setEmergency_contact_person(emergency_contact_person);
			studentVo.setBorn_date(born_date);
			studentVo.setJoin_date(join_date);
			studentVo.setPolitical_appearance(political_appearance);
			studentVo.setHouse_registe(house_registe);
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
			this.StudentEntranceService.insertep(userVo,studentVo,educateList,familyList);
			
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
	 * 描述: 初始化学生详情信息界面
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/studententrance.do",method=RequestMethod.GET,params="m=detailInit")
	public ModelAndView deatailInit(HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id) {
		
		Map map=null;
		try{
			map=new HashMap<String,Object>();
			StudentVo StudentVo=this.StudentEntranceService.getStudentbyId(id);
			map.put("Student", StudentVo);
			List education=this.StudentEntranceService.geteducationById(id);
			map.put("education", education);
			List family=this.StudentEntranceService.getfamilyById(id);
			map.put("family", family);
			SysLogUtil.info("查询员工详细信息");
		}catch(Exception e){
			SysLogUtil.error("用户信息详情查看初始化异常！",e);
		}
		return new ModelAndView("/entrance/StudentEntranceDetail","data",map);		
	}
	/**
	 * 
	 * 方法名: editInit   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午08:46:40 
	 * 描述: 初始化修改学生信息界面
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/studententrance.do",method=RequestMethod.GET,params="m=editInit")
	public ModelAndView editInit(HttpServletRequest request,HttpServletResponse response,@RequestParam("id") String id) {
		
		Map map=null;
		try{
			map=new HashMap<String,Object>();
			StudentVo StudentVo=this.StudentEntranceService.getStudentbyId(id);
			map.put("Student", StudentVo);
			List education=this.StudentEntranceService.geteducationById(id);
			map.put("education", education);
			List family=this.StudentEntranceService.getfamilyById(id);
			map.put("family", family);
		}catch(Exception e){
			SysLogUtil.error("修改初始化异常！",e);
		}
		return new ModelAndView("/entrance/StudentEntranceEdit","data",map);		
	}
	/**
	 * 
	 * 方法名: update   
	 * 建立者： 于旭东 
	 * 建立时间：2013-7-31 上午08:48:39 
	 * 描述: 修改学生信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/studententrance.do",method=RequestMethod.POST,params="m=update")
	@ResponseBody 
	public Object update(HttpServletRequest request,HttpServletResponse response) {
		ResultJson json=new ResultJson();
		try {
			
		//user
			String id=request.getParameter("ID");
			String dp=request.getParameter("departmentId");
			String cl=request.getParameter("classId");
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
			StudentVo studentVo = new StudentVo();
			studentVo.setDept_id(dp);
			studentVo.setClass_id(cl);
			studentVo.setSchool_id(sc);
			studentVo.setName(name);
			studentVo.setBirth_place(birth_place);
			studentVo.setSex(sex);
			studentVo.setCredential_number(credential_number);
			studentVo.setNation(nation);
			studentVo.setEmergency_contact_tel(emergency_contact_tel);
			studentVo.setEmergency_contact_person(emergency_contact_person);
			studentVo.setBorn_date(born_date);
			studentVo.setJoin_date(join_date);
			studentVo.setPolitical_appearance(political_appearance);
			studentVo.setHouse_registe(house_registe);
			studentVo.setId(id);
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
			this.StudentEntranceService.updatestudent(userVo,studentVo,educateList,familyList);
			
			SysLogUtil.info("登记新信息");
			json.setResultCode(0);
	}catch(Exception e){
		SysLogUtil.error("登记出错",e);
		json.setResultCode(1);
	}
	   return json;		
	}
}
