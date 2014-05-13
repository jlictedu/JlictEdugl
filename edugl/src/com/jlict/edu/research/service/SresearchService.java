package com.jlict.edu.research.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.research.dao.SresearchDao;
import com.jlict.edu.research.dao.SresearchItemVo;

@Service
public class SresearchService {
	@Autowired
	private SresearchDao dao;
	
	public PagingJson queryUsers(int pageIndex, int pageSize) {
		return this.dao.queryUsers(pageIndex, pageSize);
	}

	public SresearchItemVo getSresearch(String id) {
		return this.dao.getSresearch(id);
	}
}
