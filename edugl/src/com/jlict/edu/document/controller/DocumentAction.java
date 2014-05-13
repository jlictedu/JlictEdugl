package com.jlict.edu.document.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jlict.edu.core.controller.BaseAction;
import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.core.util.ResultJson;
import com.jlict.edu.core.util.SysLogUtil;
import com.jlict.edu.document.service.DocumentService;


@Controller
public class DocumentAction extends BaseAction {
	@Autowired
	DocumentService documentService;
	
	@RequestMapping(value="/document.do",method=RequestMethod.GET)
	public ModelAndView init(HttpServletRequest request, HttpServletResponse response){
		return new ModelAndView("/exam/document");
	}
	
	@RequestMapping(value="/document.do",method=RequestMethod.POST,params="m=backup")
	@ResponseBody  
	public Object backup(HttpServletRequest request, HttpServletResponse response){
		ResultJson json=new ResultJson();		
		java.text.DateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd-HH-mm-ss");
		String path = request.getSession().getServletContext().getRealPath("/WEB-INF/backup");
		String fileName="edu"+df.format(new Date())+".dmp";
		
		Process proc;
		StringBuilder result = new StringBuilder();  
		try{
			File file = new File(path,fileName);
			proc = Runtime.getRuntime().exec("exp edu/edu@orcl file="+file+" owner=(edu)");			
			BufferedReader br = new BufferedReader(new InputStreamReader(proc.getErrorStream()));  			   
			String line;
			while ((line = br.readLine())!= null){  
			    result.append(line);
			    }            
			int exitVal = proc.waitFor();
			proc.destroy();
			if(exitVal==0){
				json.setResultCode(0);
				
			}else{
				json.setResultCode(1);
			}
		}catch(Exception e){
			json.setResultCode(2);
			SysLogUtil.error("备份数据出错",e);
		}
		return json;
	}
	
	@RequestMapping(value="/document.do",method=RequestMethod.POST,params="m=query")
	@ResponseBody
	public Object queryData(HttpServletRequest request, HttpServletResponse response){
		PagingJson json=null;
		File directory;
		try{
			directory = new File(request.getSession().getServletContext().getRealPath("/WEB-INF/backup"));
			int pageIndex = Integer.parseInt(request.getParameter("pageIndex"));
			int pageSize = Integer.parseInt(request.getParameter("pageSize"));
			json = this.documentService.queryData(directory, pageIndex, pageSize);
			SysLogUtil.info("查询数据备份列表");
		}catch(Exception e){
			SysLogUtil.error("获取数据备份列表出错",e);
		}
		return json;
	}
	
	@RequestMapping(value="/document.do",method=RequestMethod.GET,params="m=download")
	public void downData(HttpServletRequest request, HttpServletResponse response){
		File directory;
		try{
			
			directory = new File(request.getSession().getServletContext().getRealPath("/WEB-INF/backup"));
			String fileName = request.getParameter("file");
			File file = new File(directory,fileName);	       
	            InputStream fis = new BufferedInputStream(new FileInputStream(file));
	            byte[] buffer = new byte[fis.available()];
	            fis.read(buffer);
	            fis.close();	           
	            response.reset();	            
	            response.addHeader("Content-Disposition", "attachment;filename=" + new String(fileName.getBytes("utf-8"),"ISO-8859-1"));
	            response.addHeader("Content-Length", "" + file.length());
	            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
	            response.setContentType("application/octet-stream");
	            toClient.write(buffer);
	            toClient.flush();
	            toClient.close();
			SysLogUtil.info("下载数据备份文件");
		}catch(Exception e){
			SysLogUtil.error("下载数据备份文件出错",e);
		}
	}
	
	@RequestMapping(value="/document.do",method=RequestMethod.POST,params="m=delete")
	@ResponseBody
	public Object deleteData(HttpServletRequest request, HttpServletResponse response){
		ResultJson json=new ResultJson();
		File directory;
		try{
			directory = new File(request.getSession().getServletContext().getRealPath("/WEB-INF/backup"));
			String fileName = request.getParameter("file");
			File file = new File(directory,fileName);
			if(file.delete()){
				json.setResultCode(0);
			}else{
				json.setResultCode(1);
			}
			SysLogUtil.info("删除数据备份");
		}catch(Exception e){
			json.setResultCode(2);
			SysLogUtil.error("删除数据备份出错",e);
		}
		return json;
	}
}
