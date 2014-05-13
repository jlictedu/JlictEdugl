package com.jlict.edu.teachfile.controller;

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
import com.jlict.edu.teachfile.dao.ConnectItemVo;
import com.jlict.edu.teachfile.service.ConnectService;

@Controller
public class ConnectAction extends BaseAction {
	@Autowired
	private ConnectService service;
	
	@RequestMapping(value="/connect.do",method=RequestMethod.GET)
	public ModelAndView initUserPanel(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/teachfile/connectPanel");
	}
	
	@RequestMapping(value="/connect.do",method=RequestMethod.POST, params="m=query")
	@ResponseBody
	public PagingJson queryUser(HttpServletRequest request, HttpServletResponse response) {
		int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		return this.service.queryUsers(pageIndex, pageSize);
	}
	
	@RequestMapping(value="/connect.do",method=RequestMethod.GET, params="m=readConnect")
	public ModelAndView readConnect(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		ConnectItemVo vo = this.service.getConnect(id);
		
		return new ModelAndView("/teachfile/connect", "data", vo);
	}
}
