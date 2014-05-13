/**
 * 
 */
package com.jlict.edu.sys.controller;
import java.util.*;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


import com.jlict.edu.core.controller.BaseAction;
import com.jlict.edu.core.util.ResultJson;
import com.jlict.edu.core.util.SysLogUtil;
import com.jlict.edu.message.service.MessageService;
import com.jlict.edu.sys.dao.SysMenuVo;
import com.jlict.edu.sys.dao.UserVo;
import com.jlict.edu.sys.service.LoginService;


/**
 * <p>Title: com.jlict.sys.controller.LoginAction.java</p>
 * <p>Description: 员工登录控制层</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Controller
public class LoginAction extends BaseAction{
	@Autowired
	private LoginService loginService;
	@Autowired
	MessageService messageService;
	
	/**
	 * 方法名: login   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-6-27 下午09:25:57 
	 * 描述: 用户登录的处理
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@RequestMapping("/login.do")
	@ResponseBody  
    public Object login(HttpServletRequest request, HttpServletResponse response) {
    	String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		ResultJson result = new ResultJson();

		try{
			UserVo user=loginService.login(userName, password);
			if(user != null){
				result.setResultCode(0);
				request.getSession().invalidate();
				HttpSession session=request.getSession(true);
				SysLogUtil.info(user.getId()+user.getName()+"登录");
				
				//缓存登录人员信息
				session.setAttribute("name", user.getName());
				session.setAttribute("userId", user.getId());
				session.setAttribute("departmentId", user.getDepartmentId());
				session.setAttribute("stationId", user.getStationId());
				
				//添加访问权限
				Set<String> permission = new HashSet<String>();
				
				permission.add("mainFrame.do");
				permission.add("menuData.do");
				permission.add("user.do");
				request.getSession().setAttribute("permission", permission);
			}else{
				result.setResultCode(1);
				result.setText("密码或用户名错误！");
			}
			
		}catch(Exception e){
			SysLogUtil.error("用户登录时出错！", e);
			result.setResultCode(1);
			result.setText("该用户已失效！");
		}
        return result; 
    }
	
	/**
	 * 方法名: mainFrame   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-6-27 下午09:27:12 
	 * 描述: 处理主框架的请求
	 * 参数：参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping("/mainFrame.do")
	public ModelAndView mainFrame(HttpServletRequest request, HttpServletResponse response){
		Map<String,String> data = new HashMap<String,String>();
		try{
			data.put("userName", this.getName(request));
			data.put("newMessageCount", String.valueOf(this.messageService.getNewMessageCount(this.getUserId(request))));		
		}catch(Exception e){
			SysLogUtil.error("框架视图数据错误",e);
		}
        return new ModelAndView("/system/mainFrame","data",data);
	}
	
	/**
	 * 方法名: getMenuData   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-6-27 下午09:27:45 
	 * 描述: 菜单数据的请求处理
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 Object       
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping("/menuData.do")
	@ResponseBody  
    public Object getMenuData(HttpServletRequest request, HttpServletResponse response){
		List<SysMenuVo> menu = null;
		try{
			menu = this.loginService.getMenuData(this.getDepartmentId(request), this.getStationtId(request));
			
		}catch(Exception e){
			SysLogUtil.error("用户获取菜单出错！", e);
		}
		try{
			Set permission = (Set) request.getSession().getAttribute("permission");
			if (permission.size()!=menu.size()+3){
				for(SysMenuVo node:menu){
					permission.add(node.getUrl());
				}			
			}
		}catch(Exception e){
			SysLogUtil.error("设置访问权限出错！", e);
		}
		return menu;
	}
	
	/**
	 * 方法名: loginout   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-6-27 下午09:28:16 
	 * 描述: 退出登录的处理
	 * 参数：request 说明：请求的request
	 * 参数：response 说明：请求的response
	 * 返回类型 ModelAndView       
	 */
	@RequestMapping("/loginOut.do")
	public ModelAndView loginout(HttpServletRequest request, HttpServletResponse response) {
		try{
			HttpSession session=request.getSession(false);
			if(session!=null){				
				session.invalidate();
				response.sendRedirect("");
			}
			SysLogUtil.info("退出登录");
		}catch(Exception e){
			SysLogUtil.error("登出操作时出错！", e);
		}
		
        return null;
	}
	
}
