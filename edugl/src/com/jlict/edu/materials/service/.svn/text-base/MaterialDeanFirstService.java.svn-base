/**
 * 
 */
package com.jlict.edu.materials.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jlict.edu.core.dao.PagingJson;
import com.jlict.edu.materials.dao.MaterialDeanFirstDao;
import com.jlict.edu.materials.dao.MaterialFirstDao;
import com.jlict.edu.materials.dao.MaterialFirstItemVo;

/**
 * <p>Title: com.jlict.edu.materials.service.MaterialSelfService.java</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2013 教务管理系统，吉林化工学院</p>
 * <p>Company: 吉林化工学院</p>
 * @author 孟兆祥
 * @version 1.0
 */
@Service
public class MaterialDeanFirstService
{
	@Autowired
	private MaterialDeanFirstDao dao;
	@Autowired
	private MaterialFirstDao mfDao;

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
	 * 方法名： approval
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月2日 下午1:26:27
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 boolean
	 */
	public boolean approval(String id, String approvalAction)
	{
		return this.dao.approval(id, approvalAction);
	}

	/**
	 * 方法名： readApproval
	 * 建立者： 孟兆祥
	 * 建立时间：2014年3月2日 下午1:33:09
	 * 描述：TODO(这里用一句话描述这个方法的作用)
	 * 参数：para 说明：TODO
	 * 返回类型 MaterialFirstItemVo
	 */
	public MaterialFirstItemVo readApproval(String id)
	{
		return this.mfDao.readApply(id);
	}
}
