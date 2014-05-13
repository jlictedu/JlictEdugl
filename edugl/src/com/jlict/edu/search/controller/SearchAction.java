package com.jlict.edu.search.controller;

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
import com.jlict.edu.search.dao.SearchVo;
import com.jlict.edu.search.service.SearchService;

@Controller
public class SearchAction extends BaseAction {
	@Autowired
	private SearchService service;
	
	@RequestMapping(value="/grade.do",method=RequestMethod.GET )
	public ModelAndView initPaperPane(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/exam/searchPanel");
	}

	@RequestMapping(value="/grade.do",method=RequestMethod.POST, params="m=query")
	@ResponseBody
	public PagingJson queryExam(HttpServletRequest request, HttpServletResponse response) {
		int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));		
		return this.service.querySearch(pageIndex, pageSize);
	}
	
	@RequestMapping(value="/grade.do",method=RequestMethod.GET, params="m=readSearch")
	public ModelAndView readPaper(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		SearchVo vo = this.service.getSearch(id);
		
		return new ModelAndView("/exam/search", "data", vo);
	}
}

