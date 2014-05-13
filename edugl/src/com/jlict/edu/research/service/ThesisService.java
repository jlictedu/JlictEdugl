package com.jlict.edu.research.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.research.dao.ThesisDao;
import com.jlict.edu.research.dao.ThesisItemVo;

@Service
public class ThesisService {
	@Autowired
	private ThesisDao dao;
	
	public PagingJson queryUsers(int pageIndex, int pageSize) {
		return this.dao.queryUsers(pageIndex, pageSize);
	}

	public ThesisItemVo getThesis(String id) {
		return this.dao.getThesis(id);
	}
}
