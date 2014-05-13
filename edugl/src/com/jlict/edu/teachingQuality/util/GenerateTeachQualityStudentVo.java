/**
 * 
 */
package com.jlict.edu.teachingQuality.util;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import com.jlict.edu.teachingQuality.dao.TeachQualityStudentVo;

/**
 * <p>Title: com.jlict.edu.teachingQuality.util.GenerateTeachQualityStudentVo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
public class GenerateTeachQualityStudentVo
{
	private HttpServletRequest request;
	private TeachQualityStudentVo vo = new TeachQualityStudentVo();

	public GenerateTeachQualityStudentVo(HttpServletRequest request)
	{
		this.request = request;
	}
	
	public TeachQualityStudentVo getTeachQualityStudentVo()
	{
		setVoTeachAttitudeData();
		setVoTeachContentData();
		setVoTeachMethodData();
		setVoTeachEffectData();
		setVoIdea();
		setVoId();

		return vo;
	}
	
	private void setVoTeachAttitudeData()
	{
		 vo.setTa_ei1(Integer.parseInt(request.getParameter("teachAttitude1")));
		 vo.setTa_ei2(Integer.parseInt(request.getParameter("teachAttitude2")));
	}
	
	private void setVoTeachContentData()
	{
		vo.setTc_ei1(Integer.parseInt(request.getParameter("teachContent1")));
		vo.setTc_ei2(Integer.parseInt(request.getParameter("teachContent2")));
		vo.setTc_ei3(Integer.parseInt(request.getParameter("teachContent3")));
		vo.setTc_ei4(Integer.parseInt(request.getParameter("teachContent4")));
		vo.setTc_ei5(Integer.parseInt(request.getParameter("teachContent5")));
	}
	
	private void setVoTeachMethodData()
	{
		vo.setTm_ei1(Integer.parseInt(request.getParameter("teachMethod1")));
		vo.setTm_ei2(Integer.parseInt(request.getParameter("teachMethod2")));
		vo.setTm_ei3(Integer.parseInt(request.getParameter("teachMethod3")));
	}
	
	private void setVoTeachEffectData()
	{
		 vo.setTe_ei1(Integer.parseInt(request.getParameter("teachEffect1")));
	}
	
	public void setVoStudentId(String studentId)
	{
		vo.setStu_id(studentId);
	}
	
	private void setVoIdea()
	{
		vo.setIdea(request.getParameter("ideaContent"));
	}
	
	private void setVoId()
	{
		String id = request.getParameter("personEvaluationId");
		
		if(id != null)
		{
			vo.setId(id);
		}
		else
		{
			vo.setId(UUID.randomUUID().toString());
		}
	}
}
