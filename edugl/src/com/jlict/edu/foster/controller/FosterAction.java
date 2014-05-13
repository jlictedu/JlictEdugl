package com.jlict.edu.foster.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jlict.edu.core.controller.BaseAction;
import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.core.util.ResultJson;
import com.jlict.edu.core.util.SysLogUtil;
import com.jlict.edu.foster.dao.FosterVo;
import com.jlict.edu.foster.dao.UpVo;
import com.jlict.edu.foster.service.FosterService;

/**
 * <p>Title: com.jlict.edu.foster.controller.FosterAction.java</p>
 * <p>Description: 培养方案管理控制层</p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 王森玉
 * @version 1.0
 */
@Controller
public class FosterAction extends BaseAction{
	@Autowired
	FosterService fosterService;
	
	static String yearid;
	static String deptid;
	static String cuid;
	
	/**
	 * 方法名: All   
	 * 建立者： 王森玉 
	 * 建立时间：2014-1-10 下午04:32:10 
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/foster.do",method=RequestMethod.GET)
	public ModelAndView All(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/foster/all");
	}
	
	/**
	 * 方法名: queryAll   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-10 下午04:32:20 
	 * 描述: 查询所在院系培养方案入学年份
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/foster.do",method=RequestMethod.POST,params="m=query")
	@ResponseBody  
	public Object queryAll(HttpServletRequest request, HttpServletResponse response){
		PagingJson json=null;	
		try{
		String dept_id=this.getDepartmentId(request);
		int pageIndex= Integer.parseInt(request.getParameter("pageIndex"));
		int pageSize= Integer.parseInt(request.getParameter("pageSize"));
		json = this.fosterService.getAll(dept_id, pageIndex, pageSize);
		SysLogUtil.info("查询入学年份信息");
		}catch(Exception e){
			SysLogUtil.error("查询入学年份信息出错", e);
		}
		return json;
	}
	
	/**
	 * 方法名: getDepartment   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-10 下午04:31:09 
	 * 描述: 查询院系信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/foster.do",method=RequestMethod.POST,params="m=queryDepartment")
	@ResponseBody  
    public Object getDepartment(HttpServletRequest request, HttpServletResponse response) {
		List json = null;
		try{
			String dept_id=this.getDepartmentId(request);
			json = this.fosterService.getDepartment(dept_id);
			SysLogUtil.info("查询院系信息");
		}catch(Exception e){
			SysLogUtil.error("查询院系信息出错");
			e.printStackTrace();
		}
		return json;
		
	}
	
	/**
	 * 方法名: AllAdd   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-10 下午04:39:44 
	 * 描述: 添加所在院系入学年份信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/foster.do",method=RequestMethod.GET,params="m=addall")
	public ModelAndView AllAdd(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/foster/alladd");
	}
	
	/**
	 * 方法名: SaveAll   
	 * 建立者： 王森玉 
	 * 建立时间：2014-1-10 下午04:39:50 
	 * 描述: 保存入学年份信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/foster.do",method=RequestMethod.POST,params="m=saveall")
	@ResponseBody  
    public Object SaveAll(HttpServletRequest request, HttpServletResponse response){
		ResultJson json = new ResultJson();
		try{
			String uid = UUID.randomUUID().toString();
			String id=uid.subSequence(0, 31).toString();
			String departmentId = request.getParameter("departmentId");
			String year = request.getParameter("year");

			if(this.fosterService.SaveAll(id,departmentId, year)){
				json.setResultCode(0);
				SysLogUtil.info("授予入学年份");
			}else{
				json.setResultCode(1);
				json.setText("入学年份重复");
			}
		}catch(Exception e){
			json.setResultCode(2);
			SysLogUtil.error("授予入学年份失败");			
		}
		return json;
	}
	
	/**
	 * 方法名: deleteAll   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-10 下午04:39:54 
	 * 描述: 删除相应年份培养方案
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/foster.do",method=RequestMethod.POST,params="m=deleteall")
	@ResponseBody  
    public Object deleteAll(HttpServletRequest request, HttpServletResponse response){
		ResultJson json = new ResultJson();
		try{			
			String deptid = request.getParameter("deptid");
			String yearid = request.getParameter("id");
			this.fosterService.deleteTC(deptid,yearid);
			if(this.fosterService.deleteTCY(deptid,yearid)){
				json.setResultCode(0);
				SysLogUtil.info("删除入学年份");
			}else{
				json.setResultCode(1);
				json.setText("入学年份不存在");
			}
		}catch(Exception e){
			json.setResultCode(2);
			SysLogUtil.error("解除入学年份失败");			
		}
		return json;
	}
	
	/**
	 * 方法名: queryDown   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-10 下午04:39:59 
	 * 描述: 查询课程信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/foster.do",method=RequestMethod.POST,params="m=querydown")
	@ResponseBody  
	public Object queryDown(HttpServletRequest request, HttpServletResponse response){
		PagingJson json=null;	
		try{
		int pageIndex= Integer.parseInt(request.getParameter("pageIndex"));
		int pageSize= Integer.parseInt(request.getParameter("pageSize"));
		json = this.fosterService.readFosterDown(yearid, pageIndex, pageSize);
		SysLogUtil.info("查询课程信息");
		}catch(Exception e){
			SysLogUtil.error("查询课程出错", e);
		}
		return json;
	}
	
	/**
	 * 方法名: queryUp   
	 * 建立者： 王森玉 
	 * 建立时间：2014-1-10 下午04:40:03 
	 * 描述: 查询院系基本
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/foster.do",method=RequestMethod.GET,params="m=queryup")
	public ModelAndView queryUp(HttpServletRequest request, HttpServletResponse response){
		UpVo vo=null;
		try{
			deptid = request.getParameter("deptid");
			yearid = request.getParameter("id");
			vo = this.fosterService.readFosterUp(deptid,yearid);
			SysLogUtil.info("读取院系基本信息");
		}catch(Exception e){
			SysLogUtil.error("读取院系基本信息出错",e);
		}
		return new ModelAndView("/foster/foster","up",vo);
	}
	
	/**
	 * 方法名: getSort   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-12 上午11:13:27 
	 * 描述: 查询院系信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/foster.do",method=RequestMethod.POST,params="m=querySort")
	@ResponseBody  
    public Object getSort(HttpServletRequest request, HttpServletResponse response) {
		List json = null;
		try{
			json = this.fosterService.getSort();
			SysLogUtil.info("查询院系信息");
		}catch(Exception e){
			SysLogUtil.error("查询院系信息出错");
			e.printStackTrace();
		}
		return json;
		
	}
	
	/**
	 * 方法名: AddFoster   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-12 上午11:16:20 
	 * 描述: 添加课程信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/foster.do",method=RequestMethod.GET,params="m=addfoster")
	public ModelAndView AddFoster(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/foster/addfoster");
	}
	
	/**
	 * 方法名: SaveFoster   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-12 上午11:17:56 
	 * 描述: 保存课程信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/foster.do",method=RequestMethod.POST,params="m=savefoster")
	@ResponseBody  
    public Object SaveFoster(HttpServletRequest request, HttpServletResponse response){
		ResultJson json = new ResultJson();
		try{
			String uid = UUID.randomUUID().toString();
			String id=uid.subSequence(0, 31).toString();
			String coding = request.getParameter("coding");
			String name = request.getParameter("name");
			String attribute = request.getParameter("attribute");
			String exam = request.getParameter("exam");
			String credit;
			String prelect = request.getParameter("prelect");
			String experiment = request.getParameter("experiment");
				if(experiment==null||experiment.equals("")){
					experiment="0";
				}
			String computer = request.getParameter("computer");
				if(computer==null||computer.equals("")){
					computer="0";
				}
			
			Float pre=Float.parseFloat(prelect);
			Float exp=Float.parseFloat(experiment);
			Float com=Float.parseFloat(computer);
			credit=(pre/16+exp/24+com/24)+"";
			
			String term = request.getParameter("term");
			String sort = request.getParameter("sort");
			String all = (pre+exp+com)+"";
			String allperiod=all.subSequence(0, 1).toString();
			String weeks = request.getParameter("weeks");
			String weekcla = request.getParameter("weekcla");

			if(this.fosterService.SaveFoster(id,coding,name,attribute ,exam,credit,prelect,experiment,computer,term,sort,allperiod,deptid,yearid,weeks,weekcla)){
				json.setResultCode(0);
				SysLogUtil.info("授予课程信息");
			}else{
				json.setResultCode(1);
				json.setText("课程信息重复");
			}
		}catch(Exception e){
			json.setResultCode(2);
			SysLogUtil.error("授予课程信息失败");			
		}
		return json;
	}
	
	/**
	 * 方法名: Upadte   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午02:19:34 
	 * 描述: 读取课程信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/foster.do",method=RequestMethod.GET,params="m=update")
	public ModelAndView Upadte(HttpServletRequest request, HttpServletResponse response){
		FosterVo vo=null;
		try{
			cuid = request.getParameter("id");
			vo = this.fosterService.UpadteFoster(cuid);
			SysLogUtil.info("读取课程基本信息");
		}catch(Exception e){
			SysLogUtil.error("读取课程基本信息出错",e);
		}
		return new ModelAndView("/foster/updatefoster","up",vo);
	}
	
	/**
	 * 方法名: UpdateFoster   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午02:20:40 
	 * 描述: 更新课程信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/foster.do",method=RequestMethod.POST,params="m=updatefoster")
	@ResponseBody  
    public Object UpdateFoster(HttpServletRequest request, HttpServletResponse response){
		this.fosterService.deleteFoster(cuid);
		return this.SaveFoster(request, response);
	}
	
	/**
	 * 方法名: deleteFoster   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午02:21:40 
	 * 描述: 删除课程信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/foster.do",method=RequestMethod.POST,params="m=deletefoster")
	@ResponseBody  
    public Object deleteFoster(HttpServletRequest request, HttpServletResponse response){
		ResultJson json = new ResultJson();
		try{			
			String id = request.getParameter("id");
			if(this.fosterService.deleteFoster(id)){
				json.setResultCode(0);
				SysLogUtil.info("删除入学年份");
			}else{
				json.setResultCode(1);
				json.setText("入学年份不存在");
			}
		}catch(Exception e){
			json.setResultCode(2);
			SysLogUtil.error("解除入学年份失败");			
		}
		return json;
	}
	
	/**
	 * 方法名: copy   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午02:22:14 
	 * 描述: 复制培养方案初始化
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/foster.do",method=RequestMethod.GET,params="m=copy")
	public ModelAndView copy(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/foster/copyfoster");
	}
	
	/**
	 * 方法名: getYear   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午02:22:51 
	 * 描述: 获取年份信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/foster.do",method=RequestMethod.POST,params="m=queryYear")
	@ResponseBody  
    public Object getYear(HttpServletRequest request, HttpServletResponse response) {
		List json = null;
		try{
			json = this.fosterService.getYear(deptid);
			SysLogUtil.info("查询院系信息");
		}catch(Exception e){
			SysLogUtil.error("查询院系信息出错");
			e.printStackTrace();
		}
		return json;
		
	}

	/**
	 * 方法名: copyFoster   
	 * 建立者： 王森玉
	 * 建立时间：2014-1-13 下午02:23:22 
	 * 描述: 复制培养方案
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/foster.do",method=RequestMethod.POST,params="m=copyfoster")
	@ResponseBody  
    public Object copyFoster(HttpServletRequest request, HttpServletResponse response){		
		ResultJson json = new ResultJson();
		try{			
			String year = request.getParameter("year");
			
			this.fosterService.deleteCopy();
			int num=this.fosterService.Copy(yearid,deptid);
			 
			for(int i=0;i<num;i++){
				String uid = UUID.randomUUID().toString();
				String id=uid.subSequence(0, 31).toString();
				if(this.fosterService.copyFoster(id,year)){
					json.setResultCode(0);					
				}else{
					json.setResultCode(1);
					json.setText("入学年份重复");
					break;
				}				
			}
			SysLogUtil.info("授予入学年份");
			}catch(Exception e){
			json.setResultCode(2);
			SysLogUtil.error("授予入学年份失败");			
			}		
		return json;
	}
}
