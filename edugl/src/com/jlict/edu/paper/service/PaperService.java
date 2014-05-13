package com.jlict.edu.paper.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.paper.dao.PaperDao;
import com.jlict.edu.paper.dao.PaperVo;

@Service
public class PaperService {
	@Autowired
	private PaperDao dao;
	
	public  PagingJson queryPaper(int pageIndex, int pageSize) {
		return this.dao.queryPaper(pageIndex, pageSize);
	}

	public PaperVo getPaper(String id) {
		return this.dao.getPaper(id);
	}

}
