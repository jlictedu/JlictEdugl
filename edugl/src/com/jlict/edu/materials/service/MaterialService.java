/**
 * 
 */
package com.jlict.edu.materials.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.materials.dao.MaterialDao;
import com.jlict.edu.materials.dao.MaterialItemVo;
import com.jlict.edu.materials.dao.MaterialVo;

/**
 * <p>Title: com.jlict.edu.materials.service.MaterialSelfService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Service
public class MaterialService
{
	@Autowired
	private MaterialDao dao;
	
	/**
	 * 方法名： addSubmit
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月25日 上午4:08:08
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean addSubmit(MaterialVo vo)
	{
		return this.dao.addSubmit(vo);
	}

	/**
	 * 方法名： queryApplys
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月26日 下午1:52:45
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
	 * 建立时间：2014年2月28日 上午10:06:49
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
	 * 方法名： updateApply
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月28日 上午10:53:36
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean updateApply(MaterialVo vo)
	{
		return this.dao.updateApply(vo);
	}

	/**
	 * 方法名： initUpdateApply
	 * 建立者： 孟兆祥
	 * 建立时间：2014年2月28日 下午5:02:21
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 MaterialItemVo
	 */
	public MaterialItemVo initUpdateApply(String id)	
	{
		return this.dao.readApply(id);
	}
}
