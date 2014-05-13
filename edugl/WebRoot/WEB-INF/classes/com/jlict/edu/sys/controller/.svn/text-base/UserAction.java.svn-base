/**
 * 
 */
package com.jlict.edu.sys.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jlict.edu.core.controller.BaseAction;
import com.jlict.edu.core.util.ResultJson;
import com.jlict.edu.core.util.SysLogUtil;
import com.jlict.edu.manager.service.DepartmentService;
import com.jlict.edu.sys.service.LoginService;
import com.jlict.edu.sys.service.UserService;

/**
 * <p>Title: com.jlict.hrgl.sys.controller.UserAction.java</p>
 * <p>Description: 用户信息模块控制层</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Controller
public class UserAction extends BaseAction {
	@Autowired
	UserService userService;
	@Autowired
	LoginService loginService;
	@Autowired
	DepartmentService departmentService;
	
	/**
	 * 方法名: getUserById   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-2 下午04:18:49 
	 * 描述: 通过id获取用户信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/user.do",method=RequestMethod.POST,params="m=userId")
	@ResponseBody
	public Object getUserById(HttpServletRequest request, HttpServletResponse response){
		try{
		String id = request.getParameter("userId") ;
		return this.userService.getUserById(id);
		}catch(Exception e){
			SysLogUtil.error("获取用户信息错误",e);
			return null;
		}
	}
	
	/**
	 * 方法名: passwordModify   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-27 上午09:11:43 
	 * 描述: 修改密码
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping(value="/user.do",method=RequestMethod.POST,params="m=modifyPassword")
	@ResponseBody  
    public Object passwordModify(HttpServletRequest request, HttpServletResponse response) {
		ResultJson json = new ResultJson();
		try{			
			String oldPassword = request.getParameter("old");
			String newPassword = request.getParameter("new");
			String confirmPassword = request.getParameter("confirm");
			if(this.loginService.validatePassword(this.getUserId(request), oldPassword)){
				if(newPassword.equals(confirmPassword)){
					if(this.userService.mofifyPassword(this.getUserId(request), newPassword)){
						json.setResultCode(0);		
						SysLogUtil.info("修改密码成功");
					}
					else{
						json.setResultCode(3);
						json.setText("修改失败");
					}
				}else{
					json.setResultCode(2);
					json.setText("确认密码与新密码不一致");
				}
			}else{
				json.setResultCode(1);
				json.setText("原密码错误");
			}
		}catch(Exception e){
			SysLogUtil.error("修改密码出错");
			e.printStackTrace();
			json.setResultCode(4);
			json.setText("服务器异常");
		}
		return json;
		
	}
	
	/**
	 * 方法名: getDepartment   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-12-24 下午03:30:47 
	 * 描述: 查询部门信息
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@SuppressWarnings("rawtypes")
	@RequestMapping(value="/user.do",method=RequestMethod.POST,params="m=dept")
	@ResponseBody  
    public Object getDepartment(HttpServletRequest request, HttpServletResponse response) {
		List json = null;
		try{
			json = this.departmentService.queryDepartment();
		}catch(Exception e){
			SysLogUtil.error("查询所有部门信息出错");
			e.printStackTrace();
		}
		return json;
		
	}
	
	@RequestMapping(value="/user.do",method=RequestMethod.GET,params="m=dept") 
    public String getDepartmentInit(HttpServletRequest request, HttpServletResponse response) {
		return "system/departmentSelect";
		
	}
	
	/**
	 * 方法名: passwordInit   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-8-4 下午07:01:17 
	 * 描述: 密码修改页面初始化
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping(value="/user.do",method=RequestMethod.GET,params="m=password")
	public ModelAndView passwordInit(HttpServletRequest request,HttpServletResponse response) {
		return new ModelAndView("/user/password-modify");		
	}
	
}
