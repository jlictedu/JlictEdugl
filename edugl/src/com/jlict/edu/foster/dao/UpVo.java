package com.jlict.edu.foster.dao;

/**
 * <p>Title: com.jlict.edu.foster.dao.UpVo.java</p>
 * <p>Description: 院系vo</p>
 * <p>Copyright: Copyright (c) 2013 人力资源管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 王森玉
 * @version 1.0
 */
public class UpVo {
	String deptid;
	String deptname;
	String bossdeptid;
	String bossdeptname;
	String year;
	public String getDeptid() {
		return deptid;
	}
	public void setDeptid(String deptid) {
		this.deptid = deptid;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getBossdeptid() {
		return bossdeptid;
	}
	public void setBossdeptid(String bossdeptid) {
		this.bossdeptid = bossdeptid;
	}
	public String getBossdeptname() {
		return bossdeptname;
	}
	public void setBossdeptname(String bossdeptname) {
		this.bossdeptname = bossdeptname;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	
}
