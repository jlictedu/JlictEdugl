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
import com.jlict.edu.teachfile.dao.SumbitItemVo;
import com.jlict.edu.teachfile.service.SumbitService;

@Controller
public class SumbitAction extends BaseAction {
	@Autowired
	private SumbitService service;
	
	@RequestMapping(value="/sumbit.do",method=RequestMethod.GET)
	public ModelAndView initUserPanel(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/teachfile/sumbitPanel");
	}
	
	@RequestMapping(value="/sumbit.do",method=RequestMethod.POST, params="m=query")
	@ResponseBody
	public PagingJson queryUser(HttpServletRequest request, HttpServletResponse response) {
		int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		return this.service.queryUsers(pageIndex, pageSize);
	}
	
	@RequestMapping(value="/sumbit.do",method=RequestMethod.GET, params="m=readSumbit")
	public ModelAndView readSumbit(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		SumbitItemVo vo = this.service.getSumbit(id);
		
		return new ModelAndView("/teachfile/sumbit", "data", vo);
	}
}
