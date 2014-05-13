/**
 * 
 */
package com.jlict.edu.materials.dao;

/**
 * <p>Title: com.jlict.edu.materials.dao.MaterialSelfVo.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
public class MaterialFirstItemVo
{
	private String id;
	private String courseName;
	private String courseProperty;
	private String isbn;
	private String materialName;
	private String editor;
	private String revision;
	private String press;
	private int studentCount;
	private int teacherCount;
	private String useClass;
	private String tel;
	private String summary;
	private String applyDate;
	private String applyResult;
	private String director;
	private String directorIdea;
	private String dean;
	private String deanIdea;
	
	public String getId()
	{
		return id;
	}

	public String getCourseName()
	{
		return courseName;
	}

	public String getIsbn()
	{
		return isbn;
	}

	public String getMaterialName()
	{
		return materialName;
	}

	public String getEditor()
	{
		return editor;
	}

	public String getPress()
	{
		return press;
	}

	public String getUseClass()
	{
		return useClass;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public void setCourseName(String courseName)
	{
		this.courseName = courseName;
	}

	public void setIsbn(String isbn)
	{
		this.isbn = isbn;
	}

	public void setMaterialName(String materialName)
	{
		this.materialName = materialName;
	}

	public void setEditor(String editor)
	{
		this.editor = editor;
	}

	public void setPress(String press)
	{
		this.press = press;
	}

	public void setUseClass(String useClass)
	{
		this.useClass = useClass;
	}

	public String getApplyDate()
	{
		return applyDate;
	}

	public void setApplyDate(String applyDate)
	{
		this.applyDate = applyDate;
	}

	public String getDirector()
	{
		return director;
	}

	public String getDirectorIdea()
	{
		return directorIdea;
	}

	public String getDean()
	{
		return dean;
	}

	public String getDeanIdea()
	{
		return deanIdea;
	}

	public void setDirector(String director)
	{
		this.director = director;
	}

	public void setDirectorIdea(String directorIdea)
	{
		this.directorIdea = directorIdea;
	}

	public void setDean(String dean)
	{
		this.dean = dean;
	}

	public void setDeanIdea(String deanIdea)
	{
		this.deanIdea = deanIdea;
	}

	public String getCourseProperty()
	{
		return courseProperty;
	}

	public String getRevision()
	{
		return revision;
	}

	public int getStudentCount()
	{
		return studentCount;
	}

	public int getTeacherCount()
	{
		return teacherCount;
	}

	public String getTel()
	{
		return tel;
	}

	public String getSummary()
	{
		return summary;
	}

	public String getApplyResult()
	{
		return applyResult;
	}

	public void setCourseProperty(String courseProperty)
	{
		this.courseProperty = courseProperty;
	}

	public void setRevision(String revision)
	{
		this.revision = revision;
	}

	public void setStudentCount(int studentCount)
	{
		this.studentCount = studentCount;
	}

	public void setTeacherCount(int teacherCount)
	{
		this.teacherCount = teacherCount;
	}

	public void setTel(String tel)
	{
		this.tel = tel;
	}

	public void setSummary(String summary)
	{
		this.summary = summary;
	}

	public void setApplyResult(String applyResult)
	{
		this.applyResult = applyResult;
	}
}