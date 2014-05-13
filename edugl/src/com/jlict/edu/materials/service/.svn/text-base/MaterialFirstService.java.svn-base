/**
 * 
 */
package com.jlict.edu.materials.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.materials.dao.MaterialFirstDao;
import com.jlict.edu.materials.dao.MaterialFirstItemVo;
import com.jlict.edu.materials.dao.MaterialFirstVo;

/**
 * <p>Title: com.jlict.edu.materials.service.MaterialSelfService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Service
public class MaterialFirstService
{
	@Autowired
	private MaterialFirstDao dao;
	
	/**
	 * 方法名： addSubmit
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月25日 上午4:08:08
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean addSubmit(MaterialFirstVo vo)
	{
		return this.dao.addSubmit(vo);
	}

	/**
	 * 方法名： queryApplys
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月26日 上午4:19:57
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 PagingJson
	 */
	public PagingJson queryApplys(String year, String userId, int pageIndex, int pageSize)
	{
		return this.dao.queryApplys(year, userId, pageIndex, pageSize);
	}

	/**
	 * 方法名： deleteApply
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月28日 上午10:04:04
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean deleteApply(String id)
	{
		return this.dao.deleteApply(id);
	}

	/**
	 * 方法名： readApply
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月28日 上午10:09:58
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 MaterialFirstVo
	 */
	public MaterialFirstItemVo readApply(String id)
	{
		return this.dao.readApply(id);
	}

	/**
	 * 方法名： updateApply
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月28日 上午10:33:14
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean updateApply(MaterialFirstVo vo)
	{
		return this.dao.updateApply(vo);
	}
}
