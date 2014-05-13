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
import javax.servlet.http.HttpSession;

import org.apache.log4j.MDC;

/**
 * <p>Title: com.jlict.hrgl.core.filter.LogSessionFilter.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
public class LogSessionFilter implements Filter {
	String LOGIN_URI = "login.do";
	String LOGINOUT_URI = "loginOut.do";
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest hreq = (HttpServletRequest) request;
		HttpSession session = hreq.getSession();
		String path = hreq.getRequestURI().replaceFirst(hreq.getContextPath()+"/", "");
		if(0==path.indexOf(this.LOGIN_URI)){
			MDC.remove("name");
			MDC.remove("id");
			chain.doFilter(request, response);
		}else if(0==path.indexOf(this.LOGINOUT_URI)){
			chain.doFilter(request, response);
			MDC.remove("name");
			MDC.remove("id");
		}else{
			MDC.put("name",session.getAttribute("name"));
			MDC.put("id",session.getAttribute("userId"));
			chain.doFilter(request, response);
		}

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		this.LOGIN_URI = filterConfig.getInitParameter("LOGIN_URI");
		this.LOGINOUT_URI = filterConfig.getInitParameter("LOGINOUT_URI");
	}

}
