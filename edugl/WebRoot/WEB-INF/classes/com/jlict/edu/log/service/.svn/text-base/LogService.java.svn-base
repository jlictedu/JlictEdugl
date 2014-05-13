/**
 * 
 */
package com.jlict.edu.log.service;

import java.io.File;
import java.io.FilenameFilter;
import java.util.*;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.log.dao.LogFileVo;

/**
 * <p>Title: com.jlict.hrgl.log.service.LogService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Service
public class LogService {
	public PagingJson queryLog(File directory,int pageIndex,int pageSize){
		List<String> fileList = Arrays.asList(directory.list(new FilenameFilter(){

			public boolean accept(File dir, String name) {
				// TODO Auto-generated method stub
				return (name.matches("edu\\w+\\.log"));
			}		
		}));
		Collections.sort(fileList);
		ListIterator<String> iter = fileList.listIterator(pageSize*(pageIndex-1));
		int count=0;
		PagingJson json = new PagingJson();
		List<Object> rows = new ArrayList<Object>();
		while(iter.hasNext()&&count<=pageSize){
			LogFileVo vo = new LogFileVo();
			vo.setName(iter.next());
			rows.add(vo);
			count++;
		}
		json.setRows(rows);
		json.setTotal(count);
		return json;
	}
}
