package com.jlict.edu.file.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.file.dao.FileDao;
import com.jlict.edu.file.dao.FileVo;

@Service
public class FileService {
	@Autowired
	private FileDao dao;
	
	public  PagingJson queryFile(int pageIndex, int pageSize) {
		return this.dao.queryFile(pageIndex, pageSize);
	}

	public FileVo getFile(String id) {
		return this.dao.getFile(id);
	}

}