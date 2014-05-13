/**
 * 
 */
package com.jlict.edu.materials.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.materials.dao.MaterialItemVo;
import com.jlict.edu.materials.dao.MaterialPurchaseDao;

/**
 * <p>Title: com.jlict.edu.materials.service.MaterialSelfService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Service
public class MaterialPurchaseService
{
	@Autowired
	private MaterialPurchaseDao dao;

	/**
	 * 方法名： queryApplys
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月26日 下午1:52:45
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
	 * 建立时间：2014年2月28日 上午10:17:50
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 MaterialFirstVo
	 */
	public MaterialItemVo readApply(String id)
	{
		return this.dao.readApply(id);
	}

	/**
	 * 方法名： purchase
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月2日 下午4:49:30
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean purchase(String id)
	{
		return this.dao.purchase(id);
	}

	/**
	 * 方法名： queryApplys
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月8日 下午2:39:57
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 List
	 */
	public List<?> queryApplys(String year, String deptId) {
		return this.dao.queryApplys(year, deptId);
	}
}
