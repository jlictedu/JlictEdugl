package com.jlict.edu.cour.controller;

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
import com.jlict.edu.cour.dao.CourVo;
import com.jlict.edu.cour.dao.UpVo;
import com.jlict.edu.cour.service.CourService;

/**
 * <p>Title: com.jlict.edu.cour.controller.CourAction.java</p>
 * <p>Description: 排课管理控制层</p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 刘向平
 * @version 1.0
 */
@Controller
public class CourAction extends BaseAction{
	@Autowired
	CourService courService;
	
	static String yearid;
	static String deptid;
	static String cuid;
	
	
	/**
	 * 方法名: All   
	 * 建立者： 刘向平 
	 * 建立时间：2014-1-10 下午04:32:10 
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/cour.do",method=RequestMethod.GET)
	public ModelAndView All(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/cour/all");
	}
	/**
	 * 方法名: queryUp   
	 * 建立者： 刘向平
	 * 建立时间：2014-1-10 下午04:40:03 
	 * 描述: 查询院系基本
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/cour.do",method=RequestMethod.GET,params="m=queryup")
	public ModelAndView queryUp(HttpServletRequest request, HttpServletResponse response){
		UpVo vo=null;
		try{
			deptid = request.getParameter("deptid");
			yearid = request.getParameter("id");
			vo = this.courService.readCourUp(deptid,yearid);
			SysLogUtil.info("读取院系基本信息");
		}catch(Exception e){
			SysLogUtil.error("读取院系基本信息出错",e);
		}
		return new ModelAndView("/cour/all","up",vo);
	}
	/**
	 * 方法名: queryDown   
	 * 建立者： 刘向平
	 * 建立时间：2014-1-10 下午04:39:59 
	 * 描述: 查询课程信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/cour.do",method=RequestMethod.POST,params="m=querydown")
	@ResponseBody  
	public Object queryDown(HttpServletRequest request, HttpServletResponse response){
		List json = null;	
		try{
		json = this.courService.readCourDown();
		SysLogUtil.info("查询课程信息");
		}catch(Exception e){
			SysLogUtil.error("查询课程出错", e);
		}
		return json;
	}
	/**
	 * 方法名: AddCour  
	 * 建立者： 刘向平
	 * 建立时间：2014-1-12 上午11:16:20 
	 * 描述: 添加课程信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/cour.do",method=RequestMethod.GET,params="m=addcour")
	public ModelAndView AddCour(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/cour/addcour");
	}
	
	/**
	 * 方法名: SaveCour   
	 * 建立者： 刘向平
	 * 建立时间：2014-1-12 上午11:17:56 
	 * 描述: 保存课程信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/cour.do",method=RequestMethod.POST,params="m=savecour")
	@ResponseBody  
    public Object SaveCour(HttpServletRequest request, HttpServletResponse response){
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

			if(this.courService.SaveCour(id,coding,name,attribute ,exam,credit,prelect,experiment,computer,term,sort,allperiod,deptid,yearid,weeks,weekcla)){
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
	
	
}
