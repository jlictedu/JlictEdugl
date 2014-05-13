package com.jlict.edu.document.service;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.document.dao.DocumentFileVo;

@Service
public class DocumentService {
	public PagingJson queryData(File directory,int pageIndex,int pageSize){
		List<String> fileList = Arrays.asList(directory.list(new FilenameFilter(){

			public boolean accept(File dir, String name) {				
				return (name.matches("edu.+\\.dmp"));
			}		
		}));
		Collections.sort(fileList);
		ListIterator<String> iter = fileList.listIterator(pageSize*(pageIndex-1));
		int count=0;
		PagingJson json = new PagingJson();
		List<Object> rows = new ArrayList<Object>();
		while(iter.hasNext()&&count<=pageSize){
			DocumentFileVo vo = new DocumentFileVo();
			vo.setName(iter.next());
			rows.add(vo);
			count++;
		}
		json.setRows(rows);
		json.setTotal(count);
		return json;
	}
}