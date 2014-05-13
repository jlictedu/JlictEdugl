/**
 * 
 */
package com.jlict.edu.core.filter;

import java.io.IOException;
import java.util.Set;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.jlict.edu.core.util.SysLogUtil;
/**
 * <p>Title: com.jlict.hrgl.core.filter.PermissionFilter.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
public class PermissionFilter  implements Filter{
	String LOGIN_URI = "login.do";
	String LOGINOUT_URI = "loginOut.do";
	String NOPERMISSION_URI = "WEB-INF/jsp/system/NoPermission.jsp";
	
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@SuppressWarnings("rawtypes")
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpServletResponse hres = (HttpServletResponse) response;
		hres.setHeader("Pragma","No-cache");
		hres.setHeader("Cache-Control","no-cache");
		hres.setDateHeader("Expires", 0);
		HttpSession session = hreq.getSession();
		String path = hreq.getRequestURI().replaceFirst(hreq.getContextPath()+"/", "");
		
		Object permission =  session.getAttribute("permission");

		if (null != permission && ((Set)permission).contains(path)) {
			chain.doFilter(request, response);
		}
		else {
			if(0==path.indexOf(this.LOGIN_URI)||0==path.indexOf(this.LOGINOUT_URI) ){
				chain.doFilter(request, response);
			}
			else{
				request.getRequestDispatcher(this.NOPERMISSION_URI).forward(request, response);
				SysLogUtil.error("非法访问"+path);
			}
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.NOPERMISSION_URI = filterConfig.getInitParameter("NOPERMISSION_URI");
		this.LOGIN_URI = filterConfig.getInitParameter("LOGIN_URI");
		this.LOGINOUT_URI = filterConfig.getInitParameter("LOGINOUT_URI");
	}

}
