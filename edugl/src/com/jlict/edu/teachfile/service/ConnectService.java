package com.jlict.edu.teachfile.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.teachfile.dao.ConnectDao;
import com.jlict.edu.teachfile.dao.ConnectItemVo;

@Service
public class ConnectService {
	@Autowired
	private ConnectDao dao;
	
	public PagingJson queryUsers(int pageIndex, int pageSize) {
		return this.dao.queryUsers(pageIndex, pageSize);
	}

	public ConnectItemVo getConnect(String id) {
		return this.dao.getConnect(id);
	}
}
