package com.jlict.edu.research.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.research.dao.AwardsDao;
import com.jlict.edu.research.dao.AwardsItemVo;

@Service
public class AwardsService {
	@Autowired
	private AwardsDao dao;
	
	public PagingJson queryUsers(int pageIndex, int pageSize) {
		return this.dao.queryUsers(pageIndex, pageSize);
	}

	public AwardsItemVo getAwards(String id) {
		return this.dao.getAwards(id);
	}
}
