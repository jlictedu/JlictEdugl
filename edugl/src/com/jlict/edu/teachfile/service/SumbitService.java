package com.jlict.edu.teachfile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.teachfile.dao.SumbitDao;
import com.jlict.edu.teachfile.dao.SumbitItemVo;
@Service
public class SumbitService {
	@Autowired
	private SumbitDao dao;
	
	public PagingJson queryUsers(int pageIndex, int pageSize) {
		return this.dao.queryUsers(pageIndex, pageSize);
	}

	public SumbitItemVo getSumbit(String id) {
		return this.dao.getSumbit(id);
	}
}
