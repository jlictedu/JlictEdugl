/**
 * 
 */
package com.jlict.edu.data.service;

import java.io.File;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.data.dao.DataFileVo;

/**
 * <p>Title: com.jlict.hrgl.data.service.DataService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Service
public class DataService {
	public PagingJson queryData(File directory,int pageIndex,int pageSize){
		List<String> fileList = Arrays.asList(directory.list(new FilenameFilter(){

			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return (name.matches("edu.+\\.dmp"));
			}		
		}));
		Collections.sort(fileList);
		ListIterator<String> iter = fileList.listIterator(pageSize*(pageIndex-1));
		int count=0;
		PagingJson json = new PagingJson();
		List<Object> rows = new ArrayList<Object>();
		while(iter.hasNext()&&count<=pageSize){
			DataFileVo vo = new DataFileVo();
			vo.setName(iter.next());
			rows.add(vo);
			count++;
		}
		json.setRows(rows);
		json.setTotal(count);
		return json;
	}
}
