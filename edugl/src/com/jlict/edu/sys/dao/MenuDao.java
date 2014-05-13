/**
 * 
 */
package com.jlict.edu.sys.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;

/**
 * <p>Title: com.jlict.hrgl.sys.dao.MenuDao.java</p>
 * <p>Description:系统菜单模块持久层 </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Repository
public class MenuDao extends BaseDao{
	/**
	 * 方法名: getMenu   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-6-26 下午03:40:27 
	 * 描述: 获得系统菜单数据
	 * 参数：departmentId 说明：部门id
	 * 参数：stationId 说明：岗位id
	 * 返回类型 List<SysMenuVo>       
	 */
	public List<SysMenuVo> getMenu(String departmentId, String stationId){
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT MENU_ID,LEAF,MENU_NAME,MENU_URL,PARENT_ID FROM T_SYS_MENU WHERE ROLE_ID IN ");
		sql.append("(SELECT ROLE_ID FROM T_ROLE WHERE DEPT_ID = ? AND STATION_ID = ?) ORDER BY MENU_ID");
		Object [] para = new Object[]{departmentId,stationId};
		return this.jdbcTemplate.query(sql.toString(), para, new SysMenuRowMapper());
	}
}
