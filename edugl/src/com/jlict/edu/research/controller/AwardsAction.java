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
import com.jlict.edu.research.dao.AwardsItemVo;
import com.jlict.edu.research.service.AwardsService;
@Controller
public class AwardsAction extends BaseAction {
	@Autowired
	private AwardsService service;
	
	@RequestMapping(value="/awards.do",method=RequestMethod.GET)
	public ModelAndView initAwardsPanel(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/research/awardsPanel");
	}
	
	@RequestMapping(value="/uawards.do",method=RequestMethod.POST, params="m=query")
	@ResponseBody
	public PagingJson queryUser(HttpServletRequest request, HttpServletResponse response) {
		int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		return this.service.queryUsers(pageIndex, pageSize);
	}
	
	@RequestMapping(value="/awards.do",method=RequestMethod.GET, params="m=readAwards")
	public ModelAndView readAwards(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		AwardsItemVo vo = this.service.getAwards(id);
		
		return new ModelAndView("/research/awards", "data", vo);
	}
}
