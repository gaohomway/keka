package com.keekan.serve.impl;


import java.util.List;

import com.keekan.dao.NavigateDao;
import com.keekan.serve.NavigateServe;

/**
 * @author KEEKAN.10000
 * @version 1.0 <br>
 *          Copyright (C), 2012-, keekan.com <br>
 *          This program is protected by copyright laws. <br>
 *          Program Name: KEEKAN<br>
 *          Class Name: 导航的Service接口 <br>
 */
@SuppressWarnings("unchecked")
public class NavigateServeImpl implements NavigateServe {

	private NavigateDao navigateDao;
	
	/**
	 * 查看导航
	 * @return
	 * @throws Exception
	 */
	public List viewNavigate() throws Exception {
		try {
			List navigateList = navigateDao.viewNavigate();
			return navigateList;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("查看导航时出现异常！");
		}
	}
	
	public void setNavigateDao(NavigateDao navigateDao) {
		this.navigateDao = navigateDao;
	}
	public NavigateDao getNavigateDao() {
		return navigateDao;
	}

}
