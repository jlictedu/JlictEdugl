package com.jlict.edu.paper.controller;

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
import com.jlict.edu.paper.dao.PaperVo;
import com.jlict.edu.paper.service.PaperService;

@Controller
public class PaperAction extends BaseAction {
	@Autowired
	private PaperService service;
	
	@RequestMapping(value="/paper.do",method=RequestMethod.GET )
	public ModelAndView initPaperPane(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/exam/paperPanel");
	}

	@RequestMapping(value="/paper.do",method=RequestMethod.POST, params="m=query")
	@ResponseBody
	public PagingJson queryExam(HttpServletRequest request, HttpServletResponse response) {
		int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		return this.service.queryPaper(pageIndex, pageSize);
	}
	
	@RequestMapping(value="/paper.do",method=RequestMethod.GET, params="m=readPaper")
	public ModelAndView readPaper(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		PaperVo vo = this.service.getPaper(id);
		
		return new ModelAndView("/exam/paper", "data", vo);
	}
}

