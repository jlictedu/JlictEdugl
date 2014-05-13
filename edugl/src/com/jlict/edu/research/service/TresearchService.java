package com.jlict.edu.research.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.research.dao.TresearchDao;
import com.jlict.edu.research.dao.TresearchItemVo;

@Service
public class TresearchService {
	@Autowired
	private TresearchDao dao;
	
	public PagingJson queryUsers(int pageIndex, int pageSize) {
		return this.dao.queryUsers(pageIndex, pageSize);
	}

	public TresearchItemVo getTresearch(String id) {
		return this.dao.getTresearch(id);
	}
}
