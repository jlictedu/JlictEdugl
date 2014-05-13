package com.jlict.edu.research.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.research.dao.WritingsDao;
import com.jlict.edu.research.dao.WritingsItemVo;

@Service
public class WritingsService {
	@Autowired
	private WritingsDao dao;
	
	public PagingJson queryUsers(int pageIndex, int pageSize) {
		return this.dao.queryUsers(pageIndex, pageSize);
	}

	public WritingsItemVo getWritings(String id) {
		return this.dao.getWritings(id);
	}
}
