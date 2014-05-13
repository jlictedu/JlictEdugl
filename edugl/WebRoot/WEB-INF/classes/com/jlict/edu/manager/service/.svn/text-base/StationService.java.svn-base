/**
 * 
 */
package com.jlict.edu.manager.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.manager.dao.StationDao;
import com.jlict.edu.manager.dao.StationVo;

/**
 * <p>Title: com.jlict.hrgl.manager.service.StationService.java</p>
 * <p>Description: 岗位管理模块</p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 薄景仁
 * @version 1.0
 */
@Service
public class StationService {
	@Autowired
	StationDao stationDao;
	
	/**
	 * 方法名: queryStationDetail   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午04:22:42 
	 * 描述: 岗位详细信息分页查询
	 * 参数：pageIndex 说明：分页索引
	 * 参数：pageSize 说明：单个分页记录数
	 * 参数：name 说明：名称
	 * 参数：people 说明：人数
	 * 返回类型 PagingJson       
	 */
	public PagingJson queryStationDetail(int pageIndex, int pageSize, String name, int people){
		return this.stationDao.queryStationDetail(pageIndex, pageSize, name, people);
	}
	
	/**
	 * 方法名: queryStation   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午04:26:01 
	 * 描述: 岗位信息查询
	 * 返回类型 List<StationVo>       
	 */
	public List<StationVo> queryStation(){
		return this.stationDao.queryStation();
	}
	
	/**
	 * 方法名: updateName   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午04:27:04 
	 * 描述: 修改岗位名称
	 * 参数：id 说明：岗位id
	 * 参数：name 说明：岗位名称
	 * 返回类型 boolean       
	 */
	public boolean updateName(String id,String name){
		return this.stationDao.updateStationName(id, name);
	}
	
	/**
	 * 方法名: delete   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午04:27:56 
	 * 描述: 删除岗位
	 * 参数：id 说明：岗位id
	 * 返回类型 boolean       
	 */
	public boolean delete(String id){
		return this.stationDao.deleteStation(id);
	}
	
	/**
	 * 方法名: create   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午04:28:11 
	 * 描述: 创建岗位
	 * 参数：name 说明：岗位名称
	 * 返回类型 boolean       
	 */
	public boolean create(String name){
		return this.stationDao.createStation(name);
	}
	
	/**
	 * 方法名: queryStationById   
	 * 建立者： 薄景仁 
	 * 建立时间：2013-7-26 下午04:28:29 
	 * 描述: 通过岗位id查询岗位信息
	 * 参数：id 说明：岗位id
	 * 返回类型 StationVo       
	 */
	public StationVo queryStationById(String id){
		return this.stationDao.queryStationById(id);
	}
}
