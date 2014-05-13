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
import com.jlict.edu.research.dao.TresearchItemVo;
import com.jlict.edu.research.service.TresearchService;

@Controller
public class TresearchAction extends BaseAction {
	@Autowired
	private TresearchService service;
	
	@RequestMapping(value="/tresearch.do",method=RequestMethod.GET)
	public ModelAndView initThesis(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/research/tresearchPanel");
	}
	
	@RequestMapping(value="/tresearch.do",method=RequestMethod.POST, params="m=query")
	@ResponseBody
	public PagingJson queryUser(HttpServletRequest request, HttpServletResponse response) {
		int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		return this.service.queryUsers(pageIndex, pageSize);
	}
	
	@RequestMapping(value="/tresearch.do",method=RequestMethod.GET, params="m=readTresearch")
	public ModelAndView readThesis(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		TresearchItemVo vo = this.service.getTresearch(id);
		
		return new ModelAndView("/research/tresearch", "data", vo);
	}
}
