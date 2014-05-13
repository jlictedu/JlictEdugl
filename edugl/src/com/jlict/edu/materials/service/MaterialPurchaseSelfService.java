/**
 * 
 */
package com.jlict.edu.materials.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.materials.dao.MaterialPurchaseSelfDao;
import com.jlict.edu.materials.dao.MaterialSelfVo;

/**
 * <p>Title: com.jlict.edu.materials.service.MaterialSelfService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Service
public class MaterialPurchaseSelfService
{
	@Autowired
	private MaterialPurchaseSelfDao dao;
	
	/**
	 * 方法名： queryApplys
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月26日 上午1:51:19
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 PagingJson
	 */
	public PagingJson queryApplys(String year, String deptId, int pageIndex, int pageSize)
	{
		return this.dao.queryApplys(year, deptId, pageIndex, pageSize);
	}

	/**
	 * 方法名： readApply
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月27日 上午10:36:53
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 Object
	 */
	public MaterialSelfVo readApply(String id)
	{
		return this.dao.readApply(id);
	}
	
	/**
	 * 方法名： purchase
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月2日 下午7:10:15
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean purchase(String materialId)
	{
		return this.dao.purchase(materialId);
	}

	/**
	 * 方法名： queryApplys
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月9日 下午1:26:36
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 List<?>
	 */
	public List<?> queryApplys(String year, String deptId) {
		return this.dao.queryApplys(year, deptId);
	}

}
