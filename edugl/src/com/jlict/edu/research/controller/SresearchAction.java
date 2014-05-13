package com.jlict.edu.research.controller;

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
import com.jlict.edu.research.dao.SresearchItemVo;
import com.jlict.edu.research.service.SresearchService;

@Controller
public class SresearchAction extends BaseAction {
	@Autowired
	private SresearchService service;
	
	@RequestMapping(value="/sresearch.do",method=RequestMethod.GET)
	public ModelAndView initUserPanel(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/research/sresearchPanel");
	}
	
	@RequestMapping(value="/sresearch.do",method=RequestMethod.POST, params="m=query")
	@ResponseBody
	public PagingJson queryUser(HttpServletRequest request, HttpServletResponse response) {
		int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		return this.service.queryUsers(pageIndex, pageSize);
	}
	
	@RequestMapping(value="/sresearch.do",method=RequestMethod.GET, params="m=readSresearch")
	public ModelAndView readUserInfo(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		SresearchItemVo vo = this.service.getSresearch(id);
		
		return new ModelAndView("/research/sresearch", "data", vo);
	}
}
