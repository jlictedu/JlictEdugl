/**
 * 
 */
package com.jlict.edu.manager.dao;

import java.util.List;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.stereotype.Repository;

import com.jlict.edu.core.dao.BaseDao;
import com.jlict.edu.core.dao.PagingJson;

/**
 * <p>Title: com.jlict.hrgl.manager.dao.StationDao.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Repository
public class StationDao extends BaseDao {
	
	/**
	 * 方法名: queryStationDetail   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:05:18 
	 * 描述: 岗位详细信息分页查询
	 * 参数：pageIndex 说明：分页索引
	 * 参数：pageSize 说明：单个分页记录数
	 * 参数：name 说明：名称
	 * 参数：people 说明：人数
	 * 返回类型 PagingJson       
	 */
	public PagingJson queryStationDetail(int pageIndex, int pageSize, String name, int people){
		Object[] para = new Object[]{};
		StringBuilder countSql = new StringBuilder();
		StringBuilder listSql = new StringBuilder();
		countSql.append("SELECT COUNT( DISTINCT T_DM_STATION.STATION_ID) FROM T_DM_STATION LEFT JOIN T_USER ON");
		countSql.append(" T_USER.STATION_ID = T_DM_STATION.STATION_ID");		
		listSql.append("SELECT T_DM_STATION.STATION_ID,T_DM_STATION.STATION_NAME,COUNT(T_USER.USER_ID) AS PEOPLE");
		listSql.append(" FROM T_DM_STATION LEFT JOIN T_USER ON T_USER.STATION_ID = T_DM_STATION.STATION_ID");
		if(name != null){
			listSql.append(" WHERE T_DM_STATION.STATION_NAME LIKE ?");
			countSql.append(" WHERE T_DM_STATION.STATION_NAME LIKE ?");
			para = ArrayUtils.addAll(para,new Object[]{'%'+name+'%'});
		}
		listSql.append(" GROUP BY T_DM_STATION.STATION_ID,T_DM_STATION.STATION_NAME");		
		if(people >0){
			listSql.append(" HAVING COUNT(T_USER.USER_ID)>=?");
			countSql.append(" HAVING COUNT(T_USER.USER_ID)>=?");
			para = ArrayUtils.addAll(para,new Object[]{people});
		}
		listSql.append(" ORDER BY PEOPLE DESC");
		return this.queryPagingList(countSql.toString(), listSql.toString(), para, pageIndex, pageSize, new StationDetailRowMapper());
	}
	
	/**
	 * 方法名: queryStation   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:05:38 
	 * 描述: 岗位信息查询
	 * 返回类型 List<StationVo>       
	 */
	public List<StationVo> queryStation(){
		String sql = "SELECT STATION_ID,STATION_NAME FROM T_DM_STATION";
		return this.jdbcTemplate.query(sql, new StationRowMapper());
	}
	
	/**
	 * 方法名: queryStationById   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:06:49 
	 * 描述: 通过岗位id查询岗位信息
	 * 参数：id 说明：岗位id
	 * 返回类型 StationVo       
	 */
	public StationVo queryStationById(String id){
		String sql = "SELECT STATION_ID,STATION_NAME FROM T_DM_STATION WHERE STATION_ID=?";
		Object[] para = new Object[]{id};
		return this.jdbcTemplate.queryForObject(sql, new StationRowMapper(),para);
	}
	
	/**
	 * 方法名: updateStationName   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:05:53 
	 * 描述: 修改岗位名称
	 * 参数：id 说明：岗位id
	 * 参数：name 说明：岗位名称
	 * 返回类型 boolean       
	 */
	public boolean updateStationName(String id,String name){
		String sql = "UPDATE T_DM_STATION SET STATION_NAME = ? WHERE STATION_ID=?";
		Object[] para = new Object[]{name,id};
		return 1==this.jdbcTemplate.update(sql, para);
	}
	
	/**
	 * 方法名: deleteStation   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:06:14 
	 * 描述: 删除岗位
	 * 参数：id 说明：岗位id
	 * 返回类型 boolean       
	 */
	public boolean deleteStation(String id){
		String sql = "DELETE T_DM_STATION WHERE STATION_ID=?";
		Object[] para = new Object[]{id};
		return 1==this.jdbcTemplate.update(sql, para);
	}
	
	/**
	 * 方法名: createStation   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午05:06:27 
	 * 描述: 创建岗位
	 * 参数：name 说明：岗位名称
	 * 返回类型 boolean       
	 */
	public boolean createStation(String name){
		String sql = "INSERT INTO T_DM_STATION VALUES (S_COMMON.NEXTVAL,?)";
		Object[] para = new Object[]{name};
		return 1==this.jdbcTemplate.update(sql, para);
	}
}
