/**
 * 
 */
package com.jlict.edu.core.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * <p>Title: com.jlict.hrgl.core.filter.SessionFilter.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
public class SessionFilter implements Filter {

	String SESSIONOUT_URI = "WEB-INF/jsp/system/NoLoginOrSessionOut.jsp";
	String LOGIN_URI = "login.do";
	String LOGINOUT_URI = "loginOut.do";

	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	public void doFilter(ServletRequest req, ServletResponse res,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hreq = (HttpServletRequest) req;
		@SuppressWarnings("unused")
		HttpServletResponse hres = (HttpServletResponse) res;
		HttpSession session = hreq.getSession(false);
		String path = hreq.getRequestURI();
		try{
			if(null==session||!session.getAttributeNames().hasMoreElements()&&1>path.indexOf(this.LOGIN_URI)&&1>path.indexOf(this.LOGINOUT_URI)){				
				hreq.getRequestDispatcher(SESSIONOUT_URI).forward(req, res);				
			}
			else{
				chain.doFilter(req, res);
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.LOGIN_URI = filterConfig.getInitParameter("LOGIN_URI");
		this.SESSIONOUT_URI = filterConfig.getInitParameter("SESSIONOUT_URI");
		this.LOGINOUT_URI = filterConfig.getInitParameter("LOGINOUT_URI");
	}

}
