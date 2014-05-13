package com.jlict.edu.search.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.search.dao.SearchDao;
import com.jlict.edu.search.dao.SearchVo;

@Service
public class SearchService {
	@Autowired
	private SearchDao dao;
	
	public  PagingJson querySearch(int pageIndex, int pageSize) {
		return this.dao.querySearch(pageIndex, pageSize);
	}

	public SearchVo getSearch(String id) {
		return this.dao.getSearch(id);
	}

}