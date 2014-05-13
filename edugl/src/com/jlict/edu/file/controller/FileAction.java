package com.jlict.edu.file.controller;

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
import com.jlict.edu.file.dao.FileVo;
import com.jlict.edu.file.service.FileService;

@Controller
public class FileAction extends BaseAction {
	@Autowired
	private FileService service;
	
	@RequestMapping(value="/file.do",method=RequestMethod.GET )
	public ModelAndView initPaperPane(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/exam/filePanel");
	}

	@RequestMapping(value="/file.do",method=RequestMethod.POST, params="m=query")
	@ResponseBody
	public PagingJson queryExam(HttpServletRequest request, HttpServletResponse response) {
		int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		
		return this.service.queryFile(pageIndex, pageSize);
	}
	
	@RequestMapping(value="/file.do",method=RequestMethod.GET, params="m=readFile")
	public ModelAndView readPaper(HttpServletRequest request, HttpServletResponse response){
		String id = request.getParameter("id");
		FileVo vo = this.service.getFile(id);
		
		return new ModelAndView("/exam/file", "data", vo);
	}
}

